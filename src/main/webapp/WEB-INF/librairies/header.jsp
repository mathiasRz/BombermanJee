<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="Servlet.AccueilServlet" %>
<%@ page import="Servlet.DeconnexionServlet" %>
<%@ page import="Servlet.ConnexionServlet" %>
<%@ page import="Servlet.InscriptionServlet" %>
<%@ page import="Servlet.BoutiqueServlet" %>
<%@ page import="Servlet.CompteServlet" %>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
  /* Remove the navbar's default rounded borders and increase the bottom margin */ 
  .navbar {
    margin-bottom: 50px;
    border-radius: 0;
  }
  
  /* Remove the jumbotron's default bottom margin */ 
   .jumbotron {
    margin-bottom: 0;
  }
 
  /* Add a gray background color and some padding to the footer */
  footer {
    background-color: #f2f2f2;
    
    margin-top: 30%;
    padding: 25px;
  }
  
  .form {
    margin-left: auto;
    margin-right: auto;
    width: 100px
}
</style>

<header>
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>                        
	      </button>
	      <div class="navbar-brand"><img src="images/bombe.png" style="height :25px;widht :30px;" alt="bombe"></div>
	    </div>
	    <div class="collapse navbar-collapse" id="myNavbar">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="<c:url value="${AccueilServlet.ACCUEIL_URL}"/>">Accueil</a></li>
	        <li><a href="<c:url value="${BoutiqueServlet.BOUTIQUE_URL}"/>"><span class="glyphicon glyphicon-shopping-cart"></span> Boutique</a></li>
	      </ul>
	      <c:if test="${ !empty sessionScope.nomSession }">
		      <ul class="nav navbar-nav navbar-right">
		        <li><a href="<c:url value="${CompteServlet.COMPTE_URL}"/>"><span class="glyphicon glyphicon-user"></span> Votre compte</a></li>
		        <li><a href="<c:url value="${DeconnexionServlet.DECONNEXION_URL}"/>"><span class="glyphicon glyphicon-log-out"></span> Se déconnecter</a></li>
		      </ul>
	    </c:if>
	    <c:if  test="${ empty sessionScope.nomSession }">
	    	<ul class="nav navbar-nav navbar-right">
	        	<li><a href="<c:url value="${InscriptionServlet.INSCRIPTION_URL}"/>"><span class="glyphicon glyphicon-user"></span> S'inscrire</a></li>
	        	<li><a href="<c:url value="${ConnexionServlet.CONNEXION_URL}"/>"><span class="glyphicon glyphicon-log-in"></span> Se connecter</a></li>
	      	</ul>
		</c:if>
	    </div>
	  </div>
	</nav>
</header>
