/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import laFerme.entity.Ble;
import laFerme.entity.Carotte;
import laFerme.entity.Fermier;
import laFerme.entity.Utilisateur;
import laFerme.service.Crud.BleService;
import laFerme.service.Crud.CarotteService;
import laFerme.service.Crud.FermierService;
import laFerme.service.Crud.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class InitialisationPartieService {

    @Autowired
    private CarotteService carotteService;

    @Autowired
    private BleService bleService;

    @Autowired
    private FermierService fermierService;

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private ConfigService configService;

    public void creationPartie(String loginUtilisateur, String nomDuNouveauFermier) {

        // Récupère util
        Utilisateur utilisateur = utilisateurService.findByLogin(loginUtilisateur);

        // Ajoute nouv fermier à cet util
        Fermier fermier = new Fermier();
        fermier.setName(nomDuNouveauFermier);
        fermier.setUtilisateur(utilisateur);
        utilisateur.setFermier(fermier);
        fermierService.save(fermier);
        

        // Ajoute des carottes
        int nbrCarotte = configService.getNbrCarotteDebutPartie();
        int nbrBle = configService.getNbrBleDebutPartie();
        for (int x = 0; x < nbrCarotte; x++) {
            Carotte c = new Carotte();
            c.setFermier(fermier);
            fermier.getListCarrotes().add(c);
            carotteService.save(c);
        }
        for (int x = 0; x < nbrBle; x++) {
            Ble b = new Ble();
            b.setFermier(fermier);
            fermier.getListBles().add(b);
            bleService.save(b);
        }
//        utilisateurService.save(utilisateur);
//        fermier.setUtilisateur(utilisateur);
//        fermierService.save(fermier);
    }
}
