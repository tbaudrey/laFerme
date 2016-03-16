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

    public void planterCarotte(int qteCarotte, Fermier fermier) {
        List<Carotte> listeCarotte = (List<Carotte>) carotteService.findByFermierAndDatePlantationNull(fermier);
        for (int x = 0; x < qteCarotte; x++) {
            Carotte c = listeCarotte.get(x);
            c.setDatePlantation(new GregorianCalendar());
            carotteService.save(c);
        }
    }

    public void planterBle(int qteBle, Fermier fermier) {
        List<Ble> listeBle = (List<Ble>) bleService.findByFermierAndDatePlantationNull(fermier);
        for (int x = 0; x < qteBle; x++) {
            Ble b = listeBle.get(x);
            b.setDatePlantation(new GregorianCalendar());
            bleService.save(b);
        }
    }
}
