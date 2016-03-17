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
import laFerme.service.TimeService;
import laFerme.spring.AutowireServlet;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author admin
 */
//
@WebServlet(name = "FermeServlet", urlPatterns = {"/FermeServlet"})
public class FermeServlet extends AutowireServlet {

    @Autowired
    private FermierService fermierService;
    
    @Autowired
    private BleService bleService;
    
    @Autowired
    private TimeService timeService;
    
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
        
        
        List<Ble> listeBlesPlante = new ArrayList<>();
        List<Carotte> listeCarottesPlante  = new ArrayList<>();
        List<Chevre> listeChevres  = new ArrayList<>();
        List<Fromage> listeFromages  = new ArrayList<>();
        List<Fermier> listeFermier  = new ArrayList<>();
        
        String login = (String) req.getSession().getAttribute("login");
        Utilisateur u = new Utilisateur();
        u=utilisateurService.findByLogin(login);
        System.out.println(u);

        Fermier fermier = new Fermier();
        fermier=fermierService.findByName("thomasLeFermier");

        listeBlesPlante=bleService.findByFermierAndDatePlantationNotNull(fermier);
        listeCarottesPlante=carotteService.findByFermierAndDatePlantationNotNull(fermier);
        listeChevres=(List<Chevre>) chevreService.findAll();
        listeFromages=(List<Fromage>) fromageService.findAll();
        listeFermier=(List<Fermier>) fermierService.findAll();
        
        long tempsRestant;
        for (Ble ble : listeBlesPlante){
            tempsRestant=timeService.calculJoursRestantAvant(ble.getDatePlantation());
            ble.setTempsRestant(tempsRestant);
            bleService.save(ble);
        }
        System.out.println(listeBlesPlante);
        
        req.setAttribute("mesBlesPlantes", listeBlesPlante);
        req.setAttribute("quantiteBlePlante", listeBlesPlante.size());

        req.setAttribute("mesCarottesPlantees", listeCarottesPlante);
        req.setAttribute("quantiteCarottePlante", listeCarottesPlante.size());

        req.setAttribute("mesChevres", listeChevres);
        req.setAttribute("quantiteChevre", listeChevres.size());
        
        req.setAttribute("mesFromages", listeFromages);
        req.setAttribute("quantiteFromage", listeFromages.size());
        
        req.setAttribute("mesFermiers", listeFermier);
        req.setAttribute("quantiteFermier", listeFermier.size());
        
        req.getRequestDispatcher("ferme.jsp").include(req, resp);

        
    }
    
    
}
