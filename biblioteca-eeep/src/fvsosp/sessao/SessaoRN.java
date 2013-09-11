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
            dao.adicionar(sessao);
            return true;
        } 
        return false;
    }
    
    public boolean atualizar(Sessao sessao){
        dao.atualizar(sessao);
        return true;
    }
    
    public boolean remove(Sessao sessao){
        dao.remover(sessao);
        return true;
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
