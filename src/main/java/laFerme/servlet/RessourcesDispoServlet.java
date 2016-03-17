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
import laFerme.entity.Ble;
import laFerme.entity.Carotte;
import laFerme.entity.Chevre;
import laFerme.entity.Fermier;
import laFerme.entity.Fromage;
import laFerme.entity.Utilisateur;
import laFerme.service.Crud.BleService;
import laFerme.service.Crud.CarotteService;
import laFerme.service.Crud.ChevreService;
import laFerme.service.Crud.FermierService;
import laFerme.service.Crud.FromageService;
import laFerme.service.Crud.UtilisateurService;
import laFerme.service.InitialisationPartieService;
import laFerme.spring.AutowireServlet;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author admin
 */
@WebServlet(name = "RessourcesDispoServlet", urlPatterns = {"/RessourcesDispoServlet"})
public class RessourcesDispoServlet extends AutowireServlet {

    @Autowired
    private FermierService fermierService;
    
    @Autowired
    private BleService bleService;
    
    @Autowired
    private CarotteService carotteService;
    
    @Autowired
    private ChevreService chevreService;
    
    @Autowired
    private FromageService fromageService;
    
    @Autowired
    private UtilisateurService utilisateurService;
    
    @Autowired
    private InitialisationPartieService initialisationPartieService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        List<Ble> listeBlesNonPlante = new ArrayList<>();
        List<Carotte> listeCarottesNonPlante  = new ArrayList<>();
        List<Chevre> listeChevres  = new ArrayList<>();
        List<Fromage> listeFromages  = new ArrayList<>();
        
        String login = (String) req.getSession().getAttribute("login");
        Utilisateur u = new Utilisateur();
        u=utilisateurService.findByLogin(login);
        System.out.println(u);

        Fermier fermier = new Fermier();
        fermier=fermierService.findByName("thomasLeFermier");

        listeBlesNonPlante=bleService.findByFermierAndDatePlantationNull(fermier);
        listeCarottesNonPlante=carotteService.findByFermierAndDatePlantationNull(fermier);
        listeChevres=(List<Chevre>) chevreService.findAll();
        listeFromages=(List<Fromage>) fromageService.findAll();
       
       
        int quantiteBleNonPlante=listeBlesNonPlante.size();
        int quantiteCarotteNonPlante=listeCarottesNonPlante.size();
        int quantiteChevre=listeChevres.size();
        int quantiteFromage=listeFromages.size();
        
        req.setAttribute("quantiteBleNonPlante", quantiteBleNonPlante);
        req.setAttribute("quantiteCarotteNonPlante", quantiteCarotteNonPlante);
        req.setAttribute("quantiteChevre", quantiteChevre);
        req.setAttribute("quantiteFromage", quantiteFromage);
        req.getRequestDispatcher("ressources_dispo.jsp").include(req, resp);
        
    }
    
    
}
