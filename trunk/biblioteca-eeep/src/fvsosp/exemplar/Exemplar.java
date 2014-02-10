/* Este arquivo é parte do OSBiblio.
 * Copyright (C) 2014 (Pedro Saraiva, Túlio Vidal, Luís Henrique, Adriano Lima, Oziel Pereira,
 * Marcos Ellys, Francisco Júnior, Fátima Pinheiro, Darly Vinicio).
 *
 * OSBiblio é um software livre; você pode redistribuí-lo e/ou  modificá-lo dentro dos termos da 
 * Licença Pública Geral GNU como publicada pela Fundação do Software Livre (FSF); na versão 2 da Licença,
 * ou (na sua opinião) qualquer versão.
 *
 * Este programa é distribuído na esperança de que possa ser útil, mas SEM NENHUMA GARANTIA; sem uma garantia 
 * implícita de ADEQUAÇÃO a qualquer MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a Licença Pública Geral GNU
 * para maiores detalhes.
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
     * Método sobrescrito
     *
     * @param o objeto a ser acessado através da Composição.
     * @return inteiro negativo, zero ou um inteiro positivo.
     */
    @Override
    public int compareTo(Exemplar o) {
        Short tombo = getTombo();
        Short tombo2 = o.getTombo();
        return tombo.compareTo(tombo2);            
    }
    
    private static final long serialVersionUID = -6137808136410511086L;
    @Id
    @GeneratedValue
    private short tombo;
    @Column(length = 20, nullable = false)
    private short exemplar;
    
     /**
     * Método sobrescrito.
     *
     * @return String com o Tombo, Número do exemplar e o Título da Obra.
     */

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

     /**
     * Método sobrescrito.
     *
     * @return um inteiro(hash) contendo o valor total do cálculo de todos os
     * hashCodes dos Atributos contidos na Classe.
     */
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

    /**
     * Método sobrescrito.
     *
     * @param obj objeto a ser acessado através da Composição.
     * @return booleano (true|false).
     */
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
     * @return short tombo
     */
    public short getTombo() {
        return tombo;
    }

    /**
     * @param tombo short
     */
    public void setTombo(short tombo) {
        this.tombo = tombo;
    }

    /**
     * @return short exemplar
     */
    public short getExemplar() {
        return exemplar;
    }

    /**
     * @param exemplar short
     */
    public void setExemplar(short exemplar) {
        this.exemplar = exemplar;
    }

    /**
     * @return Acervo acervo
     */
    public Acervo getAcervo() {
        return acervo;
    }

    /**
     * @param acervo Acervo
     */
    public void setAcervo(Acervo acervo) {
        this.acervo = acervo;
    }

    /**
     * @return boolean ativo
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * @param ativo boolean
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * @return int situacao
     */
    public int getSituacao() {
        return situacao;
    }

    /**
     * @param situacao int
     */
    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }
}