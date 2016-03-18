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
import laFerme.entity.Chevre;
import laFerme.entity.Fermier;
import laFerme.entity.Utilisateur;
import laFerme.service.AccouplerService;
import laFerme.service.Crud.BleService;
import laFerme.service.Crud.CarotteService;
import laFerme.service.Crud.ChevreService;
import laFerme.service.Crud.FermierService;
import laFerme.service.Crud.FromageService;
import laFerme.service.Crud.UtilisateurService;
import laFerme.service.EchangerService;
import laFerme.service.InitialisationPartieService;
import laFerme.service.PlanterService;
import laFerme.service.RafraichirService;
import laFerme.spring.AutowireServlet;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends AutowireServlet {

    @Autowired
    private CarotteService carotteService;
    
    @Autowired
    private BleService bleService;
    
    @Autowired
    private FromageService fromageService;
    
    @Autowired
    private InitialisationPartieService initialisationPartieService;

    @Autowired
    private ChevreService chevreService;

    @Autowired
    private FermierService fermierService;

    @Autowired
    private EchangerService echangerService;

    @Autowired
    private PlanterService planterService;
    
    @Autowired
    private AccouplerService accouplerService;
    
    @Autowired
    private RafraichirService rafraichirService;
    
    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        carotteService.deleteAll();
        fromageService.deleteAll();
        bleService.deleteAll();
        fermierService.deleteAll();
        utilisateurService.deleteAll();
        
        String name = "Arthur";
        req.getSession().setAttribute("login", "siku18");
        String login = (String) req.getSession().getAttribute("login");
        Utilisateur u = new Utilisateur();
        u.setLogin(login);
        utilisateurService.save(u);
        initialisationPartieService.creationPartie(login, name);
        Fermier fermier = fermierService.findByName(name);
//        System.out.println(echangerService.echangeBle(3, "Carotte", fermier));
//        planterService.planterCarotte(2, fermier);
//        System.out.println(echangerService.echangeCarotte(2, "Ble", fermier));
//        int i = 7;
//        for (int x = 0; x < i; x++) {
//            Chevre c = new Chevre();
//            c.setFermier(fermier);
//            chevreService.save(c);
//        }
//        accouplerService.accouplerChevre(5, fermier);
//        rafraichirService.rafraichirChevre(fermier);
    }
}

