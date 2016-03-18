/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import java.util.List;
import laFerme.entity.Fermier;
import laFerme.entity.Utilisateur;
import laFerme.service.Crud.FermierService;
import laFerme.service.Crud.UtilisateurService;
import laFerme.service.RafraichirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class TimeService {
    
    @Autowired
    private UtilisateurService utilisateurService;
    
    @Autowired
    private FermierService fermierService;
    
    @Autowired
    private RafraichirService rafraichirService;

    @Scheduled(fixedDelay = 60000)//Toute les minutes
    public void raffraichissementDB(){
        List<Utilisateur> listeUtilisateur = (List<Utilisateur>) utilisateurService.findAll();
        for (Utilisateur u :listeUtilisateur){
            Fermier fermier =fermierService.findOneByUtilisateur(u);
            rafraichirService.rafraichirTout(fermier);
        }
    }
}
