/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.grupoleitores;

import java.util.List;

/**
 *
 * @author Pedro Saraiva
 */
public class GruposLeitoresRN {

    private GruposLeitoresDAO dao = new GruposLeitoresDAO();

    public boolean salvar(GruposLeitores gl) {
            if (gl.getIdGruposLeitores() == 0) {
                return dao.adicionar(gl);
            } else {
                return dao.atualizar(gl);
            }
    }

    public boolean atualiza(GruposLeitores gl) {
        return dao.atualizar(gl);
    }

    public boolean remover(GruposLeitores gl) {
        return dao.remover(gl);
    }

    public List<GruposLeitores> listar() {
        return dao.listar();
    }

    public List<GruposLeitores> pesquisarDescricao(String descricao) {
        return dao.pesquisaDescricao(descricao);
    }

    public List<GruposLeitores> pesquisarDescricaoLike(String descricao) {
        return dao.pesquisarDescricaoLike(descricao);
    }

    public GruposLeitores pesquisarCodigo(short codigo) {
        return dao.pesquisarCodigo(codigo);
    }
}