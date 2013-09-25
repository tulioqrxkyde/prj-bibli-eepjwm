package fvsosp.editora;

import fvsosp.acervo.Acervo;
import java.util.*;

/**
 *
 * @author Túlio
 */
public class EditoraRN {

    EditoraDAO dao = new EditoraDAO();

    public boolean salvar(Editora ed) {
        if (ed.getIdEditora() == 0) {
            if (!ed.getNome().isEmpty()) {
                return dao.adicionar(ed);

            } else {
                return dao.atualizar(ed);
            }
        }
        return false;
    }

    

    public boolean remover(Editora ed) {
        return dao.remover(ed);

    }

    public List<Editora> listar() {
        return dao.listar();
    }

    public List<Editora> pesquisarNomeEditora(String nome) {
        return dao.procuraNomeEditora(nome);
    }

    public List<Acervo> pesquisarAcervoEditora(Editora et) {
        return dao.procuraAcervoEditora(et);
    }

    public Editora pesquisarCodigo(short codigo) {
        return dao.pesquisarCodigo(codigo);
    }
}