package fvsosp.especificacoes;

import fvsosp.acervo.Acervo;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "especificacoestecnicas")
public class EspecificacoesTecnicas implements Serializable {

    @Id
    @GeneratedValue
    private short idEspecificacoesTecnicas;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.idEspecificacoesTecnicas;
        hash = 23 * hash + this.numeroPaginas;
        hash = 23 * hash + this.peso;
        hash = 23 * hash + Objects.hashCode(this.acabamentoCapa);
        hash = 23 * hash + Objects.hashCode(this.acabamentoMiolo);
       // hash = 23 * hash + Objects.hashCode(this.acervo);
        return hash;
    }

    @Override
    public String toString() {
        return "{" + "Nº Páginas=" + numeroPaginas + ", Peso=" + peso + ", AcabamentoCapa=" + acabamentoCapa + ", AcabamentoMiolo=" + acabamentoMiolo + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EspecificacoesTecnicas other = (EspecificacoesTecnicas) obj;
        if (this.idEspecificacoesTecnicas != other.idEspecificacoesTecnicas) {
            return false;
        }
        if (this.numeroPaginas != other.numeroPaginas) {
            return false;
        }
        if (this.peso != other.peso) {
            return false;
        }
        if (!Objects.equals(this.acabamentoCapa, other.acabamentoCapa)) {
            return false;
        }
        if (!Objects.equals(this.acabamentoMiolo, other.acabamentoMiolo)) {
            return false;
        }
  //      if (!Objects.equals(this.acervo, other.acervo)) {
    //        return false;
     //   }
        return true;
    }

    @Column(length = 7, nullable = false, columnDefinition = "smallint default '0'")
    private short numeroPaginas;

    @Column(length = 7, nullable = false, columnDefinition = "smallint default '0'")
    private short peso;

    @Column(length = 30, nullable = false, columnDefinition = "varchar(30) default ''")
    private String acabamentoCapa;

    @Column(length = 30, nullable = false, columnDefinition = "varchar(30) default ''")
    private String acabamentoMiolo;

    @OneToOne(mappedBy = "especificacoesTecnicas")
    private Acervo acervo;

    /*** @retorna o id das Especificações Técnicas ***/
    public short getIdEspecificacoesTecnicas() {
        return idEspecificacoesTecnicas;
    }

    /*** @retorna o Número de Páginas do livro ***/
    public short getNumeroPaginas() {
        return numeroPaginas;
    }

    /*** @seta o Número de Páginas do livro ***/
    public void setNumeroPaginas(short numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    /*** @retorna o Peso do livro ***/
    public short getPeso() {
        return peso;
    }

    /*** @seta o peso do livro ***/
    public void setPeso(short peso) {
        this.peso = peso;
    }

    /*** @retorna o tipo de Acabamento da capa do livro ***/
    public String getAcabamentoCapa() {
        return acabamentoCapa;
    }

    /*** @seta o tipo de acabamento da capa do livro ***/
    public void setAcabamentoCapa(String acabamentoCapa) {
        this.acabamentoCapa = acabamentoCapa;
    }

    /*** @retorna o acabamento do miolo do livro ***/
    public String getAcabamentoMiolo() {
        return acabamentoMiolo;
    }

    /*** @seta o acabamento do miolo do livro ***/
    public void setAcabamentoMiolo(String acabamentoMiolo) {
        this.acabamentoMiolo = acabamentoMiolo;
    }

    /*** @retorna o Acervo ***/
    public Acervo getAcervo() {
        return acervo;
    }

    /*** @seta e copia o Acervo do livro recebido para o Acervo da Classe ***/
    public void setAcervo(Acervo acervo) {
        this.acervo = acervo;
    }

    private static final long serialVersionUID = -6626525357639762449L;

}