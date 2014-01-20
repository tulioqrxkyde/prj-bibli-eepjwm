package fvsosp.editora;

import fvsosp.acervo.Acervo;
import fvsosp.cidade.Cidade;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "editora")
public class Editora implements Serializable {

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idEditora;
        hash = 41 * hash + Objects.hashCode(this.nome);
        hash = 41 * hash + Objects.hashCode(this.cidade);
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
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        return true;
    }

    
   
    
    public String toString(){
        return idEditora+" | "+getNome();
    }

    /**
     * @return the cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}