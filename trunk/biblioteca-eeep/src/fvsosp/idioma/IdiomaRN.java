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
            return dao.adicionar(idioma);
            
        }
        return false;

    }

    public boolean remove(Idioma idioma) {
        return dao.remover(idioma);
        
    }

    public boolean atualizar(Idioma idioma) {
        return dao.atualizar(idioma);
        
    }

    public List<Idioma> listar() {
        return dao.listar();
    }
    
    public List<Idioma> pesquisaDescricao(String descricao) {
        return dao.procuraDescricao(descricao);
    }
}
