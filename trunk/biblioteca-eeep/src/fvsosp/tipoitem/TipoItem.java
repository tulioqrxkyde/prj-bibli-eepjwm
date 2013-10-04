package fvsosp.tipoitem;

import fvsosp.acervo.Acervo;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tipoitem")
public class TipoItem implements Serializable{
    
    @Id //chave primária
    @GeneratedValue //auto incremento
    private short idTipoItem;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idTipoItem;
        hash = 67 * hash + Objects.hashCode(this.descricao);
        hash = 67 * hash + Objects.hashCode(this.acervos);
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
        final TipoItem other = (TipoItem) obj;
        if (this.idTipoItem != other.idTipoItem) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.acervos, other.acervos)) {
            return false;
        }
        return true;
    }
    
    @Column(length=50, nullable=false, columnDefinition = "varchar(50) default ''")
    private String descricao;
    
    @OneToMany(mappedBy="tipoItem")
    private List<Acervo> acervos;

    /**
     * @return the idTipoItem
     */
    public short getIdTipoItem() {
        return idTipoItem;
    }

    /**
     * @param idTipoItem the idTipoItem to set
     */
    public void setIdTipoItem(short idTipoItem) {
        this.idTipoItem = idTipoItem;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the acervos
     */
    public List<Acervo> getAcervos() {
        return acervos;
    }

    /**
     * @param acervos the acervos to set
     */
    public void setAcervos(List<Acervo> acervos) {
        this.acervos = acervos;
    }
    private static final long serialVersionUID = 139376686869872414L;
    
    public String toString(){
        return descricao;
    }
}
