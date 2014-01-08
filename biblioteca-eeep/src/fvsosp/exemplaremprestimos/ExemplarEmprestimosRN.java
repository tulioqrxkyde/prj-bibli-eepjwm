/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.exemplaremprestimos;

import fvsosp.exemplar.Exemplar;
import java.util.List;

/**
 *
 * @author Pedro Saraiva
 */
public class ExemplarEmprestimosRN {
    
    ExemplarEmprestimosDAO dao = new ExemplarEmprestimosDAO();
    
    public boolean adiciona(ExemplarEmprestimos em) {
        if (em.getIdExemplarEmprestimos() == 0) {
                return dao.adicionar(em);
        } else {
            return dao.atualizar(em);
        }
    }

    public boolean remover(ExemplarEmprestimos em) {
        return dao.remover(em);

    }

    public List<ExemplarEmprestimos> listar() {
        return dao.listar();
    }
    
    public ExemplarEmprestimos pesquisarCodigo(short codigo) {
        return dao.pesquisarCodigo(codigo);
    }
    
    public short pesquisarIdExemplarEmprestimoDevolvido(Exemplar exe) {
        return dao.pesquisarIdExemplarEmprestimoDevolvido(exe);

    }
}
