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
package fvsosp.autor;

import java.util.List;

/**
 *
 * @author marcos.ellys
 */
public class AutorRN {

    private AutorDAO dao = new AutorDAO();

    /**
     * Acessa o método dao.adicionar de AutorDAO que por sua vez acessa o método
     * da classe genérica (GenericDAO) salvando o Autor.
     *
     * @param autor Autor.
     * @return booleano (true|false).
     * @see AutorDAO.
     */
    public boolean salvar(Autor autor) {
        if (autor.getIdAutor() == 0) {
            return dao.adicionar(autor);
        } else {
            return dao.atualizar(autor);
        }
    }

    /**
     * Acessa o método dao.remover de AcervoDAO que por sua vez acessa o método
     * da classe genérica (GenericDao) removendo o Autor.
     *
     * @param autor Autor.
     * @return booleano (true|false).
     * @see AutorDAO.
     */
    public boolean remover(Autor autor) {
        return dao.remover(autor);
    }

    /**
     * Acessa o método dao.listar de AutorDAO que por sua vez acessa o método da
     * classe genérica (GenericDao) listando os Autores.
     *
     * @return List(Autor).
     * @see AutorDAO.
     */
    public List<Autor> listar() {
        return dao.listar();
    }

    /**
     * Acessa o método dao.pesquisarNome(autor) de AutorDAO.
     *
     * @param autor String.
     * @return List(Autor).
     * @see AutorDAO.
     */
    public List<Autor> pesquisarNome(String autor) {
        return dao.pesquisarNome(autor);
    }

    /**
     * Acessa o método dao.pesquisarsobreOAutor(sobreOAutor) de AutorDAO.
     *
     * @param sobreOAutor String.
     * @return List(Autor).
     * @see AutorDAO.
     */
    public List<Autor> pesquisarsobreOAutor(String sobreOAutor) {
        return dao.pesquisarsobreOAutor(sobreOAutor);
    }

    /**
     * Acessa o método dao.pesquisarCodigo(codigo) de AutorDAO.
     *
     * @param codigo String.
     * @return Autor.
     * @see AutorDAO.
     */
    public Autor pesquisarCodigo(short codigo) {
        return dao.pesquisarCodigo(codigo);
    }
}