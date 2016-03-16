/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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

    public void rafraichirTout(Fermier fermier){
        this.rafraichirBle(fermier);
        this.rafraichirCarotte(fermier);
        this.rafraichirChevre(fermier);
    }
    
    public void rafraichirBle(Fermier fermier) {
        List<Ble> listeBlePlantes = new ArrayList<>();
        //Si le blé a été planté, il a une date de plantation,
        listeBlePlantes = (List<Ble>) bleService.findByFermierAndDatePlantationNotNull(fermier);
        GregorianCalendar instantT = new GregorianCalendar();
        //Y (chiffre aléatoire entre b_inf et b_sup)
        int b_inf = 3;
        int b_sup = 4;
        int y = nombreAleatoireService.nombreAleatoire(b_inf, b_sup);
        // m = 6 mois (semestre) se sont écoulé le blé est supprimer de la DB
        int m = 6;
        //Y Ble sont ajouté à la DB
        GregorianCalendar dateRecolte = new GregorianCalendar();
        for (Ble b : listeBlePlantes) {
            dateRecolte = b.getDatePlantation();
            dateRecolte.add(Calendar.MONTH, m);
            if (dateRecolte.after(instantT)) {
                bleService.delete(b);
                for (int x = 0; x < y; x++) {
                    Ble ble = new Ble();
                    bleService.save(ble);
                }
            }
        }
    }

    public void rafraichirCarotte(Fermier fermier) {
        List<Carotte> listeCarottePlantes = new ArrayList<>();
        //Si le blé a été planté, il a une date de plantation,
        listeCarottePlantes = (List<Carotte>) carotteService.findByFermierAndDatePlantationNotNull(fermier);
        GregorianCalendar instantT = new GregorianCalendar();
        //Y (chiffre aléatoire entre b_inf et b_sup)
        int b_inf = 2;
        int b_sup = 3;
        int y = nombreAleatoireService.nombreAleatoire(b_inf, b_sup);
        // m = 6 mois (semestre) se sont écoulé le blé est supprimer de la DB
        int m = 6;
        //Y Ble sont ajouté à la DB
        GregorianCalendar dateRecolte = new GregorianCalendar();
        for (Carotte c : listeCarottePlantes) {
            dateRecolte = c.getDatePlantation();
            dateRecolte.add(Calendar.MONTH, m);
            if (dateRecolte.after(instantT)) {
                carotteService.delete(c);
                for (int x = 0; x < y; x++) {
                    Carotte carotte = new Carotte();
                    carotteService.save(carotte);
                }
            }
        }
    }

    public void rafraichirChevre(Fermier fermier) {
        //
        //Gestion des accouchement
        List<Chevre> listeChevreAccouplees = (List<Chevre>) chevreService.findByFermierAndDateDernierAccouplementNotNull(fermier);
        GregorianCalendar instantT = new GregorianCalendar();
        List<Chevre> listeChevreAccouchante = new ArrayList<>();
        int m1 = 12; //Tous les ans une chevre donne 1 chevreau
        for (Chevre c : listeChevreAccouplees) {
            GregorianCalendar dateAccouchement = c.getDateAccouplement();
            dateAccouchement.add(Calendar.MONTH, m1);
            if (dateAccouchement.after(instantT)) {
                listeChevreAccouchante.add(c);
                c.setDateAccouplement(null);
                chevreService.save(c);
            }
        }
        int nbrChevreau = (int) (listeChevreAccouchante.size() / 2);
        for (int v = 0; v < nbrChevreau; v++) {
            Chevre chevre = new Chevre();
            chevreService.save(chevre);
        }
        //
        //Gestion de la profuction de fromage
        List<Chevre> listeChevre = (List<Chevre>) chevreService.findAll();
        int m2 = 6; //Tous les 6 mois une chevre donne 2 a 3 fromage
        //Y (chiffre aléatoire entre b_inf et b_sup) Fromage sont ajouté à la DB
        int b_inf = 2;
        int b_sup = 3;
        int y = nombreAleatoireService.nombreAleatoire(b_inf, b_sup);
        for (Chevre c : listeChevre) {
            GregorianCalendar dateProductionFromage = c.getDateDebutProductionFromage();
            dateProductionFromage.add(Calendar.MONTH, m2);
            if (dateProductionFromage.after(instantT)) {
                for (int x = 0; x < y; x++) {
                    Fromage fromage = new Fromage();
                    fromageService.save(fromage);
                    c.setDateDebutProductionFromage(new GregorianCalendar());
                }
            }
        }
    }
}
