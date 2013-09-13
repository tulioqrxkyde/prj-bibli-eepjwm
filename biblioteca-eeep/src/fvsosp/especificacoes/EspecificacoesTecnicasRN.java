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
        return dao.adicionar(et);
        
    }
    
    public boolean remover(EspecificacoesTecnicas et){
        return dao.remover(et);
        
    }
    
    public boolean atualiza(EspecificacoesTecnicas et){
        return dao.atualizar(et);
        
    }
    
    public List<EspecificacoesTecnicas> listar(){
        return dao.listar();
    }
    
}
