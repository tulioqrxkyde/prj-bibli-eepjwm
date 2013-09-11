/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.autor;
import java.util.List;

/**
 *
 * @author marcos
 */
public class AutorRN {
    
    private AutorDAO dao = new AutorDAO();
    
    // Metódo que adiciona um autor
    
    public boolean adiciona(Autor autor){
     if (autor.getNome() != null){
         dao.adicionar(autor);
         return true;
     }
          return false; 
    }
    
    // Metódo que remove
    
    public boolean remover(Autor autor){
        dao.remover(autor);
        return true;
        }
    
    
    // Metódo que atualiza
    
    public boolean atualizar(Autor autor){
        dao.atualizar(autor);
        return true;
    }
    
    // Metódo que faz um List de arcervos
    public List<Autor> listar(){
    return dao.listar();
    }
    
    
    // Metódo de pesquisa
    public List<Autor> pesquisarNome(String autor){
     return dao.pesquisarNome(autor);
    }
}
