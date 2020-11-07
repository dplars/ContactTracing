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
@Table(name = "arts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arts.findAll", query = "SELECT a FROM Arts a")
    , @NamedQuery(name = "Arts.findByAid", query = "SELECT a FROM Arts a WHERE a.aid = :aid")
    , @NamedQuery(name = "Arts.findByNaam", query = "SELECT a FROM Arts a WHERE a.naam = :naam")})
public class Arts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aid")
    private Integer aid;
    @Column(name = "naam")
    private Integer naam;

    public Arts() {
    }

    public Arts(Integer aid) {
        this.aid = aid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getNaam() {
        return naam;
    }

    public void setNaam(Integer naam) {
        this.naam = naam;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aid != null ? aid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arts)) {
            return false;
        }
        Arts other = (Arts) object;
        if ((this.aid == null && other.aid != null) || (this.aid != null && !this.aid.equals(other.aid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Beans.Arts[ aid=" + aid + " ]";
    }
    
}
