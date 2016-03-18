/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tom
 */
@Entity
public class Carotte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private GregorianCalendar datePlantation;
    
    @Temporal(TemporalType.TIMESTAMP)
    private GregorianCalendar tpsAvantRecolte;

    public GregorianCalendar getTpsAvantRecolte() {
        return tpsAvantRecolte;
    }

    public void setTpsAvantRecolte(GregorianCalendar tpsAvantRecolte) {
        this.tpsAvantRecolte = tpsAvantRecolte;
    }
    
    private long tempsRestant;//

    public long getTempsRestant() {
        return tempsRestant;
    }

    public void setTempsRestant(long tempsRestant) {
        this.tempsRestant = tempsRestant;
    }
    
    @ManyToOne
    @JoinColumn(name = "FERMIER_ID")
    private Fermier fermier;
    
    public GregorianCalendar getDatePlantation() {
        return datePlantation;
    }

    public void setDatePlantation(GregorianCalendar datePlantation) {
        this.datePlantation = datePlantation;
    }


    public Fermier getFermier() {
        return fermier;
    }

    public void setFermier(Fermier fermier) {
        this.fermier = fermier;
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
        if (!(object instanceof Carotte)) {
            return false;
        }
        Carotte other = (Carotte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "streaming.entity.Carotte[ id=" + id + " ]";
    }
    
}
