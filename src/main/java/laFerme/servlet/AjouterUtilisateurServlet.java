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
import laFerme.entity.Utilisateur;
import laFerme.service.InscriptionService;
import laFerme.spring.AutowireServlet;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "AjouterUtilisateurServlet", urlPatterns = {"/AjouterUtilisateurServlet"})
public class AjouterUtilisateurServlet extends AutowireServlet {

    @Autowired
    private InscriptionService inscriptionService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Utilisateur u = new Utilisateur();
        u.setLogin((String) req.getParameter("login"));
        u.setMdp((String) req.getParameter("mdp"));

        Boolean etatInscription = inscriptionService.inscription(u);

        req.setAttribute("etatInscription", etatInscription);

        if (etatInscription == false) {
            req.getRequestDispatcher("Ajouter_utilisateur.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("inscrit.jsp").forward(req, resp);
        }
    }
}
