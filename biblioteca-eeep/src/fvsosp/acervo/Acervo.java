package fvsosp.acervo;

import fvsosp.autor.Autor;
import fvsosp.biblioteca.Biblioteca;
import fvsosp.editora.Editora;
import fvsosp.especificacoes.EspecificacoesTecnicas;
import fvsosp.idioma.Idioma;
import fvsosp.sessao.Sessao;
import fvsosp.tipoitem.TipoItem;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="acervo")
public class Acervo implements Serializable{

    @Id
    @GeneratedValue
    private int idAcervo;
    
    @NaturalId
    private int tombo;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.getIdAcervo();
        hash = 61 * hash + this.getTombo();
        hash = 61 * hash + Objects.hashCode(this.getTituloObra());
        hash = 61 * hash + Objects.hashCode(this.getSubtituloObra());
        hash = 61 * hash + Objects.hashCode(this.getIsbn());
        hash = 61 * hash + this.getExemplar();
        hash = 61 * hash + Objects.hashCode(this.getVolume());
        hash = 61 * hash + Objects.hashCode(this.getEdicao());
        hash = 61 * hash + this.getAnoEdicao();
        hash = 61 * hash + Objects.hashCode(this.getInformacoesAdicionais());
        hash = 61 * hash + Objects.hashCode(this.getLocalizacao());
        hash = 61 * hash + Objects.hashCode(this.getTipoItem());
        hash = 61 * hash + Objects.hashCode(this.getAutor());
        hash = 61 * hash + Objects.hashCode(this.getEditora());
        hash = 61 * hash + Objects.hashCode(this.getIdioma());
        hash = 61 * hash + Objects.hashCode(this.getEspecificacoesTecnicas());
        hash = 61 * hash + Objects.hashCode(this.getSessao());
        hash = 61 * hash + Objects.hashCode(this.getBiblioteca());
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
        if (this.getIdAcervo() != other.getIdAcervo()) {
            return false;
        }
        if (this.getTombo() != other.getTombo()) {
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
        if (this.getExemplar() != other.getExemplar()) {
            return false;
        }
        if (!Objects.equals(this.volume, other.volume)) {
            return false;
        }
        if (!Objects.equals(this.edicao, other.edicao)) {
            return false;
        }
        if (this.getAnoEdicao() != other.getAnoEdicao()) {
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
        return true;
    }
    
    @Column(nullable=false, length=150)
    private String tituloObra;
    
    @Column(nullable=false, length=150)
    private String subtituloObra;
    
    @Column(length=50, columnDefinition="varchar(50) default ''")
    private String isbn;
    
    @Column(nullable=false)
    private int exemplar;
    
    private String volume;
    
    private String edicao;
    
    private int anoEdicao;
    
    private String informacoesAdicionais;
    
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
    
    private static long serialVersionUID = -8256983727176831230L;

    /**
     * @return the idAcervo
     */
    public int getIdAcervo() {
        return idAcervo;
    }

    /**
     * @param idAcervo the idAcervo to set
     */
    public void setIdAcervo(int idAcervo) {
        this.idAcervo = idAcervo;
    }

    /**
     * @return the tombo
     */
    public int getTombo() {
        return tombo;
    }

    /**
     * @param tombo the tombo to set
     */
    public void setTombo(int tombo) {
        this.tombo = tombo;
    }

    /**
     * @return the tituloObra
     */
    public String getTituloObra() {
        return tituloObra;
    }

    /**
     * @param tituloObra the tituloObra to set
     */
    public void setTituloObra(String tituloObra) {
        this.tituloObra = tituloObra;
    }

    /**
     * @return the subtituloObra
     */
    public String getSubtituloObra() {
        return subtituloObra;
    }

    /**
     * @param subtituloObra the subtituloObra to set
     */
    public void setSubtituloObra(String subtituloObra) {
        this.subtituloObra = subtituloObra;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the exemplar
     */
    public int getExemplar() {
        return exemplar;
    }

    /**
     * @param exemplar the exemplar to set
     */
    public void setExemplar(int exemplar) {
        this.exemplar = exemplar;
    }

    /**
     * @return the volume
     */
    public String getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     * @return the edicao
     */
    public String getEdicao() {
        return edicao;
    }

    /**
     * @param edicao the edicao to set
     */
    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    /**
     * @return the anoEdicao
     */
    public int getAnoEdicao() {
        return anoEdicao;
    }

    /**
     * @param anoEdicao the anoEdicao to set
     */
    public void setAnoEdicao(int anoEdicao) {
        this.anoEdicao = anoEdicao;
    }

    /**
     * @return the informacoesAdicionais
     */
    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    /**
     * @param informacoesAdicionais the informacoesAdicionais to set
     */
    public void setInformacoesAdicionais(String informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }

    /**
     * @return the localizacao
     */
    public String getLocalizacao() {
        return localizacao;
    }

    /**
     * @param localizacao the localizacao to set
     */
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    /**
     * @return the tipoItem
     */
    public TipoItem getTipoItem() {
        return tipoItem;
    }

    /**
     * @param tipoItem the tipoItem to set
     */
    public void setTipoItem(TipoItem tipoItem) {
        this.tipoItem = tipoItem;
    }

    /**
     * @return the autor
     */
    public Autor getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    /**
     * @return the editora
     */
    public Editora getEditora() {
        return editora;
    }

    /**
     * @param editora the editora to set
     */
    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    /**
     * @return the idioma
     */
    public Idioma getIdioma() {
        return idioma;
    }

    /**
     * @param idioma the idioma to set
     */
    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    /**
     * @return the especificacoesTecnicas
     */
    public EspecificacoesTecnicas getEspecificacoesTecnicas() {
        return especificacoesTecnicas;
    }

    /**
     * @param especificacoesTecnicas the especificacoesTecnicas to set
     */
    public void setEspecificacoesTecnicas(EspecificacoesTecnicas especificacoesTecnicas) {
        this.especificacoesTecnicas = especificacoesTecnicas;
    }

    /**
     * @return the sessao
     */
    public Sessao getSessao() {
        return sessao;
    }

    /**
     * @param sessao the sessao to set
     */
    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    /**
     * @return the biblioteca
     */
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    /**
     * @param biblioteca the biblioteca to set
     */
    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    
}
