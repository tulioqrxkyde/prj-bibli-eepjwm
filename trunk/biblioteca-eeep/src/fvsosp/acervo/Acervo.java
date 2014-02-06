/* Este arquivo é parte do OSBiblio.
 * Copyright (C) 2014 (Pedro Saraiva, Túlio Vidal, Luís Henrique, Adriano Lima, Oziel Pereira,
 * Marcos Ellys, Francisco Júnior, Fátima Pinheiro, Darly Vinicio).
 *
 * OSBiblio é um software livre; você pode redistribuí-lo e/ou  modificá-lo dentro dos termos da 
 * Licença Pública Geral GNU como publicada pela Fundação do Software Livre (FSF); na versão 2 da Licença,
 * ou (na sua opinião) qualquer versão.
 *
 * Este programa é distribuído na esperança de que possa ser útil, mas SEM NENHUMA GARANTIA; sem uma garantia 
 * implícita de ADEQUAÇÃO a qualquer MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a Licença Pública Geral GNU
 * para maiores detalhes.
 */
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
import org.hibernate.annotations.NaturalId;

/**
 *
 * @author tulio.xcrtf
 */
@Entity
@Table(name = "acervo")
public class Acervo implements Serializable, Comparable<Acervo> {

    /**
     * Método sobrescrito.
     *
     * @param o objeto a ser acessado através da Composição.
     * @return inteiro negativo, zero ou um inteiro positivo.
     */
    @Override
    public int compareTo(Acervo o) {
        return tituloObra.compareTo(o.tituloObra);
    }

    /**
     * Método sobrescrito.
     *
     * @return String contendo o id do Acervo e o Título da Obra.
     */
    @Override
    public String toString() {
        return tituloObra;
    }

    /**
     * Método sobrescrito.
     *
     * @return um inteiro(hash) contendo o valor total do cálculo de todos os
     * hashCodes dos Atributos contidos na Classe.
     */
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

    /**
     * Método sobrescrito.
     * 
     * @param obj objeto a ser acessado através da Composição.
     * @return booleano (true|false).
     */
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
    @Id
    @GeneratedValue
    private short idAcervo;
    private String cutter;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "palavraschavesacervo",
            joinColumns =
            @JoinColumn(name = "idAcervo"),
            inverseJoinColumns =
            @JoinColumn(name = "idPalavrasChaves"))
    private Set<PalavrasChaves> palavrasChaves;
    @Column(nullable = false, length = 50)
    @NaturalId(mutable = true)
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
    @JoinColumn(name = "idtipoitem", nullable = false)
    private TipoItem tipoItem;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "autoresacervo",
            joinColumns =
            @JoinColumn(name = "idAcervo"),
            inverseJoinColumns =
            @JoinColumn(name = "idAutor"))
    private Set<Autor> autores;
    @ManyToOne
    @JoinColumn(name = "ideditora", nullable = false)
    private Editora editora;
    @ManyToOne
    @JoinColumn(name = "ididioma", nullable = false)
    private Idioma idioma;
    @ManyToOne
    @JoinColumn(name = "idsessao")
    private Sessao sessao;
    @ManyToOne
    @JoinColumn(name = "idbiblioteca", nullable = false)
    private Biblioteca biblioteca;
    @OneToMany(mappedBy = "acervo", fetch = FetchType.EAGER)
    private List<Exemplar> exemplares;
    @Column(length = 7, nullable = false, columnDefinition = "smallint default '0'")
    private short numeroPaginas;
    @Column(length = 7, columnDefinition = "smallint default '0'")
    private short peso;
    @Column(length = 30, columnDefinition = "varchar(30) default ''")
    private String acabamentoCapa;
    @Column(length = 30, columnDefinition = "varchar(30) default ''")
    private String acabamentoMiolo;
    private static final long serialVersionUID = -8256983727176831230L;

    /**
     * @return short idAcervo.
     */
    public short getIdAcervo() {
        return idAcervo;
    }

    /**
     * @return String títuloObra.
     */
    public String getTituloObra() {
        return tituloObra;
    }

    /**
     * @param tituloObra String.
     */
    public void setTituloObra(String tituloObra) {
        this.tituloObra = tituloObra;
    }

    /**
     * @return String subtituloObra.
     */
    public String getSubtituloObra() {
        return subtituloObra;
    }

    /**
     * @param subtituloObra String.
     */
    public void setSubtituloObra(String subtituloObra) {
        this.subtituloObra = subtituloObra;
    }

    /**
     * @return String isbn.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn String.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return String volume.
     */
    public String getVolume() {
        return volume;
    }

    /**
     * @param volume String.
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     * @return String edicao.
     */
    public String getEdicao() {
        return edicao;
    }

    /**
     * @param edicao String.
     */
    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    /**
     * @return short anoEdicao.
     */
    public short getAnoEdicao() {
        return anoEdicao;
    }

    /**
     * @param anoEdicao short.
     */
    public void setAnoEdicao(short anoEdicao) {
        this.anoEdicao = anoEdicao;
    }

    /**
     * @return String informacoesAdicionais.
     */
    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    /**
     * @param informacoesAdicionais String.
     */
    public void setInformacoesAdicionais(String informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }

    /**
     * @return String localizacao.
     */
    public String getLocalizacao() {
        return localizacao;
    }

    /**
     * @param localizacao String.
     */
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    /**
     * @return TipoItem tipoItem.
     */
    public TipoItem getTipoItem() {
        return tipoItem;
    }

    /**
     * @param tipoItem TipoItem.
     */
    public void setTipoItem(TipoItem tipoItem) {
        this.tipoItem = tipoItem;
    }

    /**
     * @return Set(Autor) autores.
     */
    public Set<Autor> getAutor() {
        return getAutores();
    }

    /**
     * @param autores Set(Autor).
     */
    public void setAutor(Set<Autor> autores) {
        this.setAutores(autores);
    }

    /**
     * @return Editora editora.
     */
    public Editora getEditora() {
        return editora;
    }

    /**
     * @param editora Editora.
     */
    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    /**
     * @return Idioma idioma.
     */
    public Idioma getIdioma() {
        return idioma;
    }

    /**
     * @param idioma Idioma.
     */
    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    /**
     * @return Sessao sessao.
     */
    public Sessao getSessao() {
        return sessao;
    }

    /**
     * @param sessao Sessao.
     */
    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    /**
     * @return Biblioteca biblioteca.
     */
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    /**
     * @param biblioteca Biblioteca.
     */
    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    /**
     * @return List(Exemplar) exemplares.
     */
    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    /**
     * @return Set(PalavrasChaves) palavrasChaves.
     */
    public Set<PalavrasChaves> getPalavrasChaves() {
        return palavrasChaves;
    }

    /**
     * @return Set(Autor) autores.
     */
    public Set<Autor> getAutores() {
        return autores;
    }

    /**
     * @return short numeroPaginas.
     */
    public short getNumeroPaginas() {
        return numeroPaginas;
    }

    /**
     * @param numeroPaginas short.
     */
    public void setNumeroPaginas(short numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    /**
     * @return short peso.
     */
    public short getPeso() {
        return peso;
    }

    /**
     * @param peso short.
     */
    public void setPeso(short peso) {
        this.peso = peso;
    }

    /**
     * @return String acabamentoCapa.
     */
    public String getAcabamentoCapa() {
        return acabamentoCapa;
    }

    /**
     * @param acabamentoCapa String.
     */
    public void setAcabamentoCapa(String acabamentoCapa) {
        this.acabamentoCapa = acabamentoCapa;
    }

    /**
     * @return String acabamentoMiolo.
     */
    public String getAcabamentoMiolo() {
        return acabamentoMiolo;
    }

    /**
     * @param acabamentoMiolo String.
     */
    public void setAcabamentoMiolo(String acabamentoMiolo) {
        this.acabamentoMiolo = acabamentoMiolo;
    }

    /**
     * @return String cutter.
     */
    public String getCutter() {
        return cutter;
    }

    /**
     * @param cutter String,
     */
    public void setCutter(String cutter) {
        this.cutter = cutter;
    }

    /**
     * @param palavrasChaves Set(PalavrasChaves).
     */
    public void setPalavrasChaves(Set<PalavrasChaves> palavrasChaves) {
        this.palavrasChaves = palavrasChaves;
    }

    /**
     * @param autores Set(Autor).
     */
    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }

    /**
     * @param exemplares List(Exemplar).
     */
    public void setExemplares(List<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }
}