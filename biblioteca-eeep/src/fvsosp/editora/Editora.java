package fvsosp.editora;

import fvsosp.acervo.Acervo;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "editora")
public class Editora implements Serializable {

    @Id
    @GeneratedValue
    private short idEditora;
    @Column(length = 70, nullable = false)
    private String nome;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idEditora;
        hash = 53 * hash + Objects.hashCode(this.nome);
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
        final Editora other = (Editora) obj;
        if (this.idEditora != other.idEditora) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

   
    
    public String toString(){
        return nome;
    }
}