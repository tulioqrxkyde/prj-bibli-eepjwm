package eeepjwm.acervo;

import eeepjwm.autor.Autor;
import eeepjwm.biblioteca.Biblioteca;
import eeepjwm.editora.Editora;
import eeepjwm.emprestimo.Emprestimo;
import eeepjwm.especificacoes.EspecificacoesTecnicas;
import eeepjwm.idioma.Idioma;
import eeepjwm.palavraschaves.PalavrasChaves;
import eeepjwm.sessao.Sessao;
import eeepjwm.tipoitem.TipoItem;
import java.util.List;

public class Acervo {
 
	private int tombo;
	 
	private String tituloObra;
	 
	private String subtituloObra;
	 
	private int id;
	 
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
 
