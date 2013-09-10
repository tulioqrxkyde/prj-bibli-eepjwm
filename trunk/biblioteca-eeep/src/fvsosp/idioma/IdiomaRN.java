/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.idioma;

import java.util.List;

/**
 *
 * @author Pedro Saraiva
 */
public class IdiomaRN {

    private IdiomaDAO dao = new IdiomaDAO();

    public boolean adiciona(Idioma idioma) {
        if (idioma.getDescricao()!=null) {
            dao.adicionar(idioma);
            return true;
        }
        return false;

    }

    public boolean remove(Idioma idioma) {
        dao.remover(idioma);
        return true;
    }

    public boolean atualizar(Idioma idioma) {
        dao.atualizar(idioma);
        return true;
    }

    public List<Idioma> listar() {
        return dao.listar();
    }
    
    public List<Idioma> pesquisaDescricao(String descricao) {
        return dao.procuraDescricao(descricao);
    }
}