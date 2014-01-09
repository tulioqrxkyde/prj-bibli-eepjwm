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

    public boolean salvar(Biblioteca biblioteca) {
        if (biblioteca.getIdBiblioteca() == 0) {
            return dao.adicionar(biblioteca);
        } else {
            return dao.atualizar(biblioteca);
        }
    }

    public boolean remove(Biblioteca biblioteca) {
        return dao.remover(biblioteca);
    }

    public List<Biblioteca> listar() {
        return dao.listar();
    }

    public List<Biblioteca> pesquisarDescricao(String descricao) {
        return dao.pesquisarDescricao(descricao);
    }
    
    public Biblioteca pesquisarDescricaoEq(String descricao) {
        return dao.pesquisarDescricaoEq(descricao);
    }
    
    public Biblioteca pesquisarCodigo(short codigo) {
        return dao.pesquisarCodigo(codigo);
    }
}