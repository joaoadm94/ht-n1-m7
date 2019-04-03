package ht.n1.m7.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "colaboradores")
@XmlAccessorType(XmlAccessType.FIELD)
public class Colaboradores {


    @XmlElement(name = "colaborador")
    private List<Colaborador> colaboradores = null;

    public List<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(List<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }
}
