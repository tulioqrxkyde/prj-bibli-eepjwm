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
package fvsosp.multa;

import fvsosp.leitor.Leitor;
import java.util.List;

/**
 *
 * @author Francisco Junior
 */
public class MultaRN {
    
    MultaDAO dao = new MultaDAO();
    
    /**
     * Acessa o método dao.adicionar de MultaRN que por sua vez acessa o método
     * da classe genérica (GenericDAO) salvando o Multa.
     *
     * @param multa Multa.
     * @return booleano (true|false).
     * @see MultaDAO.
     */
    
    public boolean salvar(Multa multa) {
        if (multa.getIdMulta() == 0) {
            return dao.adicionar(multa);
        } else {
            return dao.atualizar(multa);
        }
    }

    /**
     * Acessa o método dao.remover de MultaRN  que por sua vez acessa o método
     * da classe genérica (GenericDao) removendo a Multa.
     *
      * @param multa Multa.
     * @return booleano (true|false).
     * @see MultaDAO.
     */
    public boolean remove(Multa multa) {
        return dao.remover(multa);

    }

    /**
     * Acessa o método dao.listar de MultaDAO que por sua vez acessa o método da
     * classe genérica (GenericDao) listando os Multas.
     *
     * @return List (Multa).
     * @see MultaDAO.
     */
    public List<Multa> listar() {
        return dao.listar();
    }
    
    /**
     * Acessa o método dao.pesquisarSeTemEmAbertoMulta de MultaDAO que por sua vez acessa o método
     * da classe genérica (GenericDao) pesquisarSeTemEmAbertoMulta a Multa.
     *
     * @param leitor Leitor.
     * @return booleano (true|false).
     * @see MultaDAO.
     */
    public boolean pesquisarSeTemEmAbertoMulta(Leitor leitor) {
        return dao.pesquisarSeTemEmAbertoMulta(leitor);
    }
     /**
     * Acessa o método dao.pesquisarMultas(leitor) de MultaDAO.
     *
     * @param leitor Leitor.
     * @return List(Multa).
     * @see MultaDAO.
     */
    public List<Multa> pesquisarMultas(Leitor leitor) {
        return dao.pesquisarMultas(leitor);
    }
    
     /**
     * Acessa o método dao.pesquisarCodigo(codigo) de MultaDAO.
     *
     * @param codigo int.
     * @return Leitor.
     * @see MultaDAO.
     */
    public Multa pesquisarCodigo(int codigo) {
        return dao.pesquisarCodigo(codigo);
    }
    
}
