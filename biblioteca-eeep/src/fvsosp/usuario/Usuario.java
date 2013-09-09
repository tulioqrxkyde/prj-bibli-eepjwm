package fvsosp.usuario;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
    
    @Id // chave primária
    @GeneratedValue // campo auto incremento
    private int idUsuario;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.idUsuario;
        hash = 13 * hash + Objects.hashCode(this.login);
        hash = 13 * hash + Objects.hashCode(this.senha);
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
        return true;
    }
    
    @Column(length = 50, nullable = false)
    private String login;
    
    @Column(length = 50, nullable = false)
    private String senha;

    /*** @retorna o id do Usuário ***/
    public int getIdUsuario() {
        return idUsuario;
    }

    /*** @seta o id do Usuário ***/
    public void setIdUsuario(int id) {
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
        this.senha = md5(senha);
    }
    
    /* @MD5 Método de Encriptação da Senha em um HASH Hexadecimal */
    public String md5(String senha){ 
        MessageDigest md = null;  
        try {  
            md = MessageDigest.getInstance("MD5");  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));            
        return ((String) hash.toString(16));
    } 
    private static final long serialVersionUID = -8877584534061371241L;
}