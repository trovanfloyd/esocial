package br.gov.ce.seplag.esocial.extrator.service;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import br.gov.ce.seplag.esocial.extrator.entity.ArquivoEsocial;
import br.gov.ce.seplag.esocial.extrator.entity.S1000;
import br.gov.ce.seplag.esocial.extrator.enumeration.StatusArquivoEsocialEnum;
import br.gov.ce.seplag.esocial.extrator.enumeration.TipoEventoEnum;
import br.gov.ce.seplag.esocial.extrator.repository.RepositoryFactory;
import br.gov.ce.seplag.esocial.extrator.repository.eventos.S1000Repository;
import br.gov.ce.seplag.esocial.extrator.util.ExtratorUtil;
import br.gov.ce.seplag.esocial.extrator.util.XmlGenerator;

@Service
public class ExtratorService {


	private static final String PREFIX_ID = "ID1";

	@Autowired
	AssinadorService assinadorService;

	@Autowired
	ArquivoEsocialService arquivoEsocialService;
	
	@Autowired
	RepositoryFactory repositoryFactory;
	
	@Autowired
	S1000Repository s1000Repository;
	

	Map<String, Object> mapXml;

	String idEvento = "";

	public List<?> findAll(TipoEventoEnum tipoEvento) {
		List<?> list = (List<?>) repositoryFactory.getRepository(tipoEvento).findAll();
		
		return list;
	}

	public String executeXml(TipoEventoEnum tipoEvento) {
		
		String xmlOriginal = "";
		String xmlSigned = "";
		String idEvento = "";
		String xmlSignedRetorno = "";
		
		List<String> listXmlSigned = new ArrayList<>();

		try {
			List<?> list = (List<?>) repositoryFactory.getRepository(tipoEvento).findAllByOrderByIdAsc();
			for (Object evento : list) {
				mapXml = ExtratorUtil.mapValueOnFields(evento, null);
				
				idEvento = gerarIDEvento(mapXml);
				
				XmlGenerator xmlGenerator = new XmlGenerator();
				Document doc = xmlGenerator.gerarXML(mapXml, tipoEvento.xsd(), tipoEvento.rootElement(), idEvento);
				xmlOriginal = getXml(doc);
				
				Document docSigned = assinadorService.signDocument(doc);
				xmlSigned = getXml(docSigned);
				listXmlSigned.add(xmlSigned);
				xmlSignedRetorno += xmlSigned;
				
				String nrInsc = (String) mapXml.get("nrInsc_ideEmpregador");
				ArquivoEsocial arquivoEsocial = createAndSaveArquivoEsocial(xmlOriginal, xmlSigned, tipoEvento, idEvento, nrInsc);
				
				setArquivoEsocialOnEvento(arquivoEsocial, tipoEvento, evento);
			}
			
			
//			return xmlOriginal;
			return xmlSignedRetorno;

		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	

	public String getXml(Document document) {
		String output = "";
		try {
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			transformer.setOutputProperty(OutputKeys.INDENT, "no");
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(document), new StreamResult(writer));
			output = writer.getBuffer().toString();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}
	
	
	private ArquivoEsocial createAndSaveArquivoEsocial(String arquivoOriginal, String arquivoAssinado, 
											 TipoEventoEnum tipoEvento, String idEvento, String nrInsc) {
		ArquivoEsocial arq = new ArquivoEsocial();
		arq.setArquivoOriginal(arquivoOriginal.getBytes());
		arq.setArquivoAssinado(arquivoAssinado.getBytes());
		arq.setDataCriacao(new Date());
		arq.setDescricao("arquivo do evento: " + tipoEvento.evento());
		arq.setTipoEvento(tipoEvento);
		arq.setIdEvento(idEvento);
		arq.setStatus(StatusArquivoEsocialEnum.AGUARDANDO_PROCESSAMENTO);
		arq.setNrInsc_ideEmpregador(nrInsc);
		arquivoEsocialService.save(arq);
		
		return arq;
	}
	
	private void setArquivoEsocialOnEvento(ArquivoEsocial arquivoEsocial, TipoEventoEnum tipoEvento,
			Object evento) {
		try {
			
			BeanWrapperImpl bwSource = new BeanWrapperImpl(evento);
			bwSource.setPropertyValue("arquivoEsocial", arquivoEsocial);
			repositoryFactory.getRepositoryCustom(tipoEvento).saveCustom(bwSource.getWrappedInstance());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private String gerarIDEvento(Map<String, Object> mapXml) {
		String cnpj = (String) mapXml.get("nrInsc_ideEmpregador");
		cnpj = String.format("%-14s",cnpj).replace(' ', '0');
		Long id = (Long) mapXml.get("id");
		String idFormated = String.format("%05d", id);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String data = format.format(new Date());
		
		String idEvt = PREFIX_ID + cnpj + data + idFormated;
		
		return idEvt;
	}
	
/*	private String gerarIDEventoLote(String idEvento) {
		
		String numInscricaoEmpregador = "08691976000000";
		
		String idEvtLote = PREFIX_ID + numInscricaoEmpregador + idEvento.substring(17);
		
		return idEvtLote;
	}*/

	@SuppressWarnings("unchecked")
	public String cleanBase(String nrInsc_ideEmpregador) {
		
		String xmlOriginal = "";
		String xmlSigned = "";
		String idEvento = "";
		String xmlSignedRetorno = "";
		TipoEventoEnum tipoEvento = TipoEventoEnum.S1000;
		
		List<String> listXmlSigned = new ArrayList<>();

		try {
			
			List<?> list = (List<?>) repositoryFactory.getRepository(tipoEvento).findAllByOrderByIdAsc();
			if (list != null && !list.isEmpty()) {
				List<S1000> listS1000 = (List<S1000>) list;
				
				S1000 s1000 = listS1000.stream().filter(evt -> nrInsc_ideEmpregador.equals(evt.getNrInsc_ideEmpregador() ) ).findFirst().orElse(null);
				
				s1000.setNmRazao_infoCadastro("RemoverEmpregadorDaBaseDeDadosDaProducaoRestrita");
				s1000.setClassTrib("00");
				
				mapXml = ExtratorUtil.mapValueOnFields(s1000, null);
				
				idEvento = gerarIDEvento(mapXml);
				
				XmlGenerator xmlGenerator = new XmlGenerator();
				Document doc = xmlGenerator.gerarXML(mapXml, tipoEvento.xsd(), tipoEvento.rootElement(), idEvento);
				xmlOriginal = getXml(doc);
				
				Document docSigned = assinadorService.signDocument(doc);
				xmlSigned = getXml(docSigned);
				listXmlSigned.add(xmlSigned);
				xmlSignedRetorno += xmlSigned;
				
				String nrInsc = (String) mapXml.get("nrInsc_ideEmpregador");
				ArquivoEsocial arquivoEsocial = createAndSaveArquivoEsocial(xmlOriginal, xmlSigned, tipoEvento, idEvento, nrInsc);
				
				setArquivoEsocialOnEvento(arquivoEsocial, tipoEvento, s1000);
			}
			
			return xmlSignedRetorno;

		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}


}
