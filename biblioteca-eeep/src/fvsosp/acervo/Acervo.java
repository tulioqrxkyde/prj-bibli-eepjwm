package fvsosp.acervo;

import fvsosp.exemplar.Exemplar;
import fvsosp.autor.Autor;
import fvsosp.biblioteca.Biblioteca;
import fvsosp.editora.Editora;
import fvsosp.especificacoes.EspecificacoesTecnicas;
import fvsosp.idioma.Idioma;
import fvsosp.sessao.Sessao;
import fvsosp.tipoitem.TipoItem;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="acervo")
public class Acervo implements Serializable{

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    @Id
    @GeneratedValue
    private int idAcervo;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idAcervo;
        hash = 79 * hash + Objects.hashCode(this.tituloObra);
        hash = 79 * hash + Objects.hashCode(this.subtituloObra);
        hash = 79 * hash + Objects.hashCode(this.isbn);
        hash = 79 * hash + Objects.hashCode(this.volume);
        hash = 79 * hash + Objects.hashCode(this.edicao);
        hash = 79 * hash + this.anoEdicao;
        hash = 79 * hash + Objects.hashCode(this.informacoesAdicionais);
        hash = 79 * hash + Objects.hashCode(this.localizacao);
        hash = 79 * hash + Objects.hashCode(this.tipoItem);
        hash = 79 * hash + Objects.hashCode(this.autor);
        hash = 79 * hash + Objects.hashCode(this.editora);
        hash = 79 * hash + Objects.hashCode(this.idioma);
        hash = 79 * hash + Objects.hashCode(this.especificacoesTecnicas);
        hash = 79 * hash + Objects.hashCode(this.sessao);
        hash = 79 * hash + Objects.hashCode(this.biblioteca);
        hash = 79 * hash + Objects.hashCode(this.exemplares);
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
        final Acervo other = (Acervo) obj;
        if (this.idAcervo != other.idAcervo) {
            return false;
        }
        if (!Objects.equals(this.tituloObra, other.tituloObra)) {
            return false;
        }
        if (!Objects.equals(this.subtituloObra, other.subtituloObra)) {
            return false;
        }
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        if (!Objects.equals(this.volume, other.volume)) {
            return false;
        }
        if (!Objects.equals(this.edicao, other.edicao)) {
            return false;
        }
        if (this.anoEdicao != other.anoEdicao) {
            return false;
        }
        if (!Objects.equals(this.informacoesAdicionais, other.informacoesAdicionais)) {
            return false;
        }
        if (!Objects.equals(this.localizacao, other.localizacao)) {
            return false;
        }
        if (!Objects.equals(this.tipoItem, other.tipoItem)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        if (!Objects.equals(this.editora, other.editora)) {
            return false;
        }
        if (!Objects.equals(this.idioma, other.idioma)) {
            return false;
        }
        if (!Objects.equals(this.especificacoesTecnicas, other.especificacoesTecnicas)) {
            return false;
        }
        if (!Objects.equals(this.sessao, other.sessao)) {
            return false;
        }
        if (!Objects.equals(this.biblioteca, other.biblioteca)) {
            return false;
        }
        if (!Objects.equals(this.exemplares, other.exemplares)) {
            return false;
        }
        return true;
    }
    
      
    @Column(nullable = false, length = 50)
    private String tituloObra;
    
    @Column(nullable = false, length = 50)
    private String subtituloObra;
    
    @Column(length = 14, columnDefinition = "varchar(14) default ''")
    private String isbn;
     
    @Column(length = 4, nullable = false)
    private String volume;
    
    @Column(length = 4, nullable = false)
    private String edicao;
    
    @Column(length = 4, nullable = false)
    private short anoEdicao;
    
    @Column(length = 70, nullable = false)
    private String informacoesAdicionais;
    
    @Column(length = 50, nullable = false)
    private String localizacao;
    
    @ManyToOne
    @JoinColumn(name="idtipoitem")
    private TipoItem tipoItem;
    
    @ManyToOne
    @JoinColumn(name="idautor")
    private Autor autor;
    
    @ManyToOne
    @JoinColumn(name="ideditora")
    private Editora editora;
    
    @ManyToOne
    @JoinColumn(name="ididioma")
    private Idioma idioma;
    
    @OneToOne
    @JoinColumn(name="idespecificacoestecnicas",unique=true)
    private EspecificacoesTecnicas especificacoesTecnicas;
    
    @ManyToOne
    @JoinColumn(name="idsessao")
    private Sessao sessao;
    
    @ManyToOne
    @JoinColumn(name="idbiblioteca")
    private Biblioteca biblioteca;
    
    @OneToMany(mappedBy="acervo")
    private List<Exemplar> exemplares;
    
    private static long serialVersionUID = -8256983727176831230L;

    /*** @retorna o id do Acervo ***/
    public int getIdAcervo() {
        return idAcervo;
    }

    /*** @seta idAcervo the idAcervo to set ***/
    public void setIdAcervo(int idAcervo) {
        this.idAcervo = idAcervo;
    }

    /*** @retorna o Título da Obra ***/
    public String getTituloObra() {
        return tituloObra;
    }

    /*** @seta o Título da Obra ***/
    public void setTituloObra(String tituloObra) {
        this.tituloObra = tituloObra;
    }

    /*** @retorna o Sub-Título da Obra ***/
    public String getSubtituloObra() {
        return subtituloObra;
    }

    /*** @seta o Sub-Título da Obra ***/
    public void setSubtituloObra(String subtituloObra) {
        this.subtituloObra = subtituloObra;
    }

    /*** @retorna o Isbn ***/
    public String getIsbn() {
        return isbn;
    }

    /*** @seta o Isbn ***/
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /*** @retorna o Volume ***/
    public String getVolume() {
        return volume;
    }

    /*** @seta o Volume ***/
    public void setVolume(String volume) {
        this.volume = volume;
    }

    /*** @retorna a Edição ***/
    public String getEdicao() {
        return edicao;
    }

    /*** @seta a Edição ***/
    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    /*** @retorna o Ano de Edição ***/
    public short getAnoEdicao() {
        return anoEdicao;
    }

    /*** @seta o Ano de Edição ***/
    public void setAnoEdicao(short anoEdicao) {
        this.anoEdicao = anoEdicao;
    }

    /*** @retorna as Informações Adicionais ***/
    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    /*** @seta as Informações Adicionais ***/
    public void setInformacoesAdicionais(String informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }

    /*** @retorna a Localização ***/
    public String getLocalizacao() {
        return localizacao;
    }

    /*** @seta a Localização ***/
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    /*** @retorna o Tipo de Item ***/
    public TipoItem getTipoItem() {
        return tipoItem;
    }

    /*** @seta e copia o Tipo de Item recebido para o Tipo de Item da Classe ***/
    public void setTipoItem(TipoItem tipoItem) {
        this.tipoItem = tipoItem;
    }

    /*** @retorna o Autor ***/
    public Autor getAutor() {
        return autor;
    }

    /*** @seta e copia o Autor recebido para o Autor da Classe ***/
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    /*** @retorna a Editora ***/
    public Editora getEditora() {
        return editora;
    }

    /*** @seta e copia a Editora recebida para a Editora da Classe ***/
    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    /*** @retorna o Idioma ***/
    public Idioma getIdioma() {
        return idioma;
    }

    /*** @seta e copia o Idioma recebido para o Idioma da Classe ***/
    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    /*** @retorna uma Especificações Técnicas ***/
    public EspecificacoesTecnicas getEspecificacoesTecnicas() {
        return especificacoesTecnicas;
    }

    /*** @seta e copia as Especificações Técnicas recebidas para a Especificações Técnicas da Classe ***/
    public void setEspecificacoesTecnicas(EspecificacoesTecnicas especificacoesTecnicas) {
        this.especificacoesTecnicas = especificacoesTecnicas;
    }

    /*** @retorna a Sessão ***/
    public Sessao getSessao() {
        return sessao;
    }

    /*** @seta e copia a Sessão recebida para a Sessão da Classe ***/
    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    /*** @retorna a Biblioteca ***/
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    /*** @seta e copia a Biblioteca recebida para a Biblioteca da Classe ***/
    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    /**
     * @return the exemplares
     */
    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    /**
     * @param exemplares the exemplares to set
     */
    public void setExemplares(List<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }
}