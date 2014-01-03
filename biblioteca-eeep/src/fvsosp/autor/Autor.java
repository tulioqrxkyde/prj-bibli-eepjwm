package fvsosp.autor;

import fvsosp.acervo.Acervo;
import java.io.Serializable;

import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Type;


@Entity
@Table(name="autor")
public class Autor implements Comparable<Autor> {

     @Override
    public int compareTo(Autor o) {        
        return nome.compareTo(o.nome);            
    }
    
    @Id // campo chave primária
    @GeneratedValue // campo autoincremento
    private short idAutor;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idAutor;
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Objects.hashCode(this.sobreOAutor);
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
        final Autor other = (Autor) obj;
        if (this.idAutor != other.idAutor) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sobreOAutor, other.sobreOAutor)) {
            return false;
        }
        return true;
    }
    
    // not null de tamanho 70 e valor padrão ''
    @Column(nullable = false, length = 70, columnDefinition = "varchar(70) default ''") 
    private String nome;
    
    @Type(type="text")
    @Column(nullable = false, length = 150)
    private String sobreOAutor;
    
       
    /*** @retorna o id do Autor ***/
    public short getIdAutor() {
        return idAutor;
    }

    /*** @seta o id do Autor ***/
    public void setIdAutor(short idAutor) {
        this.idAutor = idAutor;
    }

    /*** @retorna o nome do Autor ***/
    public String getNome() {
        return nome;
    }

    /*** @seta o nome do Autor ***/
    public void setNome(String nome) {
        this.nome = nome;
    }

    /*** @retorna as informações sobre o Autor ***/
    public String getSobreOAutor() {
        return sobreOAutor;
    }

    /*** @seta as informações do Autor ***/
    public void setSobreOAutor(String sobreOAutor) {
        this.sobreOAutor = sobreOAutor;
    }

    /*** @retorna a lista de Acervos ***/
    public String toString(){
        return nome;
    }
}