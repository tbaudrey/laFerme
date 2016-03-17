<%-- 
    Document   : _MENU
    Created on : 8 mars 2016, 14:52:41
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="menu">
    <a href="RessourcesDispoServlet">Ressources disponibles</a>
    <a href="FermeServlet">Ferme</a>
    <c:if test="${sessionScope.login==null}">
        <a href="login.jsp">Connexion</a>
    </c:if>
    <c:if test="${sessionScope.login!=null}">
        <a href="se_deconnecter">Deconnexion</a>
    </c:if>
    Bonjour ${sessionScope.login}
</div>
