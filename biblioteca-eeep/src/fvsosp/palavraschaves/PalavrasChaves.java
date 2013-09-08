package fvsosp.palavraschaves;

import fvsosp.acervo.Acervo;
import java.io.Serializable;
import java.util.List;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "palavraschaves")
public class PalavrasChaves implements Serializable{

    @Id // campo chave primária
    private int idPalavrasChaves;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.idPalavrasChaves;
        hash = 83 * hash + this.descricao;
        hash = 83 * hash + Objects.hashCode(this.acervo);
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
        final PalavrasChaves other = (PalavrasChaves) obj;
        if (this.idPalavrasChaves != other.idPalavrasChaves) {
            return false;
        }
        if (this.descricao != other.descricao) {
            return false;
        }
        if (!Objects.equals(this.acervo, other.acervo)) {
            return false;
        }
        return true;
    }
    
    @Column(length = 40, nullable = false, columnDefinition = "varchar(40) default ''")
    private int descricao;
    /*
     * Um palavraschaves possui muitos acervos, e um acervo possui 
     * muitos palavraschaves, no caso será criada uma nova tabela chamada
     * PalavraschavesAcervo, que possuirá a chave primaria de palavraschaves
     * e a chave primaria de acervo
     * 
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PalavraschavesAcervo", 
            joinColumns = @JoinColumn(name = "idPalavrasChaves"), 
            inverseJoinColumns = @JoinColumn(name = "idAcervo"))
    private List<Acervo> acervo;

    
    /*** @retorna o id da Palavra Chave  ***/  
    public int getIdPalavrasChaves() {
        return idPalavrasChaves;
    }
    /*** @seta o id da Palavra Chave ***/
    public void setIdPalavrasChaves(int idPalavrasChaves) {
        this.idPalavrasChaves = idPalavrasChaves;
    }
    /*** @retorna a descrição ***/
    public int getDescricao() {
        return descricao;
    }
    /*** @seta a descricao ***/
    public void setDescricao(int descricao) {
        this.descricao = descricao;
    }
    /*** @retorna o acervo ***/
    public List<Acervo> getAcervo() {
        return acervo;
    }
    /*** @seta e copia a lista de Acervos recebida para a lista de Acervos da Classe ***/
    public void setAcervo(List<Acervo> acervo) {
        this.acervo = acervo;
    }
    private static final long serialVersionUID = 7848363955215642796L;
    
    
    
}
