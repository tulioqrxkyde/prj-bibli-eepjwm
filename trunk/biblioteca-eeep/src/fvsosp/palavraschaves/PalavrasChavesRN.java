/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.palavraschaves;

import fvsosp.acervo.Acervo;
import java.util.List;

/**
 *
 * @author Controle Avaliação
 */
public class PalavrasChavesRN {
    
    private PalavrasChavesDAO dao = new PalavrasChavesDAO();
    
    public boolean adicionar(PalavrasChaves pc){
        if(!pc.getDescricao().isEmpty()){
            dao.adicionar(pc);
            return true;
        } 
        return false;
    }
    
    public boolean atualizar(PalavrasChaves pc){
        dao.atualizar(pc);
        return true;
    }
    
    public boolean remove(PalavrasChaves pc){
        dao.remover(pc);
        return true;
    }
    
    public List<PalavrasChaves> listar(){
        return dao.listar();
    }
    
    public List<PalavrasChaves> pesquisarDescricao(String descricao) {
        return dao.pesquisarDescricao(descricao);
    }
    
    public List<PalavrasChaves> pesquisarAcervo(Acervo acervo) {
        return dao.pesquisarAcervo(acervo);
    }
    
}
