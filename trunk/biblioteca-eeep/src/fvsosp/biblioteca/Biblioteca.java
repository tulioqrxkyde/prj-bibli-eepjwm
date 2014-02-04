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
package fvsosp.biblioteca;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.NaturalId;

/**
 *
 * @author tulio.xcrtf
 */
@Entity
@Table(name = "biblioteca")
public class Biblioteca implements Serializable {

    @Id // campo chave primária
    @GeneratedValue // campo auto incremento
    private short idBiblioteca;
    
    private static final long serialVersionUID = 8467106441036780639L;

    /**
     * Método sobrescrito.
     *
     * @return um inteiro(hash) contendo o valor total do cálculo de todos os
     * hashCodes dos Atributos contidos na Classe.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.idBiblioteca;
        hash = 11 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

    /**
     * Método sobrescrito.
     *
     * @return String contendo o id da Biblioteca e a descricao sobre ela.
     */
    public String toString() {
        return idBiblioteca + " | " + descricao;
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
        final Biblioteca other = (Biblioteca) obj;
        if (this.idBiblioteca != other.idBiblioteca) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }
    @Column(length = 70, nullable = false, columnDefinition = "varchar(70) default ''")
    @NaturalId(mutable = true)
    private String descricao;

    /**
     * @return short idBiblioteca.
     */
    public short getIdBiblioteca() {
        return idBiblioteca;
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
}