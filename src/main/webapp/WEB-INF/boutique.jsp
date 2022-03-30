<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="Servlet.BoutiqueServlet" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>boutique</title>
		<style>
			.dimension {
  				height: 330px;
 				width: 340px;
			}
		</style>
	</head>
	<body>
	<c:import url="/WEB-INF/librairies/header.jsp"/>
		<c:if test="${ !empty sessionScope.nomSession }">
	        <h1 style="text-align: center">${ sessionScope.nomSession } vous avez ${ bucks } bucks en votre possession</h1>
    	</c:if>
    	<c:if test="${ empty sessionScope.nomSession }">
	        <h1 style="text-align: center">pour pouvoir intéragir avec les skins, veuillez vous connecter ! </h1>
    	</c:if>
    	<c:if test="${ !empty erreur }"><h1 style="color:red;text-align: center;"><c:out value="${ erreur }" /></h1></c:if>
    	<div class="container">    
		  <div class="row"> 
		    <div class="col-sm-4"> 
		      <div class="panel panel-default">
		        <div class="panel-heading" style="text-align: center">Bomberman white</div>
		        <div class="panel-body"><img src="images/bomberman_white.png" class="dimension" alt="bomberman_white"></div>
		        <input type="hidden" name="skin" value="white">
		        <c:if test="${ empty sessionScope.nomSession }">
		        	<div class="panel-footer" style="text-align: center">gratuit à l'inscription</div>
		        </c:if>
		        <c:if test="${ !empty sessionScope.nomSession }">
		        	<div class="panel-footer" style="text-align: center">possédé</div>
		        </c:if>
		      </div>
		    </div>
		    <div class="col-sm-4"> 
		      <div class="panel panel-default">
		        <div class="panel-heading" style="text-align: center">Bomberman black</div>
		        <div class="panel-body"><img src="images/bomberman_black.png" class="dimension" alt="bomberman_black"></div>
		        <div class="panel-footer" style="text-align: center">
		        	<c:if test="${ empty sessionScope.nomSession }">100 Bucks</c:if>
		        	<c:if test="${ !empty sessionScope.nomSession && skins[1]==1 }">possédé</c:if>
		        	<c:if test="${ !empty sessionScope.nomSession && skins[1]==0 }">
			        	<form method="post" action="<c:url value="${BoutiqueServlet.BOUTIQUE_URL}" />">
			        		<input type="hidden" name="skin" value="black">
			        		<input type="hidden" name="valeur" value="100">
			        		<input type="submit" name="achat" value="100 Bucks"/>
			        	</form>
		        	</c:if>
		        </div>
		      </div>
		    </div>
		    <div class="col-sm-4"> 
		      <div class="panel panel-default">
		        <div class="panel-heading" style="text-align: center">Bomberman lady</div>
		        <div class="panel-body"><img src="images/bomberman_lady.png" class="dimension" alt="bomberman_lady"></div>
		        <div class="panel-footer" style="text-align: center">
		        	<c:if test="${ empty sessionScope.nomSession }">100 Bucks</c:if>
		        	<c:if test="${ !empty sessionScope.nomSession && skins[2]==1 }">possédé</c:if>
		        	<c:if test="${ !empty sessionScope.nomSession && skins[2]==0 }">
			        	<form method="post" action="<c:url value="${BoutiqueServlet.BOUTIQUE_URL}" />">
			        		<input type="hidden" name="skin" value="lady">
			        		<input type="hidden" name="valeur" value="100">
			        		<input type="submit" name="achat" value="100 Bucks"/>
			        	</form>
		        	</c:if>
		        </div>
		      </div>
		    </div>
		  </div>
	    </div><br>
		
		<div class="container">    
		  <div class="row">
		    <div class="col-sm-4"> 
		      <div class="panel panel-info">
		        <div class="panel-heading" style="text-align: center">Bomberman magnet</div>
		        <div class="panel-body"><img src="images/bomberman_magnet.png" class="dimension" alt="bomberman_magnet"></div>
		        <div class="panel-footer" style="text-align: center">
		        	<c:if test="${ empty sessionScope.nomSession }">500 Bucks</c:if>
		        	<c:if test="${ !empty sessionScope.nomSession && skins[3]==1 }">possédé</c:if>
		        	<c:if test="${ !empty sessionScope.nomSession && skins[3]==0 }">
			        	<form method="post" action="<c:url value="${BoutiqueServlet.BOUTIQUE_URL}" />">
			        		<input type="hidden" name="skin" value="magnet">
			        		<input type="hidden" name="valeur" value="500">
			        		<input type="submit" name="achat" value="500 Bucks"/>
			        	</form>
		        	</c:if>
		        </div>
		      </div>
		    </div>
		   	<div class="col-sm-4"> 
		      <div class="panel panel-info">
		        <div class="panel-heading" style="text-align: center">Bomberman plasma</div>
		        <div class="panel-body"><img src="images/bomberman_plasma.png" class="dimension" alt="bomberman_plasma"></div>
		        <div class="panel-footer" style="text-align: center">
		        	<c:if test="${ empty sessionScope.nomSession }">500 Bucks</c:if>
		        	<c:if test="${ !empty sessionScope.nomSession && skins[4]==1 }">possédé</c:if>
		        	<c:if test="${ !empty sessionScope.nomSession && skins[4]==0 }">
			        	<form method="post" action="<c:url value="${BoutiqueServlet.BOUTIQUE_URL}" />">
			        		<input type="hidden" name="skin" value="plasma">
			        		<input type="hidden" name="valeur" value="500">
			        		<input type="submit" name="achat" value="500 Bucks"/>
			        	</form>
		        	</c:if>
		        </div>
		      </div>
		    </div>
		    <div class="col-sm-4"> 
		      <div class="panel panel-info">
		        <div class="panel-heading" style="text-align: center">Bomberman pretty</div>
		        <div class="panel-body"><img src="images/bomberman_pretty.png" class="dimension" alt="bomberman_pretty"></div>
		        <div class="panel-footer" style="text-align: center">
		        	<c:if test="${ empty sessionScope.nomSession }">500 Bucks</c:if>
		        	<c:if test="${ !empty sessionScope.nomSession && skins[5]==1 }">possédé</c:if>
		        	<c:if test="${ !empty sessionScope.nomSession && skins[5]==0 }">
			        	<form method="post" action="<c:url value="${BoutiqueServlet.BOUTIQUE_URL}" />">
			        		<input type="hidden" name="skin" value="pretty">
			        		<input type="hidden" name="valeur" value="500">
			        		<input type="submit" name="achat" value="500 Bucks"/>
			        	</form>
		        	</c:if>
		        </div>
		      </div>
		    </div>
		  </div>
		</div><br> 
		
		  <div class="container">    
		  <div class="row"> 
		    <div class="col-sm-4"> 
		      <div class="panel panel-danger">
		        <div class="panel-heading" style="text-align: center">Bomberman golem</div>
		        <div class="panel-body"><img src="images/bomberman_golem.png" class="dimension" alt="bomberman_golem"></div>
		        <div class="panel-footer" style="text-align: center">
		        	<c:if test="${ empty sessionScope.nomSession }">1000 Bucks</c:if>
		        	<c:if test="${ !empty sessionScope.nomSession && skins[6]==1 }">possédé</c:if>
		        	<c:if test="${ !empty sessionScope.nomSession && skins[6]==0 }">
			        	<form method="post" action="<c:url value="${BoutiqueServlet.BOUTIQUE_URL}" />">
			        		<input type="hidden" name="skin" value="golem">
			        		<input type="hidden" name="valeur" value="1000">
			        		<input type="submit" name="achat" value="1000 Bucks"/>
			        	</form>
		        	</c:if>
		        </div>
		      </div>
		    </div>
		    <div class="col-sm-4"> 
		      <div class="panel panel-danger">
		        <div class="panel-heading">Bomberman regulus bullzeeb</div>
		        <div class="panel-body"><img src="images/bomberman_regulus_bullzeeb.png" class="dimension" alt="bomberman_regulus_bullzeeb"></div>
		        <div class="panel-footer" style="text-align: center">
		        	<c:if test="${ empty sessionScope.nomSession }">1000 Bucks</c:if>
		        	<c:if test="${ !empty sessionScope.nomSession && skins[7]==1 }">possédé</c:if>
		        	<c:if test="${ !empty sessionScope.nomSession && skins[7]==0 }">
			        	<form method="post" action="<c:url value="${BoutiqueServlet.BOUTIQUE_URL}" />">
			        		<input type="hidden" name="skin" value="regulus_bullzeeb">
			        		<input type="hidden" name="valeur" value="1000">
			        		<input type="submit" name="achat" value="1000 Bucks"/>
			        	</form>
		        	</c:if>
		        </div>
		      </div>
		    </div>  
		    <div class="col-sm-4"> 
		      <div class="panel panel-danger">
		        <div class="panel-heading" style="text-align: center">Bomberman brain</div>
		        <div class="panel-body"><img src="images/bomberman_brain.png" class="dimension" alt="bomberman_brain"></div>
		        <div class="panel-footer" style="text-align: center">
		        	<c:if test="${ empty sessionScope.nomSession }">2000 Bucks</c:if>
		        	<c:if test="${ !empty sessionScope.nomSession && skins[8]==1 }">possédé</c:if>
		        	<c:if test="${ !empty sessionScope.nomSession && skins[8]==0 }">
			        	<form method="post" action="<c:url value="${BoutiqueServlet.BOUTIQUE_URL}" />">
			        		<input type="hidden" name="skin" value="brain">
			        		<input type="hidden" name="valeur" value="2000">
			        		<input type="submit" name="achat" value="2000 Bucks"/>
			        	</form>
		        	</c:if>
		        </div>
		      </div>
		    </div>
		  </div>
		</div><br> 
    <c:import url="/WEB-INF/librairies/footer.jsp"/>
	</body>
</html>