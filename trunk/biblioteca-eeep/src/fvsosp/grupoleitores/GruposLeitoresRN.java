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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.grupoleitores;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Saraiva
 */
public class GruposLeitoresRN {

    private GruposLeitoresDAO dao = new GruposLeitoresDAO();
 /**
     * Acessa o método dao.adicionar de GruposLeitoresDAO que por sua vez acessa o método
     * da classe genérica (GenericDAO) salvando o Autor.
     *
     * @param gl Autor.
     * @return booleano (true|false).
     * @see GruposLeitoresDAO.
     */
    public boolean salvar(GruposLeitores gl) {
            if (gl.getIdGruposLeitores() == 0) {
                List<GruposLeitores> lista = dao.checkExists("descricao", gl.getDescricao());
                if(lista.size()==0){
                return dao.adicionar(gl);
                } else {
                    JOptionPane.showMessageDialog(null, "Descrição Já cadastrado para Grupo de Leitores");
                    return false;
                }
            } else {
                return dao.atualizar(gl);
            }
    }

    
    public boolean atualiza(GruposLeitores gl) {
        return dao.atualizar(gl);
    }
     /**
     * Acessa o método dao.remover de gl que por sua vez acessa o método
     * da classe genérica (GenericDao) removendo o GruposLeitores.
     *
     * @param gl GruposLeitores.
     * @return booleano (true|false).
     * @see GruposLeitoresDAO.
     */
    public boolean remover(GruposLeitores gl) {
        return dao.remover(gl);
    }
     /**
     * Acessa o método dao.listar de GruposLeitoresDAO que por sua vez acessa o método da
     * classe genérica (GenericDao) listando os GruposLeitores.
     *
     * @return List(GruposLeitores).
     * @see GruposLeitoresDAO
     */
    public List<GruposLeitores> listar() {
        return dao.listar();
    }
/**
     * Acessa o método dao.pesquisarDescricao(descricao) de GruposLeitoresDAO.
     *
     * @param descricao String.
     * @return List(GruposLeitores).
     * @see GruposLeitoresDAO.
     */
    public List<GruposLeitores> pesquisarDescricao(String descricao) {
        return dao.pesquisaDescricao(descricao);
    }
    /**
     * Acessa o método dao.pesquisarDescricaoEq(Descricao) de GruposLeitoresDAO.
     *
     * @param Descricao String.
     * @return List(GruposLeitores).
     * @see GruposLeitoresDAO.
     */
    public GruposLeitores pesquisarDescricaoEq(String descricao) {
        return dao.pesquisaDescricaoEq(descricao);
    }
     /**
     * Acessa o método dao.pesquisarDescricaoLike(Descricao) de GruposLeitoresDAO.
     *
     * @param Descricao String.
     * @return GruposLeitores.
     * @see GruposLeitoresDAO.
     */
    public List<GruposLeitores> pesquisarDescricaoLike(String descricao) {
        return dao.pesquisarDescricaoLike(descricao);
    }

     /**
     * Acessa o método dao.pesquisarCodigo(codigo) de GruposLeitoresDAO.
     *
     * @param codigo Short.
     * @return GruposLeitores.
     * @see GruposLeitoresDAO.
     */
    public GruposLeitores pesquisarCodigo(short codigo) {
        return dao.pesquisarCodigo(codigo);
    }
}