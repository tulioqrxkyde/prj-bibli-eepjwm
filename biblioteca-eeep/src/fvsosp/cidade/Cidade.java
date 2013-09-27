package fvsosp.cidade;

import fvsosp.leitor.Leitor;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "cidade")
public class Cidade implements Serializable{

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    
    @Id // campo chave primária
    @GeneratedValue // campo auto incremento
    private short idCidade;
    
    @NaturalId
    private int codIBGE;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.getCodIBGE();
        hash = 19 * hash + Objects.hashCode(this.getDescricao());
        hash = 19 * hash + Objects.hashCode(this.getUf());
       // hash = 19 * hash + Objects.hashCode(this.getLeitores());
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
//        if (!Objects.equals(this.leitores, other.leitores)) {
//            return false;
//        }
        return true;
    }
    
    @Column(length = 62, nullable = false, columnDefinition = "varchar(62) default ''")
    private String descricao;
      
    @Column(length = 2, nullable = false, columnDefinition = "varchar(2) default ''")
    private String uf;
    
    /*Uma cidade possui vários leitores
     * quando uma cidade for criada já irá vir carregada com uma lista
     * de leitores pertencentes a ela
     */
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cidade") 
//    private List<Leitor> leitores;

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

    /*** @retorna a lista de Leitores ***/
//    public List<Leitor> getLeitores() {
//        return leitores;
//    }

     private static long serialVersionUID = -5660386351782012215L;

    /**
     * @return the idCidade
     */
    public short getIdCidade() {
        return idCidade;
    }

    /**
     * @param idCidade the idCidade to set
     */
    public void setIdCidade(short idCidade) {
        this.idCidade = idCidade;
    }

    /**
     * @param leitores the leitores to set
     */
//    public void setLeitores(List<Leitor> leitores) {
//        this.leitores = leitores;
//    }
//    
    public String toString(){
        return descricao+"-"+uf;
    }
    
}