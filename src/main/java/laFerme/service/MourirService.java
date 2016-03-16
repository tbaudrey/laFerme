/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import java.util.List;
import laFerme.entity.Chevre;
import laFerme.entity.Fermier;
import laFerme.service.Crud.ChevreService;
import laFerme.service.Crud.FermierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class MourirService {
    
    @Autowired
    private FermierService fermierService;
    
    @Autowired
    private ChevreService chevreService;
    
    @Autowired
    private TimeService timeService;
    
    
    public void mourir(){
        List<Chevre> listChevres = (List<Chevre>) chevreService.findAll();
        List<Fermier> listFermier = (List<Fermier>) fermierService.findAll();
        
        for(Chevre laChevre : listChevres){
            if(timeService.dateExpiree(laChevre.getDateDerniereNutrition(), 3));
                chevreService.delete(laChevre);
        }
        
        for(Fermier leFermier : listFermier){
            if(timeService.dateExpiree(leFermier.getDateDerniereNutrition(), 3)){
                fermierService.delete(leFermier);
            }
        }
    }
    
}
