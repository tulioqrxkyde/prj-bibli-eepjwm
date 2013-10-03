package fvsosp.usuario;

import fvsosp.util.Util;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.NaturalId;
//classe persistente de usuário
@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
    
    @Id // chave primária
    @GeneratedValue // campo auto incremento
    private short idUsuario;

    @NaturalId(mutable=true) // será um valor único mas poderá ser alterado
    @Column(length = 50, nullable = false)
    private String login;
    
    @Column(length = 50, nullable = false)
    private String senha;
    
    @Column(nullable = false)
    private boolean administrador;

    /*** @retorna o id do Usuário ***/
    public short getIdUsuario() {
        return idUsuario;
    }

    /*** @seta o id do Usuário ***/
    public void setIdUsuario(short id) {
        this.idUsuario = id;
    }

    /*** @retorna o Login do Usuário ***/
    public String getLogin() {
        return login;
    }

    /*** @seta o Login do Usuário ***/
    public void setLogin(String login) {
        this.login = login;
    }

    /*** @retorna a Senha do Usuário ***/
    public String getSenha() {
        return senha;
    }

    /*** @seta a senha a passando para o HASH MD5 ***/
    public void setSenha(String senha) {
        this.senha = Util.md5(senha);
    }
    
    
    private static final long serialVersionUID = -8877584534061371241L;

    /**
     * @return the administrador
     */
    public boolean isAdministrador() {
        return administrador;
    }

    /**
     * @param administrador the administrador to set
     */
    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.idUsuario;
        hash = 17 * hash + Objects.hashCode(this.login);
        hash = 17 * hash + Objects.hashCode(this.senha);
        hash = 17 * hash + (this.isAdministrador() ? 1 : 0);
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
    
    
}