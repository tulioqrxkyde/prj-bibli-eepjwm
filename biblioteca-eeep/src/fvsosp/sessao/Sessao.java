package fvsosp.sessao;

import fvsosp.acervo.Acervo;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sessao")
public class Sessao {

    @Id
    @GeneratedValue
    private int idSessao;
    
    @Column(nullable=true, length=150)
    private int descricao;
    
    @OneToMany(mappedBy="idAcervo")
    private List<Acervo> acervos;

    /**
     * @return the idSessao
     */
    public int getIdSessao() {
        return idSessao;
    }

    /**
     * @param idSessao the idSessao to set
     */
    public void setIdSessao(int idSessao) {
        this.idSessao = idSessao;
    }

    /**
     * @return the descricao
     */
    public int getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(int descricao) {
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
}
