/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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

    
    @Temporal(TemporalType.TIMESTAMP)
    private GregorianCalendar dateDebutProductionFromage;
    
    @Temporal(TemporalType.TIMESTAMP)
    private GregorianCalendar dateProductionFromage;
    
    @Temporal(TemporalType.TIMESTAMP)
    private GregorianCalendar dateDerniereNutrition;
    
    @Temporal(TemporalType.TIMESTAMP)
    private GregorianCalendar dateAccouplement;
    
    @Temporal(TemporalType.TIMESTAMP)
    private GregorianCalendar dateNaissanceChevreau;
    
    @Temporal(TemporalType.TIMESTAMP)
    private GregorianCalendar dateAvantMortChevre;
    
    @ManyToOne
    @JoinColumn(name = "FERMIER_ID")
    private Fermier fermier;


    public Chevre() {
        this.dateDerniereNutrition= new GregorianCalendar();
        this.dateDebutProductionFromage = new GregorianCalendar();
    }

    public GregorianCalendar getDateProductionFromage() {
        return dateProductionFromage;
    }

    public void setDateProductionFromage(GregorianCalendar dateProductionFromage) {
        this.dateProductionFromage = dateProductionFromage;
    }

    public GregorianCalendar getDateAvantMortChevre() {
        return dateAvantMortChevre;
    }

    public void setDateAvantMortChevre(GregorianCalendar dateAvantMortChevre) {
        this.dateAvantMortChevre = dateAvantMortChevre;
    }

    public GregorianCalendar getDateNaissanceChevreau() {
        return dateNaissanceChevreau;
    }

    public void setDateNaissanceChevreau(GregorianCalendar dateNaissanceChevreau) {
        this.dateNaissanceChevreau = dateNaissanceChevreau;
    }

    public GregorianCalendar getDateDerniereNutrition() {
        return dateDerniereNutrition;
    }

    public void setDateDerniereNutrition(GregorianCalendar dateDerniereNutrition) {
        this.dateDerniereNutrition = dateDerniereNutrition;
    }

    public Fermier getFermier() {
        return fermier;
    }

    public void setFermier(Fermier fermier) {
        this.fermier = fermier;
    }

    public GregorianCalendar getDateDebutProductionFromage() {
        return dateDebutProductionFromage;
    }

    public void setDateDebutProductionFromage(GregorianCalendar dateDebutProductionFromage) {
        this.dateDebutProductionFromage = dateDebutProductionFromage;
    }

    public GregorianCalendar getDateAccouplement() {
        return dateAccouplement;
    }

    public void setDateAccouplement(GregorianCalendar dateAccouplement) {
        this.dateAccouplement = dateAccouplement;
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
        return "[ id=" + id + " ]";
    }
    
}
