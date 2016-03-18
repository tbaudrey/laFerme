/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import java.util.GregorianCalendar;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class TempsRestantService {

    public String calculTempsRestantAvant(GregorianCalendar date) {
        GregorianCalendar instantT = new GregorianCalendar();
        long tpsRestants = date.getTime().getTime()- instantT.getTime().getTime() ;
        System.out.println(tpsRestants);
        Integer jours = (int) (tpsRestants / (24 * 3600 * 1000));
        System.out.println("0000000000000000000000000000000");
        System.out.println(jours.toString());
        System.out.println("11111111111111111111111111111111");
        tpsRestants = tpsRestants / (24 * 3600 * 1000) - jours * (24 * 3600 * 1000);
        System.out.println("222222222222222222222222222222");
        System.out.println(tpsRestants);
        System.out.println("333333333333333333333333333333");
        Integer heures = (int) (tpsRestants / (3600 * 1000));
        System.out.println("44444444444444444444444444444444");
        tpsRestants = tpsRestants / (3600 * 1000) - heures * (3600 * 1000);
        Integer minutes = (int) (tpsRestants / (60 * 1000));
        tpsRestants = tpsRestants / (60 * 1000) - minutes * (60 * 1000);
        Integer secondes = (int) (tpsRestants / (1000));
        String dates = ("jours: " + jours.toString() + ", heures: " + heures.toString() + ", minutes: " + minutes.toString() + ", secondes: " + secondes.toString());;
        return (dates);
    }
}
