/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.usuario;

import fvsosp.util.Util;
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

    public boolean autentica(Usuario usuario) {
        Usuario usu = usuDAO.pesquisaUsuario(usuario);
        if (usu != null) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * se usuário for administrador não pode ser removido
     */
    public boolean remover(Usuario usuario) {
        if (!usuario.isAdministrador()) {
            return usuDAO.remover(usuario);
        } else {
            return false;
        }
    }

    public boolean salvar(Usuario usuario, String outraSenha) {
        if (usuario.getIdUsuario() == 0) {
            //se adiciona tem que ter uma senha pra confirma a senha digitada
            outraSenha = Util.md5(outraSenha);
            if ((usuario.getLogin() != null) && usuario.getSenha() != null) {
                if (usuario.getSenha().equals(outraSenha)) {
                    return usuDAO.adicionar(usuario);
                }
            }
        } else {
            //se altera tem que ter uma senha pra confirmar a senha anterior
            Usuario usu = usuDAO.pesquisarCodigo(usuario.getIdUsuario());
            if (usu.getSenha().equals(Util.md5(outraSenha))) {
                return usuDAO.atualizar(usuario);
            }
        }
        return false;
    }

    public Usuario pesquisaLogin(String login) {
        return usuDAO.pesquisarLogin(login);
    }

    public List<Usuario> listar() {
        return usuDAO.listar();
    }
    
    public List<Usuario> pesquisarLoginLike(String login) {
        return usuDAO.pesquisarLoginLike(login);
    }
    
     public Usuario pesquisarCodigo(short codigo) {
         return usuDAO.pesquisarCodigo(codigo);
     }
}
