package fvsosp.editora;

import fvsosp.acervo.Acervo;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Túlio
 */
public class EditoraRN {

    EditoraDAO dao = new EditoraDAO();

    public boolean salvar(Editora ed) {
        if (ed.getIdEditora() == 0) {
            List<Editora> lista = dao.checkExists("nome", ed.getNome());
            if(lista.size()==0){
            return dao.adicionar(ed);
            } else {
                JOptionPane.showMessageDialog(null, "Nome Já cadastrado para Editora");
                return false;
            }
        } else {
            return dao.atualizar(ed);
        }
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
    
    public Editora pesquisarNomeEditoraEq(String nome) {
        return dao.procuraNomeEditoraEq(nome);
    }

    public List<Acervo> pesquisarAcervoEditora(Editora et) {
        return dao.procuraAcervoEditora(et);
    }

    public Editora pesquisarCodigo(short codigo) {
        return dao.pesquisarCodigo(codigo);
    }
}