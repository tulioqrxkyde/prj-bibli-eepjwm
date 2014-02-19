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
package fvsosp.multa;

import fvsosp.exemplaremprestimos.ExemplarEmprestimos;
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

/**
 *
 * @author Pedro Saraiva
 */
@Entity
@Table(name="multa")
public class Multa {
    
    
    @Id
    @GeneratedValue
    private int idMulta;
    
    private double valor;
    
    @ManyToOne
    @JoinColumn(name="exemplaremprestimo")
    private ExemplarEmprestimos exemplarEmprestimo;
    
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
    
    private boolean pago;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.idMulta;
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 43 * hash + Objects.hashCode(this.exemplarEmprestimo);
        hash = 43 * hash + Objects.hashCode(this.dataPagamento);
        hash = 43 * hash + (this.pago ? 1 : 0);
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
        final Multa other = (Multa) obj;
        if (this.idMulta != other.idMulta) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.exemplarEmprestimo, other.exemplarEmprestimo)) {
            return false;
        }
        if (!Objects.equals(this.dataPagamento, other.dataPagamento)) {
            return false;
        }
        if (this.pago != other.pago) {
            return false;
        }
        return true;
    }

    

       

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the exemplarEmprestimo
     */
    public ExemplarEmprestimos getExemplarEmprestimo() {
        return exemplarEmprestimo;
    }

    /**
     * @param exemplarEmprestimo the exemplarEmprestimo to set
     */
    public void setExemplarEmprestimo(ExemplarEmprestimos exemplarEmprestimo) {
        this.exemplarEmprestimo = exemplarEmprestimo;
    }

    /**
     * @return the idMulta
     */
    public int getIdMulta() {
        return idMulta;
    }

    /**
     * @param idMulta the idMulta to set
     */
    public void setIdMulta(int idMulta) {
        this.idMulta = idMulta;
    }

    /**
     * @return the dataPagamento
     */
    public Date getDataPagamento() {
        return dataPagamento;
    }

    /**
     * @param dataPagamento the dataPagamento to set
     */
    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    /**
     * @return the pago
     */
    public boolean isPago() {
        return pago;
    }

    /**
     * @param pago the pago to set
     */
    public void setPago(boolean pago) {
        this.pago = pago;
    }
    
    public String toString(){
        return idMulta+" | Leitor: "+exemplarEmprestimo.getEmprestimo().getLeitor().getNome()+
                " | Exemplar: "+exemplarEmprestimo.getExemplar().getTombo()+" | Acervo: "
                +exemplarEmprestimo.getExemplar().getAcervo().getTituloObra()+" | Valor: "+
                valor+" | Pago: "+pago;
    }
    
    
    
}
