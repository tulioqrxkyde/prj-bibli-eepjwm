package fvsosp.sessao;

import fvsosp.acervo.Acervo;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name="sessao")
public class Sessao implements Serializable{

    @Id // chave primária
    @GeneratedValue //auto incrmento
    private short idSessao;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.idSessao;
        hash = 11 * hash + Objects.hashCode(this.descricao);
        hash = 11 * hash + Objects.hashCode(this.acervos);
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
        final Sessao other = (Sessao) obj;
        if (this.idSessao != other.idSessao) {
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
    
    @Column(nullable = false, length = 150, columnDefinition = "varchar(150) default ''")
    private String descricao;
    
    /*Uma sessao possui vários acervos
     * quando uma sessao for criada já irá vir carregado com uma lista
     * de acervos pertencentes a ele
     */
    @OneToMany(mappedBy="sessao")
    private List<Acervo> acervos;

    /*** @retorna o id da Sessão ***/
    public short getIdSessao() {
        return idSessao;
    }

    /*** @seta o id da Sessão ***/
    public void setIdSessao(short idSessao) {
        this.idSessao = idSessao;
    }

    /*** @retorna a Descrição ***/
    public String getDescricao() {
        return descricao;
    }

    /*** @seta a Descrição da Sessão */
    public void setDescricao(String descricao) {
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
    private static final long serialVersionUID = 2535742826332189587L;
}