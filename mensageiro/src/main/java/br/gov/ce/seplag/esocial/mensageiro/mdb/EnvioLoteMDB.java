package br.gov.ce.seplag.esocial.mensageiro.mdb;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import br.gov.ce.seplag.esocial.mensageiro.config.SOAPConnector;
import br.gov.ce.seplag.esocial.mensageiro.dto.LoteEventosDTO;
import br.gov.ce.seplag.esocial.mensageiro.entity.ArquivoEsocial;
import br.gov.ce.seplag.esocial.mensageiro.entity.Ocorrencia;
import br.gov.ce.seplag.esocial.mensageiro.entity.ProcessamentoLote;
import br.gov.ce.seplag.esocial.mensageiro.enumeration.StatusArquivoEsocialEnum;
import br.gov.ce.seplag.esocial.mensageiro.enumeration.StatusProcessamentoLoteEnum;
import br.gov.ce.seplag.esocial.mensageiro.repository.MensageiroRepository;
import br.gov.ce.seplag.esocial.mensageiro.repository.OcorrenciaRepository;
import br.gov.ce.seplag.esocial.mensageiro.repository.ProcessamentoLoteRepository;
import br.gov.ce.seplag.esocial.mensageiro.schemas.EnviarLoteEventos;
import br.gov.ce.seplag.esocial.mensageiro.schemas.EnviarLoteEventos.LoteEventos;
import br.gov.ce.seplag.esocial.mensageiro.schemas.EnviarLoteEventosResponse;
import br.gov.ce.seplag.esocial.mensageiro.schemas.retornoenvio.RetornoEnvio;

@Component
public class EnvioLoteMDB {

	@Autowired
	SOAPConnector soapConnector;

	@Autowired
	MensageiroRepository mensageiroRepository;

	@Autowired
	ProcessamentoLoteRepository processamentoLoteRepository;

	@Autowired
	OcorrenciaRepository ocorrenciaRepository;

	@Value("${url.enviar.lote.eventos}")
	private String urlEnvio;

	@Autowired
	Jaxb2Marshaller marshaller;

	@JmsListener(destination = "esocial")
	@JmsListener(destination = "esocial")
	public void executarEnvio(LoteEventosDTO loteEventosDTO) {
		System.out.println("Receiving message...");
		
		EnviarLoteEventos enviarLoteEventos = criarLoteEventos(loteEventosDTO);
		
		EnviarLoteEventosResponse response = (EnviarLoteEventosResponse) soapConnector.callWebService(urlEnvio, enviarLoteEventos);
		
		processarRetornoEnvio(response, loteEventosDTO.getListArquivos());
	}

	private EnviarLoteEventos criarLoteEventos(LoteEventosDTO loteEventosDTO) {
		String xml = (String) loteEventosDTO.getLoteEventos().getLoteEventos().getAny();
		Element el = teste(xml);
		EnviarLoteEventos enviarLoteEventos = new EnviarLoteEventos();
		LoteEventos loteEventos = new LoteEventos();
		loteEventos.setAny(el);
		enviarLoteEventos.setLoteEventos(loteEventos);
		return enviarLoteEventos;
	}
	
	private Element teste(String s) {
		try {
			
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(s));
			
			Document doc = db.parse(is);
			return doc.getDocumentElement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void processarRetornoEnvio(EnviarLoteEventosResponse response, List<ArquivoEsocial> listArq) {

		RetornoEnvio retornoEnvio = convertRetornoEnvioLote(response);
		if (retornoEnvio != null && retornoEnvio.getRetornoEnvioLoteEventos() != null) {
			if (retornoEnvio.getRetornoEnvioLoteEventos().getStatus().getCdResposta() == 201
					|| retornoEnvio.getRetornoEnvioLoteEventos().getStatus().getCdResposta() == 202) {

				// Element el = (Element) response.getEnviarLoteEventosResult().getAny();
				// String protocolo = MensageiroUtil.getValueFromElement("protocoloEnvio", el);
				String protocolo = retornoEnvio.getRetornoEnvioLoteEventos().getDadosRecepcaoLote().getProtocoloEnvio();

				ProcessamentoLote processamentoLote = atualizarProcessamentoLote(protocolo,
						StatusProcessamentoLoteEnum.LOTE_EM_PROCESSAMENTO, listArq);

				atualizarArquivoEnviados(listArq, processamentoLote);
			} else {
				ProcessamentoLote processamentoLote = atualizarProcessamentoLote(null,
						StatusProcessamentoLoteEnum.ERRO_ENVIO_LOTE, listArq);

				atualizarOcorrenciasProcesamentoLote(retornoEnvio, processamentoLote);
			}
		}

	}

	private ProcessamentoLote atualizarProcessamentoLote(String protocolo, StatusProcessamentoLoteEnum status,
			List<ArquivoEsocial> listArq) {
		ProcessamentoLote processamentoLote = new ProcessamentoLote();
		processamentoLote.setProtocoloEnvio(protocolo);
		processamentoLote.setStatus(status);
		processamentoLote.setDataEnvio(new Date());
		processamentoLote.setListArquivos(listArq);

		processamentoLoteRepository.save(processamentoLote);
		return processamentoLote;
	}

	private void atualizarArquivoEnviados(List<ArquivoEsocial> listArquivosEnviados,
			ProcessamentoLote processamentoLote) {
		for (ArquivoEsocial arquivoEsocial : listArquivosEnviados) {
			arquivoEsocial.setStatus(StatusArquivoEsocialEnum.ENVIADO_PARA_PROCESSAMENTO);
			arquivoEsocial.setProcessamentoLote(processamentoLote);
		}

		mensageiroRepository.saveAll(listArquivosEnviados);
	}

	private void atualizarOcorrenciasProcesamentoLote(RetornoEnvio retornoEnvio, ProcessamentoLote processamentoLote) {

		List<Ocorrencia> listOcorrencias = new ArrayList<Ocorrencia>();
		retornoEnvio.getRetornoEnvioLoteEventos().getStatus().getOcorrencias().getOcorrencia().forEach(oco -> {

			Ocorrencia ocorrencia = new Ocorrencia(oco.getCodigo(), oco.getDescricao(), oco.getTipo(),
					oco.getLocalizacao(), processamentoLote);
			listOcorrencias.add(ocorrencia);
		});

		ocorrenciaRepository.saveAll(listOcorrencias);

	}

	/**
	 * 
	 * @param response
	 * @return RetornoEnvioLote
	 */
	private RetornoEnvio convertRetornoEnvioLote(EnviarLoteEventosResponse response) {

		// InputStream inputStream =
		// MensageiroUtil.getInputStream(response.getEnviarLoteEventosResult().getAny());

		// RetornoEnvio retornoEnvio = (RetornoEnvio) marshaller.unmarshal(new
		// StreamSource(inputStream));

		RetornoEnvio retornoEnvio = (RetornoEnvio) response.getEnviarLoteEventosResult().getAny();

		return retornoEnvio;
	}
}
