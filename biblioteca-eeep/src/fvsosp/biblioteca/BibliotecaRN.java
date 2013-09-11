/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.biblioteca;

import java.util.List;

/**
 *
 * @author Oziel
 */
public class BibliotecaRN {

    private BibliotecaDAO dao = new BibliotecaDAO();

    public boolean adiciona(Biblioteca biblioteca) {
        if (biblioteca.getDescricao() != null) {
            dao.adicionar(biblioteca);
            return true;
        }
        return false;
    }

    public boolean remove(Biblioteca biblioteca) {
        dao.remover(biblioteca);
        return true;
    }

    public boolean atualizar(Biblioteca biblioteca) {
        dao.atualizar(biblioteca);
        return true;
    }

    public List<Biblioteca> listar() {
        return dao.listar();
    }

    public List<Biblioteca> pesquisaDescricao(String descricao) {
        return dao.pesquisarDescricao(descricao);
    }
}
