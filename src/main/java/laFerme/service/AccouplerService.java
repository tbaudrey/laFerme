/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import java.util.GregorianCalendar;
import java.util.List;
import laFerme.entity.Chevre;
import laFerme.service.Crud.ChevreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class AccouplerService {
    @Autowired
    private ChevreService chevreService;
    
        public void accouplerChevre(List<Chevre> listeChevre) {
        if (listeChevre.size()%2!=1){
            listeChevre.remove(listeChevre.size()-1);
        }
        for (Chevre c : listeChevre){
            c.setDateAccouplement(new GregorianCalendar());
            chevreService.save(c);
        }
    }
}
