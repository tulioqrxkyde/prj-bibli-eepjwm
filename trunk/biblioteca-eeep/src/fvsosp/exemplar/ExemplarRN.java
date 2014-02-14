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
package fvsosp.exemplar;

import fvsosp.acervo.Acervo;
import java.util.List;

/**
 *
 * @author pedrosaraiva
 */
public class ExemplarRN {

    private ExemplarDAO dao = new ExemplarDAO();

     /**
     * Acessa o método dao.adicionar de ExemplarDAO que por sua vez acessa o
     * método da classe genérica (GenericDAO) salvando o Exemplar.
     *
     * @param exemplar Exemplar.
     * @return booleano (true|false).
     * @see ExemplarDAO.
     */
    public boolean adiciona(Exemplar exemplar) {
        if (exemplar.getTombo() == 0) {
            return dao.adicionar(exemplar);
        } else {
            return dao.atualizar(exemplar);
        }
    }
    
     /**
     * Acessa o método dao.remover de ExemplarDAO que por sua vez acessa o método
     * da classe genérica (GenericDao) removendo o Exemplar.
     *
     * @param exemplar Exemplar.
     * @return booleano (true|false).
     * @see ExemplarDAO.
     */
    public boolean remover(Exemplar exemplar) {
        return dao.remover(exemplar);
    }
    
     /**
     * Acessa o método dao.listar de ExemplarDAO que por sua vez acessa o método da
     * classe genérica (GenericDao) listando os Exemplares.
     *
     * @return List(Exemplar).
     * @see ExemplarDAO.
     */
    
    public List<Exemplar> listar() {
        return dao.listar();
    }

     /**
     * Acessa o método dao.pesquisarTombo(tombo) de ExemplarDAO.
     *
     * @param tombo short.
     * @return Exemplar.
     * @see ExemplarDAO.
     */
    public Exemplar pesquisarTombo(short tombo) {
        return dao.pesquisarTombo(tombo);
    }
    
     /**
     * Acessa o método dao.pesquisarAcervo(acervo) de ExemplarDAO.
     *
     * @param acervo Acervo.
     * @return List(Exemplar).
     * @see ExemplarDAO.
     */

    public List<Exemplar> pesquisarAcervo(Acervo acervo) {
        return dao.pesquisarAcervo(acervo);
    }
}