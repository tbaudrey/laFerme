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
public class EchangerServlet extends AutowireServlet {

 
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String echange1=req.getParameter("Echange1");
        String echange2=req.getParameter("Echange1");
        String quantiteAEchanger=req.getParameter("quantiteAEchanger");
        
        if(echange1.equals("1")){
            //on echange "quantiteAEchanger" de ble contre :
            if(echange2.equals("2")){
                //des carottes
            }
            if(echange2.equals("3")){
                //des chevres
            }
            if(echange2.equals("4")){
                //du fromage
            }
        }
        else if(echange1.equals("2")){
            //on echange "quantiteAEchanger" de carottes contre :
            if(echange2.equals("1")){
                //du ble
            }
            if(echange2.equals("3")){
                //des chevres
            }
            if(echange2.equals("4")){
                //du fromage
            }
        }
        else if(echange1.equals("3")){
            //on echange "quantiteAEchanger" de chevres contre :
            if(echange2.equals("1")){
                //du ble
            }
            if(echange2.equals("2")){
                //des carottes
            }
            if(echange2.equals("4")){
                //du fromage
            }
        }
        else if(echange1.equals("4")){
            //on echange "quantiteAEchanger" de fromage contre :
            if(echange2.equals("1")){
                //du ble
            }
            if(echange2.equals("2")){
                //des carottes
            }
            if(echange2.equals("3")){
                //des chevres
            }
        }
        
        req.
        req.getRequestDispatcher("RessourcesDispoServlet").include(req, resp);
        
    }
    
    
}
