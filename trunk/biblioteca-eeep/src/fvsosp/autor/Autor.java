package fvsosp.autor;

import fvsosp.acervo.Acervo;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="aluno")
public class Autor {

    @Id
    @GeneratedValue
    private int id;
    
    private String nome;
    private String sobreOAutor;
    private List<Acervo> acervos;
}
