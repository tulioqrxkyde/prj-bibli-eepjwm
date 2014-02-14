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
package fvsosp.usuario;

import fvsosp.util.Util;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.NaturalId;

/**
 *
 * @author pedrosaraiva
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable, Comparable<Usuario> {

    /**
     * Método sobrescrito
     *
     * @param o objeto a ser acessado através da Composição.
     * @return inteiro negativo, zero ou inteiro positivo.
     */
    @Override
    public int compareTo(Usuario o) {
        return login.compareTo(o.login);
    }
    @Id // chave primária
    @GeneratedValue // campo auto incremento
    private short idUsuario;
    @NaturalId(mutable = true) // será um valor único mas poderá ser alterado
    @Column(length = 50, nullable = false)
    private String login;
    @Column(length = 50, nullable = false)
    private String senha;
    @Column(nullable = false)
    private boolean administrador;

    /**
     * @return short IdUsuario.
     */
    public short getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param id short.
     */
    public void setIdUsuario(short id) {
        this.idUsuario = id;
    }

    /**
     * @return String login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login String.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return String senha.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha String.
     */
    public void setSenha(String senha) {
        this.senha = Util.md5(senha);
    }
    private static final long serialVersionUID = -8877584534061371241L;

    /**
     * @return boolean administrador.
     */
    public boolean isAdministrador() {
        return administrador;
    }

    /**
     * @param administrador boolean.
     */
    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    /**
     * Método sobrescrito
     *
     * @return um inteiro(hash) contendo o valor total do cálculo de todos os
     * hasCodes dos Atributos contidos na classe.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.idUsuario;
        hash = 17 * hash + Objects.hashCode(this.login);
        hash = 17 * hash + Objects.hashCode(this.senha);
        hash = 17 * hash + (this.isAdministrador() ? 1 : 0);
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
        final Usuario other = (Usuario) obj;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (this.isAdministrador() != other.isAdministrador()) {
            return false;
        }
        return true;
    }

    /**
     * Método sobrescrito
     *
     * @return String contendo o id do Usuario e o Login.
     */
    @Override
    public String toString() {
        return idUsuario + " | " + login;
    }
}
