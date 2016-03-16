/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import laFerme.entity.Ble;
import laFerme.entity.Carotte;
import laFerme.service.Crud.BleService;
import laFerme.service.Crud.CarotteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class PlanterService{
    
    @Autowired
    private BleService bleService;
    
    @Autowired
    private CarotteService carotteService;
    
    public void planterCarotte(List<Carotte> listeCarotte) {
        for (Carotte c : listeCarotte){
            c.setDatePlantation(new GregorianCalendar());
            carotteService.save(c);
        }
    }

    public void planterBle(List<Ble> listeBle) {
        for (Ble b : listeBle){
            b.setDatePlantation(new GregorianCalendar());
            bleService.save(b);
        }
    }
}
