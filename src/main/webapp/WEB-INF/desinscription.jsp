<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="Servlet.AccueilServlet" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Desinscription</title>
	</head>
	<body>
	<c:if test="${ !empty erreur }"><p style="color:red;"><c:out value="${ erreur }" /></p></c:if>
	
	<c:if test ="${ !empty valide }"><p><c:out value="${ valide }"/> </p></c:if>
	<a href="<c:url value="${AccueilServlet.ACCUEIL_URL}"/>">Retour à l'accueil</a>
</html>