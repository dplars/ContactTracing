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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dehan
 */
@Entity
@Table(name = "test")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Test.findAll", query = "SELECT t FROM Test t")
    , @NamedQuery(name = "Test.findByTid", query = "SELECT t FROM Test t WHERE t.tid = :tid")
    , @NamedQuery(name = "Test.findByTestresultaat", query = "SELECT t FROM Test t WHERE t.testresultaat = :testresultaat")
    , @NamedQuery(name = "Test.findAantal", query = "SELECT count(t) FROM Test t")})
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tid")
    private Integer tid;
    @Column(name = "testresultaat")
    private Integer testresultaat;
    @Column(name = "pid")
    private Integer pid;

    public Test() {
    }

    public Test(Integer tid) {
        this.tid = tid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }
    
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getTestresultaat() {
        return testresultaat;
    }

    public void setTestresultaat(Integer testresultaat) {
        this.testresultaat = testresultaat;
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
