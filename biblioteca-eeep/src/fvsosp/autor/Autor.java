package fvsosp.autor;

import fvsosp.acervo.Acervo;

import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Type;


@Entity
@Table(name="autor")
public class Autor {

    @Id // campo chave primária
    @GeneratedValue // campo autoincremento
    private short idAutor;
    
    // not null de tamanho 70 e valor padrão ''
    @Column(nullable = false, length = 70, columnDefinition = "varchar(70) default ''") 
    private String nome;
    
    @Type(type="text")
    @Column(nullable = false, length = 150)
    private String sobreOAutor;
    
    /* Um autor possui vários acervos
     * quando um autor for criado já irá vir carregado com uma lista
     * de acervos pertencentes a ele
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "AutorAcervo", 
            joinColumns = @JoinColumn(name = "idAutor"), 
            inverseJoinColumns = @JoinColumn(name = "idAcervo"))
    private List<Acervo> acervo;
    
    /*** @retorna o id do Autor ***/
    public short getIdAutor() {
        return idAutor;
    }

    /*** @seta o id do Autor ***/
    public void setIdAutor(short idAutor) {
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
        return acervo;
    }

    /*** @seta e copia a lista de Acervos recebida para a lista da Classe ***/
    public void setAcervos(List<Acervo> acervos) {
        this.acervo = acervo;
    }
}