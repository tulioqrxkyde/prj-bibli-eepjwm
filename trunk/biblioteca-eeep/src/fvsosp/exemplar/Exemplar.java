/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.exemplar;

import fvsosp.acervo.Acervo;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Pedro Saraiva
 */
@Entity
@Table(name = "exemplar")
public class Exemplar implements Serializable, Comparable<Exemplar> {

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    @Override
    public int compareTo(Exemplar o) {
        Short exemplar2 = getExemplar();
        Short exemplarO2 = o.getExemplar();
        return exemplar2.compareTo(exemplarO2);            
    }
    
    private static long serialVersionUID = -6137808136410511086L;
    @Id
    @GeneratedValue
    private short tombo;
    @Column(length = 20, nullable = false)
    private short exemplar;

    @Override
    public String toString() {
        return "Tombo: "+getTombo()+" | Nº exemplar =" + getExemplar()+ " | Acervo: "
                +getAcervo().getTituloObra();
    }
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idAcervo")
    private Acervo acervo;
    
    @Column(columnDefinition="boolean default true")
    private boolean ativo;
    
    /* 
     * 1 - Disponível
     * 2 - Em espera
     * 3 - Emprestado
     * 4 - Indisponível
     */
    
    @Column(columnDefinition="int default 1")
    private int situacao;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.tombo;
        hash = 59 * hash + this.exemplar;
        hash = 59 * hash + Objects.hashCode(this.acervo);
        hash = 59 * hash + (this.ativo ? 1 : 0);
        hash = 59 * hash + this.situacao;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Exemplar other = (Exemplar) obj;
        if (this.tombo != other.tombo) {
            return false;
        }
        if (this.exemplar != other.exemplar) {
            return false;
        }
        if (!Objects.equals(this.acervo, other.acervo)) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        if (this.situacao != other.situacao) {
            return false;
        }
        return true;
    }

   

    /**
     * @return the tombo
     */
    public short getTombo() {
        return tombo;
    }

    /**
     * @param tombo the tombo to set
     */
    public void setTombo(short tombo) {
        this.tombo = tombo;
    }

    /**
     * @return the exemplar
     */
    public short getExemplar() {
        return exemplar;
    }

    /**
     * @param exemplar the exemplar to set
     */
    public void setExemplar(short exemplar) {
        this.exemplar = exemplar;
    }

    /**
     * @return the acervo
     */
    public Acervo getAcervo() {
        return acervo;
    }

    /**
     * @param acervo the acervo to set
     */
    public void setAcervo(Acervo acervo) {
        this.acervo = acervo;
    }

    /**
     * @return the ativo
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the situacao
     */
    public int getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }
}