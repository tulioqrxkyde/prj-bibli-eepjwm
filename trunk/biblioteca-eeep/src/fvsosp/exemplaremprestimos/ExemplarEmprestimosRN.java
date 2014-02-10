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
package fvsosp.exemplaremprestimos;

import fvsosp.exemplar.Exemplar;
import java.util.List;

/**
 *
 * @author Pedro Saraiva
 */
public class ExemplarEmprestimosRN {
    
    ExemplarEmprestimosDAO dao = new ExemplarEmprestimosDAO();
    
     /**
     * Acessa o método dao.adicionar de EmprestimoDAO que por sua vez acessa o
     * método da classe genérica (GenericDAO) salvando o Emprestimo.
     *
     * @param em ExemplarEmprestimos.
     * @return booleano (true|false).
     * @see ExemplarDAO.
     */
    public boolean adiciona(ExemplarEmprestimos em) {
        if (em.getIdExemplarEmprestimos() == 0) {
                return dao.adicionar(em);
        } else {
            return dao.atualizar(em);
        }
    }
    
     /**
     * Acessa o método dao.remover de ExemplarDAO que por sua vez acessa o
     * método da classe genérica (GenericDAO) removendo o ExemplarEmprestimos.
     *
     * @param em ExemplarEmprestimos.
     * @return booleano (true|false).
     * @see ExemplarDAO.
     */

    public boolean remover(ExemplarEmprestimos em) {
        return dao.remover(em);

    }

     /**
     * Acessa o método dao.listar de EmprestimoDAO que por sua vez acessa o método da
     * classe genérica (GenericDao) listando os Exemplares.
     *
     * @return List(ExemplarEmprestimos).
     * @see ExemplarDAO.
     */
    public List<ExemplarEmprestimos> listar() {
        return dao.listar();
    }
    
     /**
     * Acessa o método dao.pesquisarCodigo(codigo) de ExemplarDAO.
     *
     * @param codigo short.
     * @return short codigo).
     * @see ExemplarDAO.
     */
    public ExemplarEmprestimos pesquisarCodigo(short codigo) {
        return dao.pesquisarCodigo(codigo);
    }
    
     /**
     * Acessa o método dao.pesquisarIdExemplarEmprestimoDevolvido(exe) de ExemplarDAO.
     *
     * @param exe Exemplar.
     * @return short codigo).
     * @see ExemplarDAO.
     */
    public short pesquisarIdExemplarEmprestimoDevolvido(Exemplar exe) {
        return dao.pesquisarIdExemplarEmprestimoDevolvido(exe);

    }
}
