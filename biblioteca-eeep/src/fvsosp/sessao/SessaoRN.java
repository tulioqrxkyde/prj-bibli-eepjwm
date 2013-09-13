/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.sessao;

import fvsosp.acervo.Acervo;
import java.util.List;

/**
 *
 * @author Controle Avaliação
 */
public class SessaoRN {
    
    private SessaoDAO dao = new SessaoDAO();
    
    public boolean adicionar(Sessao sessao){
        if(!sessao.getDescricao().isEmpty()){
            return dao.adicionar(sessao);
            
        } 
        return false;
    }
    
    public boolean atualizar(Sessao sessao){
        return dao.atualizar(sessao);
        
    }
    
    public boolean remove(Sessao sessao){
        return dao.remover(sessao);
        
    }
    
    public List<Sessao> listar(){
        return dao.listar();
    }
    
    public List<Sessao> pesquisarDescricao(String descricao) {
        return dao.pesquisarDescricao(descricao);
    }
    
    public List<Sessao> pesquisarAcervos(Acervo acervos) {
        return dao.pesquisarAcervos(acervos);
    }
    
    
    
}
