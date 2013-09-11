package fvsosp.emprestimo;

import fvsosp.acervo.Acervo;
import java.util.*;

/**
 *
 * @author Túlio
 */
public class EmprestimoRN {

    EmprestimoDAO dao = new EmprestimoDAO();

    public boolean adiciona(Emprestimo em) {
        if ((!em.getDataEmprestimo().toString().isEmpty()) && (em.getLeitor() != null) && (!em.getAcervos().isEmpty())) {
            dao.adicionar(em);
            return true;
        }
        return false;
    }

    public boolean remover(Emprestimo em) {
        dao.remover(em);
        return true;
    }

    public boolean atualizar(Emprestimo em) {
        dao.atualizar(em);
        return true;
    }

    public List<Emprestimo> listar() {
        return dao.listar();
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
}