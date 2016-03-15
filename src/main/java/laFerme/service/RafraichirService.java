/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import laFerme.entity.Ble;
import laFerme.entity.Carotte;
import laFerme.entity.Chevre;
import laFerme.entity.Fermier;
import laFerme.entity.Fromage;
import laFerme.service.Crud.BleService;
import laFerme.service.Crud.CarotteService;
import laFerme.service.Crud.ChevreService;
import laFerme.service.Crud.FromageService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
public class RafraichirService {

    @Autowired
    private BleService bleService;

    @Autowired
    private CarotteService carotteService;

    @Autowired
    private ChevreService chevreService;

    @Autowired
    private FromageService fromageService;

    @Autowired
    private NombreAleatoireService nombreAleatoireService;

    public void RafraichirBle(Fermier fermier) {
        List<Ble> listeBleRafraichie = new ArrayList<>();
        listeBleRafraichie = (List<Ble>) bleService.findByFermier(fermier);
        Date instantT = new Date();
        // 6 mois = 6 heures
        Date semestre = new Date(0, 0, 0, 6, 0);
        //Y (chiffre aléatoire entre b_inf et b_sup) blé sont ajouté à la DB
        int b_inf = 2;
        int b_sup = 3;
        int y = nombreAleatoireService.NombreAleatoire(b_inf, b_sup);
        System.out.println(y);
        //Si le blé a été planté, il a une date de plantation, 
        //si 6 mois (semestre) se sont écoulé le blé est supprimer de la DB,
        //Y Ble sont ajouté à la DB
        for (Ble b : listeBleRafraichie) {
            if (!b.getDatePlantation().equals(null)) {
                if (instantT.getTime() - b.getDatePlantation().getTime() > semestre.getTime()) {
                    bleService.delete(b);
                    for (int x = 0; x < y; x++) {
                        Ble ble = new Ble();
                        bleService.save(ble);
                    }
                }
            }
        }
    }

    public void RafraichirCarotte(Fermier fermier) {
        List<Carotte> listeCarotteRafraichie = new ArrayList<>();
        listeCarotteRafraichie = (List<Carotte>) carotteService.findByFermier(fermier);
        Date instantT = new Date();
        // 6 mois = 6 heures
        Date semestre = new Date(0, 0, 0, 6, 0);
        //Y (chiffre aléatoire entre b_inf et b_sup) Carotte sont ajouté à la DB
        int b_inf = 3;
        int b_sup = 4;
        int y = nombreAleatoireService.NombreAleatoire(b_inf, b_sup);
        //Si la Carotte a été planté, il a une date de plantation, 
        //si 6 mois (semestre) se sont écoulé la Carotte est supprimer de la DB, 
        //Y Carotte sont ajouté à la DB
        for (Carotte c : listeCarotteRafraichie) {
            if (!c.getDatePlantation().equals(null)) {
                if (instantT.getTime() - c.getDatePlantation().getTime() > semestre.getTime()) {
                    carotteService.delete(c);
                    for (int x = 0; x < y; x++) {
                        Carotte carotte = new Carotte();
                        carotteService.save(carotte);
                    }
                }
            }
        }
    }

    public void RafraichirChevre(Fermier fermier) {
        List<Chevre> listeChevreRafraichie = new ArrayList<>();
        listeChevreRafraichie = (List<Chevre>) chevreService.findByFermierOrderByDateCreation(fermier);
        Date instantT = new Date();
        // 1 ans = 12 heures
        Date semestre = new Date(0, 0, 0, 12, 0);
        // 3 mois = 3 heures
        Date trimestre = new Date(0, 0, 0, 3, 0);
        //Y (chiffre aléatoire entre b_inf et b_sup) Fromage sont ajouté à la DB
        int b_inf = 2;
        int b_sup = 3;
        int y = nombreAleatoireService.NombreAleatoire(b_inf, b_sup);
        List<Chevre> listeChevreAccouchante = new ArrayList<>();
        for (Chevre c : listeChevreRafraichie) {
            if (instantT.getTime() - c.getDateCreation().getTime() > semestre.getTime()) {
                for (int x = 0; x < y; x++) {
                    Fromage fromage = new Fromage();
                    fromageService.save(fromage);
                }
            }
            if (instantT.getTime() - c.getDateCreation().getTime() > trimestre.getTime()) {
                listeChevreAccouchante.add(c);
            }
        }
        int w =(int) listeChevreAccouchante.size()/2;
        for (int z=0 ;z<w;z++){
            Chevre c = new Chevre();
            chevreService.save(c);
        }
    }
}

