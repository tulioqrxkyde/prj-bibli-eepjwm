package fvsosp.acervo;

import fvsosp.exemplar.Exemplar;
import fvsosp.autor.Autor;
import fvsosp.biblioteca.Biblioteca;
import fvsosp.editora.Editora;
import fvsosp.idioma.Idioma;
import fvsosp.palavraschaves.PalavrasChaves;
import fvsosp.sessao.Sessao;
import fvsosp.tipoitem.TipoItem;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.IndexColumn;
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
    
    public String toString() {
        return getIdAcervo() + " | " + tituloObra;
    }

    @Id
    @GeneratedValue
    private short idAcervo;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.getIdAcervo();
        hash = 41 * hash + Objects.hashCode(this.getCutter());
        hash = 41 * hash + Objects.hashCode(this.getPalavrasChaves());
        hash = 41 * hash + Objects.hashCode(this.getTituloObra());
        hash = 41 * hash + Objects.hashCode(this.getSubtituloObra());
        hash = 41 * hash + Objects.hashCode(this.getIsbn());
        hash = 41 * hash + Objects.hashCode(this.getVolume());
        hash = 41 * hash + Objects.hashCode(this.getEdicao());
        hash = 41 * hash + this.getAnoEdicao();
        hash = 41 * hash + Objects.hashCode(this.getInformacoesAdicionais());
        hash = 41 * hash + Objects.hashCode(this.getLocalizacao());
        hash = 41 * hash + Objects.hashCode(this.getTipoItem());
        hash = 41 * hash + Objects.hashCode(this.getAutores());
        hash = 41 * hash + Objects.hashCode(this.getEditora());
        hash = 41 * hash + Objects.hashCode(this.getIdioma());
        hash = 41 * hash + Objects.hashCode(this.getSessao());
        hash = 41 * hash + Objects.hashCode(this.getBiblioteca());
        hash = 41 * hash + Objects.hashCode(this.getExemplares());
        hash = 41 * hash + this.getNumeroPaginas();
        hash = 41 * hash + this.getPeso();
        hash = 41 * hash + Objects.hashCode(this.getAcabamentoCapa());
        hash = 41 * hash + Objects.hashCode(this.getAcabamentoMiolo());
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
        if (!Objects.equals(this.cutter, other.cutter)) {
            return false;
        }
        if (!Objects.equals(this.palavrasChaves, other.palavrasChaves)) {
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
        if (!Objects.equals(this.autores, other.autores)) {
            return false;
        }
        if (!Objects.equals(this.editora, other.editora)) {
            return false;
        }
        if (!Objects.equals(this.idioma, other.idioma)) {
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
        if (this.getNumeroPaginas() != other.getNumeroPaginas()) {
            return false;
        }
        if (this.getPeso() != other.getPeso()) {
            return false;
        }
        if (!Objects.equals(this.acabamentoCapa, other.acabamentoCapa)) {
            return false;
        }
        if (!Objects.equals(this.acabamentoMiolo, other.acabamentoMiolo)) {
            return false;
        }
        return true;
    }
    
    private String cutter;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "PalavraschavesAcervo", 
            joinColumns = @JoinColumn(name = "idAcervo"), 
            inverseJoinColumns = @JoinColumn(name = "idPalavrasChaves"))
    private Set<PalavrasChaves> palavrasChaves;
      
    @Column(nullable = false, length = 50)
    @NaturalId(mutable=true)
    private String tituloObra;
    
    @Column(nullable = false, length = 50)
    private String subtituloObra;
    
    @Column(length = 14, columnDefinition = "varchar(14) default ''")
    private String isbn;
     
    @Column(length = 4, nullable = false)
    private String volume;
    
    @Column(length = 4)
    private String edicao;
    
    @Column(length = 4, nullable = false)
    private short anoEdicao;
    
    @Column(length = 70)
    private String informacoesAdicionais;
    
    @Column(length = 50)
    private String localizacao;
    
    @ManyToOne
    @JoinColumn(name="idtipoitem", nullable=false)
    private TipoItem tipoItem;
      
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "AutoresAcervo", 
            joinColumns = @JoinColumn(name = "idAcervo"), 
            inverseJoinColumns = @JoinColumn(name = "idAutor"))
    private Set<Autor> autores;
    
    @ManyToOne
    @JoinColumn(name="ideditora", nullable=false)
    private Editora editora;
    
    @ManyToOne
    @JoinColumn(name="ididioma", nullable=false)
    private Idioma idioma;
      
    @ManyToOne
    @JoinColumn(name="idsessao")
    private Sessao sessao;
    
    @ManyToOne
    @JoinColumn(name="idbiblioteca", nullable=false)
    private Biblioteca biblioteca;
    
    @OneToMany(mappedBy="acervo",fetch = FetchType.EAGER)
    private List<Exemplar> exemplares;
    
    @Column(length = 7, nullable = false, columnDefinition = "smallint default '0'")
    private short numeroPaginas;

    @Column(length = 7, columnDefinition = "smallint default '0'")
    private short peso;

    @Column(length = 30, columnDefinition = "varchar(30) default ''")
    private String acabamentoCapa;

    @Column(length = 30, columnDefinition = "varchar(30) default ''")
    private String acabamentoMiolo;
    
    private static long serialVersionUID = -8256983727176831230L;

    /*** @retorna o id do Acervo ***/
    public short getIdAcervo() {
        return idAcervo;
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
    public Set<Autor> getAutor() {
        return getAutores();
    }

    /*** @seta e copia o Autor recebido para o Autor da Classe ***/
    public void setAutor(Set<Autor> autores) {
        this.setAutores(autores);
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
     * @return the palavrasChaves
     */
    public Set<PalavrasChaves> getPalavrasChaves() {
        return palavrasChaves;
    }

    
   
    /**
     * @return the autores
     */
    public Set<Autor> getAutores() {
        return autores;
    }

      /**
     * @return the numeroPaginas
     */
    public short getNumeroPaginas() {
        return numeroPaginas;
    }

    /**
     * @param numeroPaginas the numeroPaginas to set
     */
    public void setNumeroPaginas(short numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    /**
     * @return the peso
     */
    public short getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(short peso) {
        this.peso = peso;
    }

    /**
     * @return the acabamentoCapa
     */
    public String getAcabamentoCapa() {
        return acabamentoCapa;
    }

    /**
     * @param acabamentoCapa the acabamentoCapa to set
     */
    public void setAcabamentoCapa(String acabamentoCapa) {
        this.acabamentoCapa = acabamentoCapa;
    }

    /**
     * @return the acabamentoMiolo
     */
    public String getAcabamentoMiolo() {
        return acabamentoMiolo;
    }

    /**
     * @param acabamentoMiolo the acabamentoMiolo to set
     */
    public void setAcabamentoMiolo(String acabamentoMiolo) {
        this.acabamentoMiolo = acabamentoMiolo;
    }

    /**
     * @return the cutter
     */
    public String getCutter() {
        return cutter;
    }

    /**
     * @param cutter the cutter to set
     */
    public void setCutter(String cutter) {
        this.cutter = cutter;
    }

    /**
     * @param palavrasChaves the palavrasChaves to set
     */
    public void setPalavrasChaves(Set<PalavrasChaves> palavrasChaves) {
        this.palavrasChaves = palavrasChaves;
    }

    /**
     * @param autores the autores to set
     */
    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }

    /**
     * @param exemplares the exemplares to set
     */
    public void setExemplares(List<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }

}