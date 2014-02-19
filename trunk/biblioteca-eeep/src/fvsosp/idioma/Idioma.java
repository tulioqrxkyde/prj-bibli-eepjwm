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

package fvsosp.idioma;

import fvsosp.acervo.Acervo;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.NaturalId;

/**
 *
 * @author Francisco Junior
 */
@Entity
@Table(name = "idioma")
public class Idioma implements Serializable {

    /**
     * Método sobrescrito
     *
     * @param o objeto a ser acessado através da Composição.
     * @return inteiro negativo, zero ou um inteiro positivo.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idIdioma;
        hash = 17 * hash + Objects.hashCode(this.descricao);
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
        final Idioma other = (Idioma) obj;
        if (this.idIdioma != other.idIdioma) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }
    @Id // campo chave primária
    @GeneratedValue //campo auto incremento
    private short idIdioma;
    @Column(length = 40, nullable = false, columnDefinition = "varchar(40) default ''")
    @NaturalId(mutable = true)
    private String descricao;

    /**
     * * @retorna o id do Idioma **
     */
    public short getIdIdioma() {
        return idIdioma;
    }

    /**
     * * @seta o id do Idioma **
     */
    public void setIdIdioma(short idIdioma) {
        this.idIdioma = idIdioma;
    }

    /**
     * * @retorna o nome do Idioma **
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * * @seta o nome do Idioma **
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    private static final long serialVersionUID = -3057265994106209062L;

    public String toString() {
        return  descricao;
    }
}