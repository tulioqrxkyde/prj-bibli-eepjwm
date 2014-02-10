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
package fvsosp.exemplaremprestimos;

import fvsosp.emprestimo.Emprestimo;
import fvsosp.exemplar.Exemplar;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CollectionId;

/**
 *
 * @author Pedro Saraiva
 */
@Entity
@Table(name="exemplaremprestimos")
public class ExemplarEmprestimos implements Serializable , Comparable<ExemplarEmprestimos> {
    
    /**
     * Método sobrescrito.
     *
     * @return String contendo o id e tombo do Emprestimo, número do exemplar, Título da obra e o tipo da operação.
     */
    @Override
    public String toString() {
        return idExemplarEmprestimos+" | Tombo: "+getExemplar().getTombo()+" | Nº exemplar =" + 
                getExemplar().getExemplar()+
                " | Acervo: "+getExemplar().getAcervo().getTituloObra()+
                " | Operação: "+descricaoOperacao()
                ;
    }
    
    /**
     * Método sobrescrito.
     *
     * @param o objeto a ser acessado através da Composição.
     * @return inteiro negativo, zero ou um inteiro positivo.
     */
    @Override
    public int compareTo(ExemplarEmprestimos o) {
        Short exemplar2 = getIdExemplarEmprestimos();;
        Short exemplarO2 = o.getIdExemplarEmprestimos();
        return exemplar2.compareTo(exemplarO2);            
    }
    
    @Id
    @GeneratedValue
    private short idExemplarEmprestimos;
    
    @ManyToOne
    @JoinColumn(name="idEmprestimo")
    private Emprestimo emprestimo;
    
    @ManyToOne
    @JoinColumn(name="idExemplar")
    private Exemplar exemplar;
    @Temporal(TemporalType.DATE)
    private Date dataEmprestimo;
    @Temporal(TemporalType.DATE)
    private Date dataDevolucao;
    @Temporal(TemporalType.DATE)
    private Date dataPrevistaDevolucao;

    /**
     * Método sobrescrito.
     *
     * @return um inteiro(hash) contendo o valor total do cálculo de todos os
     * hashCodes dos Atributos contidos na Classe.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idExemplarEmprestimos;
        hash = 97 * hash + Objects.hashCode(this.emprestimo);
        hash = 97 * hash + Objects.hashCode(this.exemplar);
        hash = 97 * hash + Objects.hashCode(this.dataEmprestimo);
        hash = 97 * hash + Objects.hashCode(this.dataDevolucao);
        hash = 97 * hash + Objects.hashCode(this.dataPrevistaDevolucao);
        hash = 97 * hash + this.operacao;
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
        final ExemplarEmprestimos other = (ExemplarEmprestimos) obj;
        if (this.idExemplarEmprestimos != other.idExemplarEmprestimos) {
            return false;
        }
        if (!Objects.equals(this.emprestimo, other.emprestimo)) {
            return false;
        }
        if (!Objects.equals(this.exemplar, other.exemplar)) {
            return false;
        }
        if (!Objects.equals(this.dataEmprestimo, other.dataEmprestimo)) {
            return false;
        }
        if (!Objects.equals(this.dataDevolucao, other.dataDevolucao)) {
            return false;
        }
        if (!Objects.equals(this.dataPrevistaDevolucao, other.dataPrevistaDevolucao)) {
            return false;
        }
        if (this.operacao != other.operacao) {
            return false;
        }
        return true;
    }

    
    
    
    /*
     * Metodo sobrescrito.
     * 
     * 1 - Emprestado
     * 2 - Devolvido
     * 3 - Renovado
     * 
     * @return String
     */
    private int operacao;
    
    public String descricaoOperacao(){
        if(getOperacao()==1){
            return "Emprestado";
        } else if (getOperacao()==2){
            return "Devolvido";
        } else if(getOperacao()==3){
            return "Renovado";
        }
        return "";
    }

    /**
     * @return short idExemplarEmprestimos
     */
    public short getIdExemplarEmprestimos() {
        return idExemplarEmprestimos;
    }

    /**
     * @param idExemplarEmprestimos short
     */
    public void setIdExemplarEmprestimos(short idExemplarEmprestimos) {
        this.idExemplarEmprestimos = idExemplarEmprestimos;
    }

    /**
     * @return Emprestimo emprestimo
     */
    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    /**
     * @param emprestimo Emprestimo
     */
    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    /**
     * @return Exemplar exemplar
     */
    public Exemplar getExemplar() {
        return exemplar;
    }

    /**
     * @param exemplar Exemplar
     */
    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    /**
     * @return int operacao
     */
    public int getOperacao() {
        return operacao;
    }

    /**
     * @param operacao int
     */
    public void setOperacao(int operacao) {
        this.operacao = operacao;
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
     * @return Date dataDevolucao
     */
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * @param dataDevolucao Date
     */
    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    /**
     * @return Date dataPrevistaDevolucao
     */
    public Date getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    /**
     * @param dataPrevistaDevolucao Date
     */
    public void setDataPrevistaDevolucao(Date dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }
    
    
    
}
