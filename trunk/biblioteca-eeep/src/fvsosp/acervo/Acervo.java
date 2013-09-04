package fvsosp.acervo;

import fvsosp.autor.Autor;
import fvsosp.biblioteca.Biblioteca;
import fvsosp.editora.Editora;
import fvsosp.emprestimo.Emprestimo;
import fvsosp.especificacoes.EspecificacoesTecnicas;
import fvsosp.idioma.Idioma;
import fvsosp.palavraschaves.PalavrasChaves;
import fvsosp.sessao.Sessao;
import fvsosp.tipoitem.TipoItem;
import java.util.List;

public class Acervo {

    private int id;
    private int tombo;
    private String tituloObra;
    private String subtituloObra;
    private String isbn;
    private int exemplar;
    private String volume;
    private String edicao;
    private int anoEdicao;
    private String informacoesAdicionais;
    private String localizacao;
    private TipoItem tipoItem;
    private Autor autor;
    private Editora editora;
    private Idioma idioma;
    private List<PalavrasChaves> palavrasChaves;
    private EspecificacoesTecnicas especificacoesTecnicas;
    private Sessao sessao;
    private Biblioteca biblioteca;
    private List<Emprestimo> emprestimos;
}
