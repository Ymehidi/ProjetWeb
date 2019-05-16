<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="data.Adresse,data.Personne,java.util.Collection" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form method="get" action="/Web3_BaseDonnee/index.html">
	<%
	Collection<Personne> listePersonnes = (Collection<Personne>) request.getAttribute("listePersonnes");
	%>
	<%for (Personne personne : listePersonnes) {%>
		<%=personne.getNom()%> <%=personne.getPrenom()%> :<br>
		<blockquote>
		<%for (Adresse adresse : personne.getAdresses()) {%>
			<%=adresse.getRue()%>, <%=adresse.getVille()%><br>
		<%}%>
		</BLOCKQUOTE>
	<%}%>
</form>
</body>
</html>
