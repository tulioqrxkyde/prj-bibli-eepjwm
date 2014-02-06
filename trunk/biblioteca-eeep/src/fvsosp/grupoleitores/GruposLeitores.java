package fvsosp.grupoleitores;

import fvsosp.acervo.Acervo;
import fvsosp.leitor.Leitor;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NaturalId;

@Entity
@Table (name="gruposleitores")
public class GruposLeitores implements Serializable, Comparable<GruposLeitores>{

    @Override
    public int compareTo(GruposLeitores o) {
        return descricao.compareTo(o.descricao);            
    }
    
    @Id
    @GeneratedValue
    private short idGruposLeitores;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idGruposLeitores;
        hash = 41 * hash + Objects.hashCode(this.descricao);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.valorMultaDiaria) ^ (Double.doubleToLongBits(this.valorMultaDiaria) >>> 32));
        hash = 41 * hash + this.quantMaxLivros;
        hash = 41 * hash + this.duracaoDiasEmprestimo;
        //hash = 41 * hash + Objects.hashCode(this.leitores);
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
        final GruposLeitores other = (GruposLeitores) obj;
        if (this.idGruposLeitores != other.idGruposLeitores) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorMultaDiaria) != Double.doubleToLongBits(other.valorMultaDiaria)) {
            return false;
        }
        if (this.quantMaxLivros != other.quantMaxLivros) {
            return false;
        }
        if (this.duracaoDiasEmprestimo != other.duracaoDiasEmprestimo) {
            return false;
        }
//        if (!Objects.equals(this.leitores, other.leitores)) {
//            return false;
//        }
        return true;
    }
   
    @Column(length = 40, nullable = false)
    @NaturalId(mutable=true)
    private String descricao;
    
    @Column(length = 2, nullable = false)
    private double valorMultaDiaria;
    
    @Column(length = 2, nullable = false)
    private byte quantMaxLivros;
    
    @Column(length = 2, nullable = false)
    private byte duracaoDiasEmprestimo;
    
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "gruposLeitores")
//    private List<Leitor> leitores;

    public short getIdGruposLeitores() {
        return idGruposLeitores;
    }
    
    public void setIdGruposLeitores(short idGruposLeitores) {
        this.idGruposLeitores = idGruposLeitores;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorMultaDiaria() {
        return valorMultaDiaria;
    }

    public void setValorMultaDiaria(double valorMultaDiaria) {
        this.valorMultaDiaria = valorMultaDiaria;
    }

    public byte getQuantMaxLivros() {
        return quantMaxLivros;
    }

    public void setQuantMaxLivros(byte quantMaxLivros) {
        this.quantMaxLivros = quantMaxLivros;
    }

    public byte getDuracaoDiasEmprestimo() {
        return duracaoDiasEmprestimo;
    }

    public void setDuracaoDiasEmprestimo(byte duracaoDiasEmprestimo) {
        this.duracaoDiasEmprestimo = duracaoDiasEmprestimo;
    }

//    public List<Leitor> getLeitores() {
//        return leitores;
//    }
//
//    public void setLeitores(List<Leitor> leitores) {
//        this.leitores = leitores;
//    }
    private static final long serialVersionUID = -3510357413546466120L;  
    
    public String toString(){
        return descricao+", Q.Dias: "+duracaoDiasEmprestimo+", Q.Livros: "+quantMaxLivros;
    }
}
