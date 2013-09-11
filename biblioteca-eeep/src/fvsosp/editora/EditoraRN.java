package fvsosp.editora;

import fvsosp.acervo.Acervo;
import java.util.*;

/**
 *
 * @author Túlio
 */
public class EditoraRN {
    
    EditoraDAO dao = new EditoraDAO();
    
    public boolean adiciona(Editora ed) {
        if ((ed.getIdEditora()> 0) && (!ed.getNome().isEmpty()) && (ed.getAcervo() != null) && (!ed.getAcervo().isEmpty())) {
            dao.adicionar(ed);
            return true;
        }
        return false;
    }

    public boolean remover(Editora ed) {
        dao.remover(ed);
        return true;
    }

    public boolean atualizar(Editora ed) {
        dao.atualizar(ed);
        return true;
    }

    public List<Editora> listar() {
        return dao.listar();
    }

    public Editora pesquisarIdEditora(int id) {
        return dao.procuraIdEditora(id);
    }

    public List<Editora> pesquisarNomeEditora(String nome) {
        return dao.procuraNomeEditora(nome);
    }

    public List<Acervo> pesquisarAcervoEditora(Editora et) {
        return dao.procuraAcervoEditora(et);
    }
}