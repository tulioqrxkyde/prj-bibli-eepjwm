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
            return dao.adicionar(biblioteca);
        
        }
        return false;
    }

    public boolean remove(Biblioteca biblioteca) {
        return dao.remover(biblioteca);

    }

    public boolean atualizar(Biblioteca biblioteca) {
        return dao.atualizar(biblioteca);
   
    }

    public List<Biblioteca> listar() {
        return dao.listar();
    }

    public Biblioteca pesquisaDescricao(String descricao) {
        return dao.pesquisarDescricao(descricao);
    }
}
