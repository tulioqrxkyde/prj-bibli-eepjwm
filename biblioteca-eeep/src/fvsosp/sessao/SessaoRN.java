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

    public boolean salvar(Sessao sessao) {
        if (sessao.getIdSessao() == 0) {
            return dao.adicionar(sessao);
        } else {
            return dao.atualizar(sessao);
        }
    }

    public boolean remove(Sessao sessao) {
        return dao.remover(sessao);

    }

    public List<Sessao> listar() {
        return dao.listar();
    }

    public Sessao pesquisarDescricao(String descricao) {
        return dao.pesquisarDescricao(descricao);
    }

    public List<Sessao> pesquisarDescricaoLike(String descricao) {
        return dao.pesquisarDescricaoLike(descricao);
    }

    public List<Sessao> pesquisarAcervos(Acervo acervos) {
        return dao.pesquisarAcervos(acervos);
    }

    public Sessao pesquisarCodigo(short codigo) {
        return dao.pesquisarCodigo(codigo);
    }
}
