/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.exemplar;

import fvsosp.acervo.Acervo;
import fvsosp.acervo.AcervoDAO;
import java.util.List;

/**
 *
 * @author Pedro Saraiva
 */
public class ExemplarRN {

    private ExemplarDAO dao = new ExemplarDAO();

    // Metódo que adiciona um livro no acervo, caso contrário retorna false
    public boolean adiciona(Exemplar exemplar) {
        if (exemplar.getTombo() == 0) {
            return dao.adicionar(exemplar);
        } else {
            return dao.atualizar(exemplar);
        }

    }

    // Metódo que remove
    public boolean remover(Exemplar exemplar) {
        return dao.remover(exemplar);
    }

    // Metódo que faz um List de arcervos
    public List<Exemplar> listar() {
        return dao.listar();
    }

    public Exemplar pesquisarTombo(int tombo) {
        return dao.pesquisarTombo(tombo);
    }

    public List<Exemplar> pesquisarAcervo(Acervo acervo) {
        return dao.pesquisarAcervo(acervo);
    }
}
