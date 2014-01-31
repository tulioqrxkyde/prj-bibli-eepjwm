package fvsosp.leitor;

import fvsosp.acervo.Acervo;
import fvsosp.cidade.Cidade;
import fvsosp.emprestimo.Emprestimo;
import fvsosp.grupoleitores.GruposLeitores;
import fvsosp.util.Util;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="leitor")
public class Leitor implements Serializable, Comparable<Leitor>{

    @Override
    public int compareTo(Leitor o) {
        return nome.compareTo(o.nome);            
    }
    
    @Override
    public String toString(){
        return idLeitor+" | "+nome;
    }

    @Id
    @GeneratedValue
    private short idLeitor;
    
    @Column(nullable=false, length=100)
    @NaturalId(mutable=true)
    private String nome;
    
    @Column(length=70)
    private String email;
    
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    
    @Column(length=1)
    private char sexo;
    
    @Column(length=20)
    private String telefone;
    
    @Column(length=20)
    private String celular;
    
    @Column(length=50, nullable=false)
    @NaturalId(mutable=true)
    private String matricula;
    
    @Column(columnDefinition="boolean default 1")
    private boolean ativo;
    
    @Column(length = 50)
    private String observacoes;
    
    @Column(length = 70)
    private String endereco;
    
    @Column(length=50)
    private String bairro;
    
    @Column(length=10)
    private String cep;
    
    @Column(length=100)
    private String nomePai;
    
    @Column(length=100)
    private String nomeMae;
    
    @Column(length=8)
    private String rg;
    
    @NaturalId(mutable=true)
    @Column(length=11)
    private String cpf;
    
    @ManyToOne
    @JoinColumn(name="idgrupoleitores")
    private GruposLeitores gruposLeitores;
    
    @ManyToOne
    @JoinColumn(name="idcidade")
    private Cidade cidade;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy="leitor")
    private List<Emprestimo> emprestimos;

    /**
     * @return the idLeitor
     */
    public short getIdLeitor() {
        return idLeitor;
    }

    /**
     * @param idLeitor the idLeitor to set
     */
    public void setIdLeitor(short idLeitor) {
        this.idLeitor = idLeitor;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the dataNascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the dataCadastro
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the ativo
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the observacoes
     */
    public String getObservacoes() {
        return observacoes;
    }

    /**
     * @param observacoes the observacoes to set
     */
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the nomePai
     */
    public String getNomePai() {
        return nomePai;
    }

    /**
     * @param nomePai the nomePai to set
     */
    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    /**
     * @return the nomeMae
     */
    public String getNomeMae() {
        return nomeMae;
    }

    /**
     * @param nomeMae the nomeMae to set
     */
    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        if(Util.CPF(cpf)){
        this.cpf = cpf;
        }
    }

    /**
     * @return the gruposLeitores
     */
    public GruposLeitores getGruposLeitores() {
        return gruposLeitores;
    }

    /**
     * @param gruposLeitores the gruposLeitores to set
     */
    public void setGruposLeitores(GruposLeitores gruposLeitores) {
        this.gruposLeitores = gruposLeitores;
    }

    /**
     * @return the cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the emprestimos
     */
    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    /**
     * @param emprestimos the emprestimos to set
     */
    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
    private static final long serialVersionUID = -9050110991870108319L;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idLeitor;
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.email);
        hash = 89 * hash + Objects.hashCode(this.dataNascimento);
        hash = 89 * hash + Objects.hashCode(this.dataCadastro);
        hash = 89 * hash + this.sexo;
        hash = 89 * hash + Objects.hashCode(this.telefone);
        hash = 89 * hash + Objects.hashCode(this.celular);
        hash = 89 * hash + Objects.hashCode(this.matricula);
        hash = 89 * hash + (this.ativo ? 1 : 0);
        hash = 89 * hash + Objects.hashCode(this.observacoes);
        hash = 89 * hash + Objects.hashCode(this.endereco);
        hash = 89 * hash + Objects.hashCode(this.bairro);
        hash = 89 * hash + Objects.hashCode(this.cep);
        hash = 89 * hash + Objects.hashCode(this.nomePai);
        hash = 89 * hash + Objects.hashCode(this.nomeMae);
        hash = 89 * hash + Objects.hashCode(this.rg);
        hash = 89 * hash + Objects.hashCode(this.cpf);
        hash = 89 * hash + Objects.hashCode(this.gruposLeitores);
        hash = 89 * hash + Objects.hashCode(this.cidade);
        hash = 89 * hash + Objects.hashCode(this.emprestimos);
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
        final Leitor other = (Leitor) obj;
        if (this.idLeitor != other.idLeitor) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        if (!Objects.equals(this.dataCadastro, other.dataCadastro)) {
            return false;
        }
        if (this.sexo != other.sexo) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.celular, other.celular)) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        if (!Objects.equals(this.observacoes, other.observacoes)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        if (!Objects.equals(this.nomePai, other.nomePai)) {
            return false;
        }
        if (!Objects.equals(this.nomeMae, other.nomeMae)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.emprestimos, other.emprestimos)) {
            return false;
        }
        return true;
    }
    
    
    
}
