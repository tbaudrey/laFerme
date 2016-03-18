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
import laFerme.service.Crud.ChevreService;
import laFerme.service.Crud.FermierService;
import laFerme.service.Crud.UtilisateurService;
import laFerme.service.NourirService2;
import laFerme.spring.AutowireServlet;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author admin
 */
@WebServlet(name = "AccouplerServlet", urlPatterns = {"/AccouplerServlet"})
public class AccouplerServlet extends AutowireServlet {
    
    @Autowired
    private ChevreService chevreService;
    
    @Autowired
    private FermierService fermierService;
            
    @Autowired
    private UtilisateurService utilisateurService;
    
    @Autowired
    private AccouplerService accouplerService;

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
        
        String quantiteChevreAAccoupler=req.getParameter("quantiteChevreAAccoupler");
        
        accouplerService.accouplerChevre(Integer.parseInt(quantiteChevreAAccoupler), fermier);
        
        req.getRequestDispatcher("FermeServlet").include(req, resp);
        
    }
    
    
}
