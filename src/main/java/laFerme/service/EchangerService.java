/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

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
    private FromageService fromageService;

    public String echangeBle(int qteBleEchange, String ressourceAEchanger, Fermier fermier) {

        switch (ressourceAEchanger) {

            case "Carotte":
                if (qteBleEchange < 2) {
                    return ("Echange impossible, la quantite de ble a echnager contre des carottes doit etre superieur a 2 !");
                }
                int valeurBleVSCarotte = 2;
                int qteCarotteEchangee = (int) (qteBleEchange / valeurBleVSCarotte);
                qteBleEchange = ((int) qteBleEchange / valeurBleVSCarotte) * valeurBleVSCarotte;
                for (int x = 0; x < qteBleEchange; x++) {
                    bleService.delete(bleService.findByFermierAndDatePlantationNull(fermier).get(0));
                }
                for (int y = 0; y < qteCarotteEchangee; y++) {
                    Carotte c = new Carotte();
                    c.setFermier(fermier);
                    carotteService.save(c);
                }
                return ("Vous avez echanger " + qteBleEchange + " ble(s) contre " + qteCarotteEchangee + " carotte(s) ! Qu'elle affaire !!");

            case "Chevre":
                if (qteBleEchange < 4) {
                    return ("Echange impossible, la quantite de ble a echnager contre des chevres doit etre superieur a 4 !");
                }
                int valeurBleVSChevre = 4;
                int qteChevreEchangee = (int) (qteBleEchange / valeurBleVSChevre);
                qteBleEchange = ((int) qteBleEchange / valeurBleVSChevre) * valeurBleVSChevre;
                for (int x = 0; x < qteBleEchange; x++) {
                    bleService.delete(bleService.findByFermierAndDatePlantationNull(fermier).get(0));
                }
                for (int y = 0; y < qteChevreEchangee; y++) {
                    Chevre c = new Chevre();
                    c.setFermier(fermier);
                    chevreService.save(c);
                }
                return ("Vous avez echanger " + qteBleEchange + " ble(s) contre " + qteChevreEchangee + " chevre(s) ! Qu'elle affaire !!");

            default:

                return ("Echange impossible. Vous avez mal renseigner les ressources a echanger !");
        }
    }

    public String echangeCarotte(int qteCarotteEchange, String ressourceAEchanger, Fermier fermier) {

        switch (ressourceAEchanger) {

            case "Ble":
                float valeurCarotteVSBle = 0.5f;
                int qteBleEchangee = (int) (qteCarotteEchange / valeurCarotteVSBle);
                for (int x = 0; x < qteCarotteEchange; x++) {
                    carotteService.delete(carotteService.findByFermierAndDatePlantationNull(fermier).get(0));
                }
                for (int y = 0; y < qteBleEchangee; y++) {
                    Ble b = new Ble();
                    b.setFermier(fermier);
                    bleService.save(b);
                }
                return ("Vous avez echanger " + qteCarotteEchange + " carotte(s) contre " + qteBleEchangee + " ble(s) ! Qu'elle affaire !!");

            case "Chevre":
                if (qteCarotteEchange < 2) {
                    return ("Echange impossible, la quantite de ble a echnager contre des carottes doit etre superieur a 2 !");
                }
                int valeurCarotteVSChevre = 2;
                int qteChevreEchangee = (int) (qteCarotteEchange / valeurCarotteVSChevre);
                qteCarotteEchange = ((int) qteCarotteEchange / valeurCarotteVSChevre) * valeurCarotteVSChevre;//Donne une valeur pair
                for (int x = 0; x < qteCarotteEchange; x++) {
                    carotteService.delete(carotteService.findByFermierAndDatePlantationNull(fermier).get(0));
                }
                for (int y = 0; y < qteChevreEchangee; y++) {
                    Carotte c = new Carotte();
                    c.setFermier(fermier);
                    carotteService.save(c);
                }
                return ("Vous avez echanger " + qteCarotteEchange + " carotte(s) contre " + qteChevreEchangee + " chevre(s) ! Qu'elle affaire !!");

            default:

                return ("Echange impossible. Vous avez mal renseigner les ressources a echanger !");
        }
    }
        public String echangeChevre(int qteChevreEchange, String ressourceAEchanger, Fermier fermier) {

        switch (ressourceAEchanger) {

            case "Ble":
                float valeurChevreVSBle = 0.25f;
                int qteBleEchangee = (int) (qteChevreEchange / valeurChevreVSBle);
                for (int x = 0; x < qteChevreEchange; x++) {
                    chevreService.delete(chevreService.findByFermierAndDateAccouplementNull(fermier).get(0));
                }
                for (int y = 0; y < qteBleEchangee; y++) {
                    Ble b = new Ble();
                    b.setFermier(fermier);
                    bleService.save(b);
                }
                return ("Vous avez echanger " + qteChevreEchange + " chevre(s) contre " + qteBleEchangee + " ble(s) ! Qu'elle affaire !!");

            case "Carotte":
                float valeurChevreVSCarotte = 0.5f;
                int qteCarotteEchangee = (int) (qteChevreEchange / valeurChevreVSCarotte);
                for (int x = 0; x < qteChevreEchange; x++) {
                    chevreService.delete(chevreService.findByFermierAndDateAccouplementNull(fermier).get(0));
                }
                for (int y = 0; y < qteCarotteEchangee; y++) {
                    Carotte c = new Carotte();
                    c.setFermier(fermier);
                    carotteService.save(c);
                }
                return ("Vous avez echanger " + qteChevreEchange + " chevre(s) contre " + qteCarotteEchangee + " carotte(s) ! Qu'elle affaire !!");
            default:
                return ("Echange impossible. Vous avez mal renseigner les ressources a echanger !");
        }
    }
}
