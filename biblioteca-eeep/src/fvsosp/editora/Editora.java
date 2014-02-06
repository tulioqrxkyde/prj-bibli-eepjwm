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

package fvsosp.editora;

import fvsosp.acervo.Acervo;
import fvsosp.cidade.Cidade;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "editora")
public class Editora implements Serializable, Comparable<Editora> {
    
     /**
     * Método sobrescrito
     *
     * @param o objeto a ser acessado através da Composição.
     * @return inteiro negativo, zero ou um inteiro positivo.
     */
    @Override
    public int compareTo(Editora o) {
        return nome.compareTo(o.nome);            
    }
    
    @Id
    @GeneratedValue
    private short idEditora;
    @Column(length = 70, nullable = false)
    @NaturalId(mutable=true)
    private String nome;
    
    @ManyToOne
    @JoinColumn(name="idcidade")
    private Cidade cidade;
//    @OneToMany(mappedBy = "editora")
//    private List<Acervo> acervo;

    /*** @retorna o id da Editora ***/
    public short getIdEditora() {
        return idEditora;
    }

    /*** @seta o id da Editora ***/
    public void setIdEditora(short idEditora) {
        this.idEditora = idEditora;
    }

    /*** @retorna o nome da Editora ***/
    public String getNome() {
        return nome;
    }

    /*** @seta o nome da Editora ***/
    public void setNome(String nome) {
        this.nome = nome;
    }

    private static final long serialVersionUID = 3804966434934653111L;
    
    
    /**
     * Método sobrescrito.
     *
     * @return um inteiro(hash) contendo o valor total do cálculo de todos os
     * hashCodes dos Atributos contidos na Classe.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idEditora;
        hash = 41 * hash + Objects.hashCode(this.nome);
        hash = 41 * hash + Objects.hashCode(this.cidade);
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
        final Editora other = (Editora) obj;
        if (this.idEditora != other.idEditora) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        return true;
    }

    /**
     * Método sobrescrito.
     *
     * @return String contendo o Nome da Editora.
     */
    public String toString(){
        return getNome();
    }

    /**
     * @return String cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * @param Cidade String
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}