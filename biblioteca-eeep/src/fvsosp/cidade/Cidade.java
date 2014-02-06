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
package fvsosp.cidade;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.NaturalId;

/**
 *
 * @author tulio.xcrtf
 */
@Entity
@Table(name = "cidade")
public class Cidade implements Serializable, Comparable<Cidade> {

    /**
     * Método sobrescrito
     *
     * @param o objeto a ser acessado através da Composição.
     * @return inteiro negativo, zero ou um inteiro positivo.
     */
    @Override
    public int compareTo(Cidade o) {
        return descricao.compareTo(o.descricao);
    }
    @Id // campo chave primária
    @GeneratedValue // campo auto incremento
    private short idCidade;
    @NaturalId(mutable = true)
    private int codIBGE;

    /**
     * Método sobrescrito.
     *
     * @return String contendo o id da Cidade e sua descrição.
     */
    @Override
    public String toString() {
        return descricao + "-" + uf;
    }

    /**
     * Método sobrescrito.
     *
     * @return um inteiro(hash) contendo o valor total do cálculo de todos os
     * hashCodes dos Atributos contidos na Classe.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.getCodIBGE();
        hash = 19 * hash + Objects.hashCode(this.getDescricao());
        hash = 19 * hash + Objects.hashCode(this.getUf());
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
        final Cidade other = (Cidade) obj;
        if (this.getCodIBGE() != other.getCodIBGE()) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.uf, other.uf)) {
            return false;
        }
        return true;
    }
    @Column(length = 62, nullable = false, columnDefinition = "varchar(62) default ''")
    private String descricao;
    @Column(length = 2, nullable = false, columnDefinition = "varchar(2) default ''")
    private String uf;
    private static final long serialVersionUID = -670186122491242513L;

    /**
     * @return short idCidade.
     */
    public short getIdCidade() {
        return idCidade;
    }

    /**
     * @return int codIBGE.
     */
    public int getCodIBGE() {
        return codIBGE;
    }

    /**
     * @param codIBGE int.
     */
    public void setCodIBGE(int codIBGE) {
        this.codIBGE = codIBGE;
    }

    /**
     * @return String descricao.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao String.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return String uf.
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf String.
     */
    public void setUf(String uf) {
        this.uf = uf;
    }
}