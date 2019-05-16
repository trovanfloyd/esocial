package br.gov.ce.seplag.esocial.mensageiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.gov.ce.seplag.esocial.mensageiro.entity.ArquivoEsocial;
import br.gov.ce.seplag.esocial.mensageiro.entity.ProcessamentoLote;
import br.gov.ce.seplag.esocial.mensageiro.enumeration.StatusProcessamentoLoteEnum;
import br.gov.ce.seplag.esocial.mensageiro.repository.MensageiroRepository;
import br.gov.ce.seplag.esocial.mensageiro.repository.ProcessamentoLoteRepository;

@Service
public class ConsultaLoteBusiness {
	
	
	@Autowired
	ProcessamentoLoteRepository processamentoLoteRepository;
	
	@Autowired
	MensageiroRepository mensageiroRepository;
	
	@Autowired
	ConfigurableApplicationContext context;
	

	@Transactional
	public void consultarLoteEventos() {
		
		List<ProcessamentoLote> listProcessamento = processamentoLoteRepository.findByStatus(StatusProcessamentoLoteEnum.LOTE_EM_PROCESSAMENTO);
		
		if (listProcessamento != null && !listProcessamento.isEmpty()) {
			
			JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
			
			listProcessamento.forEach(proc -> {
				
				//System.out.println(proc.getListArquivos().size());
				System.out.println("Sending message consulta...");
				jmsTemplate.convertAndSend("consulta", proc);
				
			});
		} else {
			System.out.println("Não existem Lotes em Processamento!");
		}
		
	}
	
	public ArquivoEsocial mapToJson(ArquivoEsocial arquivoEsocial) {
		ArquivoEsocial arquivoEsocial2 = mensageiroRepository.findByIdEvento("ID1055414240000002018081613164400065");
		ObjectMapper mapper = new ObjectMapper();
		arquivoEsocial2.setArquivoAssinado(null);
		arquivoEsocial2.setArquivoOriginal(null);
		//arquivoEsocial2.setProcessamentoLote(null);
		arquivoEsocial2.setListOcorrencias(null);
		try {
			String json = mapper.writeValueAsString(arquivoEsocial2);
			return arquivoEsocial2;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
