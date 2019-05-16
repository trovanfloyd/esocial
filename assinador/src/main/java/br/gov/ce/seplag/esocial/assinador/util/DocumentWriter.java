package br.gov.ce.seplag.esocial.assinador.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class DocumentWriter {

    private String pathToFile;

    public DocumentWriter(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public void writeDocument(Document document) throws FileNotFoundException, TransformerException {
        OutputStream stream = new FileOutputStream(pathToFile);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult(stream));
    }
}
