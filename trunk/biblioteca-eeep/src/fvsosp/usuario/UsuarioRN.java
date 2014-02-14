/* Este arquivo é parte do OSBiblio.
 * Copyright (C) 2014 (Pedro Saraiva, Túlio Vidal, Luís Henrique, Adriano Lima, Oziel Pereira,
 * Marcos Ellys, Francisco Júnior, Fátima Pinheiro, Darly Vinicio).
 *
 * OSBiblio é um software livre; você pode redistribuí-lo e/ou  modificá-lo dentro dos termos da 
 * Licença Pública Geral GNU como publicada pela Fundação do Software Livre (FSF); na versão 2 da Licença,
 * ou (na sua opinião) qualquer versão.
 *
 * Este programa é distribuído na esperança de que possa ser útil, mas SEM NENHUMA GARANTIA; sem uma garantia 
 * implícita de ADEQUAÇÃO a qualquer MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a Licença Pública Geral GNU
 * para maiores detalhes.
 */
package fvsosp.usuario;

import fvsosp.util.Util;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author pedrosaraiva
 */
public class UsuarioRN {

    /**
     * Essa é a classe de comunicação com a camada visual (interface) e com a
     * camada de dados, essa classe implementa todas as regras de negócio
     * possíveis a Usuario.
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

    /**
     * Se usuário for administrador não pode ser removido.
     *
     * @param usuario Usuario.
     * @return booleano (true|false).
     */
    public boolean remover(Usuario usuario) {
        if (!usuario.isAdministrador()) {
            return usuDAO.remover(usuario);
        } else {
            return false;
        }
    }

    /**
     * Acessa o método usuDAO.adicionar que por sua vez acessa o método da
     * classe generica (GenericDAO) salvado o usuario.
     *
     * @param usuario Usuario.
     * @param outraSenha String.
     * @return booleano (true|false).
     * @see UsuarioDAO.
     */
    public boolean salvar(Usuario usuario, String outraSenha) {
        if (usuario.getIdUsuario() == 0) {
            //se adiciona tem que ter uma senha pra confirma a senha digitada
            List<Usuario> lista = usuDAO.checkExists("login", usuario.getLogin());
            if (lista.isEmpty()) {
                outraSenha = Util.md5(outraSenha);
                if ((usuario.getLogin() != null) && usuario.getSenha() != null) {
                    if (usuario.getSenha().equals(outraSenha)) {
                        return usuDAO.adicionar(usuario);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Login já cadastrado para Usuário!");
                return false;
            }
        } else {
            //se alterar tem que ter uma senha pra confirmar a senha anterior
            Usuario usu = usuDAO.pesquisarCodigo(usuario.getIdUsuario());
            if (usu.getSenha().equals(Util.md5(outraSenha))) {
                return usuDAO.atualizar(usuario);
            }
        }
        return false;
    }

    /**
     * Acessa o método dao.pesquisarLogin(login) de UsuarioDAO.
     *
     * @param login String.
     * @return Usuario.
     * @see UsuarioDAO.
     */
    public Usuario pesquisaLogin(String login) {
        return usuDAO.pesquisarLogin(login);
    }

    /**
     * Acessa o método dao,listar de TipoItemDAO que por sua vez acessa o método
     * da classe genérica (GenericDAO) listando o Usuario.
     *
     * @return List(Usuario).
     * @see UsuarioDAO.
     */
    public List<Usuario> listar() {
        return usuDAO.listar();
    }

    /**
     * Acessa o método dao.pesquisarLoginLike(login) de UsuarioDAO.
     *
     * @param login String.
     * @return list(usuario).
     * @see UsuarioDAO.
     */
    public List<Usuario> pesquisarLoginLike(String login) {
        return usuDAO.pesquisarLoginLike(login);
    }

    /**
     * Acessa o método dao.pesquisarCodigo(codigo) de UsuarioDAO.
     *
     * @param codigo short.
     * @return Usuario.
     * @see UsuarioDAO.
     */
    public Usuario pesquisarCodigo(short codigo) {
        return usuDAO.pesquisarCodigo(codigo);
    }
}