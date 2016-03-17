/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import java.util.GregorianCalendar;
import java.util.List;
import laFerme.entity.Chevre;
import laFerme.entity.Fermier;
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

    public void accouplerChevre(int Qte, Fermier fermier) {
        if (Qte % 2 == 1) {
            Qte = Qte - 1;
        }
        List<Chevre> listeChevre = (List<Chevre>) chevreService.findByFermierAndDateAccouplementNull(fermier);
        if (listeChevre.size() > Qte) {
            for (int x = 0; x < Qte; x++) {
                Chevre c = listeChevre.get(x);
                c.setDateAccouplement(new GregorianCalendar());
                chevreService.save(c);
            }
        } else {
            throw new RuntimeException("Il n'y a pas assez de chevre fecondable !");
        }
    }
}
