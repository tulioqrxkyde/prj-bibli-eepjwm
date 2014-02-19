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
package fvsosp.grupoleitores;

import fvsosp.acervo.Acervo;
import fvsosp.leitor.Leitor;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NaturalId;

/**
 *
 * @author Francisco Junior
 */

@Entity
@Table (name="gruposleitores")
public class GruposLeitores implements Serializable, Comparable<GruposLeitores>{

    /**
     * Método sobrescrito
     *
     * @param o objeto a ser acessado através da Composição.
     * @return inteiro negativo, zero ou um inteiro positivo.
     */
    @Override
    public int compareTo(GruposLeitores o) {
        return descricao.compareTo(o.descricao);            
    }
    /**
     * Método sobrescrito.
     *
     * @return String contendo o id do Grupoleitores e informação Sobre o Grupoleitores.
     */
    @Id // campo chave primária
    @GeneratedValue // campo autoincremento
    private short idGruposLeitores;
    
    /**
     * Método sobrescrito.
     *
     * @return um inteiro(hash) contendo o valor total do cálculo de todos os
     * hashCodes dos Atributos contidos na Classe.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idGruposLeitores;
        hash = 41 * hash + Objects.hashCode(this.descricao);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.valorMultaDiaria) ^ (Double.doubleToLongBits(this.valorMultaDiaria) >>> 32));
        hash = 41 * hash + this.quantMaxLivros;
        hash = 41 * hash + this.duracaoDiasEmprestimo;
        //hash = 41 * hash + Objects.hashCode(this.leitores);
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
        final GruposLeitores other = (GruposLeitores) obj;
        if (this.idGruposLeitores != other.idGruposLeitores) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorMultaDiaria) != Double.doubleToLongBits(other.valorMultaDiaria)) {
            return false;
        }
        if (this.quantMaxLivros != other.quantMaxLivros) {
            return false;
        }
        if (this.duracaoDiasEmprestimo != other.duracaoDiasEmprestimo) {
            return false;
        }
//        if (!Objects.equals(this.leitores, other.leitores)) {
//            return false;
//        }
        return true;
    }
   
    @Column(length = 40, nullable = false)
    @NaturalId(mutable=true)
    private String descricao;
    
    @Column(length = 2, nullable = false)
    private double valorMultaDiaria;
    
    @Column(length = 2, nullable = false)
    private byte quantMaxLivros;
    
    @Column(length = 2, nullable = false)
    private byte duracaoDiasEmprestimo;
    
     /**
     * @return short idGrupoLeitoresr.
     */
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "gruposLeitores")
//    private List<Leitor> leitores;

   /**
     * @return String idGrupoleitores.
     */
    
    public short getIdGruposLeitores() {
        return idGruposLeitores;
    }
     /**
     * @param idGrupoleitores short.
     */
    
    public void setIdGruposLeitores(short idGruposLeitores) {
        this.idGruposLeitores = idGruposLeitores;
    }
    /**
     * @return String descrição.
     */

    public String getDescricao() {
        return descricao;
    }
      /**
     * @param descrição String.
     */

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    /**
     * @return String valorMultaDiaria.
     */
    public double getValorMultaDiaria() {
        return valorMultaDiaria;
    }
    /**
     * @param valorMultaDiaria String.
     */

    public void setValorMultaDiaria(double valorMultaDiaria) {
        this.valorMultaDiaria = valorMultaDiaria;
    }
      /**
     * @return String QuantMaxLivros.
     */
    public byte getQuantMaxLivros() {
        return quantMaxLivros;
    }

     /**
     * @param QuantMaxLivros String.
     */
    public void setQuantMaxLivros(byte quantMaxLivros) {
        this.quantMaxLivros = quantMaxLivros;
    }

    
    /**
     * @return String DuracaoDiasEmprestimo.
     */
    public byte getDuracaoDiasEmprestimo() {
        return duracaoDiasEmprestimo;
    }

     /**
     * @param DuracaoDiasEmprestimo String.
     */
    public void setDuracaoDiasEmprestimo(byte duracaoDiasEmprestimo) {
        this.duracaoDiasEmprestimo = duracaoDiasEmprestimo;
    }

//    public List<Leitor> getLeitores() {
//        return leitores;
//    }
//
//    public void setLeitores(List<Leitor> leitores) {
//        this.leitores = leitores;
//    }
    private static final long serialVersionUID = -3510357413546466120L;  
    
    public String toString(){
        return descricao+", Q.Dias: "+duracaoDiasEmprestimo+", Q.Livros: "+quantMaxLivros;
    }
}
