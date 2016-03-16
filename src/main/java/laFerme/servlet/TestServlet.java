/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.servlet;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import laFerme.service.NombreAleatoireService;
import laFerme.spring.AutowireServlet;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends AutowireServlet {

    @Autowired
    private NombreAleatoireService nombreAleatoireService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date heure = new Date(0, 0, 0, 1, 0);
        Date ojd = new Date(0, 0, 0);
        System.out.println("*************************************");
        System.out.println(heure.getTime());
        System.out.println("*************************************");
        System.out.println(ojd.getTime());
        System.out.println("*************************************");
        System.out.println((heure.getTime()-ojd.getTime()));
        System.out.println("*************************************");
        System.out.println(3600*1000);
        System.out.println("*************************************");
        System.out.println(nombreAleatoireService.NombreAleatoire(5, 8));
    }
}
