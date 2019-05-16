<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="data.Adresse,data.Personne,java.util.Collection" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form method="get" action="/Web3_BaseDonnee/ServletOp">
	<%
	Collection<Personne> listePersonnes = (Collection<Personne>) request.getAttribute("listePersonnes");
	Collection<Adresse> listeAdresses = (Collection<Adresse>) request.getAttribute("listeAdresses");
	%>

	Choisir la personne :<br>
	<%for (Personne personne : listePersonnes) {%>
		<input type="radio" name="personne" value=<%=Integer.toString(personne.getId())%>> <%=personne.getNom()%> <%=personne.getPrenom()%><br>
	<%}%>
	<br>
	Choisir l'adresse   :<br>
	<%for (Adresse adresse : listeAdresses) {%>
		<input type="radio" name="adresse" value=<%=Integer.toString(adresse.getId())%>> <%=adresse.getRue()%>, <%=adresse.getVille()%><br>
	<%}%>
	<br>
	<input type="submit" value="OK" >
	<input type="hidden" name="op" value="creerLien">
</form>
</body>
</html>
