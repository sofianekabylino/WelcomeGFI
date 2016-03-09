<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean-1.2.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html-1.2.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic-1.2.tld" prefix="logic"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<title><bean:message key="panier.nomPage" /></title>
	<html:base />
</head>
<body>
	<h1><bean:message key="panier.titre" /></h1>
	<div class="fondBlanc">
		<div id="alignRight">	
			<bean:message key="session.nbArticles" />
			<c:out value="${nbArticles}" />
		</div>
		<h3>
			<bean:message key="panier.soustitre" />
		</h3>
		<c:if test="${not empty panier}">
		<table>
			<tr>
				<th align="left"><bean:message key="general.tableau.reference" /></th>
				<th align="left"><bean:message key="general.tableau.nomProduit" /></th>
				<th align="left"><bean:message key="general.tableau.quantite" /></th>
				<th></th>
			</tr>
			<c:forEach items="${panier}" var="produitPanier" varStatus="status1">
				<tr>
					<td align="left"><c:out value="${produitPanier.key}" /></td>
					<td align="left"><c:out value="${catalogue[produitPanier.key].nomProduit}" /></td>
					<td align="left"><c:out value="${produitPanier.value}" /></td>
					<td>
						<a href="../suppressionProduit.do?reference=${produitPanier.key}">
							<button type="submit" class="projectButtonTop">
								<bean:message key="panier.tableau.suppression" />
							</button>
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		</c:if>
		<p>
			<a href="../afficheCatalogue.do">
				<button type="submit" class="projectButtonTop">
					<bean:message key="panier.bouton.accueil" />
				</button>
			</a>
			<a href="../viderPanier.do">
				<button type="submit" class="projectButtonTop">
					<bean:message key="general.bouton.viderPanier" />
				</button>
			</a>
			<a href="../validerCommande.do">
				<button type="submit" class="projectButtonTop">
					<bean:message key="general.bouton.validerPanier" />
				</button>
			</a>
		</p>
	</div>
</body>
</html:html>