package br.gov.ce.seplag.esocial.mensageiro.schemas.retornoprocessamentolote;

public class MockRetornoConsulta {

	String retorno = "<eSocial xmlns=\"http://www.esocial.gov.br/schema/lote/eventos/envio/retornoProcessamento/v1_3_0\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
			"               <retornoProcessamentoLoteEventos>\r\n" + 
			"                  <ideEmpregador>\r\n" + 
			"                     <tpInsc>1</tpInsc>\r\n" + 
			"                     <nrInsc>08691976</nrInsc>\r\n" + 
			"                  </ideEmpregador>\r\n" + 
			"                  <ideTransmissor>\r\n" + 
			"                     <tpInsc>1</tpInsc>\r\n" + 
			"                     <nrInsc>08691976000160</nrInsc>\r\n" + 
			"                  </ideTransmissor>\r\n" + 
			"                  <status>\r\n" + 
			"                     <cdResposta>201</cdResposta>\r\n" + 
			"                     <descResposta>Lote processado com sucesso.</descResposta>\r\n" + 
			"                  </status>\r\n" + 
			"                  <dadosRecepcaoLote>\r\n" + 
			"                     <dhRecepcao>2018-07-13T15:51:35.953</dhRecepcao>\r\n" + 
			"                     <versaoAplicativoRecepcao>0.1.0-A0323</versaoAplicativoRecepcao>\r\n" + 
			"                     <protocoloEnvio>1.2.201807.0000000000012680451</protocoloEnvio>\r\n" + 
			"                  </dadosRecepcaoLote>\r\n" + 
			"                  <dadosProcessamentoLote>\r\n" + 
			"                     <versaoAplicativoProcessamentoLote>1.0.0.0</versaoAplicativoProcessamentoLote>\r\n" + 
			"                  </dadosProcessamentoLote>\r\n" + 
			"                  <retornoEventos>\r\n" + 
			"                     <evento Id=\"ID1086919760000002018070908201000002\">\r\n" + 
			"                        <retornoEvento>\r\n" + 
			"                           <eSocial xmlns=\"http://www.esocial.gov.br/schema/evt/retornoEvento/v1_2_0\">\r\n" + 
			"                              <retornoEvento Id=\"ID1086919760000002018070908201000002\">\r\n" + 
			"                                 <ideEmpregador>\r\n" + 
			"                                    <tpInsc>1</tpInsc>\r\n" + 
			"                                    <nrInsc>08691976</nrInsc>\r\n" + 
			"                                 </ideEmpregador>\r\n" + 
			"                                 <recepcao>\r\n" + 
			"                                    <tpAmb>2</tpAmb>\r\n" + 
			"                                    <dhRecepcao>2018-07-13T15:51:35.953</dhRecepcao>\r\n" + 
			"                                    <versaoAppRecepcao>0.1.0-A0323</versaoAppRecepcao>\r\n" + 
			"                                    <protocoloEnvioLote>1.2.201807.0000000000012680451</protocoloEnvioLote>\r\n" + 
			"                                 </recepcao>\r\n" + 
			"                                 <processamento>\r\n" + 
			"                                    <cdResposta>402</cdResposta>\r\n" + 
			"                                    <descResposta>Schema do evento inválido.</descResposta>\r\n" + 
			"                                    <versaoAppProcessamento>10.0.2-A3260</versaoAppProcessamento>\r\n" + 
			"                                    <dhProcessamento>2018-07-13T15:51:57.753</dhProcessamento>\r\n" + 
			"                                    <ocorrencias>\r\n" + 
			"                                       <ocorrencia>\r\n" + 
			"                                          <tipo>1</tipo>\r\n" + 
			"                                          <codigo>17</codigo>\r\n" + 
			"                                          <descricao>A estrutura do arquivo XML está em desconformidade com o esquema XSD.The element 'ideEvento' in namespace 'http://www.esocial.gov.br/schema/evt/evtAdmissao/v02_04_02' has invalid child element 'tpAmb' in namespace 'http://www.esocial.gov.br/schema/evt/evtAdmissao/v02_04_02'. List of possible elements expected: 'indRetif' in namespace 'http://www.esocial.gov.br/schema/evt/evtAdmissao/v02_04_02'.</descricao>\r\n" + 
			"                                       </ocorrencia>\r\n" + 
			"                                       <ocorrencia>\r\n" + 
			"                                          <tipo>1</tipo>\r\n" + 
			"                                          <codigo>17</codigo>\r\n" + 
			"                                          <descricao>A estrutura do arquivo XML está em desconformidade com o esquema XSD.The element 'trabalhador' in namespace 'http://www.esocial.gov.br/schema/evt/evtAdmissao/v02_04_02' has invalid child element 'nmTrab' in namespace 'http://www.esocial.gov.br/schema/evt/evtAdmissao/v02_04_02'. List of possible elements expected: 'nisTrab' in namespace 'http://www.esocial.gov.br/schema/evt/evtAdmissao/v02_04_02'.</descricao>\r\n" + 
			"                                       </ocorrencia>\r\n" + 
			"                                       <ocorrencia>\r\n" + 
			"                                          <tipo>1</tipo>\r\n" + 
			"                                          <codigo>17</codigo>\r\n" + 
			"                                          <descricao>A estrutura do arquivo XML está em desconformidade com o esquema XSD.The element 'infoCeletista' in namespace 'http://www.esocial.gov.br/schema/evt/evtAdmissao/v02_04_02' has invalid child element 'FGTS' in namespace 'http://www.esocial.gov.br/schema/evt/evtAdmissao/v02_04_02'. List of possible elements expected: 'dtAdm' in namespace 'http://www.esocial.gov.br/schema/evt/evtAdmissao/v02_04_02'.</descricao>\r\n" + 
			"                                       </ocorrencia>\r\n" + 
			"                                       <ocorrencia>\r\n" + 
			"                                          <tipo>1</tipo>\r\n" + 
			"                                          <codigo>17</codigo>\r\n" + 
			"                                          <descricao>A estrutura do arquivo XML está em desconformidade com o esquema XSD.The element 'infoContrato' in namespace 'http://www.esocial.gov.br/schema/evt/evtAdmissao/v02_04_02' has invalid child element 'localTrabalho' in namespace 'http://www.esocial.gov.br/schema/evt/evtAdmissao/v02_04_02'. List of possible elements expected: 'codCargo, codFuncao, codCateg' in namespace 'http://www.esocial.gov.br/schema/evt/evtAdmissao/v02_04_02'.</descricao>\r\n" + 
			"                                       </ocorrencia>\r\n" + 
			"                                    </ocorrencias>\r\n" + 
			"                                 </processamento>\r\n" + 
			"                              </retornoEvento>\r\n" + 
			"                           </eSocial>\r\n" + 
			"                        </retornoEvento>\r\n" + 
			"                     </evento>\r\n" + 
			"                  </retornoEventos>\r\n" + 
			"               </retornoProcessamentoLoteEventos>\r\n" + 
			"            </eSocial>";
	
	public String retornar() {
		return retorno;
	}
}
