//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementa��o de Refer�ncia (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modifica��es neste arquivo ser�o perdidas ap�s a recompila��o do esquema de origem. 
// Gerado em: 2018.08.01 �s 02:17:32 PM GMT-03:00 
//


package br.gov.ce.seplag.esocial.mensageiro.schemas.retornoeventos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="retornoEvento">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ideEmpregador" type="{http://www.esocial.gov.br/schema/evt/retornoEvento/v1_2_0}TIdeEmpregador"/>
 *                   &lt;element name="recepcao" type="{http://www.esocial.gov.br/schema/evt/retornoEvento/v1_2_0}TDadosRecepcao"/>
 *                   &lt;element name="processamento" type="{http://www.esocial.gov.br/schema/evt/retornoEvento/v1_2_0}TDadosProcessamentoEvento"/>
 *                   &lt;element name="recibo" type="{http://www.esocial.gov.br/schema/evt/retornoEvento/v1_2_0}TDadosRecibo" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "retornoEvento"
})
@XmlRootElement(name = "eSocial")
public class RetornoProcessamento {

    @XmlElement(required = true)
    protected RetornoProcessamento.RetornoEvento retornoEvento;

    /**
     * Obt�m o valor da propriedade retornoEvento.
     * 
     * @return
     *     possible object is
     *     {@link RetornoProcessamento.RetornoEvento }
     *     
     */
    public RetornoProcessamento.RetornoEvento getRetornoEvento() {
        return retornoEvento;
    }

    /**
     * Define o valor da propriedade retornoEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link RetornoProcessamento.RetornoEvento }
     *     
     */
    public void setRetornoEvento(RetornoProcessamento.RetornoEvento value) {
        this.retornoEvento = value;
    }



    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ideEmpregador" type="{http://www.esocial.gov.br/schema/evt/retornoEvento/v1_2_0}TIdeEmpregador"/>
     *         &lt;element name="recepcao" type="{http://www.esocial.gov.br/schema/evt/retornoEvento/v1_2_0}TDadosRecepcao"/>
     *         &lt;element name="processamento" type="{http://www.esocial.gov.br/schema/evt/retornoEvento/v1_2_0}TDadosProcessamentoEvento"/>
     *         &lt;element name="recibo" type="{http://www.esocial.gov.br/schema/evt/retornoEvento/v1_2_0}TDadosRecibo" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ideEmpregador",
        "recepcao",
        "processamento",
        "recibo"
    })
    public static class RetornoEvento {

        @XmlElement(required = true)
        protected TIdeEmpregador ideEmpregador;
        @XmlElement(required = true)
        protected TDadosRecepcao recepcao;
        @XmlElement(required = true)
        protected TDadosProcessamentoEvento processamento;
        protected TDadosRecibo recibo;
        @XmlAttribute(name = "Id", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlID
        @XmlSchemaType(name = "ID")
        protected String id;

        /**
         * Obt�m o valor da propriedade ideEmpregador.
         * 
         * @return
         *     possible object is
         *     {@link TIdeEmpregador }
         *     
         */
        public TIdeEmpregador getIdeEmpregador() {
            return ideEmpregador;
        }

        /**
         * Define o valor da propriedade ideEmpregador.
         * 
         * @param value
         *     allowed object is
         *     {@link TIdeEmpregador }
         *     
         */
        public void setIdeEmpregador(TIdeEmpregador value) {
            this.ideEmpregador = value;
        }

        /**
         * Obt�m o valor da propriedade recepcao.
         * 
         * @return
         *     possible object is
         *     {@link TDadosRecepcao }
         *     
         */
        public TDadosRecepcao getRecepcao() {
            return recepcao;
        }

        /**
         * Define o valor da propriedade recepcao.
         * 
         * @param value
         *     allowed object is
         *     {@link TDadosRecepcao }
         *     
         */
        public void setRecepcao(TDadosRecepcao value) {
            this.recepcao = value;
        }

        /**
         * Obt�m o valor da propriedade processamento.
         * 
         * @return
         *     possible object is
         *     {@link TDadosProcessamentoEvento }
         *     
         */
        public TDadosProcessamentoEvento getProcessamento() {
            return processamento;
        }

        /**
         * Define o valor da propriedade processamento.
         * 
         * @param value
         *     allowed object is
         *     {@link TDadosProcessamentoEvento }
         *     
         */
        public void setProcessamento(TDadosProcessamentoEvento value) {
            this.processamento = value;
        }

        /**
         * Obt�m o valor da propriedade recibo.
         * 
         * @return
         *     possible object is
         *     {@link TDadosRecibo }
         *     
         */
        public TDadosRecibo getRecibo() {
            return recibo;
        }

        /**
         * Define o valor da propriedade recibo.
         * 
         * @param value
         *     allowed object is
         *     {@link TDadosRecibo }
         *     
         */
        public void setRecibo(TDadosRecibo value) {
            this.recibo = value;
        }

        /**
         * Obt�m o valor da propriedade id.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Define o valor da propriedade id.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }

    }

}
