package br.gov.ce.seplag.esocial.mensageiro.mdb;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import br.gov.ce.seplag.esocial.mensageiro.config.SOAPConnectorConsulta;
import br.gov.ce.seplag.esocial.mensageiro.entity.ArquivoEsocial;
import br.gov.ce.seplag.esocial.mensageiro.entity.Ocorrencia;
import br.gov.ce.seplag.esocial.mensageiro.entity.ProcessamentoLote;
import br.gov.ce.seplag.esocial.mensageiro.enumeration.StatusArquivoEsocialEnum;
import br.gov.ce.seplag.esocial.mensageiro.enumeration.StatusProcessamentoLoteEnum;
import br.gov.ce.seplag.esocial.mensageiro.repository.MensageiroRepository;
import br.gov.ce.seplag.esocial.mensageiro.repository.OcorrenciaRepository;
import br.gov.ce.seplag.esocial.mensageiro.repository.ProcessamentoLoteRepository;
import br.gov.ce.seplag.esocial.mensageiro.schemas.ConsultarLoteEventos;
import br.gov.ce.seplag.esocial.mensageiro.schemas.ConsultarLoteEventos.Consulta;
import br.gov.ce.seplag.esocial.mensageiro.schemas.ConsultarLoteEventosResponse;
import br.gov.ce.seplag.esocial.mensageiro.schemas.retornoeventos.RetornoProcessamento;
import br.gov.ce.seplag.esocial.mensageiro.schemas.retornoprocessamentolote.ESocial;
import br.gov.ce.seplag.esocial.mensageiro.schemas.retornoprocessamentolote.ESocial.RetornoProcessamentoLoteEventos.RetornoEventos.Evento;
import br.gov.ce.seplag.esocial.mensageiro.util.ConsultaLoteEventoXml;
import br.gov.ce.seplag.esocial.mensageiro.util.MensageiroUtil;

@Component
public class ConsultaLoteMDB {
	
	@Autowired
	SOAPConnectorConsulta soapConnectorConsulta;
	
	@Autowired
	MensageiroRepository mensageiroRepository;
	
	@Autowired
	OcorrenciaRepository ocorrenciaRepository;
	
	@Autowired
	ProcessamentoLoteRepository processamentoLoteRepository;
	
	@Value("${url.consultar.lote.eventos}")
	private String urlConsulta;
	
	@Autowired
	Jaxb2Marshaller marshaller;
	
	@JmsListener(destination = "consulta")
	public void consultar(ProcessamentoLote proc) {
		
		System.out.println("Receiving message consulta...");
		
		ConsultarLoteEventos consultarLoteEventos = popularConsultarLote(proc);
		
		ConsultarLoteEventosResponse response = (ConsultarLoteEventosResponse) soapConnectorConsulta
				.callWebService(urlConsulta, consultarLoteEventos);
		
		System.out.println("=================RETORNO===========");
		
		processarRetornoProcessamentoLote(response, proc);
	}
	
	private ConsultarLoteEventos popularConsultarLote(ProcessamentoLote processamentoLote) {
		
		String xmlConsultaLote = ConsultaLoteEventoXml.gerarXmlConsulta(processamentoLote.getProtocoloEnvio());
		
		ConsultarLoteEventos consultarLoteEventos = new ConsultarLoteEventos();

		Consulta consulta = new Consulta();
		consulta.setAny(MensageiroUtil.getElement(xmlConsultaLote.getBytes()));
		
		consultarLoteEventos.setConsulta(consulta);
		
		return consultarLoteEventos;
	}
	
	
	private void processarRetornoProcessamentoLote(ConsultarLoteEventosResponse response, ProcessamentoLote processamentoLote) {
		
		ESocial eSocial = convertRetornoProcessamentoLote(response);
		
		//Verifica se o Lote já foi processado com sucesso ou esta aguardando processamento
		if (eSocial.getRetornoProcessamentoLoteEventos().getStatus().getCdResposta() == 201 || 
				eSocial.getRetornoProcessamentoLoteEventos().getStatus().getCdResposta() == 202) {
			processarRetornoEvento(eSocial);
			atualizarProcessamentoLote(processamentoLote);
		} else {
			//Implementação para lote aguardando processamento
		}
		
	}

	private void processarRetornoEvento(ESocial eSocial) {
		
		Map<String, RetornoProcessamento> mapEventoRetorno = convertRetornoEvento(eSocial);
		/*
		 * Fazer um filtro para verificar se todos estão com sucesso então atualiza todos de uma vez?!?!
		 */
		mapEventoRetorno.forEach((k,v) -> {
			//Caso o status seja diferente de 201 (sucesso), obter as ocorrências
			if (v.getRetornoEvento().getProcessamento().getCdResposta() != 201) {
				
				List<Ocorrencia> listOcorrencias = new ArrayList<Ocorrencia>();
				if (v.getRetornoEvento().getProcessamento().getOcorrencias() != null) {
					
					v.getRetornoEvento().getProcessamento().getOcorrencias().getOcorrencia().forEach(oco -> {
						
						Ocorrencia ocorrencia = new Ocorrencia(oco.getCodigo(), oco.getDescricao(), oco.getTipo(), oco.getLocalizacao());
						listOcorrencias.add(ocorrencia);
					});
				} else {
					Ocorrencia ocorrencia = new Ocorrencia(v.getRetornoEvento().getProcessamento().getCdResposta(), v.getRetornoEvento().getProcessamento().getDescResposta());
					listOcorrencias.add(ocorrencia);
				}
				
				atualizarArquivoEsocial(k, StatusArquivoEsocialEnum.PROCESSADO_COM_ERRO, listOcorrencias);
			} else {
				atualizarArquivoEsocial(k, StatusArquivoEsocialEnum.PROCESSADO_COM_SUCESSO, null);
			}
		});
	}
	
	/**
	 * 
	 * @param response
	 * @return RetornoProcessamentoLote
	 */
	private ESocial convertRetornoProcessamentoLote(ConsultarLoteEventosResponse response) {
		
	//	InputStream inputStream = MensageiroUtil.getInputStream(response.getConsultarLoteEventosResult().getAny());
		
	//	ESocial eSocial = (ESocial) marshaller.unmarshal(new StreamSource(inputStream));
		
		ESocial eSocial = (ESocial) response.getConsultarLoteEventosResult().getAny();
		
		return eSocial;
	}
	
	/**
	 * 
	 * @param eSocial que representa o RetornoProcessamentoLote
	 * @return Map contendo ID do Evento como Chave e o Retorno do Evento
	 */
	private Map<String, RetornoProcessamento> convertRetornoEvento(ESocial eSocial) {
		
		Map<String, RetornoProcessamento> mapEventoRetorno = new HashMap<String, RetornoProcessamento>();
		
		if (eSocial.getRetornoProcessamentoLoteEventos() != null && eSocial.getRetornoProcessamentoLoteEventos().getRetornoEventos() != null) {
			for(Evento evento : eSocial.getRetornoProcessamentoLoteEventos().getRetornoEventos().getEvento()) {
				InputStream inputStream = MensageiroUtil.getInputStream(evento.getRetornoEvento().getAny());
				RetornoProcessamento retornoProcessamento = (RetornoProcessamento) marshaller.unmarshal(new StreamSource(inputStream));
				
				mapEventoRetorno.put(evento.getId(), retornoProcessamento);
			}
		}
		
		return mapEventoRetorno;
	}
	
	private void atualizarArquivoEsocial(String idEvento, StatusArquivoEsocialEnum status, List<Ocorrencia> ocorrencias) {
		
		ArquivoEsocial arquivoEsocial = mensageiroRepository.findByIdEvento(idEvento);
		arquivoEsocial.setStatus(status);
		
		mensageiroRepository.save(arquivoEsocial);
		
		if (ocorrencias != null && !ocorrencias.isEmpty()) {
			for (Ocorrencia ocorrencia : ocorrencias) {
				ocorrencia.setArquivoEsocial(arquivoEsocial);
			}
			ocorrenciaRepository.saveAll(ocorrencias);
		}
		
	}
	
	private void atualizarProcessamentoLote(ProcessamentoLote processamentoLote) {
		processamentoLote.setStatus(StatusProcessamentoLoteEnum.LOTE_PROCESSADO_COM_SUCESSO);
		processamentoLoteRepository.save(processamentoLote);
	}
	
}
