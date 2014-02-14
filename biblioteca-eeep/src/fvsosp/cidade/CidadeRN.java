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
package fvsosp.cidade;

import java.util.List;

/**
 *
 * @author oziel.ico
 */
public class CidadeRN {

    private CidadeDAO dao = new CidadeDAO();

    /**
     * Acessa o método dao.adicionar de CidadeDAO que por sua vez acessa o
     * método da classe genérica (GenericDAO) salvando a Cidade.
     *
     * @param cidade Cidade.
     * @return booleano (true|false).
     * @see CidadeDAO.
     */
    public boolean salvar(Cidade cidade) {
        if (cidade.getIdCidade() == 0) {
            return dao.adicionar(cidade);
        } else {
            return dao.atualizar(cidade);
        }
    }

    /**
     * Acessa o método dao.remover de CidadeDAO que por sua vez acessa o método
     * da classe genérica (GenericDao) removendo a Cidade.
     *
     * @param cidade Cidade.
     * @return booleano (true|false).
     * @see CidadeDAO.
     */
    public boolean remover(Cidade cidade) {
        return dao.remover(cidade);
    }

    /**
     * Acessa o método dao.listar de CidadeDAO que por sua vez acessa o método
     * da classe genérica (GenericDao) listando as Cidades.
     *
     * @return List(Cidade).
     * @see CidadeDAO.
     */
    public List<Cidade> listar() {
        return dao.listar();
    }

    /**
     * Acessa o método dao.pesquisarDescricao(descricao) de CidadeDAO.
     *
     * @param descricao String.
     * @return List(Cidade).
     * @see CidadeDAO.
     */
    public List<Cidade> pesquisarDescricao(String descricao) {
        return dao.pesquisarDescricao(descricao);
    }

    /**
     * Acessa o método dao.pesquisarDescricaoEq(descricao) de CidadeDAO.
     *
     * @param descricao String.
     * @return Cidade.
     * @see CidadeDAO.
     */
    public Cidade pesquisarDescricaoEq(String descricao) {
        return dao.pesquisarDescricaoEq(descricao);
    }

    /**
     * Acessa o método dao.pesquisarUf(uf) de CidadeDAO.
     *
     * @param uf String.
     * @return List(Cidade).
     * @see CidadeDAO.
     */
    public List<Cidade> pesquisarUf(String uf) {
        return dao.pesquisarUf(uf);
    }

    /**
     * Acessa o método dao.pesquisarIBGE(ibge) de CidadeDAO.
     *
     * @param ibge int.
     * @return Cidade.
     * @see CidadeDAO.
     */
    public Cidade pesquisarIBGE(int ibge) {
        return dao.pesquisarCodIbge(ibge);
    }
}