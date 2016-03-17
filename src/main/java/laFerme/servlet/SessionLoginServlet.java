/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import laFerme.entity.Utilisateur;
import laFerme.service.Crud.UtilisateurService;
import laFerme.service.InitialisationPartieService;
import laFerme.spring.AutowireServlet;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class SessionLoginServlet extends AutowireServlet {

    @Autowired
    private UtilisateurService utilisateurService;
    
    @Autowired
    private InitialisationPartieService initialisationPartieService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Utilisateur> listeUtil = new ArrayList<>();
        listeUtil = (List<Utilisateur>) utilisateurService.findAll();

        Boolean estLogger = false;

        if (!listeUtil.isEmpty()) {
            for (Utilisateur u : listeUtil) {
                if (u.getLogin().equals(req.getParameter("login"))) {
                    if (u.getMdp().equals(req.getParameter("mdp"))) {
                        req.getSession().setAttribute("login", req.getParameter("login"));
                        req.getSession().setAttribute("mdp", req.getParameter("mdp"));
                        estLogger = true;
                        String login=req.getParameter("login");
                        initialisationPartieService.creationPartie(login, "thomasLeFermier");
                    }
                }
            }
        }
        req.setAttribute("estLogger", estLogger);
        if (estLogger == true) {
            req.getRequestDispatcher("est_loger.jsp").forward(req, resp);
        }
        else{
        req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
