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
package fvsosp.editora;

import fvsosp.acervo.Acervo;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Túlio
 */
public class EditoraRN {

    EditoraDAO dao = new EditoraDAO();

    public boolean salvar(Editora ed) {
        if (ed.getIdEditora() == 0) {
            List<Editora> lista = dao.checkExists("nome", ed.getNome());
            if(lista.size()==0){
            return dao.adicionar(ed);
            } else {
                JOptionPane.showMessageDialog(null, "Nome Já cadastrado para Editora");
                return false;
            }
        } else {
            return dao.atualizar(ed);
        }
    }

    public boolean remover(Editora ed) {
        return dao.remover(ed);

    }

    public List<Editora> listar() {
        return dao.listar();
    }

    public List<Editora> pesquisarNomeEditora(String nome) {
        return dao.procuraNomeEditora(nome);
    }
    
    public Editora pesquisarNomeEditoraEq(String nome) {
        return dao.procuraNomeEditoraEq(nome);
    }

    public List<Acervo> pesquisarAcervoEditora(Editora et) {
        return dao.procuraAcervoEditora(et);
    }

    public Editora pesquisarCodigo(short codigo) {
        return dao.pesquisarCodigo(codigo);
    }
}