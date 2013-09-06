package fvsosp.autor;

import fvsosp.acervo.Acervo;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="aluno")
public class Autor {

    @Id
    @GeneratedValue
    private int idAutor;
    
    @Column(nullable=true, length=150)
    private String nome;
    
    private String sobreOAutor;
    
    @OneToMany(mappedBy="idAcervo")
    private List<Acervo> acervos;

    /**
     * @return the idAutor
     */
    public int getIdAutor() {
        return idAutor;
    }

    /**
     * @param idAutor the idAutor to set
     */
    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
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
     * @return the sobreOAutor
     */
    public String getSobreOAutor() {
        return sobreOAutor;
    }

    /**
     * @param sobreOAutor the sobreOAutor to set
     */
    public void setSobreOAutor(String sobreOAutor) {
        this.sobreOAutor = sobreOAutor;
    }

    /**
     * @return the acervos
     */
    public List<Acervo> getAcervos() {
        return acervos;
    }

    /**
     * @param acervos the acervos to set
     */
    public void setAcervos(List<Acervo> acervos) {
        this.acervos = acervos;
    }
}
