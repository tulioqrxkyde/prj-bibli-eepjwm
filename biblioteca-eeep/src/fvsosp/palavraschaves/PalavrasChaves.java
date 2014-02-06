package fvsosp.palavraschaves;

import fvsosp.acervo.Acervo;
import java.io.Serializable;
import java.util.List;
import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "palavraschaves")
public class PalavrasChaves implements Serializable, Comparable<PalavrasChaves> {
    
    @Override
    public int compareTo(PalavrasChaves o) {        
        return descricao.compareTo(o.descricao);            
    }

    @Id // campo chave primária
    @GeneratedValue
    private short idPalavrasChaves;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idPalavrasChaves;
        hash = 97 * hash + Objects.hashCode(this.descricao);
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
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        
        return true;
    }

    
    @Column(length = 50, nullable = false, columnDefinition = "varchar(50) default ''")
    @NaturalId(mutable=true)
    private String descricao;   

    
    /*** @retorna o id da Palavra Chave  ***/  
    public short getIdPalavrasChaves() {
        return idPalavrasChaves;
    }
    /*** @seta o id da Palavra Chave ***/
    public void setIdPalavrasChaves(short idPalavrasChaves) {
        this.idPalavrasChaves = idPalavrasChaves;
    }
    /*** @retorna a descrição ***/
    public String getDescricao() {
        return descricao;
    }
    /*** @seta a descricao ***/
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
   
    private static final long serialVersionUID = 7848363955215642796L;
    
    public String toString(){
        return descricao;
    }
    
    
    
}
