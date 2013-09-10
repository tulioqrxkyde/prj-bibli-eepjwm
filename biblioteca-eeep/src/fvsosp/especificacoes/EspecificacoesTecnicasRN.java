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
    
    public boolean adiciona(EspecificacoesTecnicas et){
        dao.adicionar(et);
        return true;
    }
    
    public boolean remover(EspecificacoesTecnicas et){
        dao.remover(et);
        return true;
    }
    
    public boolean atualiza(EspecificacoesTecnicas et){
        dao.atualizar(et);
        return true;
    }
    
    public List<EspecificacoesTecnicas> listar(){
        return dao.listar();
    }
    
}
