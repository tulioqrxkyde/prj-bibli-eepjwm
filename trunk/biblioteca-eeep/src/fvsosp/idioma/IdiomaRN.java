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
package fvsosp.idioma;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Francisco Junior
 */
public class IdiomaRN {

    private IdiomaDAO dao = new IdiomaDAO();

     /**
     * Acessa o método dao.adicionar de IdiomaDAO que por sua vez acessa o método
     * da classe genérica (GenericDAO) salvando o Idioma.
     *
     * @param idioma Idioma.
     * @return booleano (true|false).
     * @see IdiomaDAO.
     */
    public boolean salvar(Idioma idioma) {
        if (idioma.getIdIdioma() == 0) {
            List<Idioma> lista = dao.checkExists("descricao", idioma.getDescricao());
            if(lista.size()==0){
            return dao.adicionar(idioma);
            } else {
                JOptionPane.showMessageDialog(null, "Descrição Já cadastrada para Idioma");
                return false;
            }
        } else {
            return dao.atualizar(idioma);
        }
    }

    /**
     * Acessa o método dao.remover de IdiomaDAO que por sua vez acessa o método
     * da classe genérica (GenericDao) removendo o Idiomas.
     *
     * @param idioma Idioma.
     * @return booleano (true|false).
     * @see IdiomaDAO.
     */
    public boolean remove(Idioma idioma) {
        return dao.remover(idioma);

    }

    /**
     * Acessa o método dao.listar de IdiomaDAO que por sua vez acessa o método
     * da classe genérica (GenericDao) lista o Idiomas.
     *
      * @return List(Idioma).
     * @see IdiomaDAO.
     */
    public List<Idioma> listar() {
        return dao.listar();
    }

    /**
     * Acessa o método dao.pesquisaDescricao(descricao) de IdiomaDAO.
     *
     * @param descricao String.
     * @return List(Idioma).
     * @see IdiomaDAO.
     */
    public List<Idioma> pesquisaDescricao(String descricao) {
        return dao.pesquisarDescricao(descricao);
    }

     /**
     * Acessa o método dao.pesquisarDescricaoEq(descricao) de IdiomaDAO.
     *
     * @param descricao String.
     * @return List(Idioma).
     * @see IdiomaDAO.
     */
    public Idioma pesquisarDescricaoEq(String descricao) {
        return dao.pesquisarDescricaoEq(descricao);
    }

    /**
     * Acessa o método dao.pesquisarCodigo(codigo) de IdiomaDAO.
     *
     * @param codigo Short.
     * @return Idioma.
     * @see IdiomaDAO.
     */
    public Idioma pesquisarCodigo(short codigo) {
        return dao.pesquisarCodigo(codigo);
    }
}
