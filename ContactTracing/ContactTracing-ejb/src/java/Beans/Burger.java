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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dehan
 */
@Entity
@Table(name = "BURGER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Burger.findAll", query = "SELECT b FROM Burger b")
    , @NamedQuery(name = "Burger.findByBid", query = "SELECT b FROM Burger b WHERE b.bid = :bid")
    , @NamedQuery(name = "Burger.findByNaam", query = "SELECT b FROM Burger b WHERE b.naam = :naam")
    , @NamedQuery(name = "Burger.findByScore", query = "SELECT b FROM Burger b WHERE b.score = :score")
    , @NamedQuery(name = "Burger.findByTelefoonnummer", query = "SELECT b FROM Burger b WHERE b.telefoonnummer = :telefoonnummer")
    , @NamedQuery(name = "Burger.findScoreByBid", query = "SELECT b.score FROM Burger b WHERE b.bid = :bid")
    , @NamedQuery(name = "Burger.findSortedBid", query = "SELECT b.bid FROM Burger b ORDER BY b.naam")    
    , @NamedQuery(name = "Burger.findAllNaam", query = "SELECT b.naam FROM Burger b ORDER BY b.naam")
    , @NamedQuery(name = "Burger.findAllTele", query = "SELECT b.telefoonnummer FROM Burger b ORDER BY b.naam")
    , @NamedQuery(name = "Burger.findAantal", query = "SELECT count(b) FROM Burger b")})
public class Burger implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BID")
    private Integer bid;
    @Size(max = 22)
    @Column(name = "NAAM")
    private String naam;
    @Column(name = "SCORE")
    private Integer score;
    @Size(max = 22)
    @Column(name = "TELEFOONNUMMER")
    private String telefoonnummer;

    public Burger() {
    }

    public Burger(Integer bid) {
        this.bid = bid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bid != null ? bid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Burger)) {
            return false;
        }
        Burger other = (Burger) object;
        if ((this.bid == null && other.bid != null) || (this.bid != null && !this.bid.equals(other.bid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Beans.Burger[ bid=" + bid + " ]";
    }
    
}
