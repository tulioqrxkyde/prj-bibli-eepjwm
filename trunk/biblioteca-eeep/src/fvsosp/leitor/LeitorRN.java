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
package fvsosp.leitor;

import fvsosp.cidade.Cidade;
import fvsosp.grupoleitores.GruposLeitores;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Saraiva
 */
public class LeitorRN {

    private LeitorDAO dao = new LeitorDAO();

     /**
     * Acessa o método dao.adicionar de LeitorDAO que por sua vez acessa o método
     * da classe genérica (GenericDAO) salvando o Leitor.
     *
     * @param leitor Leitor.
     * @return booleano (true|false).
     * @see LeitorDAO.
     */
    public boolean salvar(Leitor leitor) {
        if (leitor.getIdLeitor() == 0) {
            List<Leitor> leitores = dao.pesquisarCpf(leitor.getCpf());
            if (leitores.size() > 0) {
                JOptionPane.showMessageDialog(null, "Já Existe Leitor Cadastrado com o CPF: " + leitor.getCpf() + "!");
                return false;
            } else {
                List<Leitor> leitorMatricula = dao.checkExists("matricula", leitor.getMatricula());
                if (leitorMatricula.size() == 0) {
                    List<Leitor> leitorNome = dao.checkExists("nome", leitor.getNome());
                    if(leitorNome.size()==0){
                    return dao.adicionar(leitor);
                    } else {
                        JOptionPane.showMessageDialog(null, "Nome Já cadastrado para leitor");
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Matrícula Já cadastrada para leitor");
                    return false;
                }
            }
        } else {
            return dao.atualizar(leitor);
        }
    }

    
     /**
     * Acessa o método dao.remove de LeitorDAO que por sua vez acessa o método
     * da classe genérica (GenericDAO) removendo o Leitor.
     *
     * @param leitor Leitor.
     * @return booleano (true|false).
     * @see LeitorDAO.
     */
    public boolean remove(Leitor leitor) {
        return dao.remover(leitor);

    }

    /**
     * Acessa o método dao.listar de LeitorDAO que por sua vez acessa o método da
     * classe genérica (GenericDao) listando os Leitores.
     *
     * @return List(Leitor).
     * @see LeitorDAO.
     */
    public List<Leitor> listar() {
        return dao.listar();
    }

     /**
     * Acessa o método dao.pesquisarNome(nome) de LeitorDAO.
     *
     * @param nome String.
     * @return List(Leitor).
     * @see LeitorDAO.
     */
    public List<Leitor> pesquisaNome(String nome) {
        return dao.pesquisarNome(nome);
    }

    /**
     * Acessa o método dao.pesquisaNomeEq(nome) de LeitorDAO.
     *
     * @param nome String.
     * @return List(Leitor).
     * @see LeitorDAO.
     */
    public Leitor pesquisaNomeEq(String nome) {
        return dao.pesquisarNomeEq(nome);
    }

    
    /**
     * Acessa o método dao.pesquisarEmail(emai) de LeitorDAO.
     *
     * @param emai String.
     * @return List(Leitor).
     * @see LeitorDAO.
     */
    public List<Leitor> pesquisarEmail(String email) {
        return dao.pesquisarEmail(email);
    }

    /**
     * Acessa o método dao.pesquisarDataNascimento(dataNascimento) de LeitorDAO.
     *
     * @param dataNascimento Date.
     * @return List(Leitor).
     * @see LeitorDAO.
     */
    public List<Leitor> pesquisarDataNascimento(Date dataNascimento) {
        return dao.pesquisarDataNascimento(dataNascimento);
    }

    /**
     * Acessa o método dao.pesquisarTelefone(telefone) de LeitorDAO.
     *
     * @param telefone String.
     * @return List(Leitor).
     * @see LeitorDAO.
     */
    public List<Leitor> pesquisarTelefone(String telefone) {
        return dao.pesquisarTelefone(telefone);
    }

     /**
     * Acessa o método dao.pesquisarCelular(celular) de LeitorDAO.
     *
     * @param celular String.
     * @return List(Leitor).
     * @see LeitorDAO.
     */
    public List<Leitor> pesquisarCelular(String celular) {
        return dao.pesquisarCelular(celular);
    }

    /**
     * Acessa o método dao.pesquisarMatricula(matricular) de LeitorDAO.
     *
     * @param matricula String.
     * @return List(Leitor).
     * @see LeitorDAO.
     */
    public List<Leitor> pesquisarMatricula(String matricula) {
        return dao.pesquisarMatricula(matricula);
    }

     /**
     * Acessa o método dao.pesquisarMatriculaEq(matricular) de LeitorDAO.
     *
     * @param matricula String.
     * @return List(Leitor).
     * @see LeitorDAO.
     */
    public Leitor pesquisarMatriculaEq(String matricula) {
        return dao.pesquisarMatriculaEq(matricula);
    }

    /**
     * Acessa o método dao.pesquisarAtivo(ativo) de LeitorDAO.
     *
     * @param ativ boolean.
     * @return List(Leitor).
     * @see LeitorDAO.
     */
    public List<Leitor> pesquisarAtivo(boolean ativo) {
        return dao.pesquisarAtivo(ativo);
    }

    /**
     * Acessa o método dao.pesquisarGrupoLeitore(gruposLeitores) de LeitorDAO.
     *
     * @param gruposLeitores GruposLeitores.
     * @return List(Leitor).
     * @see LeitorDAO.
     */
    public List<Leitor> pesquisarGrupoLeitores(GruposLeitores gruposLeitores) {
        return dao.pesquisarGrupoLeitores(gruposLeitores);
    }

    /**
     * Acessa o método dao.pesquisarCidade(cidades) de LeitorDAO.
     *
     * @param cidades Cidade.
     * @return List(Leitor).
     * @see LeitorDAO.
     */
    public List<Leitor> pesquisarCidade(Cidade cidades) {
        return dao.pesquisarCidade(cidades);
    }

     /**
     * Acessa o método dao.pesquisarCodig(id) de LeitorDAO.
     *
     * @param id short.
     * @return List(Leitor).
     * @see LeitorDAO.
     */
    public Leitor pesquisarCodigo(short id) {
        return dao.pesquisarCodigo(id);
    }
}
