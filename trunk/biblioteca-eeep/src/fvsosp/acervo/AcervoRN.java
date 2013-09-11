/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.acervo;
import java.util.List;
/**
 *
 * @author marcos
 */
public class AcervoRN {
    
    private AcervoDAO dao = new AcervoDAO();
    
    // Metódo que adiciona um livro no acervo, caso contrário retorna false
    
    public boolean adiciona(Acervo acervo) {
        if (acervo.getTituloObra() != null) {
            dao.adicionar(acervo);
            return true;
        }
        return false;
    }

    // Metódo que remove
    
    public boolean remover(Acervo acervo) {
        dao.remover(acervo);
        return true;
    }

    // Metódo que atualiza no banco de dados o acervo
    public boolean atualizar(Acervo acervo) {
        dao.atualizar(acervo);
        return true;
    }
    
    // Metódo que faz um List de arcervos
    
    public List<Acervo> listar() {
        return dao.listar();
    }
    
    // Metódo de pesquisa
    public List<Acervo> pesquisarTitulodaObra(String obra) {
        return dao.pesquisarTitulodaObra(obra);
    }
    
}
