<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-bean-1.2.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html-1.2.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic-1.2.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catalogue</title>
<link rel="stylesheet" href="css/myCSS.css">
</head>
<body>
	<span>Catalogue</span>
	<p>Nb Articles : <c:out value="${taillePanier}"></c:out></p>
	<table>
		<tr>
			<th>REFERENCE</th>
			<th>PRODUIT</th>
			<th></th>
		</tr>
		<c:forEach items="${catalogue}" var="produit">
			<tr>
				<td><c:out value="${produit.value.idReference}"></c:out></td>
				<td><c:out value="${produit.value.nomProduit}"></c:out></td>
				<td><a href="ajouter.do?idReference=${produit.value.idReference}"><button>+</button></a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="panier.do"><button>Voir Panier</button></a>
	<a href="vider.do"><button>Vider le Panier</button></a>
</body>
</html>