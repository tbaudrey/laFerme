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
import laFerme.spring.AutowireServlet;


/**
 *
 * @author admin
 */
@WebServlet(name = "FermeServlet", urlPatterns = {"/FermeServlet"})
public class FermeServlet extends AutowireServlet {

 
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
       
        
//        Long id=Long.parseLong(req.getParameter("id"));
        
        
        
//        req.setAttribute("mesBlesPlantes", mesBlesPlantes);
//        req.setAttribute("quantiteBlePlante", mesBlesPlantes.size());
//
//        req.setAttribute("mesCarottesPlantees", mesCarottesPlantees);
//        req.setAttribute("quantiteCarottePlante", mesCarottesPlantees.size());
//
//        req.setAttribute("mesChevres", mesChevres);
//        req.setAttribute("quantiteChevre", mesChevre.size());
//        
//        req.setAttribute("mesFermiers", mesFermiers);
//        req.setAttribute("quantiteFermier", mesFermiers.size());
//        
//        req.getRequestDispatcher("ferme.jsp").include(req, resp);
        
    }
    
    
}
