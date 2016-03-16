<%-- 
    Document   : lister_films
    Created on : 8 mars 2016, 15:14:00
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:import url="_CSS.jsp"/>
        <c:import url="_TITRE.jsp"/>
        <title>Ressources disponibles</title>
    </head>
    <body>
        <c:import url="_MENU.jsp"/>
        
        - BLE non plante, quantite : ${quantiteBleNonPlante}
        <br>
        <br>
        <form action="PlanterServlet" method="post">
            PLANTER : Nombre
            <input name="quantiteBleAPlanter" type="number" min="0" max="${quantiteBleNonPlante}" required="true" />
            <input type="submit"/>
        </form>
        <br>
        
        - CAROTTE non plante, quantite : ${quantiteCarotteNonPlante}
        <br>
        <br>
        <form action="PlanterServlet" method="post">
            PLANTER : Nombre
            <input name="quantiteCarotteAPlanter" type="number" min="0" max="${quantiteCarotteNonPlante}" required="true" />
            <input type="submit"/>
        </form>
        <br>
        
        - CHEVRE, quantite : ${quantiteChevre}
        <br>
        <br>
        <br>
        
        - FROMAGE, quantite : ${quantiteFromage}
        <br><br><br><br><br><br>
        
        
        
        <form action="EchangerServlet" method="post">
            ECHANGER  : 
            <input type="text" name="quantiteAEchanger"/>
            <select name="Echange1">
                <option value="1">ble</option>
                <option value="2">carotte</option>
                <option value="3">chevre</option>
                <option value="4">fromage</option>
            </select>
            CONTRE
            <select name="Echange2">
                <option value="1">ble</option>
                <option value="2">carotte</option>
                <option value="3">chevre</option>
                <option value="4">fromage</option>
            </select>
            <input type="submit"/> (Rappel : 1 chevre = 2 carottes = 2 fromages = 4 bles)
            <br>
        </form>
        
        <c:import url="_PIED.jsp"/>
    </body>
</html>
