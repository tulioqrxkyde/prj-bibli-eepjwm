package fvsosp.emprestimo;

import fvsosp.acervo.Acervo;
import fvsosp.exemplar.Exemplar;
import fvsosp.leitor.Leitor;
import fvsosp.usuario.Usuario;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "emprestimo")
public class Emprestimo implements Serializable {

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.getIdEmprestimo();
        hash = 53 * hash + Objects.hashCode(this.getDataEmprestimo());
        //hash = 53 * hash + Objects.hashCode(this.getExemplares());
        hash = 53 * hash + Objects.hashCode(this.getLeitor());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Emprestimo other = (Emprestimo) obj;
        if (this.getIdEmprestimo() != other.getIdEmprestimo()) {
            return false;
        }
        if (!Objects.equals(this.dataEmprestimo, other.dataEmprestimo)) {
            return false;
        }
//        if (!Objects.equals(this.exemplares, other.exemplares)) {
//            return false;
//        }
        if (!Objects.equals(this.leitor, other.leitor)) {
            return false;
        }
        return true;
    }
    @Id // campo chave primária
    @GeneratedValue // campo auto-incremento
    private short idEmprestimo;
    @Temporal(TemporalType.DATE) // ignora horas e minutos e persiste apenas a data
    private Date dataEmprestimo;

    /*
     * Um emprestimo possui muitos acervos, e um acervo possui 
     * muitos emprestimo, no caso será criada uma nova tabela chamada
     * AcervoEmprestimos, que possuirá a chave primaria de emprestimo
     * e a chave primaria de acervo
     * O CascadaType.ALL quer dizer que ao excluir um emprestimo,
     * todos os itens da tabela acervoemprestimos que façam referência 
     * ao emprestimo excluído será deletado também
     */
//    @OneToMany(fetch= FetchType.EAGER)
//    private Set<ExemplarEmprestimos> exemplares = new HashSet<ExemplarEmprestimos>();
    /*set não aceita valores duplicados, 
     * ou seja um mesmo livro não poderá ser emprestado ao 
     * mesmo emprestimo
     */

    /*um emprestimo tem apenas um leitor
     * a chave estrangeira irá se chamar idLeitor
     */
    @ManyToOne
    @JoinColumn(name = "idLeitor")
    private Leitor leitor;
    
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    /**
     * * @retorna o id do Empréstimo **
     */
    public short getIdEmprestimo() {
        return idEmprestimo;
    }

    /**
     * * @seta o id do Empréstimo **
     */
    public void setIdEmprestimo(short idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    /**
     * * @retorna a Data do Empréstimo **
     */
    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    /**
     * * @seta a Data do Empréstimo **
     */
    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    /**
     * * @retorna a lista de Exemplares **
     */
//    public Set<ExemplarEmprestimos> getExemplares() {
//        return exemplares;
//    }

    /**
     * * @retorna o Leitor **
     */
    public Leitor getLeitor() {
        return leitor;
    }

    /**
     * * @seta o Leitor **
     */
    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }
    private static long serialVersionUID = -326568673743692245L;



    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @param exemplares the exemplares to set
     */
//    public void setExemplares(Set<ExemplarEmprestimos> exemplares) {
//        this.exemplares = exemplares;
//    }
    
    public String toString() {
        return idEmprestimo + " | Dt. Empréstimo: " + dataEmprestimo+
                " | Leitor: "+leitor.getNome();
    }
}