package fvsosp.sessao;

import fvsosp.acervo.Acervo;
import fvsosp.leitor.Leitor;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="sessao")
public class Sessao implements Serializable, Comparable<Sessao>{

    @Override
    public int compareTo(Sessao o) {
        return descricao.compareTo(o.descricao);            
    }
    
    @Id // chave primária
    @GeneratedValue //auto incrmento
    private short idSessao;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.idSessao;
        hash = 11 * hash + Objects.hashCode(this.descricao);
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
        return true;
    }
    
    @NaturalId(mutable=true)
    @Column(nullable = false, length = 150, columnDefinition = "varchar(150) default ''")
    private String descricao;


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

    private static final long serialVersionUID = 2535742826332189587L;
    
    public String toString(){
        return idSessao+" | "+descricao;
    }
}