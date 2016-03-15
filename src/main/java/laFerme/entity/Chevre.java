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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tom
 */
@Entity
public class Chevre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 64)
    private String name;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDerniereNutrition;
    
    @ManyToOne
    @JoinColumn(name = "FERMIER_ID")
    private Fermier fermier;
    
    @OneToMany (mappedBy = "chevre")
    private List<Fromage> listFromage = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateDerniereNutrition() {
        return dateDerniereNutrition;
    }

    public void setDateDerniereNutrition(Date dateDerniereNutrition) {
        this.dateDerniereNutrition = dateDerniereNutrition;
    }

    public Fermier getFermier() {
        return fermier;
    }

    public void setFermier(Fermier fermier) {
        this.fermier = fermier;
    }

    public List<Fromage> getListFromage() {
        return listFromage;
    }

    public void setListFromage(List<Fromage> listFromage) {
        this.listFromage = listFromage;
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
        if (!(object instanceof Chevre)) {
            return false;
        }
        Chevre other = (Chevre) object;
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
