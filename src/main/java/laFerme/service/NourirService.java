/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

/**
 *
 * @author admin
 */
public class NourirService {

    @Autowired
    private CarotteService carotteService;

    @Autowired
    private BleService bleService;

    @Autowired
    private FromageService fromageService;

    @Autowired
    private ChevreService chevreService;

    @Autowired
    private FermierService fermierService;

    public void nourir(Class cibleClass, long cibleId, Class nourritureClass) {

        // Determinne le nmb de nouriture à manger
        Map<Class, Integer> mapNutri = new HashMap();

        switch (cibleClass.getName()) {
            case "Fermier":
                mapNutri.put(Ble.class, 3);
                mapNutri.put(Carotte.class, 2);
                mapNutri.put(Fromage.class, 2);
                mapNutri.put(Chevre.class, 1);

                break;

            case "Chevre":
                mapNutri.put(Ble.class, 1);
                mapNutri.put(Carotte.class, 1);
                break;

            default:
                throw new RuntimeException("*********L'être mange ?***********");
        }
        
        
        // Nourrir le fermier
        if (cibleClass.equals(Fermier.class)) {
            Fermier f = fermierService.findOneById(cibleId);
            f.setDateDerniereNutrition(new Date());
            // Stock à jour
            stockAjour(cibleId, cibleClass, mapNutri.get(nourritureClass));
        }
        // Nourrir la chevre
        if (cibleClass.equals(Chevre.class)) {
            Chevre chevre = chevreService.findOneByFermierIdAndId(cibleId, cibleId);
            chevre.setDateDerniereNutrition(new Date());
            // Stock à jour
            stockAjour(cibleId, cibleClass, mapNutri.get(nourritureClass));
        }

    }

    public void stockAjour(long fermierId, Class nourritureClass, int quantite) {
        if (nourritureClass.equals(Carotte.class)) {
            if (carotteService.countByFermierId(fermierId) >= quantite) {
                List<Carotte> listCarottes = (List<Carotte>) carotteService.findAll();
                for (int i = 0; i < quantite; i++) {
                    carotteService.delete(listCarottes.get(i));
                }
            } else {
                throw new RuntimeException("Vous n'avez pas suffisantes carottes en stock");
            }
        }

        if (nourritureClass.equals(Ble.class)) {
            if (bleService.countByFermierId(fermierId) >= quantite) {
                List<Ble> listBle = (List<Ble>) bleService.findAll();
                for (int i = 0; i < quantite; i++) {
                    bleService.delete(listBle.get(i));
                }
            } else {
                throw new RuntimeException("Vous n'avez pas suffisant ble en stock");
            }
        }

        if (nourritureClass.equals(Fromage.class)) {
            if (fromageService.countByFermierId(fermierId) >= quantite) {
                List<Fromage> listFromage = (List<Fromage>) fromageService.findAll();
                for (int i = 0; i < quantite; i++) {
                    fromageService.delete(listFromage.get(i));
                }
            } else {
                throw new RuntimeException("Vous n'avez pas suffisant ble en stock");
            }
        }

        if (nourritureClass.equals(Chevre.class)) {
            if (chevreService.countByFermierId(fermierId) >= quantite) {
                List<Chevre> listChevre = (List<Chevre>) chevreService.findAll();
                for (int i = 0; i < quantite; i++) {
                    chevreService.delete(listChevre.get(i));
                }
            } else {
                throw new RuntimeException("Vous n'avez pas suffisant ble en stock");
            }
        }
    }

    public long stockActuel(long fermierId, String nourritureClass) {

        switch (nourritureClass) {
            case "Ble":
                long stockBle = bleService.countByFermierId(fermierId);
                return stockBle;
            case "Carotte":
                long stockCarotte = carotteService.countByFermierId(fermierId);
                return stockCarotte;
            case "Fromage":
                long stockFromage = fromageService.countByFermierId(fermierId);
                return stockFromage;
            case "Chevre":
                long stockChevre = chevreService.countByFermierId(fermierId);
                return stockChevre;
            default:
                throw new RuntimeException("Entité existante ?");
        }
    }

}
