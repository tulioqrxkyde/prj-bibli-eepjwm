package fvsosp.cidade;

import fvsosp.leitor.Leitor;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "cidade")
public class Cidade implements Serializable{
    
    @Id // campo chave primária
    private int codIBGE;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.codIBGE;
        hash = 19 * hash + Objects.hashCode(this.descricao);
        hash = 19 * hash + Objects.hashCode(this.uf);
        hash = 19 * hash + Objects.hashCode(this.leitores);
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
        if (this.codIBGE != other.codIBGE) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.uf, other.uf)) {
            return false;
        }
        if (!Objects.equals(this.leitores, other.leitores)) {
            return false;
        }
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
    @OneToMany(mappedBy = "cidade")
    private List<Leitor> leitores;

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
    public List<Leitor> getLeitores() {
        return leitores;
    }

    /*** @seta e copia a lista de Leitores recebida para a lista da Classe ***/
    public void setLeitores(List<Leitor> leitores) {
        this.leitores = leitores;
    }
    private static final long serialVersionUID = -5660386351782012215L;
}