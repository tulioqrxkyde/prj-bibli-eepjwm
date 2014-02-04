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
package fvsosp.biblioteca;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author oziel.ico
 */
public class BibliotecaRN {

    private BibliotecaDAO dao = new BibliotecaDAO();

    /**
     * Acessa o método dao.adicionar de BibliotecaDAO que por sua vez acessa o
     * método da classe genérica (GenericDAO) salvando a Biblioteca.
     *
     * @param biblioteca Biblioteca.
     * @return booleano (true|false).
     * @see BibliotecaDAO.
     */
    public boolean salvar(Biblioteca biblioteca) {
        if (biblioteca.getIdBiblioteca() == 0) {
            List<Biblioteca> lista = dao.checkExists("descricao", biblioteca.getDescricao());
            if (lista.isEmpty()) {
                return dao.adicionar(biblioteca);
            } else {
                JOptionPane.showMessageDialog(null, "Descrição Já cadastrada para Biblioteca");
                return false;
            }
        } else {
            return dao.atualizar(biblioteca);
        }
    }

    /**
     * Acessa o método dao.remover de BibliotecaDAO que por sua vez acessa o
     * método da classe genérica (GenericDao) removendo a Biblioteca.
     *
     * @param biblioteca Biblioteca.
     * @return booleano (true|false).
     * @see BibliotecaDAO.
     */
    public boolean remove(Biblioteca biblioteca) {
        return dao.remover(biblioteca);
    }

    /**
     * Acessa o método dao.listar de BibliotecaDAO que por sua vez acessa o
     * método da classe genérica (GenericDao) listando as Bibliotecas.
     *
     * @return List(Biblioteca).
     * @see BibliotecaDAO.
     */
    public List<Biblioteca> listar() {
        return dao.listar();
    }

    /**
     * Acessa o método dao.pesquisarDescricao(descricao) de BibliotecaDAO.
     *
     * @param descricao String.
     * @return List(Biblioteca).
     * @see BibliotecaDAO.
     */
    public List<Biblioteca> pesquisarDescricao(String descricao) {
        return dao.pesquisarDescricao(descricao);
    }

    /**
     * Acessa o método dao.pesquisarDescricaoEq(descricao) de BibliotecaDAO.
     *
     * @param descricao String.
     * @return Biblioteca.
     * @see BibliotecaDAO.
     */
    public Biblioteca pesquisarDescricaoEq(String descricao) {
        return dao.pesquisarDescricaoEq(descricao);
    }

    /**
     * Acessa o método dao.pesquisarCodigo(short) de BibliotecaDAO.
     *
     * @param codigo short.
     * @return Biblioteca.
     * @see BibliotecaDAO.
     */
    public Biblioteca pesquisarCodigo(short codigo) {
        return dao.pesquisarCodigo(codigo);
    }
}