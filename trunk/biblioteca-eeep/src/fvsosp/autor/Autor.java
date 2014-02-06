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
package fvsosp.autor;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Type;

/**
 *
 * @author tulio.xcrtf
 */
@Entity
@Table(name = "autor")
public class Autor implements Comparable<Autor>, Serializable {

    /**
     * Método sobrescrito
     *
     * @param o objeto a ser acessado através da Composição.
     * @return inteiro negativo, zero ou um inteiro positivo.
     */
    @Override
    public int compareTo(Autor o) {
        return getNome().compareTo(o.getNome());
    }

    /**
     * Método sobrescrito.
     *
     * @return String contendo o id do Autor e informação Sobre o Autor.
     */
    @Override
    public String toString() {
        return getSobreOAutor() + ", " + getNome();
    }
    @Id // campo chave primária
    @GeneratedValue // campo autoincremento
    private short idAutor;

    /**
     * Método sobrescrito.
     *
     * @return um inteiro(hash) contendo o valor total do cálculo de todos os
     * hashCodes dos Atributos contidos na Classe.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.idAutor;
        hash = 13 * hash + Objects.hashCode(this.nome);
        hash = 13 * hash + Objects.hashCode(this.sobrenome);
        hash = 13 * hash + Objects.hashCode(this.sobreOAutor);
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
        final Autor other = (Autor) obj;
        if (this.idAutor != other.idAutor) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sobrenome, other.sobrenome)) {
            return false;
        }
        if (!Objects.equals(this.sobreOAutor, other.sobreOAutor)) {
            return false;
        }
        return true;
    }
    @Column(nullable = false, length = 70, columnDefinition = "varchar(70) default ''")
    private String nome;
    @Column(nullable = false, length = 70, columnDefinition = "varchar(70) default ''")
    private String sobrenome;
    @Type(type = "text")
    @Column(nullable = false, length = 150)
    private String sobreOAutor;

    /**
     * @return short idAutor.
     */
    public short getIdAutor() {
        return idAutor;
    }

    /**
     * @param idAutor short.
     */
    public void setIdAutor(short idAutor) {
        this.idAutor = idAutor;
    }

    /**
     * @return String nome.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome String.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return String sobreOAutor.
     */
    public String getSobreOAutor() {
        return sobreOAutor;
    }

    /**
     * @param sobreOAutor String.
     */
    public void setSobreOAutor(String sobreOAutor) {
        this.sobreOAutor = sobreOAutor;
    }

    /**
     * @return String sobrenome.
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * @param sobrenome String.
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    private static final long serialVersionUID = 5447515010224855795L;
}