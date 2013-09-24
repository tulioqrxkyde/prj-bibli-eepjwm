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

    public boolean salvar(Cidade cidade) {
        if (cidade.getIdCidade() == 0) {
            if ((cidade.getDescricao() != null)
                    && (cidade.getUf() != null)) {
                return dao.adicionar(cidade);

            }
        } else {
            return dao.atualizar(cidade);
        }
        return false;
    }

    public boolean remover(Cidade cidade) {
        return dao.remover(cidade);

    }

    public List<Cidade> listar() {
        return dao.listar();
    }

    public List<Cidade> pesquisarDescricao(String descricao) {
        return dao.pesquisarDescricao(descricao);
    }

    public List<Cidade> pesquisarUf(String uf) {
        return dao.pesquisarUf(uf);
    }
}
