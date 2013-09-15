/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.exemplar;

import fvsosp.acervo.Acervo;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Generated;

/**
 *
 * @author Pedro Saraiva
 */
@Entity
@Table(name="exemplar")
public class Exemplar {
    
   @Id
   @GeneratedValue
   private int tombo;
   
   @Column(nullable=false)
   private int exemplar;
   
   @ManyToOne
   @JoinColumn(name="idacervo")
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
    public int getTombo() {
        return tombo;
    }

    /**
     * @param tombo the tombo to set
     */
    public void setTombo(int tombo) {
        this.tombo = tombo;
    }

    /**
     * @return the exemplar
     */
    public int getExemplar() {
        return exemplar;
    }

    /**
     * @param exemplar the exemplar to set
     */
    public void setExemplar(int exemplar) {
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
