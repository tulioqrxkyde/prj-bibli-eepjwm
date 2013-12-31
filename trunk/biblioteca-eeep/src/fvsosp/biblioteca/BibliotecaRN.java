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
        if (!biblioteca.getDescricao().isEmpty()) {
            if (biblioteca.getIdBiblioteca() == 0) {
                return dao.adicionar(biblioteca);
            } else {
                return dao.atualizar(biblioteca);
            }
        }
        return false;
    }

    public boolean remove(Biblioteca biblioteca) {
        return dao.remover(biblioteca);

    }

    public List<Biblioteca> listar() {
        return dao.listar();
    }

    public Biblioteca pesquisaDescricao(String descricao) {
        return dao.pesquisarDescricao(descricao);
    }
    
    public List<Biblioteca> pesquisaDescricaoLike(String descricao) {
        return dao.pesquisarDescricaoLike(descricao);
    }

    public Biblioteca pesquisarCodigo(short codigo) {
        return dao.pesquisarCodigo(codigo);
    }
}
