/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.cidade;

import java.util.List;

/**
 *
 * @author Oziel
 */
public class CidadeRN {

    private CidadeDAO dao = new CidadeDAO();

    public boolean adiciona(Cidade cidade) {
        if ((cidade.getDescricao() != null)
                &&(cidade.getUf()!=null)) {
            dao.adicionar(cidade);
            return true;
        }
        return false;
    }

    public boolean remover(Cidade cidade) {
        dao.remover(cidade);
        return true;
    }

    public boolean atualizar(Cidade cidade) {
        dao.atualizar(cidade);
        return true;
    }

    public List<Cidade> listar() {
        return dao.listar();
    }

    public List<Cidade> pesquisarDescricao(String descricao) {
        return dao.pesquisarDescricao(descricao);
    }
    
    public Cidade pesquisarCodIbge(int codibge) {
        return dao.pesquisarCodIbge(codibge);
    }
    
    public List<Cidade> pesquisarUf(String uf) {
        return dao.pesquisarUf(uf);
    }
}
