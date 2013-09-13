/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.autor;

import java.util.List;

/**
 *
 * @author marcos
 */
public class AutorRN {

    private AutorDAO dao = new AutorDAO();

    // Metódo que adiciona um autor
    public boolean adiciona(Autor autor) {
        if (autor.getNome() != null) {
            return dao.adicionar(autor);
            
        }
        return false;
    }

    // Metódo que remove
    public boolean remover(Autor autor) {
        return dao.remover(autor);
    }

    // Metódo que atualiza
    public boolean atualizar(Autor autor) {
        return dao.atualizar(autor);
    }

    // Metódo que faz um List de arcervos
    public List<Autor> listar() {
        return dao.listar();
    }

    // Metódos de pesquisa
    public List<Autor> pesquisarNome(String autor) {
        return dao.pesquisarNome(autor);
    }
    
    public List<Autor> pesquisarsobreOAutor(String sobreOAutor) {
        return dao.pesquisarsobreOAutor(sobreOAutor);
    }
}
