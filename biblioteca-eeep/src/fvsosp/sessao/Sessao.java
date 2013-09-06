package fvsosp.sessao;

import fvsosp.acervo.Acervo;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sessao")
public class Sessao {

    @Id
    @GeneratedValue
    private int id;
    
    @Column(nullable=true, length=150)
    private int descricao;
    
    @OneToMany(mappedBy="id")
    private List<Acervo> acervos;
}
