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
@WebServlet(name = "TestServlet", urlPatterns = {"/test_servlet_maria"})
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
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Utilisateur u = new Utilisateur();
        String name ="Arthur";
        u.setId(1L);
        initialisationPartieService.creationPartie(u, name);
        Fermier fermier = fermierService.findOneById(u.getId());
        planterService.planterBle(2, fermier);
        long stock = nourirService.stockActuel(u.getId(), "Ble");
        System.out.println("******************************************************"+stock);
//        nourirService.nourir(Fermier.class, u.getId(), Ble.class);
//        long actStock = nourirService.stockActuel(u.getId(), "Ble");
//        System.out.println("******************************************************"+actStock);
    }
}
