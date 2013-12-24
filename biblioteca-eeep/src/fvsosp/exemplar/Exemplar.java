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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Pedro Saraiva
 */
@Entity
@Table(name="exemplar")
public class Exemplar implements Serializable {
    private static final long serialVersionUID = -6137808136410511086L;
    
   @Id
   @GeneratedValue
   private short tombo;
   
   @Column(length = 20, nullable=false)
   private short exemplar;

    @Override
    public String toString() {
        return "{" + "Nº exemplar=" + exemplar + '}';
    }
   
   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   @JoinColumn(name="idAcervo")
   private Acervo acervo;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.getExemplar();
        hash = 41 * hash + Objects.hashCode(this.getAcervo());
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
        if (this.getTombo() != other.getTombo()) {
            return false;
        }
        if (this.getExemplar() != other.getExemplar()) {
            return false;
        }
        if (!Objects.equals(this.acervo, other.acervo)) {
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
}