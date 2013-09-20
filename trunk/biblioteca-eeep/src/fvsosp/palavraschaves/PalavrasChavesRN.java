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

    public boolean adicionar(PalavrasChaves pc) {
        if (pc.getIdPalavrasChaves() == 0) {
            if (!pc.getDescricao().isEmpty()) {
                return dao.adicionar(pc);

            }
        } else {
            return dao.atualizar(pc);
        }
        return false;
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

    public List<PalavrasChaves> pesquisarAcervo(Acervo acervo) {
        return dao.pesquisarAcervo(acervo);
    }
}
