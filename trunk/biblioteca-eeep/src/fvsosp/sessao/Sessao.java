package fvsosp.sessao;

import fvsosp.acervo.Acervo;
import java.util.List;
import javax.swing.text.html.parser.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="sessao")
public class Sessao {

    private int id;
    private int descricao;
    private List<Acervo> acervos;
}
