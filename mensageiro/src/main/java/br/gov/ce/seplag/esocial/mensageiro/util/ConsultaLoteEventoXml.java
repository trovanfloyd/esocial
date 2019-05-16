package br.gov.ce.seplag.esocial.mensageiro.util;

public class ConsultaLoteEventoXml {

	public static String gerarXmlConsulta(String protocoloEnvio) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<ns1:ConsultarLoteEventos xmlns:ns1=\"http://www.esocial.gov.br/servicos/empregador/lote/eventos/envio/consulta/retornoProcessamento/v1_1_0\">\r\n"); 
		sb.append("		<consulta xmlns=\"http://www.esocial.gov.br/servicos/empregador/lote/eventos/envio/consulta/retornoProcessamento/v1_1_0\">\r\n"); 
		sb.append("        <eSocial xmlns=\"http://www.esocial.gov.br/schema/lote/eventos/envio/consulta/retornoProcessamento/v1_0_0\">  \r\n");
		sb.append("            <consultaLoteEventos>  \r\n");
		sb.append("                <protocoloEnvio>" + protocoloEnvio + "</protocoloEnvio>  \r\n");
		sb.append("            </consultaLoteEventos>  \r\n");
		sb.append("        </eSocial>\r\n");
		sb.append("     </consulta>\r\n");
		sb.append("</ns1:ConsultarLoteEventos>");
		
		return sb.toString();
	}

}
