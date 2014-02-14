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
package fvsosp.emprestimo;

import fvsosp.leitor.Leitor;
import fvsosp.usuario.Usuario;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author adrianolima
 */
@Entity
@Table(name = "emprestimo")
public class Emprestimo implements Serializable {

    /**
     * Método sobrescrito.
     *
     * @return um inteiro(hash) contendo o valor total do cálculo de todos os
     * hashCodes dos Atributos contidos na Classe.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.getIdEmprestimo();
        hash = 53 * hash + Objects.hashCode(this.getDataEmprestimo());
        //hash = 53 * hash + Objects.hashCode(this.getExemplares());
        hash = 53 * hash + Objects.hashCode(this.getLeitor());
        return hash;
    }

    /**
     * Método sobrescrito.
     *
     * @param obj objeto a ser acessado através da Composição.
     * @return booleano (true|false).
     */
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
     * @OneToMany(fetch= FetchType.EAGER)
     * private Set<ExemplarEmprestimos> exemplares = new HashSet<ExemplarEmprestimos>();
     * set não aceita valores duplicados, 
     * ou seja um mesmo livro não poderá ser emprestado ao 
     * mesmo emprestimo
     um emprestimo tem apenas um leitor
     * a chave estrangeira irá se chamar idLeitor
     */
    @ManyToOne
    @JoinColumn(name = "idLeitor")
    private Leitor leitor;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    /**
     * @return short idEmprestimo
     */
    public short getIdEmprestimo() {
        return idEmprestimo;
    }

    /**
     * @param idEmprestimo short
     */
    public void setIdEmprestimo(short idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    /**
     * @return Date dataEmprestimo
     */
    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    /**
     * @param dataEmprestimo Date
     */
    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    /**
     * @return Leitor leitor
     */
    public Leitor getLeitor() {
        return leitor;
    }

    /**
     * @param leitor Leitor
     */
    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }
    private static final long serialVersionUID = -326568673743692245L;

    /**
     * @return Usuario usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario Usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Método sobrescrito.
     *
     * @return String contendo a Data do Empréstimo e o nome do Leitor.
     */
    @Override
    public String toString() {
        return "Dt. Empréstimo: " + dataEmprestimo
                + " | Leitor: " + leitor.getNome();
    }
}