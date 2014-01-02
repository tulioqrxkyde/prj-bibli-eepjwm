package fvsosp.biblioteca;

import fvsosp.acervo.Acervo;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "biblioteca")
public class Biblioteca implements Serializable{

    @Id // campo chave primária
    @GeneratedValue // campo auto incremento
    private short idBiblioteca;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.idBiblioteca;
        hash = 11 * hash + Objects.hashCode(this.descricao);
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
        final Biblioteca other = (Biblioteca) obj;
        if (this.idBiblioteca != other.idBiblioteca) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }

    @Column(length = 70, nullable = false, columnDefinition = "varchar(70) default ''") 
    private String descricao;
    
    /*Uma biblioteca possui vários acervos
     * quando uma biblioteca for criada já irá vir carregado com uma lista
     * de acervos pertencentes a ele
     */
//    @OneToMany(mappedBy = "biblioteca")
//    private List<Acervo> acervos;

    /*** @retorna o ID da Biblioteca ***/
    public short getIdBiblioteca() {
        return idBiblioteca;
    }

    /*** @retorna a descricao ***/
    public String getDescricao() {
        return descricao;
    }

    /*** @seta o nome do Idioma ***/
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    private static final long serialVersionUID = 8467106441036780639L;
    
    public String toString(){
        return descricao;
    }
}