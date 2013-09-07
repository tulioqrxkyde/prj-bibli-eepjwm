package fvsosp.usuario;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario {
    
    @Id // chave primária
    @GeneratedValue // campo auto incremento
    private int idUsuario;
    
    @Column(length = 50, nullable = false, columnDefinition = "varchar(50) default ''")
    private String login;
    
    @Column(length = 50, nullable = false, columnDefinition = "varchar(50) default ''")
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
}