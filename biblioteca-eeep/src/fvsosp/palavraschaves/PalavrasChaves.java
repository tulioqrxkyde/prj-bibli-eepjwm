package fvsosp.palavraschaves;

import fvsosp.acervo.Acervo;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "palavraschaves")
public class PalavrasChaves implements Serializable {

    @Id // campo chave primária
    @GeneratedValue
    private short idPalavrasChaves;

    @Override
    public String toString() {
        return descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idPalavrasChaves;
        hash = 97 * hash + Objects.hashCode(this.descricao);
        hash = 97 * hash + Objects.hashCode(this.acervo);
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
        final PalavrasChaves other = (PalavrasChaves) obj;
        if (this.idPalavrasChaves != other.idPalavrasChaves) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.acervo, other.acervo)) {
            return false;
        }
        return true;
    }

    @Column(length = 50, nullable = false)
    private String descricao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idAcervo")
    private Acervo acervo;
    
    /*** @retorna o id da Palavra Chave  ***/  
    public short getIdPalavrasChaves() {
        return idPalavrasChaves;
    }

    /*** @retorna a descrição ***/
    public String getDescricao() {
        return descricao;
    }
    /*** @seta a descricao ***/
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    /*** @retorna o acervo ***/
    public Acervo getAcervo() {
        return acervo;
    }
    /*** @seta e copia a lista de Acervos recebida para a lista de Acervos da Classe ***/
    public void setAcervo(Acervo acervo) {
        this.acervo = acervo;
    }
    private static final long serialVersionUID = -1085036742052129260L;   
}