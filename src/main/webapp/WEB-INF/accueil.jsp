<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="Servlet.InscriptionServlet" %>
<%@ page import="Servlet.ConnexionServlet" %>
<%@ page import="Servlet.DeconnexionServlet" %>
<%@ page import="Servlet.DesinscriptionServlet" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>accueil</title>
	</head>
	<body>
		<h1>Bienvenue</h1>
		<c:if test="${ !empty sessionScope.nomSession }">
	        <p>connecté en tant que ${ sessionScope.nomSession } </p>
	        <a href="<c:url value="${DeconnexionServlet.DECONNEXION_URL}"/>">Se déconnecter</a>
	        <a href="<c:url value="${DesinscriptionServlet.DESINSCRIPTION_URL}"/>">Se désinscrire</a>
    	</c:if>
		<c:if  test="${ empty sessionScope.nomSession }">
			<a href="<c:url value="${InscriptionServlet.INSCRIPTION_URL}"/>">S'inscrire</a>
			<a href="<c:url value="${ConnexionServlet.CONNEXION_URL}"/>">Se connecter</a>
		</c:if>
	</body>
</html>