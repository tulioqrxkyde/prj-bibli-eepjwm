package fvsosp.palavraschaves;

import fvsosp.acervo.Acervo;
import java.util.List;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "PalavrasChaves")
public class PalavrasChaves {

    @Id // campo chave primária
    private int idPalavrasChaves;
    
    @Column(length = 40, nullable = false, columnDefinition = "varchar(40) default ''")
    private int descricao;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PalavraschavesAcervo", joinColumns = @JoinColumn(name = "idPalavrasChaves"), inverseJoinColumns = @JoinColumn(name = "idAcervo"))
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
    
    
    
}
