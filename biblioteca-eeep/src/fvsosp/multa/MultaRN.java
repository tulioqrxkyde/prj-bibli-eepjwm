/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.multa;

import fvsosp.leitor.Leitor;
import java.util.List;

/**
 *
 * @author Pedro Saraiva
 */
public class MultaRN {
    
    MultaDAO dao = new MultaDAO();
    
    public boolean salvar(Multa multa) {
        if (multa.getIdMulta() == 0) {
            return dao.adicionar(multa);
        } else {
            return dao.atualizar(multa);
        }
    }

    public boolean remove(Multa multa) {
        return dao.remover(multa);

    }

    public List<Multa> listar() {
        return dao.listar();
    }
    
    public boolean pesquisarSeTemEmAbertoMulta(Leitor leitor) {
        return dao.pesquisarSeTemEmAbertoMulta(leitor);
    }
    
}
