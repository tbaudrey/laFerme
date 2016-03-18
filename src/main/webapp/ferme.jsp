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
        <title>Ferme</title>
    </head>
    <body>
        <c:import url="_MENU.jsp"/>
        
        - BLES plantes, quantite : ${quantiteBlePlante}
        <c:forEach items="${mesBlesPlantes}" var="monBleActuel">
            <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Temps restant avant recolte : ${monBleActuel.tempsRestant}, 
        </c:forEach>  
        <br>
        
        - CAROTTES plantes, quantite : ${quantiteCarottePlante}
        <c:forEach items="${mesCarottesPlantees}" var="maCarotteActuelle">
            <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Temps restant avant recolte : ${maCarotteActuelle.tempsRestant}, 
        </c:forEach>  
        <br> 
        
        - FROMAGE, quantite : ${quantiteFromage}
        <br> 
        
        - CHEVRES dans le pres, quantite : ${quantiteChevre}
        <c:forEach items="${mesChevres}" var="maChevreActuelle">
            <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - Date Accouplement : ${maChevreActuelle.dateAccouplement.getTime()}   et Temps restant avant de mourrir : ${maChevreActuelle.dateDerniereNutrition.getTime()}
            <a href="NourrirChevreServlet?id=${maChevreActuelle.id}">NOURRIR CETTE CHEVRE</a>
        </c:forEach> 
        <form action="AccouplerServlet" method="post">
            Nombre de chevre a accoupler : 
            <input type="text" name="quantiteChevreAAccoupler"/>
            <input type="submit" value="Accoupler"/>
        <br> 
        
        - FERMIER dans la ferme, quantite : ${quantiteFermier}
        <c:forEach items="${mesFermiers}" var="monFermierActuel">
            <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - ${monFermierActuel.name} Temps restant avant de mourrir : ${monFermierActuel.dateDerniereNutrition.getTime()}
            <!--<a href="NourrirFermierServlet?id=${monFermierActuel.id}">NOURRIR CE FERMIER AVEC : </a>--> 
            <form action="NourrirFermierServlet" method="post">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Nourrir ce fermier avec : 
                <select name="NourrirFermier">
                    <option value="1">ble</option>
                    <option value="2">carotte</option>
                    <option value="3">chevre</option>
                    <option value="4">fromage</option>
                </select>
                <input type="submit"/>
            <br>
            </form>
        </c:forEach>  
        <br>     
            
        <c:import url="_PIED.jsp"/>
    </body>
</html>
