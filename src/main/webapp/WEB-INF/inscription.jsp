<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="Servlet.AccueilServlet" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Inscription</title>
	</head>
	<body>
		<c:if test="${ !empty erreur }"><p style="color:red;"><c:out value="${ erreur }" /></p></c:if>
		<c:if test ="${ empty form.resultat }">
			<form method="post" action="<c:url value="${InscriptionServlet.INSCRIPTION_URL}"/>">
				<div>
				    <label for="nom">Entrez un pseudo : </label>
				    <input type="text" name="nom" id="nom" required>
			  	</div>
			  	<div>
				    <label for="nom">Entrez un mot de passe : </label>
				    <input type="password" name="mdp" id="mdp" required>
			  	</div>
			  	<div>
				    <label for="nom">Entrez Votre nationalité : </label>
				    <input type="text" name="pays" id="pays" required>
			  	</div>
			  	<div>
				    <input type="submit" name="valider" id="valider" value="valider">
			  	</div>
			</form>
		</c:if>
		<c:if test ="${ !empty form.resultat }"><p><c:out value="${ form.resultat }"/> </p></c:if>
		<a href="<c:url value="${AccueilServlet.ACCUEIL_URL}"/>">Retour à l'accueil</a>
	</body>
	
</html>