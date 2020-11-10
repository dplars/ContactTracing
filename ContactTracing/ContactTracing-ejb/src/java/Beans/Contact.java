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
@Table(name = "CONTACT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c")
    , @NamedQuery(name = "Contact.findByCid", query = "SELECT c FROM Contact c WHERE c.cid = :cid")
    , @NamedQuery(name = "Contact.findByPersoon1", query = "SELECT c FROM Contact c WHERE c.persoon1 = :persoon1")
    , @NamedQuery(name = "Contact.findByPersoon2", query = "SELECT c FROM Contact c WHERE c.persoon2 = :persoon2")
    , @NamedQuery(name = "Contact.findByType", query = "SELECT c FROM Contact c WHERE c.type = :type")
    , @NamedQuery(name = "Contact.laatsteKnr", query = "SELECT max(c.cid) FROM Contact c ")})
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CID")
    private Integer cid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERSOON1")
    private int persoon1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERSOON2")
    private int persoon2;
    @Column(name = "TYPE")
    private Integer type;

    public Contact() {
    }

    public Contact(Integer cid) {
        this.cid = cid;
    }

    public Contact(Integer cid, int persoon1, int persoon2) {
        this.cid = cid;
        this.persoon1 = persoon1;
        this.persoon2 = persoon2;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public int getPersoon1() {
        return persoon1;
    }

    public void setPersoon1(int persoon1) {
        this.persoon1 = persoon1;
    }

    public int getPersoon2() {
        return persoon2;
    }

    public void setPersoon2(int persoon2) {
        this.persoon2 = persoon2;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cid != null ? cid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.cid == null && other.cid != null) || (this.cid != null && !this.cid.equals(other.cid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Beans.Contact[ cid=" + cid + " ]";
    }
    
}
