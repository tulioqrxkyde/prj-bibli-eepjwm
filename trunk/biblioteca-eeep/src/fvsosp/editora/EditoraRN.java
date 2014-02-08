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
package fvsosp.editora;

import fvsosp.acervo.Acervo;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Túlio
 */
public class EditoraRN {

    EditoraDAO dao = new EditoraDAO();

    
     /**
     * Acessa o método dao.adicionar de EditoraDAO que por sua vez acessa o método
     * da classe genérica (GenericDAO) salvando a Editora.
     *
     * @param ed Editora.
     * @return booleano (true|false).
     * @see EditoraDAO.
     */
    
    public boolean salvar(Editora ed) {
        if (ed.getIdEditora() == 0) {
            List<Editora> lista = dao.checkExists("nome", ed.getNome());
            if(lista.size()==0){
            return dao.adicionar(ed);
            } else {
                JOptionPane.showMessageDialog(null, "Nome Já cadastrado para Editora");
                return false;
            }
        } else {
            return dao.atualizar(ed);
        }
    }
    
     /**
     * Acessa o método dao.remover de EditoraDAO que por sua vez acessa o método
     * da classe genérica (GenericDao) removendo a Editora.
     *
     * @param ed Editora.
     * @return booleano (true|false).
     * @see EditoraDAO.
     */

    public boolean remover(Editora ed) {
        return dao.remover(ed);

    }
    
     /**
     * Acessa o método dao.listar de EditoraDAO que por sua vez acessa o método da
     * classe genérica (GenericDao) listando as Editoras.
     *
     * @return List(Editora).
     * @see EditoraDAO.
     */

    public List<Editora> listar() {
        return dao.listar();
    }
    
     /**
     * Acessa o método dao.pesquisarNomeEditora(nome) de EditoraDAO.
     *
     * @param nome String.
     * @return List(Editora).
     * @see EditoraDAO.
     */
    public List<Editora> pesquisarNomeEditora(String nome) {
        return dao.procuraNomeEditora(nome);
    }
    
     /**
     * Acessa o método dao.pesquisarNomeEditoraEq(nome) de EditoraDAO.
     *
     * @param nome String.
     * @return Editora nome.
     * @see EditoraDAO.
     */
    
    public Editora pesquisarNomeEditoraEq(String nome) {
        return dao.procuraNomeEditoraEq(nome);
    }
    
     /**
     * Acessa o método dao.pesquisarAcervoEditora(ed) de EditoraDAO.
     *
     * @param ed String.
     * @return Editora ed.
     * @see EditoraDAO.
     */

    public List<Acervo> pesquisarAcervoEditora(Editora ed) {
        return dao.procuraAcervoEditora(ed);
    }
    
        
     /**
     * Acessa o método dao.pesquisarCodigo(codigo) de EditoraDAO.
     *
     * @param codigo short.
     * @return Editora editora.
     * @see EditoraDAO.
     */

    public Editora pesquisarCodigo(short codigo) {
        return dao.pesquisarCodigo(codigo);
    }
}