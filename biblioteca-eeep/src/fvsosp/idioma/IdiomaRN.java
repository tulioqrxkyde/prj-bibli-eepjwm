package fvsosp.idioma;

import java.util.List;

/**
 *
 * @author Pedro Saraiva
 */
public class IdiomaRN {

    private IdiomaDAO dao = new IdiomaDAO();

    public boolean salvar(Idioma idioma) {
        if (idioma.getIdIdioma() == 0) {
            return dao.adicionar(idioma);
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

    public List<Idioma> pesquisarDescricaoLike(String descricao) {
        return dao.pesquisarDescricaoLike(descricao);
    }

    public Idioma pesquisarCodigo(short codigo) {
        return dao.pesquisarCodigo(codigo);
    }
}
