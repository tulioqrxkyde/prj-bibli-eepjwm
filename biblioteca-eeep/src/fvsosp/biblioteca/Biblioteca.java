package fvsosp.biblioteca;

import fvsosp.acervo.Acervo;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Biblioteca")
public class Biblioteca {

    @Id //campo chave primária
    @GeneratedValue // campo auto incremento
    private int idBiblioteca;
    
    @Column(length = 70, nullable = true) 
    private String descricao;
    
    /*Uma biblioteca possui vários acervos
     * quando um autor for criado já irá vir carregado com uma lista
     * de acervos pertencentes a ele
     */
    @OneToMany(mappedBy = "idAcervo")
    private List<Acervo> acervos;

    /*** @retorna o ID da Biblioteca ***/
    public int getIdBiblioteca() {
        return idBiblioteca;
    }

    /*** @seta o ID da Biblioteca ***/
    public void setIdBiblioteca(int idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    /*** @retorna a descricao ***/
    public String getDescricao() {
        return descricao;
    }

    /*** @seta o nome do Idioma ***/
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /*** @retorna uma Lista de Acervos ***/
    public List<Acervo> getAcervos() {
        return acervos;
    }

    /*** @seta e copia uma lista de Acervos ***/
    public void setAcervos(List<Acervo> acervos) {
        this.acervos = acervos;
    }
}