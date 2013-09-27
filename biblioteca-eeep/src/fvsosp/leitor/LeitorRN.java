/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.leitor;

import fvsosp.cidade.Cidade;
import fvsosp.grupoleitores.GruposLeitores;
import fvsosp.util.Util;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Pedro Saraiva
 */
public class LeitorRN {

    private LeitorDAO dao = new LeitorDAO();

    public boolean salvar(Leitor leitor) {
        if (leitor.getIdLeitor() == 0) {
            if ((leitor.getNome() != null) && (leitor.getGruposLeitores() != null)
                    && (leitor.getMatricula() != null)) {
                leitor.setAtivo(true);
                leitor.setDataCadastro(new Date( System.currentTimeMillis()));
                return dao.adicionar(leitor);

            }
        } else {
            return dao.atualizar(leitor);
        }
        return false;
    }

    public boolean remove(Leitor leitor) {
        return dao.remover(leitor);

    }

    public List<Leitor> listar() {
        return dao.listar();
    }

    public List<Leitor> pesquisaNome(String nome) {
        return dao.pesquisarNome(nome);
    }

    public List<Leitor> pesquisarEmail(String email) {
        return dao.pesquisarEmail(email);
    }

    public List<Leitor> pesquisarDataNascimento(Date dataNascimento) {
        return dao.pesquisarDataNascimento(dataNascimento);
    }

    public List<Leitor> pesquisarTelefone(String telefone) {
        return dao.pesquisarTelefone(telefone);
    }

    public List<Leitor> pesquisarCelular(String celular) {
        return dao.pesquisarCelular(celular);
    }

    public List<Leitor> pesquisarMatricula(String matricula) {
        return dao.pesquisarMatricula(matricula);
    }

    public List<Leitor> pesquisarAtivo(boolean ativo) {
        return dao.pesquisarAtivo(ativo);
    }

    public List<Leitor> pesquisarGrupoLeitores(GruposLeitores gruposLeitores) {
        return dao.pesquisarGrupoLeitores(gruposLeitores);
    }

    public List<Leitor> pesquisarCidade(Cidade cidades) {
        return dao.pesquisarCidade(cidades);
    }
    
    public Leitor pesquisarCodigo(short id) {
        return dao.pesquisarCodigo(id);
    }
}
