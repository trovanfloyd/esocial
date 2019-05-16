package br.gov.ce.seplag.esocial.mensageiro.service;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;

import br.gov.ce.seplag.esocial.mensageiro.dto.LoteEventosDTO;
import br.gov.ce.seplag.esocial.mensageiro.entity.ArquivoEsocial;
import br.gov.ce.seplag.esocial.mensageiro.enumeration.StatusArquivoEsocialEnum;
import br.gov.ce.seplag.esocial.mensageiro.enumeration.TipoEventoEnum;
import br.gov.ce.seplag.esocial.mensageiro.repository.MensageiroRepository;
import br.gov.ce.seplag.esocial.mensageiro.schemas.EnviarLoteEventos;
import br.gov.ce.seplag.esocial.mensageiro.schemas.EnviarLoteEventos.LoteEventos;
import br.gov.ce.seplag.esocial.mensageiro.util.MensageiroUtil;
import br.gov.ce.seplag.esocial.mensageiro.xml.XmlGeneratorLote;

@Service
public class EnvioLoteBusiness {

	private static final int QTD_MAX_EVENTOS = 50;

	@Autowired
	MensageiroRepository mensageiroRepository;
	
	Map<TipoEventoEnum, List<ArquivoEsocial>> arquivos;
	
	@Autowired
	ConfigurableApplicationContext context;
	
	
	public void send() {
		
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		
		Map<EnviarLoteEventos, List<ArquivoEsocial>> loteEventos = popularLote();
		
		try {
			
			loteEventos.forEach((k,v) -> {
				System.out.println("Sending message with lote...");
				jmsTemplate.convertAndSend("esocial", new LoteEventosDTO(k, v));
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private Map<EnviarLoteEventos, List<ArquivoEsocial>> popularLote() {
		
		Map<EnviarLoteEventos, List<ArquivoEsocial>> mapLoteEventos = new LinkedHashMap<EnviarLoteEventos, List<ArquivoEsocial>>();
		
		List<ArquivoEsocial> listArquivo = (List<ArquivoEsocial>) mensageiroRepository.findByStatus(StatusArquivoEsocialEnum.AGUARDANDO_PROCESSAMENTO);
		
		//Agrupa a lista de arquivos por Tipo de Evento
		arquivos = listArquivo.stream().collect( (Collectors.groupingBy(ArquivoEsocial::getTipoEvento)) );
		
		arquivos.forEach((tipoEvento, arquivosTEvento) -> {
			System.out.println("Evento: " + tipoEvento );
			
			Map<String, List<ArquivoEsocial>> mapByOrgao = arquivosTEvento.stream().collect( (Collectors.groupingBy(ArquivoEsocial::getNrInsc_ideEmpregador)) );
			mapByOrgao.forEach((empregador, arquivosEmpregador) -> {
				
				System.out.println("Numero Inscricao empregador: " + empregador );
				
				Collection<List<ArquivoEsocial>> collectionArqEsocial = null;
				// Verifica Tipo Evento e Particiona a Lista de acordo coma  quatidade de eventos permitidos em um Lote
				if (tipoEvento.equals(TipoEventoEnum.S1000)) {
					collectionArqEsocial = MensageiroUtil.partition(arquivosEmpregador, 1);
				} else {
					collectionArqEsocial = MensageiroUtil.partition(arquivosEmpregador, QTD_MAX_EVENTOS);
				}
				List<List<ArquivoEsocial>> listPartition = collectionArqEsocial.stream().collect(Collectors.toList());
				listPartition.forEach(listArq -> {
					Element loteElement = gerarLote(listArq);
					EnviarLoteEventos enviarLoteEventos = new EnviarLoteEventos();
					LoteEventos loteEventos = new LoteEventos();
					loteEventos.setAny(loteElement);
					enviarLoteEventos.setLoteEventos(loteEventos);
					
					mapLoteEventos.put(enviarLoteEventos, listArq);
				});
			});
			
			
		});
		

		return mapLoteEventos;
	}

	/**
	 * 
	 * @return XML com Lote de eventos
	 */
	private Element gerarLote(List<ArquivoEsocial> listArquivos) {
		Element loteElement = null;
		
		
		//Map contendo ID do Evento como chave o XML assinado
		Map<String, String> xmlMap = new LinkedHashMap<String, String>();
		
		listArquivos.forEach(arq -> {
			String xml = new String(arq.getArquivoAssinado());
			xmlMap.put(arq.getIdEvento(), xml);
		});
		
		try {
			XmlGeneratorLote generatorLote = new XmlGeneratorLote();
			String xmlLote = generatorLote.gerarXmlLote(xmlMap, gerarNrInscLote(xmlMap));
			
			loteElement = MensageiroUtil.getElement(xmlLote.getBytes());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return loteElement;

	}
	
	private String gerarNrInscLote(Map<String, String> xmlMap) {
		Map.Entry<String,String> entry = xmlMap.entrySet().iterator().next();
		String key= entry.getKey();
		 
		String nrInscLote = key.substring(3, 11);
		
		return nrInscLote;
	}

	
}
