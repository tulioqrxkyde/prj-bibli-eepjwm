/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.grupoleitores;

import fvsosp.cidade.Cidade;
import java.util.List;

/**
 *
 * @author Pedro Saraiva
 */
public class GruposLeitoresRN {

    private GruposLeitoresDAO dao = new GruposLeitoresDAO();

    public boolean adiciona(GruposLeitores gl) {
        if (gl.getDescricao() != null) {
            dao.adicionar(gl);
            return true;
        }
        return false;
    }

    public boolean atualiza(GruposLeitores gl) {
        dao.atualizar(gl);
        return true;

    }

    public boolean remover(GruposLeitores gl) {
        dao.remover(gl);
        return true;

    }

    public List<GruposLeitores> listar() {
        return dao.listar();
    }

    public List<GruposLeitores> pesquisarDescricao(String descricao) {
        return dao.pesquisaDescricao(descricao);
    }
}
