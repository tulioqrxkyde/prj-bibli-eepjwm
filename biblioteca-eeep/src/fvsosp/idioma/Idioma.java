package fvsosp.idioma;

import fvsosp.acervo.Acervo;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "idioma")
public class Idioma implements Serializable{

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idIdioma;
        hash = 17 * hash + Objects.hashCode(this.descricao);
        hash = 17 * hash + Objects.hashCode(this.acervo);
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
        final Idioma other = (Idioma) obj;
        if (this.idIdioma != other.idIdioma) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.acervo, other.acervo)) {
            return false;
        }
        return true;
    }

    @Id // campo chave primária
    @GeneratedValue //campo auto incremento
    private short idIdioma;
    
    @Column(length = 40, nullable = false, columnDefinition = "varchar(40) default ''")
    private String descricao;

    /*Um idioma possui vários acervos
     * quando um idioma for criado já irá vir carregado com uma lista
     * de acervos pertencentes a ele
     */
    @OneToMany(mappedBy = "idioma")
    private List<Acervo> acervo;

    /*** @retorna o id do Idioma ***/
    public short getIdIdioma() {
        return idIdioma;
    }

    /*** @seta o id do Idioma ***/
    public void setIdIdioma(short idIdioma) {
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
    private static final long serialVersionUID = -3057265994106209062L;
    
    public String toString(){
        return descricao;
    }
}