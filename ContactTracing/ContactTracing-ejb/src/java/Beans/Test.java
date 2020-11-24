/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dehan
 */
@Entity
@Table(name = "TEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Test.findAll", query = "SELECT t FROM Test t")
    , @NamedQuery(name = "Test.findByTid", query = "SELECT t FROM Test t WHERE t.tid = :tid")
    , @NamedQuery(name = "Test.findByTestresultaat", query = "SELECT t FROM Test t WHERE t.testresultaat = :testresultaat")
    , @NamedQuery(name = "Test.findByPid", query = "SELECT t FROM Test t WHERE t.pid = :pid")
    , @NamedQuery(name = "Test.findAantal", query = "SELECT count(t) FROM Test t")
    , @NamedQuery(name = "Test.findBurgerTests", query = "SELECT t FROM Test t where t.pid = :pid ORDER BY t.tid DESC")
    , @NamedQuery(name = "Test.laatsteTid", query = "SELECT max(t.tid) FROM Test t")})
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TID")
    private Integer tid;
    @Column(name = "TESTRESULTAAT")
    private Integer testresultaat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PID")
    private int pid;

    public Test() {
    }

    public Test(Integer tid) {
        this.tid = tid;
    }

    public Test(Integer tid, int pid) {
        this.tid = tid;
        this.pid = pid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getTestresultaat() {
        return testresultaat;
    }

    public void setTestresultaat(Integer testresultaat) {
        this.testresultaat = testresultaat;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tid != null ? tid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Test)) {
            return false;
        }
        Test other = (Test) object;
        if ((this.tid == null && other.tid != null) || (this.tid != null && !this.tid.equals(other.tid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Beans.Test[ tid=" + tid + " ]";
    }
    
}
