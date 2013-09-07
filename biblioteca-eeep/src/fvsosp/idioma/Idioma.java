package fvsosp.idioma;

import fvsosp.acervo.Acervo;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Idioma")
public class Idioma {

    @Id
    private int idIdioma;
    
    @Column(length = 40, nullable = true)
    private String descricao;

    @OneToMany(mappedBy = "idAcervo")
    private List<Acervo> acervo;

    /*** @retorna o id do Idioma ***/
    public int getIdIdioma() {
        return idIdioma;
    }

    /*** @seta o id do Idioma ***/
    public void setIdIdioma(int idIdioma) {
        this.idIdioma = idIdioma;
    }

    /*** @retorna o nome do Idioma ***/
    public String getDescricao() {
        return descricao;
    }

    /*** @seta o nome do Idioma ***/
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /*** @retorna a lista de Acervos ***/
    public List<Acervo> getAcervo() {
        return acervo;
    }

    /*** @seta e copia a lista de Acervos recebida para a lista de Acervos da Classe ***/
    public void setAcervo(List<Acervo> acervo) {
        this.acervo = acervo;
    }
}