package eeepjwm.emprestimo;

import eeepjwm.acervo.Acervo;
import eeepjwm.leitor.Leitor;
import java.util.Date;
import java.util.List;

public class Emprestimo {

    private int id;
    private Date dataEmrepstimo;
    private Date dataDevolucao;
    private List<Acervo> acervos;
    private Leitor leitor;
}
