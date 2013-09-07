package fvsosp.autor;

import fvsosp.acervo.Acervo;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name="aluno")
public class Autor {

    @Id // campo chave primária
    @GeneratedValue // campo autoincremento
    private int idAutor;
    
    @Column(nullable = false, length = 150, columnDefinition = "varchar(150) default ''") // not null de tamanho 150
    private String nome;
    
    @Column(nullable = false, length = 200, columnDefinition = "varchar(200) default ''")
    private String sobreOAutor;
    
    /* Um autor possui vários acervos
     * quando um autor for criado já irá vir carregado com uma lista
     * de acervos pertencentes a ele
     */
    @OneToMany(mappedBy="idAcervo")
    private List<Acervo> acervos;

    /*** @retorna o id do Autor ***/
    public int getIdAutor() {
        return idAutor;
    }

    /*** @seta o id do Autor ***/
    public void setIdAutor(int idAutor) {
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
    public List<Acervo> getAcervos() {
        return acervos;
    }

    /*** @seta e copia a lista de Acervos recebida para a lista da Classe ***/
    public void setAcervos(List<Acervo> acervos) {
        this.acervos = acervos;
    }
}