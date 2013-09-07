package fvsosp.usuario;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
    
    @Id //chave primária
    @GeneratedValue // campo auto incremento
    private int idUsuario;
    
    @Column(length=50,nullable=false)
    private String login;
    
    @Column(length=50,nullable=false)
    private String senha;

    /**
     * @return the id
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param id the id to set
     */
    public void setIdUsuario(int id) {
        this.idUsuario = id;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = md5(senha);
    }
    
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
}
