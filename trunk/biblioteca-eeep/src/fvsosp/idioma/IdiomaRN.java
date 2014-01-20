package fvsosp.idioma;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Saraiva
 */
public class IdiomaRN {

    private IdiomaDAO dao = new IdiomaDAO();

    public boolean salvar(Idioma idioma) {
        if (idioma.getIdIdioma() == 0) {
            List<Idioma> lista = dao.checkExists("descricao", idioma.getDescricao());
            if(lista.size()==0){
            return dao.adicionar(idioma);
            } else {
                JOptionPane.showMessageDialog(null, "Descrição Já cadastrada para Idioma");
                return false;
            }
        } else {
            return dao.atualizar(idioma);
        }
    }

    public boolean remove(Idioma idioma) {
        return dao.remover(idioma);

    }

    public List<Idioma> listar() {
        return dao.listar();
    }

    public List<Idioma> pesquisaDescricao(String descricao) {
        return dao.pesquisarDescricao(descricao);
    }

    public Idioma pesquisarDescricaoEq(String descricao) {
        return dao.pesquisarDescricaoEq(descricao);
    }

    public Idioma pesquisarCodigo(short codigo) {
        return dao.pesquisarCodigo(codigo);
    }
}
