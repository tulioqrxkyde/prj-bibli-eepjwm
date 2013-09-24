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
        if(ed.getIdEditora()==0){
        if ((!ed.getNome().isEmpty()) && (ed.getAcervo() != null) && (!ed.getAcervo().isEmpty())) {
            return dao.adicionar(ed);
            
        }}else{
            return dao.atualizar(ed);
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
}