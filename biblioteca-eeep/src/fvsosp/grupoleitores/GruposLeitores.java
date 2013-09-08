package fvsosp.grupoleitores;

import fvsosp.acervo.Acervo;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table (name="gruposleitores")
public class GruposLeitores implements Serializable{

    @Id
    private int idGruposLeitores;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idGruposLeitores;
        hash = 41 * hash + Objects.hashCode(this.descricao);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.valorMultaDiaria) ^ (Double.doubleToLongBits(this.valorMultaDiaria) >>> 32));
        hash = 41 * hash + this.quantMaxLivros;
        hash = 41 * hash + this.duracaoDiasEmprestimo;
        hash = 41 * hash + Objects.hashCode(this.acervos);
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
        if (!Objects.equals(this.acervos, other.acervos)) {
            return false;
        }
        return true;
    }
   
    @Column(length = 40, nullable = false, columnDefinition = "Varchar(40) default ''")
    private String descricao;
    
    @Column(length = 20, nullable = false, columnDefinition = "Varchar(20) default ''")
    private double valorMultaDiaria;
    
    @Column(length = 50, nullable = false, columnDefinition = "Varchar(50) default ''")
    private int quantMaxLivros;
    
    @Column(length = 30, nullable = false, columnDefinition = "Varchar(30) default ''")
    private int duracaoDiasEmprestimo;
    
    @OneToMany(mappedBy = "idLeitor")
    private List <Acervo> acervos;

    public int getIdGruposLeitores() {
        return idGruposLeitores;
    }
    
    public void setIdGruposLeitores(int idGruposLeitores) {
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

    public int getQuantMaxLivros() {
        return quantMaxLivros;
    }

    public void setQuantMaxLivros(int quantMaxLivros) {
        this.quantMaxLivros = quantMaxLivros;
    }

    public int getDuracaoDiasEmprestimo() {
        return duracaoDiasEmprestimo;
    }

    public void setDuracaoDiasEmprestimo(int duracaoDiasEmprestimo) {
        this.duracaoDiasEmprestimo = duracaoDiasEmprestimo;
    }

    public List<Acervo> getAcervos() {
        return acervos;
    }

    public void setAcervos(List<Acervo> acervos) {
        this.acervos = acervos;
    }
    private static final long serialVersionUID = -3510357413546466120L;    
}
