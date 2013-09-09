/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.usuario;

import java.util.List;

/**
 *
 * @author Pedro Saraiva
 */
public class UsuarioRN {
    
    /*
     * Essa é a classe de comunicação com
     * a camada visual (interface)
     * e com a camada de dados,
     * essa classe implementa todas as regras de negócio
     * possíveis a Usuario
     */
    
    private UsuarioDAO usuDAO = new UsuarioDAO();
    
    public boolean autentica(Usuario usuario){
        Usuario usu = usuDAO.pesquisaUsuario(usuario);
        if(usu!=null){
            return true;
        } else {
            return false;
        }
    }
    
    /*
     * se usuário for administrador não pode ser removido
     */
    public boolean remover(Usuario usuario){
        if (!usuario.isAdministrador()){
            usuDAO.remover(usuario);
            return true;
        } else {
            return false;
        }
    }
    
    /*
     * verifica se a senha foi confirmada corretamente
     * depois atualiza
     */
    public boolean atualizar(Usuario usuario, String confirmaSenha){
        Usuario usu = usuDAO.carregaChavePrimaria(usuario.getIdUsuario());
        if(usu.getSenha().equals(confirmaSenha)){
            usuDAO.atualizar(usuario);
            return true;
        }
        return false;
        
    }
    
    /*
     * antes de adicionar verifica se a senha 
     * foi confirmada corretamente
     */
    public boolean adiciona(Usuario usuario, String confirmaSenha){
        if(usuario.getSenha().equals(confirmaSenha)){
            usuDAO.adicionar(usuario);
            return true;
        } 
        return false;
    }
    
    public Usuario pesquisaLogin(String login){
        return usuDAO.pesquisarLogin(login);
    }
    
    public List<Usuario> listar(){
        return usuDAO.listar();
    }
    
}
