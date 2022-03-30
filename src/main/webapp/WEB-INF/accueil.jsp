<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>accueil</title>
		
		<style>
		.img_accueil {
			display: block;
			margin-left: auto;
    		margin-right: auto;
    		height : 600px;
    		width : 600px;
    		
		}
		</style>
	</head>
	<body>
	<c:import url="/WEB-INF/librairies/header.jsp"/>
		<c:if test="${ !empty sessionScope.nomSession }">
	        <h1 style="text-align: center">Bienvenue ${ sessionScope.nomSession } </h1>
    	</c:if>
    	<c:if test="${ empty sessionScope.nomSession }">
	        <h1 style="text-align: center">Bienvenue </h1>
    	</c:if>
    	<div ><img src="images/image_accueil.png"  alt="bomberman" class="img_accueil" ></div>
    <c:import url="/WEB-INF/librairies/footer.jsp"/>
	</body>
</html>