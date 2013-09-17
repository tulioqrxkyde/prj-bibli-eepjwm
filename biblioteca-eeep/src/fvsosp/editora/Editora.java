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
    @OneToMany(mappedBy = "editora")
    private List<Acervo> acervo;

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

    /*** @retorna uma lista de Acervos ***/
    public List<Acervo> getAcervo() {
        return acervo;
    }

    /*** @seta e copia a lista de Acervos recebida para a lista da Classe ***/
    public void setAcervo(List<Acervo> acervo) {
        this.acervo = acervo;
    }
    private static final long serialVersionUID = 3804966434934653111L;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idEditora;
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.acervo);
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
        if (!Objects.equals(this.acervo, other.acervo)) {
            return false;
        }
        return true;
    }
}