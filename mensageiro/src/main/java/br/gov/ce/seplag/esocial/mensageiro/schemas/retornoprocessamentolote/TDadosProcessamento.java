//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementa��o de Refer�ncia (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modifica��es neste arquivo ser�o perdidas ap�s a recompila��o do esquema de origem. 
// Gerado em: 2018.08.01 �s 02:13:44 PM GMT-03:00 
//


package br.gov.ce.seplag.esocial.mensageiro.schemas.retornoprocessamentolote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Define os dados de processamento de um lote de eventos.
 * 
 * <p>Classe Java de TDadosProcessamento complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TDadosProcessamento">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="versaoAplicativoProcessamentoLote" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TDadosProcessamento", propOrder = {
    "versaoAplicativoProcessamentoLote"
})
public class TDadosProcessamento {

    protected String versaoAplicativoProcessamentoLote;

    /**
     * Obt�m o valor da propriedade versaoAplicativoProcessamentoLote.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersaoAplicativoProcessamentoLote() {
        return versaoAplicativoProcessamentoLote;
    }

    /**
     * Define o valor da propriedade versaoAplicativoProcessamentoLote.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersaoAplicativoProcessamentoLote(String value) {
        this.versaoAplicativoProcessamentoLote = value;
    }

}
