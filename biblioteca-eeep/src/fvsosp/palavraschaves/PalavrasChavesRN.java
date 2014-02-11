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
package fvsosp.palavraschaves;

import fvsosp.acervo.Acervo;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Oziel
 */
public class PalavrasChavesRN {

    private PalavrasChavesDAO dao = new PalavrasChavesDAO();
    
    /**
     * Acessa o metodo dao.adicionar de PalavrasChavesDAO que por sua vez acessa
     * o metodo da classe generica (GenericDAO) salvando as PalavrasChaves.
     * 
     * @param pc PalavrasChaves.
     * @return booleano (true|false).
     * @see PalavrasChavesDAO.
     */
    public boolean adicionar(PalavrasChaves pc) {
        if (pc.getIdPalavrasChaves() == 0) {
            List<PalavrasChaves> lista = dao.checkExists("descricao", pc.getDescricao());
            if(lista.size()==0){
            return dao.adicionar(pc);
            } else {
                JOptionPane.showMessageDialog(null, "Descrição já cadastrada para Palavra Chave!");
                return false;
            }
        } else {
            return dao.atualizar(pc);
        }
    }
    /**
     * Acessa o metodo dao.remove de PalavrasChavesDAO que por sua vez acessa
     * o metodo da classe generica (GenericDAO) removendo as PalavrasChaves.
     * 
     * @param pc PalavrasChaves
     * @return booleano (true|false).
     * @see PalavrasChavesDAO
     */ 
    public boolean remove(PalavrasChaves pc) {
        return dao.remover(pc);

    }
    
    /**
     * Acessa o metodo dao.listar de PalavrasChavesDAO que por sua vez acessa
     * o metodo da classe generica (GenericDAO) listando as PalavrasChaves.
     * 
     * @return List(PalavrasChaves).
     * @see PalavrasChavesDAO.
     */
    public List<PalavrasChaves> listar() {
        return dao.listar();
    }
    
    /**
     * Acessa o metodo dao.pesquisarDescricao(descricao) de PalavrasChavesDAO.
     * 
     * @param descricao String.
     * @return List(PalavrasChaves).
     * @see PalavrasChavesDAO.
     */
    public List<PalavrasChaves> pesquisarDescricao(String descricao) {
        return dao.pesquisarDescricao(descricao);
    }
    
    /**
     * Acessa o metodo dao.pesquisarDescricaoEq(descricao) de PalavrasChavesDAO.
     * 
     * @param descricao String.
     * @return PalavrasChaves.
     * @see PalavrasChavesDAO.
     */
    public PalavrasChaves pesquisarDescricaoEq(String descricao) {
        return dao.pesquisarDescricaoEq(descricao);
    }
    
    /**
     * Acessa o metodo dao.pesquisarCodigo(id) de PalavrasChavesDAO.
     * 
     * @param id short.
     * @return PalavrasChaves.
     * @see PalavrasChavesDAO.
     */
    public PalavrasChaves pesquisarCodigo(short id) {
        return dao.pesquisarCodigo(id);
    }
    
    /**
     * Acessa o metodo dao.pesquisarAcervo(acervo) de PalavrasChavesDAO.
     * 
     * @param acervo Acervo.
     * @return List(PalavrasChaves).
     * @see PalavrasChavesDAO.
     */
    public List<PalavrasChaves> pesquisarAcervo(Acervo acervo) {
        return dao.pesquisarAcervo(acervo);
    }
}
