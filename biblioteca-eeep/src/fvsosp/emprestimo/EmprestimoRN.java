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
package fvsosp.emprestimo;

import fvsosp.acervo.Acervo;
import fvsosp.exemplar.Exemplar;
import fvsosp.exemplaremprestimos.ExemplarEmprestimos;
import fvsosp.leitor.Leitor;
import java.util.*;

/**
 *
 * @author tulio.xcrtf
 */
public class EmprestimoRN {

    EmprestimoDAO dao = new EmprestimoDAO();

    /**
     * Acessa o método dao.adicionar de EmprestimoDAO que por sua vez acessa o
     * método da classe genérica (GenericDAO) salvando o Emprestimo.
     *
     * @param em Emprestimo.
     * @return booleano (true|false).
     * @see EmprestimoDAO.
     */
    public boolean adiciona(Emprestimo em) {
        if (em.getIdEmprestimo() == 0) {
            return dao.adicionar(em);
        } else {
            return dao.atualizar(em);
        }
    }

    /**
     * Acessa o método dao.remover de EmprestimoDAO que por sua vez acessa o
     * método da classe genérica (GenericDao) removendo o Emprestimo.
     *
     * @param emp Emprestimo.
     * @return booleano (true|false).
     * @see EmprestimoDAO.
     */
    public boolean remover(Emprestimo em) {
        return dao.remover(em);
    }

    /**
     * Acessa o método dao.listar de EmprestimoDAO que por sua vez acessa o
     * método da classe genérica (GenericDao) listando os Emprestimos.
     *
     * @return List(Emprestimo).
     * @see EmprestimoDAO.
     */
    public List<Emprestimo> listar() {
        return dao.listar();
    }

    /**
     * Acessa o método dao.pesquisarCodigo(codigo) de EmprestimoDAO.
     *
     * @param codigo short.
     * @return Emprestimo.
     * @see EmprestimoDAO.
     */
    public Emprestimo pesquisarCodigo(short codigo) {
        return dao.pesquisarCodigo(codigo);
    }

    /**
     * Acessa o método dao.pesquisardataEmprestimo(data) de EmprestimoDAO.
     *
     * @param data Date.
     * @return List(Emprestimo).
     * @see EmprestimoDAO.
     */
    public List<Emprestimo> pesquisardataEmprestimo(Date data) {
        return dao.pesquisardataEmprestimo(data);
    }

    /**
     * Acessa o método dao.pesquisardataDevolucao(data) de EmprestimoDAO.
     *
     * @param data Date.
     * @return List(Emprestimo).
     * @see EmprestimoDAO.
     */
    public List<Emprestimo> pesquisardataDevolucao(Date data) {
        return dao.pesquisardataEmprestimo(data);
    }

    /**
     * Acessa o método dao.pesquisarEmprestimo(emprestimo) de EmprestimoDAO.
     *
     * @param emprestimo Emprestimo.
     * @return List(Acervo).
     * @see EmprestimoDAO.
     */
    public List<Acervo> pesquisarEmprestimo(Emprestimo emprestimo) {
        return dao.pesquisarEmprestimo(emprestimo);
    }

    /**
     * Acessa o método dao.pesquisarSituacao(leitor) de EmprestimoDAO.
     *
     * @param leitor Leitor.
     * @return int.
     * @see EmprestimoDAO.
     */
    public int pesquisarSituacao(Leitor leitor) {
        return dao.pesquisarSituacao(leitor);
    }

    /**
     * Acessa o método dao.pesquisarEmprestimoLivroDevolvido() de EmprestimoDAO.
     *
     * @return short.
     * @see EmprestimoDAO.
     */
    public short pesquisarEmprestimoLivroDevolvido(Exemplar exe) {
        return dao.pesquisarEmprestimoLivroDevolvido(exe);

    }

    /**
     * Acessa o método dao.pesquisarExemplaresEmprestados() de EmprestimoDAO.
     *
     * @return List(ExemplarEmprestimos) querySQL.list().
     * @see EmprestimoDAO.
     */
    public List<ExemplarEmprestimos> pesquisarExemplaresEmprestados(Leitor leitor) {
        return dao.pesquisarExemplaresEmprestados(leitor);
    }
}