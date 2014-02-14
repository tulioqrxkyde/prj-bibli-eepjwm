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
package fvsosp.sessao;

import fvsosp.acervo.Acervo;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author adrianolima
 */
public class SessaoRN {

    private SessaoDAO dao = new SessaoDAO();

    /**
     * Acessa o método dao.adicionar de SessaoDAO que por sua vez acessa o
     * método da classe generica (GenericDAO) salvando a Sessao.
     *
     * @param sessao Sessao.
     * @return booleano (true|false).
     * @see SessaoDAO.
     */
    public boolean salvar(Sessao sessao) {
        if (sessao.getIdSessao() == 0) {
            List<Sessao> lista = dao.checkExists("descricao", sessao.getDescricao());
            if (lista.isEmpty()) {
                return dao.adicionar(sessao);
            } else {
                JOptionPane.showMessageDialog(null, "Descrição já cadastrada para Sessão!");
                return false;
            }
        } else {
            return dao.atualizar(sessao);
        }
    }

    /**
     * Acessa o método dao.remover de SessaoDAO que por sua vez acessa o método
     * da classe genérica (GenericDAO) removendo a Sessao.
     *
     * @param sessao Sessao.
     * @return booleano (true|false).
     * @see SessaoDAO.
     */
    public boolean remove(Sessao sessao) {
        return dao.remover(sessao);
    }

    /**
     * Acessa o método dao.listar de SessaoDAO que por sua vez acessa o método
     * da classe genérica (GenericDAO) listando a Sesssao.
     *
     * @return List(Sessao).
     * @see SessaoDAO.
     */
    public List<Sessao> listar() {
        return dao.listar();
    }

    /**
     * Acessa o método dao.pesquisarDescricao(descricao) de SessaoDAO.
     *
     * @param descricao String.
     * @return Sessao.
     * @see SessaoDAO.
     */
    public Sessao pesquisarDescricao(String descricao) {
        return dao.pesquisarDescricao(descricao);
    }

    /**
     * Acessa o método dao.pesquisarDescricaoLike(descricao) de SessaoDAO.
     *
     * @param descricao String.
     * @return list(Sessao).
     * @see SessaoDAO.
     */
    public List<Sessao> pesquisarDescricaoLike(String descricao) {
        return dao.pesquisarDescricaoLike(descricao);
    }

    /**
     * Acessa o método dao.pesquisarAcervos(acervos) de SessaoDAO.
     *
     * @param acervos Acervo.
     * @return List(Sessao).
     * @see SessaoDAO.
     */
    public List<Sessao> pesquisarAcervos(Acervo acervos) {
        return dao.pesquisarAcervos(acervos);
    }

    /**
     * Acessa o método dao.pesquisarCodigo(codigo) de SessaoDAO.
     *
     * @param codigo short.
     * @return Sessao.
     * @see SessaoDAO.
     */
    public Sessao pesquisarCodigo(short codigo) {
        return dao.pesquisarCodigo(codigo);
    }
}