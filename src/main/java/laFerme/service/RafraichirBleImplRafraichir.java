/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import laFerme.entity.Ble;
import laFerme.entity.Fermier;
import laFerme.service.Crud.BleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */

public class RafraichirBleImplRafraichir implements RafraichirService{
    
    @Autowired
    private BleService bleService;
    
    public List<Ble> RafraichirBle (Fermier fermier){
        List<Ble> listeBleRafraichie=new ArrayList<>();
        listeBleRafraichie=(List<Ble>) bleService.findAll();
        Date instantT = new Date();
        //
        Date 
        //Si le ble a été planté, 
        for (Ble b : listeBleRafraichie){
            if(!b.getDatePlantation().equals(null)){
                if (instantT.getTime()-b.getDatePlantation().getTime()==
            }
                
        }
        return listeBleRafraichie;
    }
}
