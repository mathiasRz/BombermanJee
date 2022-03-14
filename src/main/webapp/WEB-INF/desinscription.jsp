<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Desinscription</title>
	</head>
	<body>
	<c:import url="/WEB-INF/librairies/header.jsp"/>
	<c:if test="${ !empty erreur }"><p style="color:red;"><c:out value="${ erreur }" /></p></c:if>
	
	<c:if test ="${ !empty valide }"><p><c:out value="${ valide }"/> </p></c:if>
	<c:import url="/WEB-INF/librairies/footer.jsp"/>
	</body>
</html>