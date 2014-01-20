/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.log;

import fvsosp.usuario.Usuario;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Pedro Saraiva
 */
@Entity
@Table(name="log")
public class Log {
    
    @Id
    @GeneratedValue
    private short idLog;
    
    private String descricao;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date datalog;
    
    @ManyToOne
    private Usuario usuario;

    /**
     * @return the idLog
     */
    public short getIdLog() {
        return idLog;
    }

    /**
     * @param idLog the idLog to set
     */
    public void setIdLog(short idLog) {
        this.idLog = idLog;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the datalog
     */
    public Date getDatalog() {
        return datalog;
    }

    /**
     * @param datalog the datalog to set
     */
    public void setDatalog(Date datalog) {
        this.datalog = datalog;
    }

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.idLog;
        hash = 67 * hash + Objects.hashCode(this.descricao);
        hash = 67 * hash + Objects.hashCode(this.datalog);
        hash = 67 * hash + Objects.hashCode(this.usuario);
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
        final Log other = (Log) obj;
        if (this.idLog != other.idLog) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.datalog, other.datalog)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
}
