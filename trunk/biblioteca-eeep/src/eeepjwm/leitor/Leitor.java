package eeepjwm.leitor;

import eeepjwm.cidade.Cidade;
import eeepjwm.emprestimo.Emprestimo;
import eeepjwm.grupoleitores.GruposLeitores;
import java.sql.Date;
import java.util.List;

public class Leitor {
 
	private int id;
	 
	private String nome;
	 
	private String email;
	 
	private Date dataNascimento;
	 
	private Date dataCadastro;
	 
	private char sexo;
	 
	private String telefone;
	 
	private String celular;
	 
	private String matricula;
	 
	private boolean ativo;
	 
	private String observacoes;
	 
	private String endereco;
	 
	private String bairro;
	 
	private String cep;
	 
	private String nomePai;
	 
	private String nomeMae;
	 
	private String rg;
	 
	private String cpf;
	 
	private GruposLeitores gruposLeitores;
	 
	private Cidade cidade;
	 
	private List<Emprestimo> emprestimos;
	 
}
 
