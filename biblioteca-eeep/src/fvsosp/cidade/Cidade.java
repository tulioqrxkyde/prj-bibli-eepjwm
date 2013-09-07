package fvsosp.cidade;

import fvsosp.leitor.Leitor;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "cidade")
public class Cidade {
    
    @Id // campo chave primária
    private int codIBGE;
    
    @Column(length = 62, nullable = false, columnDefinition = "varchar(62) default ''")
    private String descricao;
      
    @Column(length = 2, nullable = false, columnDefinition = "varchar(2) default ''")
    private String uf;
    
    /*Uma cidade possui vários leitores
     * quando uma cidade for criada já irá vir carregada com uma lista
     * de leitores pertencentes a ela
     */
    @OneToMany(mappedBy = "idLeitor")
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
}