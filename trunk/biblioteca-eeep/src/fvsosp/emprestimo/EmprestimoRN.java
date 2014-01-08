package fvsosp.emprestimo;

import fvsosp.acervo.Acervo;
import fvsosp.exemplar.Exemplar;
import fvsosp.leitor.Leitor;
import java.util.*;

/**
 *
 * @author Túlio
 */
public class EmprestimoRN {

    EmprestimoDAO dao = new EmprestimoDAO();

    public boolean adiciona(Emprestimo em) {
        if (em.getIdEmprestimo() == 0) {
                return dao.adicionar(em);
        } else {
            return dao.atualizar(em);
        }
    }

    public boolean remover(Emprestimo em) {
        return dao.remover(em);

    }

    public List<Emprestimo> listar() {
        return dao.listar();
    }
    
    public Emprestimo pesquisarCodigo(short codigo) {
        return dao.pesquisarCodigo(codigo);
    }

    public List<Emprestimo> pesquisardataEmprestimo(Date data) {
        return dao.pesquisardataEmprestimo(data);
    }

    public List<Emprestimo> pesquisardataDevolucao(Date data) {
        return dao.pesquisardataEmprestimo(data);
    }

    public List<Acervo> pesquisarEmprestimo(Emprestimo emprestimo) {
        return dao.pesquisarEmprestimo(emprestimo);
    }
    
    public int pesquisarSituacao(Leitor leitor) {
        return dao.pesquisarSituacao(leitor);
    }
    
    public short pesquisarEmprestimoLivroDevolvido(Exemplar exe) {
        return dao.pesquisarEmprestimoLivroDevolvido(exe);

    }
}