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
import laFerme.service.NourirService2;
import laFerme.service.PlanterService;
import laFerme.spring.AutowireServlet;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author admin
 */
@WebServlet(name = "NourrirFermierServlet", urlPatterns = {"/NourrirFermierServlet"})
public class NourrirFermierServlet extends AutowireServlet {
    
    @Autowired
    private PlanterService planterService;
    
    @Autowired
    private FermierService fermierService;
            
    @Autowired
    private UtilisateurService utilisateurService;
    
    @Autowired
    private NourirService2 nourirService2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        

        String login = (String) req.getSession().getAttribute("login");
        Utilisateur utilisateur = new Utilisateur();
        utilisateur=utilisateurService.findByLogin(login);
        String choixCategorie=req.getParameter("NourrirFermier");
        Fermier fermier = new Fermier();
        fermier=fermierService.findByName("thomasLeFermier");
        System.out.println(fermier);
        if(choixCategorie.equals("1")){
            nourirService2.nourirFermier("Ble", fermier);
        }
        if(choixCategorie.equals("2")){
            nourirService2.nourirFermier("Carotte", fermier);
        }
        if(choixCategorie.equals("3")){
            nourirService2.nourirFermier("Chevre", fermier);
        }
        if(choixCategorie.equals("4")){
            nourirService2.nourirFermier("Fromage", fermier);
        }
        
        req.getRequestDispatcher("FermeServlet").include(req, resp);
        
    }
    
    
}
