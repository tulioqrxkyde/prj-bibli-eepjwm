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
package fvsosp.sessao;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.NaturalId;

/**
 *
 * @author oziel.ico
 */
@Entity
@Table(name = "sessao")
public class Sessao implements Serializable, Comparable<Sessao> {

    /**
     * Método sobrescrito.
     *
     * @param o objeto a ser acessado através da Composição.
     * @return inteiro negativo, zero ou um inteiro positivo.
     */
    @Override
    public int compareTo(Sessao o) {
        return descricao.compareTo(o.descricao);
    }
    @Id // chave primária
    @GeneratedValue //auto incrmento
    private short idSessao;

    /**
     * Método sobrescrito.
     *
     * @return um inteiro(hash) contendo o valor total do cálculo de todos os
     * hashCodes dos Atributos contidos na classe.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.idSessao;
        hash = 11 * hash + Objects.hashCode(this.descricao);
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
        final Sessao other = (Sessao) obj;
        if (this.idSessao != other.idSessao) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }
    @NaturalId(mutable = true)
    @Column(nullable = false, length = 150, columnDefinition = "varchar(150) default ''")
    private String descricao;

    /**
     * @return short idSessao.
     */
    public short getIdSessao() {
        return idSessao;
    }

    /**
     * @param idSessao short.
     */
    public void setIdSessao(short idSessao) {
        this.idSessao = idSessao;
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
    private static final long serialVersionUID = 2535742826332189587L;

    /**
     * Método sobrescrito.
     *
     * @return String contendo o id da Sessao e a Descricao.
     */
    @Override
    public String toString() {
        return descricao;
    }
}