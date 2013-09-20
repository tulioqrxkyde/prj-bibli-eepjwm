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
        if (gl.getIdGruposLeitores() == 0) {
            if (gl.getDescricao() != null) {
                return dao.adicionar(gl);

            }
        } else {
            return dao.atualizar(gl);
        }
        return false;
    }

    public boolean atualiza(GruposLeitores gl) {
        return dao.atualizar(gl);
    }

    public List<GruposLeitores> listar() {
        return dao.listar();
    }

    public List<GruposLeitores> pesquisarDescricao(String descricao) {
        return dao.pesquisaDescricao(descricao);
    }
}
