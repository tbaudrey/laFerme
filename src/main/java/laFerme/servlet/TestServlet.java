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
import laFerme.entity.Fermier;
import laFerme.entity.Utilisateur;
import laFerme.service.Crud.FermierService;
import laFerme.service.Crud.UtilisateurService;
import laFerme.service.EchangerService;
import laFerme.service.InitialisationPartieService;
import laFerme.service.PlanterService;
import laFerme.spring.AutowireServlet;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends AutowireServlet {

    @Autowired
    private InitialisationPartieService initialisationPartieService;

    @Autowired
    private UtilisateurService utilisateurService;
    
    @Autowired
    private FermierService fermierService;
    
    @Autowired
    private EchangerService echangerService;

    @Autowired
    private PlanterService planterService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur u = new Utilisateur();
        String name ="Arthur";
        initialisationPartieService.creationPartie(u, name);
        Fermier fermier = fermierService.findByName(name);
        System.err.println("****************************************");
        System.out.println(echangerService.echangeBle(3, "Carotte",fermier ));
        planterService.planterCarotte(2, fermier);
        System.err.println("****************************************");
        System.out.println(echangerService.echangeCarotte(2, "Ble",fermier ));
    }
}
