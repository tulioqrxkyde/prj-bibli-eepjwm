package fvsosp.cidade;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "cidade")
public class Cidade implements Serializable {

    @Id // campo chave primária
    @GeneratedValue // campo auto incremento
    private short idCidade;
    
    @NaturalId(mutable=true)
    private int codIBGE;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.getCodIBGE();
        hash = 19 * hash + Objects.hashCode(this.getDescricao());
        hash = 19 * hash + Objects.hashCode(this.getUf());
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
        final Cidade other = (Cidade) obj;
        if (this.getCodIBGE() != other.getCodIBGE()) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.uf, other.uf)) {
            return false;
        }
        return true;
    }
    
    @Column(length = 62, nullable = false, columnDefinition = "varchar(62) default ''")
    private String descricao;
      
    @Column(length = 2, nullable = false, columnDefinition = "varchar(2) default ''")
    private String uf;
    
    private static final long serialVersionUID = -670186122491242513L;
    
     /*** @retorna o id da Cidade ***/
    public short getIdCidade() {
        return idCidade;
    }
    
    /*** @retorna o código do IBGE ***/
    public int getCodIBGE() {
        return codIBGE;
    }

    /*** @seta o código do IBGE ***/
    public void setCodIBGE(int codIBGE) {
        this.codIBGE = codIBGE;
    }

    /*** @retorna a Descrição da Cidade ***/
    public String getDescricao() {
        return descricao;
    }

    /*** @seta a Descrição da Cidade ***/
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /*** @retorna o Estado ***/
    public String getUf() {
        return uf;
    }

    /*** @seta o Estado ***/
    public void setUf(String uf) {
        this.uf = uf;
    }

    public String toString(){
        return idCidade+" | "+descricao+"-"+uf;
    }
}