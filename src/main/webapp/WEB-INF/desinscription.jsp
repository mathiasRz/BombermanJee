<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>desinscription</title>
	</head>
	<body>
	<c:import url="/WEB-INF/librairies/header.jsp"/>
	<c:if test="${ !empty erreur }"><h1 style="color:red;text-align: center;"><c:out value="${ erreur }" /></h1></c:if>
	
	<c:if test ="${ !empty valide }"><h1 style="text-align: center;"><c:out value="${ valide }"/> </h1></c:if>
	<c:import url="/WEB-INF/librairies/footer.jsp"/>
	</body>
</html>