package fvsosp.cidade;

import fvsosp.leitor.Leitor;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "cidade")
public class Cidade {
    
    @Id
    private int codIBGE;
    
    @Column(length = 62, nullable = true)
    private String descricao;
      
    @Column(length = 2, nullable = true)
    private String uf;
    
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