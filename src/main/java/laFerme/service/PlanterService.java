/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import java.util.ArrayList;
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
    
//    @Autowired
//    private BleService bleService;

//    @Autowired
//    private CarotteService carotteService;

//    public List<Carotte> nonPlanterCarotte() {
//        List<Carotte> listeCarottes = (List<Carotte>) carotteService.findAll();
//        List<Carotte> listeCarottesNonPlante = new ArrayList<>();
//        for (Carotte c : listeCarottes) {
//            if (c.getDatePlantation() == null) {
//                listeCarottesNonPlante.add(c);
//            }
//        }
//        return listeCarottesNonPlante;
//    }
//
//    public List<Ble> nonPlanterBle() {
//        List<Ble> listeBle = (List<Ble>) bleService.findAll();
//        List<Ble> listeBleNonPlante = new ArrayList<>();
//        for (Ble b : listeBle) {
//            if (b.getDatePlantation() == null) {
//                listeBleNonPlante.add(b);
//            }
//        }
//        return listeBleNonPlante;
//    }
}
