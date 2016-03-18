/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import java.util.List;
import laFerme.entity.Ble;
import laFerme.entity.Carotte;
import laFerme.entity.Chevre;
import laFerme.entity.Fermier;
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
public class EchangerService {

    @Autowired
    private BleService bleService;

    @Autowired
    private CarotteService carotteService;

    @Autowired
    private ChevreService chevreService;

    @Autowired
    private ConfigService configService;

    public String echangeBle(int qteBleEchange, String ressourceAEchanger, Fermier fermier) {
        List<Ble> listeBle = bleService.findByFermierAndDatePlantationNull(fermier);
        switch (ressourceAEchanger) {

            case "Carotte":
                int valeurBleVSCarotte = configService.getValeurBleVSCarotte();
                if (qteBleEchange < valeurBleVSCarotte) {
                    return ("Echange impossible, la quantite de ble a echnager contre des carottes doit etre superieur a 2 !");
                }
                int qteCarotteEchangee = (int) (qteBleEchange / valeurBleVSCarotte);
                qteBleEchange = ((int) qteBleEchange / valeurBleVSCarotte) * valeurBleVSCarotte;
                for (int x = 0; x < qteBleEchange; x++) {
                    fermier.getListCarrotes().remove(listeBle.get(x));
                    bleService.delete(listeBle.get(x));
                    listeBle.remove(x);
                }
                for (int y = 0; y < qteCarotteEchangee; y++) {
                    Carotte c = new Carotte();
                    c.setFermier(fermier);
                    fermier.getListCarrotes().add(c);
                    carotteService.save(c);
                }
                return ("Vous avez echanger " + qteBleEchange + " ble(s) contre " + qteCarotteEchangee + " carotte(s) ! Qu'elle affaire !!");

            case "Chevre":
                int valeurBleVSChevre = configService.getValeurBleVSChevre();
                if (qteBleEchange < valeurBleVSChevre) {
                    return ("Echange impossible, la quantite de ble a echnager contre des chevres doit etre superieur a 4 !");
                }
                int qteChevreEchangee = (int) (qteBleEchange / valeurBleVSChevre);
                qteBleEchange = ((int) qteBleEchange / valeurBleVSChevre) * valeurBleVSChevre;
                for (int x = 0; x < qteBleEchange; x++) {
                    fermier.getListBles().remove(x);
                    bleService.delete(listeBle.get(x));
                    listeBle.remove(x);
                }
                for (int y = 0; y < qteChevreEchangee; y++) {
                    Chevre c = new Chevre();
                    c.setFermier(fermier);
                    fermier.getListChevres().add(c);
                    chevreService.save(c);
                }
                return ("Vous avez echanger " + qteBleEchange + " ble(s) contre " + qteChevreEchangee + " chevre(s) ! Qu'elle affaire !!");

            default:

                return ("Echange impossible. Vous avez mal renseigner les ressources a echanger !");
        }
    }

    public String echangeCarotte(int qteCarotteEchange, String ressourceAEchanger, Fermier fermier) {
        List<Carotte> listeCarotte = carotteService.findByFermierAndDatePlantationNull(fermier);
        switch (ressourceAEchanger) {

            case "Ble":
                float valeurCarotteVSBle = 1 / configService.getValeurBleVSCarotte();
                int qteBleEchangee = (int) (qteCarotteEchange / valeurCarotteVSBle);
                for (int x = 0; x < qteCarotteEchange; x++) {
                    fermier.getListBles().remove(x);
                    carotteService.delete(listeCarotte.get(x));
                    listeCarotte.remove(x);
                }
                for (int y = 0; y < qteBleEchangee; y++) {
                    Ble b = new Ble();
                    b.setFermier(fermier);
                    fermier.getListBles().add(b);
                    bleService.save(b);
                }
                return ("Vous avez echanger " + qteCarotteEchange + " carotte(s) contre " + qteBleEchangee + " ble(s) ! Qu'elle affaire !!");

            case "Chevre":
                int valeurCarotteVSChevre = configService.getValeurCarotteVSChevre();
                if (qteCarotteEchange < valeurCarotteVSChevre) {
                    return ("Echange impossible, la quantite de ble a echnager contre des carottes doit etre superieur a 2 !");
                }
                int qteChevreEchangee = (int) (qteCarotteEchange / valeurCarotteVSChevre);
                qteCarotteEchange = ((int) qteCarotteEchange / valeurCarotteVSChevre) * valeurCarotteVSChevre;//Donne une valeur pair
                for (int x = 0; x < qteCarotteEchange; x++) {
                    fermier.getListBles().remove(x);
                    carotteService.delete(listeCarotte.get(x));
                    listeCarotte.remove(x);
                }
                for (int y = 0; y < qteChevreEchangee; y++) {
                    Carotte c = new Carotte();
                    c.setFermier(fermier);
                    fermier.getListCarrotes().add(c);
                    carotteService.save(c);
                }
                return ("Vous avez echanger " + qteCarotteEchange + " carotte(s) contre " + qteChevreEchangee + " chevre(s) ! Qu'elle affaire !!");

            default:

                return ("Echange impossible. Vous avez mal renseigner les ressources a echanger !");
        }
    }

    public String echangeChevre(int qteChevreEchange, String ressourceAEchanger, Fermier fermier) {
        List<Chevre> listeChevre = chevreService.findByFermierAndDateAccouplementNull(fermier);
        switch (ressourceAEchanger) {

            case "Ble":
                float valeurChevreVSBle = 1 / configService.getValeurBleVSChevre();
                int qteBleEchangee = (int) (qteChevreEchange / valeurChevreVSBle);
                for (int x = 0; x < qteChevreEchange; x++) {
                    fermier.getListBles().remove(x);
                    chevreService.delete(listeChevre.get(x));
                    listeChevre.remove(x);
                }
                for (int y = 0; y < qteBleEchangee; y++) {
                    Ble b = new Ble();
                    b.setFermier(fermier);
                    fermier.getListBles().add(b);
                    bleService.save(b);
                }
                return ("Vous avez echanger " + qteChevreEchange + " chevre(s) contre " + qteBleEchangee + " ble(s) ! Qu'elle affaire !!");

            case "Carotte":
                float valeurChevreVSCarotte = 1 / configService.getValeurCarotteVSChevre();
                int qteCarotteEchangee = (int) (qteChevreEchange / valeurChevreVSCarotte);
                for (int x = 0; x < qteChevreEchange; x++) {
                    fermier.getListBles().remove(x);
                    chevreService.delete(listeChevre.get(x));
                    listeChevre.remove(x);
                }
                for (int y = 0; y < qteCarotteEchangee; y++) {
                    Carotte c = new Carotte();
                    c.setFermier(fermier);
                    fermier.getListCarrotes().add(c);
                    carotteService.save(c);
                }
                return ("Vous avez echanger " + qteChevreEchange + " chevre(s) contre " + qteCarotteEchangee + " carotte(s) ! Qu'elle affaire !!");
            default:
                return ("Echange impossible. Vous avez mal renseigner les ressources a echanger !");
        }
    }
}
