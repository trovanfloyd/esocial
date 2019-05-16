//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementa��o de Refer�ncia (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modifica��es neste arquivo ser�o perdidas ap�s a recompila��o do esquema de origem. 
// Gerado em: 2018.08.01 �s 02:13:44 PM GMT-03:00 
//


package br.gov.ce.seplag.esocial.mensageiro.schemas.retornoprocessamentolote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Define os dados de recep��o de um arquivo de lote.
 * 
 * <p>Classe Java de TDadosRecepcao complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TDadosRecepcao">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dhRecepcao" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="versaoAplicativoRecepcao">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="protocoloEnvio">
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
@XmlType(name = "TDadosRecepcao", propOrder = {
    "dhRecepcao",
    "versaoAplicativoRecepcao",
    "protocoloEnvio"
})
public class TDadosRecepcao {

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dhRecepcao;
    @XmlElement(required = true)
    protected String versaoAplicativoRecepcao;
    @XmlElement(required = true)
    protected String protocoloEnvio;

    /**
     * Obt�m o valor da propriedade dhRecepcao.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDhRecepcao() {
        return dhRecepcao;
    }

    /**
     * Define o valor da propriedade dhRecepcao.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDhRecepcao(XMLGregorianCalendar value) {
        this.dhRecepcao = value;
    }

    /**
     * Obt�m o valor da propriedade versaoAplicativoRecepcao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersaoAplicativoRecepcao() {
        return versaoAplicativoRecepcao;
    }

    /**
     * Define o valor da propriedade versaoAplicativoRecepcao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersaoAplicativoRecepcao(String value) {
        this.versaoAplicativoRecepcao = value;
    }

    /**
     * Obt�m o valor da propriedade protocoloEnvio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtocoloEnvio() {
        return protocoloEnvio;
    }

    /**
     * Define o valor da propriedade protocoloEnvio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtocoloEnvio(String value) {
        this.protocoloEnvio = value;
    }

}
