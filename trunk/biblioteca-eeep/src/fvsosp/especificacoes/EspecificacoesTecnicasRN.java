/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.especificacoes;

import java.util.List;

/**
 *
 * @author Pedro Saraiva
 */
public class EspecificacoesTecnicasRN {

    private EspecificacoesTecnicasDAO dao = new EspecificacoesTecnicasDAO();

    public boolean adiciona(EspecificacoesTecnicas et) {
        if (et.getIdEspecificacoesTecnicas() == 0) {
            return dao.adicionar(et);
        } else {
            return dao.atualizar(et);
        }

    }

    public boolean remover(EspecificacoesTecnicas et) {
        return dao.remover(et);

    }

    public List<EspecificacoesTecnicas> listar() {
        return dao.listar();
    }
}
