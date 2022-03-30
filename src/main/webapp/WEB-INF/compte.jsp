<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="Servlet.CompteServlet" %>
<%@ page import="Servlet.DesinscriptionServlet" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>compte</title>
		<style>
			.dimension {
  				height: 330px;
 				width: 340px;
			}
		</style>
	</head>
	<body>
	<c:import url="/WEB-INF/librairies/header.jsp"/>
	    <h1 style="text-align: center">connecté en tant que ${ sessionScope.nomSession } vous avez ${ bucks } bucks</h1>
	    <div class="form">
    	<form method="post" action="<c:url value="${DesinscriptionServlet.DESINSCRIPTION_URL}" />">
			<input type="submit" name="achat" value="supprimer mon compte" class="btn btn-danger"/>
		</form>
		</div>
    <c:import url="/WEB-INF/librairies/footer.jsp"/>
	</body>
</html>