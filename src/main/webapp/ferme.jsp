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
            - Temps restant avant récolte : ${monBleActuel.tpsRestant}, 
        </c:forEach>  
        <br>
        
        - CAROTTES plantes, quantite : ${quantiteCarottePlante}
        <c:forEach items="${mesCarottesPlantees}" var="maCarotteActuelle">
            <br>
            - Temps restant avant récolte : ${maCarotteActuelle.tpsRestant}, 
        </c:forEach>  
        <br> 
        
        - CHEVRES dans le pres, quantite : ${quantiteChevre}
        <c:forEach items="${mesChevres}" var="maChevreActuelle">
            <br>
            - Temps restant avant de mourrir : ${maChevreActuelle.tpsRestant} 
            <a href="NourrirServlet?id=${maChevreActuelle.id}">NOURRIR cette chevre</a>
        </c:forEach>  
        <br> 
        
        - FERMIER dans la ferme, quantite : ${quantiteFermier}
        <c:forEach items="${mesFermiers}" var="monFermierActuel">
            <br>
            - Temps restant avant de mourrir : ${monFermierActuel.tpsRestant} 
            <a href="NourrirServlet?id=${monFermierActuel.id}">NOURRIR ce fermier</a>
        </c:forEach>  
        <br>     
            
        <c:import url="_PIED.jsp"/>
    </body>
</html>
