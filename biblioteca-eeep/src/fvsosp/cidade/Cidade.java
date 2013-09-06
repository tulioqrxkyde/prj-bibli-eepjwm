package fvsosp.cidade;

import fvsosp.leitor.Leitor;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "cidade")
public class Cidade {
    
    @Id
    @GeneratedValue
    private int codIBGE;
    
    @Column(length = 150, nullable = true)
    private String descricao;
    
    @Column(length = 16, nullable = false)
    private int id;
    
    @Column(length = 21, nullable = true)
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

    /*** @retorna o ID da Cidade ***/
    public int getId() {
        return id;
    }

    /*** @seta o ID da Cidade ***/
    public void setId(int id) {
        this.id = id;
    }

    /*** @retorna o Estado ***/
    public String getUf() {
        return uf;
    }

    /*** @seta o Estado ***/
    public void setUf(String uf) {
        this.uf = uf;
    }

    /*** @retorna a Lista de Leitores ***/
    public List<Leitor> getLeitores() {
        return leitores;
    }

    /*** @seta e copia a Lista de Leitores recebida para a Lista da Classe ***/
    public void setLeitores(List<Leitor> leitores) {
        this.leitores = leitores;
    }
}