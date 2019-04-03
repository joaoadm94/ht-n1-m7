package ht.n1.m7.service;

import ht.n1.m7.entity.Colaborador;
import ht.n1.m7.entity.Colaboradores;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class XmlService {

    public Colaboradores xmlParaColaborador(String xmlString) {

        JAXBContext jaxbContext;
        Colaboradores colaboradores = null;
        try {
            jaxbContext = JAXBContext.newInstance(Colaborador.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            colaboradores = (Colaboradores) jaxbUnmarshaller.unmarshal(new StringReader(xmlString));


        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return colaboradores;
    }
}
