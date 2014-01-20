/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.leitor;

import fvsosp.cidade.Cidade;
import fvsosp.grupoleitores.GruposLeitores;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Saraiva
 */
public class LeitorRN {

    private LeitorDAO dao = new LeitorDAO();

    public boolean salvar(Leitor leitor) {
        if (leitor.getIdLeitor() == 0) {
            List<Leitor> leitores = dao.pesquisarCpf(leitor.getCpf());
            if (leitores.size() > 0) {
                JOptionPane.showMessageDialog(null, "Já Existe Leitor Cadastrado com o CPF: " + leitor.getCpf() + "!");
                return false;
            } else {
                List<Leitor> leitorMatricula = dao.checkExists("matricula", leitor.getMatricula());
                if (leitorMatricula.size() == 0) {
                    List<Leitor> leitorNome = dao.checkExists("nome", leitor.getNome());
                    if(leitorNome.size()==0){
                    return dao.adicionar(leitor);
                    } else {
                        JOptionPane.showMessageDialog(null, "Nome Já cadastrado para leitor");
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Matrícula Já cadastrada para leitor");
                    return false;
                }
            }
        } else {
            return dao.atualizar(leitor);
        }
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

    public Leitor pesquisaNomeEq(String nome) {
        return dao.pesquisarNomeEq(nome);
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

    public Leitor pesquisarMatriculaEq(String matricula) {
        return dao.pesquisarMatriculaEq(matricula);
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
