/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import laFerme.entity.Ble;
import laFerme.entity.Carotte;
import laFerme.entity.Fermier;
import laFerme.service.Crud.BleService;
import laFerme.service.Crud.CarotteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class PlanterService {

    @Autowired
    private BleService bleService;

    @Autowired
    private CarotteService carotteService;

    @Autowired
    private ConfigService configService;

    public void planterCarotte(int qteCarotte, Fermier fermier) {
        System.out.println("**************************PlanterCarotte************************************");
        List<Carotte> listeCarotte = (List<Carotte>) carotteService.findByFermierAndDatePlantationNull(fermier);
        GregorianCalendar instantT = new GregorianCalendar();
        GregorianCalendar dateProchaineRecolte = instantT;
        dateProchaineRecolte.add(Calendar.MINUTE, configService.getNbrMoisAvantRecolteCarotte());
        if (listeCarotte.size() >= qteCarotte) {
            for (int x = 0; x < qteCarotte; x++) {
                Carotte c = listeCarotte.get(x);
                c.setDatePlantation(new GregorianCalendar());
                c.setTpsAvantRecolte(dateProchaineRecolte);
                carotteService.save(c);
            }
        } else {
            throw new RuntimeException("Il n'y a pas assez de carotte plantable !");
        }

    }

    public void planterBle(int qteBle, Fermier fermier) {
        System.out.println("**************************PlanterBle************************************");
        List<Ble> listeBle = (List<Ble>) bleService.findByFermierAndDatePlantationNull(fermier);
        GregorianCalendar instantT = new GregorianCalendar();
        GregorianCalendar dateProchaineRecolte = instantT;
        dateProchaineRecolte.add(Calendar.MINUTE, configService.getNbrMoisAvantRecolteBle());
        if (listeBle.size() >= qteBle) {
            for (int x = 0; x < qteBle; x++) {
                Ble b = listeBle.get(x);
                b.setDatePlantation(new GregorianCalendar());
                b.setTpsAvantRecolte(dateProchaineRecolte);
                bleService.save(b);
            }
        } else {
            throw new RuntimeException("Il n'y a pas assez de ble plantable !");
        }
    }
}
