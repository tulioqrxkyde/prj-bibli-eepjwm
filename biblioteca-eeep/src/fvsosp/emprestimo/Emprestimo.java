package fvsosp.emprestimo;

import fvsosp.acervo.Acervo;
import fvsosp.leitor.Leitor;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "Emprestimo")
public class Emprestimo {

    @Id // campo chave primária
    @GeneratedValue // campo auto-incremento
    private int idEmprestimo;
    
    @Temporal(TemporalType.DATE) // ignora horas e minutos e persiste apenas a data
    private Date dataEmprestimo;

    @Temporal(TemporalType.DATE) // ignora horas e minutos e persiste apenas a data
    private Date dataDevolucao;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(name = "AcervoEmprestimos", joinColumns = @JoinColumn(name = "idEmprestimo"), inverseJoinColumns = @JoinColumn(name = "idAcervo"))
    private List<Acervo> acervos;

    /*um emprestimo tem apenas um leitor
     * a chave estrangeira irá se chamar idLeitor
     */
    @ManyToOne 
    @JoinColumn(name = "idLeitor")
    private Leitor leitor;

    /*** @retorna o id do Empréstimo ***/
    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    /*** @seta o id do Empréstimo ***/
    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    /*** @retorna a Data do Empréstimo ***/
    public Date getDataEmrepstimo() {
        return dataEmprestimo;
    }

    /*** @seta a Data do Empréstimo ***/
    public void setDataEmrepstimo(Date dataEmrepstimo) {
        this.dataEmprestimo = dataEmrepstimo;
    }

    /*** @retorna a Data de Devolução ***/
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    /*** @seta a Data de Devolução ***/
    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    /*** @retorna a lista de Acervos ***/
    public List<Acervo> getAcervos() {
        return acervos;
    }

    /*** @seta e copia a lista de Acervos recebida para a lista de Acervos da Classe ***/
    public void setAcervos(List<Acervo> acervos) {
        this.acervos = acervos;
    }

    /*** @retorna o Leitor ***/
    public Leitor getLeitor() {
        return leitor;
    }

    /*** @seta o Leitor ***/
    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }
}