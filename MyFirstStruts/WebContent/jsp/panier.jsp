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
<title>Panier</title>
<link rel="stylesheet" href="css/myCSS.css">
</head>
<body>
	<span>Panier</span>
	<table>
		<tr>
			<th>REFERENCE</th>
			<th>PRODUIT</th>
			<th>QUANTITE</th>
			<th></th>
		</tr>
		<c:forEach items="${panier}" var="produit">
			<tr>
				<td><c:out value="${produit.key}"></c:out></td>
				<td><c:forEach items="${catalogue}" var="produitCatalogue">
						<c:if test="${produit.key == produitCatalogue.value.idReference}">
							<c:out value="${produitCatalogue.value.nomProduit}"></c:out>
						</c:if>

					</c:forEach></td>
				<td><c:out value="${produit.value}"></c:out></td>
				<td><a href="retirer.do?idReference=${produit.key}"><button>-</button></a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="catalogue.do"><button>Accueil</button></a>
	<a href="vider.do"><button>Vider le Panier</button></a>
</body>
</html>