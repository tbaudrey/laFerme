/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

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
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class NourirService2 {

    @Autowired
    private BleService bleService;

    @Autowired
    private CarotteService carotteService;

    @Autowired
    private ChevreService chevreService;

    @Autowired
    private FromageService fromageService;

    @Autowired
    private ConfigService configService;

    public String nourirFermier(String ressourcePrNourir, Fermier fermier) {

        switch (ressourcePrNourir) {
            case "Ble":
                int QteBle = configService.getNbrBleNourirFermier();
                List<Ble> listeBle = bleService.findByFermierAndDatePlantationNull(fermier);
                if (listeBle.size() >= QteBle) {
                    for (int x = 0; x < QteBle; x++) {
                        bleService.delete(listeBle.get(0));
                        fermier.setDateDerniereNutrition(new GregorianCalendar());
                        return ("Le fermier a bien ete nourie");
                    }
                } else {
                    return ("Impossible de nourir le Fermier. La quantite de ble en stock n'est pas suffisante !");
                }
            case "Carotte":
                int QteCarotte = configService.getNbrCarotteNourirFermier();
                List<Carotte> listeCarotte = carotteService.findByFermierAndDatePlantationNull(fermier);
                if (listeCarotte.size() >= QteCarotte) {
                    for (int x = 0; x < QteCarotte; x++) {
                        carotteService.delete(listeCarotte.get(0));
                        fermier.setDateDerniereNutrition(new GregorianCalendar());
                        return ("Le fermier a bien ete nourie");
                    }
                } else {
                    return ("Impossible de nourir le Fermier. La quantite de carotte en stock n'est pas suffisante !");
                }

            case "Chevre":
                int QteChevre = configService.getNbrChevreNourirFermier();
                List<Chevre> listeChevre = (List<Chevre>) chevreService.findAll();
                if (listeChevre.size() >= QteChevre) {
                    for (int x = 0; x < QteChevre; x++) {
                        chevreService.delete(listeChevre.get(0));
                        fermier.setDateDerniereNutrition(new GregorianCalendar());
                        return ("Le fermier a bien ete nourie");
                    }
                } else {
                    return ("Impossible de nourir le Fermier. La quantite de chevre en stock n'est pas suffisante !");
                }

            case "Fromage":
                int QteFromage = configService.getNbrFromageNourirFermier();
                List<Fromage> listeFromage = (List<Fromage>) fromageService.findAll();
                if (listeFromage.size() >= QteFromage) {
                    for (int x = 0; x < QteFromage; x++) {
                        fromageService.delete(listeFromage.get(0));
                        fermier.setDateDerniereNutrition(new GregorianCalendar());
                        return ("Le fermier a bien ete nourie");
                    }
                } else {
                    return ("Impossible de nourir le Fermier. La quantite de chevre en stock n'est pas suffisante !");
                }
            default:
                return ("Impossible de nourir le Fermier. La ressource a manger n'est pas bien renseigne !");
        }
    }

    public String nourirChevre(String ressourcePrNourir, Chevre chevre, Fermier fermier) {
        int QteBle = configService.getNbrBleNourirChevre();
        List<Ble> listeBle = bleService.findByFermierAndDatePlantationNull(fermier);
        if (listeBle.size() >= QteBle) {
            for (int x = 0; x < QteBle; x++) {
                bleService.delete(listeBle.get(0));
                fermier.setDateDerniereNutrition(new GregorianCalendar());
                return ("La chevre a bien ete nourie");
            }
        } else {
            return ("Impossible de nourir le Fermier. La quantite de ble en stock n'est pas suffisante !");
        }
        return("");
    }
}
