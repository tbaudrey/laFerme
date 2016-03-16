/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import java.util.Date;
import java.util.GregorianCalendar;
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

    public void nourir(long fermierId, Class entityClass, long boufId) {
        // Stock à jour
        if (entityClass.equals(Fermier.class)) {
            Fermier f = fermierService.findOneById(fermierId);
            f.setDateDerniereNutrition(new Date());
        }

//        if (entityClass.equals(Chevre.class)) {
//            if (chevreService.countByFermierId(fermierId) >= quantite) {
//                List<Chevre> listChevre = (List<Chevre>) chevreService.findAll();
//                for (int i = 0; i < quantite; i++) {
//                    chevreService.delete(listChevre.get(i));
//                }
//            }else {
//                throw new RuntimeException("Vous n'avez pas suffisant ble en stock");
//            }
//        }
        Map<Class, Integer> mapNutri = new HashMap();

        switch (entityClass.getName()) {
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

        // Nourrir l'entity
        switch (entityClass.getName()) {
            case "Fermier":

                break;

            case "Chevre":

            default:
                throw new RuntimeException("*********L'être mange ?***********");
        }

    }

    public void stockAjour(long fermierId, Class entityClass, int quantite) {
        if (entityClass.equals(Carotte.class)) {
            if (carotteService.countByFermierId(fermierId) >= quantite) {
                List<Carotte> listCarottes = (List<Carotte>) carotteService.findAll();
                for (int i = 0; i < quantite; i++) {
                    carotteService.delete(listCarottes.get(i));
                }
            } else {
                throw new RuntimeException("Vous n'avez pas suffisantes carottes en stock");
            }
        }

        if (entityClass.equals(Ble.class)) {
            if (bleService.countByFermierId(fermierId) >= quantite) {
                List<Ble> listBle = (List<Ble>) bleService.findAll();
                for (int i = 0; i < quantite; i++) {
                    bleService.delete(listBle.get(i));
                }
            } else {
                throw new RuntimeException("Vous n'avez pas suffisant ble en stock");
            }
        }

        if (entityClass.equals(Fromage.class)) {
            if (fromageService.countByFermierId(fermierId) >= quantite) {
                List<Fromage> listFromage = (List<Fromage>) fromageService.findAll();
                for (int i = 0; i < quantite; i++) {
                    fromageService.delete(listFromage.get(i));
                }
            } else {
                throw new RuntimeException("Vous n'avez pas suffisant ble en stock");
            }
        }

        if (entityClass.equals(Chevre.class)) {
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

    public long stockActuel(long fermierId, String entityClass) {

        switch (entityClass) {
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
