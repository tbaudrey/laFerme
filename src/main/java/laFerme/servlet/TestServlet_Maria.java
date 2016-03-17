/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import laFerme.entity.Ble;
import laFerme.entity.Fermier;
import laFerme.entity.Utilisateur;
import laFerme.service.Crud.ChevreService;
import laFerme.service.Crud.FermierService;
import laFerme.service.Crud.UtilisateurService;
import laFerme.service.EchangerService;
import laFerme.service.InitialisationPartieService;
import laFerme.service.MourirService;
import laFerme.service.NourirService;
import laFerme.service.PlanterService;
import laFerme.spring.AutowireServlet;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "TestServlet_Maria", urlPatterns = {"/test_servlet_maria"})
public class TestServlet_Maria extends AutowireServlet {

    @Autowired
    private FermierService fermierService;
    
    @Autowired
    private ChevreService chevreService;

    @Autowired
    private InitialisationPartieService initialisationPartieService;
    
    @Autowired
    private PlanterService planterService;
    
    @Autowired
    private EchangerService echangerService;
    
    @Autowired
    private MourirService mourirService;
    
    @Autowired
    private NourirService nourirService;
    
    @Autowired
    private UtilisateurService utilisateurService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Utilisateur u = new Utilisateur();
        String name ="Thomas";
        u.setId(1L);
        u.setLogin("mari");
        utilisateurService.save(u);
        System.out.println("11111111111111111111111111111111111111111111111111111");
        initialisationPartieService.creationPartie("mari", name);
        System.out.println("22222222222222222222222222222222222222222222222222222222");
        Fermier fermier = fermierService.findOneById(u.getId());
        System.out.println("3333333333333333333333333333333333333333333333333333333");
        planterService.planterBle(2, fermier);
        System.out.println("44444444444444444444444444444444444444444444444444444444");
        long stock = nourirService.stockActuel(u.getId(), "Ble");
        System.out.println("******************************************************"+stock);
        nourirService.nourir(Fermier.class, u.getId(), Ble.class);
//        long actStock = nourirService.stockActuel(u.getId(), "Ble");
//        System.out.println("******************************************************"+actStock);
    }
}
