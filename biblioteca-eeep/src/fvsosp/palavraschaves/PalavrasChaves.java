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

package fvsosp.palavraschaves;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.NaturalId;

/**
 *
 * @author oziel.ico
 */
@Entity
@Table(name = "palavraschaves")
public class PalavrasChaves implements Serializable, Comparable<PalavrasChaves> {

    /**
     * Método sobrescrito.
     *
     * @param o objeto a ser acessado através da Composição.
     * @return inteiro negativo, zero ou um inteiro positivo.
     */
    @Override
    public int compareTo(PalavrasChaves o) {
        return descricao.compareTo(o.descricao);
    }
    @Id // campo chave primária
    @GeneratedValue
    private short idPalavrasChaves;

    /**
     * Método sobrescrito.
     *
     * @return um inteiro(hash) contendo o valor total do cálculo de todos os
     * hashCodes dos Atributos contidos na classe.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idPalavrasChaves;
        hash = 97 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

    /**
     * Método sobrescrito.
     *
     * @param obj a ser acessado através da Composição.
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
        final PalavrasChaves other = (PalavrasChaves) obj;
        if (this.idPalavrasChaves != other.idPalavrasChaves) {
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
     * @return short idPalavrasChaves.
     */
    public short getIdPalavrasChaves() {
        return idPalavrasChaves;
    }

    /**
     * @param idPalavrasChaves short.
     */
    public void setIdPalavrasChaves(short idPalavrasChaves) {
        this.idPalavrasChaves = idPalavrasChaves;
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
    private static final long serialVersionUID = 7848363955215642796L;

    /**
     * Método sobrescrito.
     *
     * @return String contendo o id de PalavrasChaves e a descricão.
     */
    @Override
    public String toString() {
        return idPalavrasChaves + " | " + descricao;
    }
}
