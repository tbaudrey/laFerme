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
import laFerme.spring.AutowireServlet;


/**
 *
 * @author admin
 */
@WebServlet(name = "PlanterServlet", urlPatterns = {"/PlanterServlet"})
public class PlanterServlet extends AutowireServlet {

 
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        String quantiteBleAPlanter=req.getParameter("quantiteBleAPlanter");
        String quantiteCarotteAPlanter=req.getParameter("quantiteCarotteAPlanter");
        
        
        
        
        
        
        req.getRequestDispatcher("RessourcesDispoServlet").include(req, resp);
        
    }
    
    
}
