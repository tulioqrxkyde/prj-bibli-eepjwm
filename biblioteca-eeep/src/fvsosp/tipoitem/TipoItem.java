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
package fvsosp.tipoitem;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.NaturalId;

/**
 *
 * @author oziel.ico
 */
@Entity
@Table(name = "tipoitem")
public class TipoItem implements Serializable, Comparable<TipoItem> {

    /** 
     * Método sobrescrito
     *
     * @param o objeto a ser acessado através da Composição.
     * @return inteiro negativo, zero ou inteiro positivo.
     */
    @Override
    public int compareTo(TipoItem o) {
        return descricao.compareTo(o.descricao);
    }
    @Id //chave primária
    @GeneratedValue //auto incremento
    private short idTipoItem;

    /**
     * Método sobrescrito
     *
     * @return um inteiro(hash) contendo o valor total do cálculo de todos os
     * hasCodes dos Atributos contidos na classe
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idTipoItem;
        hash = 67 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

    /**
     * Método sobrescrito
     *
     * @param obj a ser acessado através da composição.
     * @return booleando (true|false).
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoItem other = (TipoItem) obj;
        if (this.idTipoItem != other.idTipoItem) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }
    @Column(length = 50, nullable = false, columnDefinition = "varchar(50) default ''")
    @NaturalId(mutable = true)
    private String descricao;

    /**
     * @return short idTipoItem.
     */
    public short getIdTipoItem() {
        return idTipoItem;
    }

    /**
     * @param idTipoItem short.
     */
    public void setIdTipoItem(short idTipoItem) {
        this.idTipoItem = idTipoItem;
    }

    /**
     * @return String descricao.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao String
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    private static final long serialVersionUID = 139376686869872414L;

    /**
     * Método sobrescrito
     *
     * @return String contendo o id do TipoItem e a Descrição.
     */
    @Override
    public String toString() {
           return descricao;
    }
}