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
import laFerme.service.Crud.FermierService;
import laFerme.service.Crud.FromageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
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

    @Autowired
    private FermierService fermierService;

    private List<Chevre> listeChevre = (List<Chevre>) chevreService.findAll();

    public void rafraichirTout(Fermier fermier) {
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
        int bInfProductionBlePlantee = 3;
        int bSupProductionBlePlantee = 4;
        int y = nombreAleatoireService.nombreAleatoire(bInfProductionBlePlantee, bSupProductionBlePlantee);
        // m = 6 mois (semestre) se sont écoulé le blé est supprimer de la DB
        int m = 6;
        //Y Ble sont ajouté à la DB
        GregorianCalendar dateRecolte = new GregorianCalendar();
        for (Ble b : listeBlePlantes) {
            dateRecolte = b.getDatePlantation();
            dateRecolte.add(Calendar.MINUTE, m);
            if (dateRecolte.before(instantT)) {
                bleService.delete(b);
                for (int x = 0; x < y; x++) {
                    Ble ble = new Ble();
                    ble.setFermier(fermier);
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
        int bInfProductionCarottePlantee = 2;
        int bSupProductionCarottePlantee = 3;
        int y = nombreAleatoireService.nombreAleatoire(bInfProductionCarottePlantee, bSupProductionCarottePlantee);
        // m = 6 mois (semestre) se sont écoulé le blé est supprimer de la DB
        int m = 6;
        //Y Ble sont ajouté à la DB
        GregorianCalendar dateRecolte = new GregorianCalendar();
        for (Carotte c : listeCarottePlantes) {
            dateRecolte = c.getDatePlantation();
            dateRecolte.add(Calendar.MINUTE, m);
            if (dateRecolte.before(instantT)) {
                carotteService.delete(c);
                for (int x = 0; x < y; x++) {
                    Carotte carotte = new Carotte();
                    carotte.setFermier(fermier);
                    carotteService.save(carotte);
                }
            }
        }
    }

    public void rafraichirChevre(Fermier fermier) {
        //Gestion des accouchement
        List<Chevre> listeChevreAccouplees = (List<Chevre>) chevreService.findByFermierAndDateAccouplementNotNull(fermier);
        GregorianCalendar instantT = new GregorianCalendar();
        List<Chevre> listeChevreAccouchante = new ArrayList<>();
        int m1 = 12; //Tous les ans une chevre donne 1 chevreau
        for (Chevre c : listeChevreAccouplees) {
            GregorianCalendar dateAccouchement = c.getDateAccouplement();
            dateAccouchement.add(Calendar.MINUTE, m1);
//            dateAccouchement.add(Calendar.SECOND, m1);
            System.out.println(dateAccouchement.getTime());
            System.out.println(instantT.getTime());
            if (dateAccouchement.before(instantT)) {
                System.out.println("?????**************************?????");
                listeChevreAccouchante.add(c);
                c.setDateAccouplement(null);
                chevreService.save(c);
            }
        }
        int nbrChevreau = (int) (listeChevreAccouchante.size() / 2);
        for (int v = 0; v < nbrChevreau; v++) {
            Chevre chevre = new Chevre();
            chevre.setFermier(fermier);
            chevreService.save(chevre);
        }
        //
        //Gestion de la profuction de fromage
        List<Chevre> listeChevre = (List<Chevre>) chevreService.findAll();
        int m2 = 6; //Tous les 6 mois une chevre donne 2 a 3 fromage
        //Y (chiffre aléatoire entre b_inf et b_sup) Fromage sont ajouté à la DB
        int bInfProductionFromage = 2;
        int bSupProductionFromage = 3;
        int y = nombreAleatoireService.nombreAleatoire(bInfProductionFromage, bInfProductionFromage);
        for (Chevre c : listeChevre) {
            GregorianCalendar dateProductionFromage = c.getDateDebutProductionFromage();
            dateProductionFromage.add(Calendar.MINUTE, m2);
            if (dateProductionFromage.before(instantT)) {
                for (int x = 0; x < y; x++) {
                    Fromage fromage = new Fromage();
                    fromage.setFermier(fermier);
                    fromageService.save(fromage);
                    c.setDateDebutProductionFromage(new GregorianCalendar());
                }
            }
        }
    }

    //Gestion de la mort des chevres
    public String rafraichirMortChevre(Fermier fermier) {
        int m3 = 3;
        int y = 0;
        GregorianCalendar instantT = new GregorianCalendar();
        for (Chevre c : listeChevre) {
            GregorianCalendar DateDerniereNutrition = c.getDateDerniereNutrition();
            DateDerniereNutrition.add(Calendar.MINUTE, m3);
            if (DateDerniereNutrition.before(instantT)) {
                chevreService.delete(c);
                y++;
            }
        }
        if (y == 1) {
            return ("Une de vos chevre est morte de fain !");
        } else if (y > 1) {
            return (y + " de vos chevre sont mortes de fain !");
        } else {
            return ("");
        }
    }

    //Gestion de la mort du fermier
    public String rafraichierMortFermier(Fermier fermier) {
        GregorianCalendar instantT = new GregorianCalendar();
        int m4 = 3;
        GregorianCalendar DateDerniereNutrition = fermier.getDateDerniereNutrition();
        DateDerniereNutrition.add(Calendar.MINUTE, m4);
        if (DateDerniereNutrition.before(instantT)) {
            fermierService.delete(fermier);
            return ("La partie est fini !! Vous n'avez pas nouri votre fermier ! Il est mort de fain");
        } else {
            return ("");
        }
    }
}
