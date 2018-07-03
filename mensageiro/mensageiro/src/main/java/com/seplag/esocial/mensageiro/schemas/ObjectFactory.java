//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2018.06.25 às 01:46:09 PM GMT-03:00 
//


package com.seplag.esocial.mensageiro.schemas;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.seplag.esocial.mensageiro.schemas package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.seplag.esocial.mensageiro.schemas
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EnviarLoteEventos }
     * 
     */
    public EnviarLoteEventos createEnviarLoteEventos() {
        return new EnviarLoteEventos();
    }

    /**
     * Create an instance of {@link EnviarLoteEventosResponse }
     * 
     */
    public EnviarLoteEventosResponse createEnviarLoteEventosResponse() {
        return new EnviarLoteEventosResponse();
    }

    /**
     * Create an instance of {@link EnviarLoteEventos.LoteEventos }
     * 
     */
    public EnviarLoteEventos.LoteEventos createEnviarLoteEventosLoteEventos() {
        return new EnviarLoteEventos.LoteEventos();
    }

    /**
     * Create an instance of {@link EnviarLoteEventosResponse.EnviarLoteEventosResult }
     * 
     */
    public EnviarLoteEventosResponse.EnviarLoteEventosResult createEnviarLoteEventosResponseEnviarLoteEventosResult() {
        return new EnviarLoteEventosResponse.EnviarLoteEventosResult();
    }

}
