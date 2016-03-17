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
import laFerme.service.PlanterService;
import laFerme.spring.AutowireServlet;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author admin
 */
@WebServlet(name = "PlanterServlet", urlPatterns = {"/PlanterServlet"})
public class PlanterServlet extends AutowireServlet {
    
    @Autowired
    private PlanterService planterService;
    
    @Autowired
    private FermierService fermierService;
            
    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("9999999999999999999999999999999999999999999999999999");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String quantiteBleAPlanter=req.getParameter("quantiteBleAPlanter");
        String quantiteCarotteAPlanter=req.getParameter("quantiteCarotteAPlanter");
        
        String login = (String) req.getSession().getAttribute("login");
        Utilisateur u = new Utilisateur();
        u=utilisateurService.findByLogin(login);
        Fermier fermier = new Fermier();
        fermier=fermierService.findByName("thomasLeFermier");
        
        if(quantiteBleAPlanter==null && quantiteCarotteAPlanter==null)
            return;
        if(quantiteBleAPlanter==null){
            // on va planter des carottes
            planterService.planterCarotte(Integer.parseInt(quantiteCarotteAPlanter), fermier); 
        }
        if(quantiteCarotteAPlanter==null){
            // on va planter du ble
            planterService.planterBle(Integer.parseInt(quantiteBleAPlanter), fermier); 
        }
        else{
            planterService.planterBle(Integer.parseInt(quantiteBleAPlanter), fermier);
            planterService.planterCarotte(Integer.parseInt(quantiteCarotteAPlanter), fermier); 

        }
        
        req.getRequestDispatcher("RessourcesDispoServlet").include(req, resp);
        
    }
    
    
}
