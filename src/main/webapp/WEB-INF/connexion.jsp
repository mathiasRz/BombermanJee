<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="Servlet.ConnexionServlet" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>connexion</title>
	</head>
	<body>
	<c:import url="/WEB-INF/librairies/header.jsp"/>
	<c:if test="${ !empty erreur }"><h1 style="color:red;text-align: center;"><c:out value="${ erreur }" /></h1></c:if>
	<c:if test ="${ empty form.resultat }">
	  <div class="form">
		<form method="post" action="<c:url value="${ConnexionServlet.CONNEXION_URL}"/>">
			<div>
			    <input type="text" name="nom" id="nom" placeholder="identifiant" required>
		  	</div>
		  	<br/>
		  	<div>
			    <input type="password" name="mdp" id="mdp" placeholder="mot de passe" required>
		  	</div>
		  	<br/>
		  	<div>
			    <input type="submit" name="valider" id="valider" value="Se connecter">
		  	</div>
		</form>
	  </div>
	</c:if>
	<c:if test ="${ !empty form.resultat }"><h1 style="text-align: center;"><c:out value="${ form.resultat }"/> </h1></c:if>
	<c:import url="/WEB-INF/librairies/footer.jsp"/>
	</body>
</html>