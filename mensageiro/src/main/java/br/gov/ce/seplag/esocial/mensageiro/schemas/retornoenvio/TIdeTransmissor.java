//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementa��o de Refer�ncia (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modifica��es neste arquivo ser�o perdidas ap�s a recompila��o do esquema de origem. 
// Gerado em: 2018.08.06 �s 01:46:16 PM GMT-03:00 
//


package br.gov.ce.seplag.esocial.mensageiro.schemas.retornoenvio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Define a identifica��o do transmissor.
 * 
 * <p>Classe Java de TIdeTransmissor complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TIdeTransmissor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tpInsc" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nrInsc">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="15"/>
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
@XmlType(name = "TIdeTransmissor", propOrder = {
    "tpInsc",
    "nrInsc"
})
public class TIdeTransmissor {

    protected int tpInsc;
    @XmlElement(required = true)
    protected String nrInsc;

    /**
     * Obt�m o valor da propriedade tpInsc.
     * 
     */
    public int getTpInsc() {
        return tpInsc;
    }

    /**
     * Define o valor da propriedade tpInsc.
     * 
     */
    public void setTpInsc(int value) {
        this.tpInsc = value;
    }

    /**
     * Obt�m o valor da propriedade nrInsc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNrInsc() {
        return nrInsc;
    }

    /**
     * Define o valor da propriedade nrInsc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNrInsc(String value) {
        this.nrInsc = value;
    }

}
