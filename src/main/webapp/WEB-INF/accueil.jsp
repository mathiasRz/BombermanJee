<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>accueil</title>
	</head>
	<body>
	<c:import url="/WEB-INF/librairies/header.jsp"/>
		<h1>Bienvenue</h1>
		<c:if test="${ !empty sessionScope.nomSession }">
	        <p>connecté en tant que ${ sessionScope.nomSession } </p>
    	</c:if>
    <c:import url="/WEB-INF/librairies/footer.jsp"/>
	</body>
</html>