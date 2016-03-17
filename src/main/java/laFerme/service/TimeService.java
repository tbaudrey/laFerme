/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class TimeService {
    
    private GregorianCalendar dateDuJour;

    public GregorianCalendar getDateDuJour() {
        return dateDuJour;
    }

    public void setDateDuJour(GregorianCalendar dateDuJour) {
        this.dateDuJour = dateDuJour;
    }
    
    @Scheduled(fixedDelay = 60000)//Toute les minutes
    public void accelerationTempsDeJeu(){
        dateDuJour.add(Calendar.MONTH, 1/60);//Sont ajouter à la date d'ojd 1/60 eme de mois <==> une heure=1 moi
    }
    
    public long calculJoursRestantAvant(Date date){
        long dateJourEnMili = dateDuJour.getTimeInMillis();
        long dateEnMili = date.getTime();
        
        long diferance = dateJourEnMili - dateEnMili;
        long diferanceEnJours = diferance/86400000;
        return diferanceEnJours;
    }
    
    
    public boolean dateExpiree(Date date, int nbMois){
        GregorianCalendar dateOjd = (GregorianCalendar) dateDuJour.clone();
        dateOjd.add(Calendar.MONTH, -nbMois);
        return dateOjd.after(date);
    }
    
}
