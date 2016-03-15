/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import org.springframework.scheduling.annotation.Scheduled;

/**
 *
 * @author admin
 */
public class TimeService {
    
    @Scheduled(fixedDelay = 2000)// 2 sec entre la FIN du précédenct et début suivant
    public void fixedDelay()throws InterruptedException{
        System.out.println("***** fixedDelay");
    }
    
    @Scheduled(cron = "*/10 **** MON-FRI")//sec min heure jour mois jourDumOIS
    public void cron(){
        System.out.println("********Cron");
    }
    
}
