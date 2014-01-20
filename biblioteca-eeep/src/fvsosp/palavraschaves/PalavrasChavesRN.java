/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.palavraschaves;

import fvsosp.acervo.Acervo;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Controle Avaliação
 */
public class PalavrasChavesRN {

    private PalavrasChavesDAO dao = new PalavrasChavesDAO();

    public boolean adicionar(PalavrasChaves pc) {
        if (pc.getIdPalavrasChaves() == 0) {
            List<PalavrasChaves> lista = dao.checkExists("descricao", pc.getDescricao());
            if(lista.size()==0){
            return dao.adicionar(pc);
            } else {
                JOptionPane.showMessageDialog(null, "Descrição já cadastrada para Palavra Chave!");
                return false;
            }
        } else {
            return dao.atualizar(pc);
        }
    }

    public boolean remove(PalavrasChaves pc) {
        return dao.remover(pc);

    }

    public List<PalavrasChaves> listar() {
        return dao.listar();
    }

    public List<PalavrasChaves> pesquisarDescricao(String descricao) {
        return dao.pesquisarDescricao(descricao);
    }
    
    public PalavrasChaves pesquisarDescricaoEq(String descricao) {
        return dao.pesquisarDescricaoEq(descricao);
    }

    public PalavrasChaves pesquisarCodigo(short id) {
        return dao.pesquisarCodigo(id);
    }

    public List<PalavrasChaves> pesquisarAcervo(Acervo acervo) {
        return dao.pesquisarAcervo(acervo);
    }
}
