package fvsosp.sessao;

import fvsosp.acervo.Acervo;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="sessao")
public class Sessao {

    @Id // chave primária
    @GeneratedValue //auto incrmento
    private int idSessao;
    
    @Column(nullable=false, length=150)
    private int descricao;
    
    /*Uma sessao possui vários acervos
     * quando uma sessao for criada já irá vir carregado com uma lista
     * de acervos pertencentes a ele
     */
    @OneToMany(mappedBy="idAcervo")
    private List<Acervo> acervos;

    /*** @retorna o id da Sessão ***/
    public int getIdSessao() {
        return idSessao;
    }

    /*** @seta o id da Sessão ***/
    public void setIdSessao(int idSessao) {
        this.idSessao = idSessao;
    }

    /*** @retorna a Descrição ***/
    public int getDescricao() {
        return descricao;
    }

    /*** @seta a Descrição da Sessão */
    public void setDescricao(int descricao) {
        this.descricao = descricao;
    }

    /*** @retorna a lista de Acervos ***/
    public List<Acervo> getAcervos() {
        return acervos;
    }

    /*** @seta e copia a lista de Acervos recebida para a lista de Acervos da Classe ***/
    public void setAcervos(List<Acervo> acervos) {
        this.acervos = acervos;
    }
}