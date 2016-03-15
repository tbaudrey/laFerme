/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tom
 */
@Entity
public class Fermier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 64, unique = true)
    private String name;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    
    @OneToOne(mappedBy = "fermier")
    private Utilisateur utilisateur;
    
    @OneToMany (mappedBy = "fermier")
    private List<Carotte> listCarrotes = new ArrayList<>();
    
    @OneToMany (mappedBy = "fermier")
    private List<Ble> listBles = new ArrayList<>();
    
    @OneToMany (mappedBy = "fermier")
    private List<Chevre> listChevres = new ArrayList<>();

    public Fermier() {
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Carotte> getListCarrotes() {
        return listCarrotes;
    }

    public void setListCarrotes(List<Carotte> listCarrotes) {
        this.listCarrotes = listCarrotes;
    }

    public List<Ble> getListBles() {
        return listBles;
    }

    public void setListBles(List<Ble> listBles) {
        this.listBles = listBles;
    }

    public List<Chevre> getListChevres() {
        return listChevres;
    }

    public void setListChevres(List<Chevre> listChevres) {
        this.listChevres = listChevres;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fermier)) {
            return false;
        }
        Fermier other = (Fermier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "streaming.entity.Effacemoi[ id=" + id + " ]";
    }
    
}