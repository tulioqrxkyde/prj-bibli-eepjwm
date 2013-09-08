package fvsosp.editora;

import fvsosp.acervo.Acervo;
import fvsosp.cidade.Cidade;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="editora")
public class Editora implements Serializable{

    @Id
    @GeneratedValue
    private int idEditora;
    
    @Column(length=150, nullable=false)
    private String nome;
    
    @OneToMany(mappedBy="idacervo")
    private List<Acervo> acervo;

    /**
     * @return the idEditora
     */
    public int getIdEditora() {
        return idEditora;
    }

    /**
     * @param idEditora the idEditora to set
     */
    public void setIdEditora(int idEditora) {
        this.idEditora = idEditora;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the acervo
     */
    public List<Acervo> getAcervo() {
        return acervo;
    }

    /**
     * @param acervo the acervo to set
     */
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
