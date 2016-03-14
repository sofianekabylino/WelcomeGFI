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
	<title><bean:message key="accueil.nomPage" /></title>
	<html:base />
</head>
<body>
	<h1><bean:message key="accueil.titre" /></h1>
	<div class="fondBlanc">
		<div id="alignRight">
			<bean:message key="session.nbArticles" />
			<c:out value="${nbArticles}" />
		</div>
		<h3>
			<bean:message key="accueil.soustitre" />
		</h3>
		<div class="liste">
		<table>
			<tr>
				<th align="left"><bean:message key="general.tableau.reference" /></th>
				<th align="left"><bean:message key="general.tableau.nomProduit" /></th>
				<th></th>
			</tr>
			<c:forEach items="${catalogue}" var="produit" varStatus="status1">
				<tr>
					<td align="left"><c:out value="${produit.value.idProduit}" /></td>
					<td align="left"><c:out value="${produit.value.nomProduit}" /></td>
					<td>
						<a href="../ajoutProduit.do?reference=${produit.value.idProduit}">
							<button><bean:message key="accueil.tableau.ajouter" /></button>
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		</div>
		<p>
			<a href="../affichePanier.do">
				<button type="submit" class="projectButtonTop"><bean:message key="accueil.bouton.votrePanier" /></button>
			</a>
			<a href="../affichageFormCreationProduit.do">
				<button type="submit" class="projectButtonTop"><bean:message key="accueil.bouton.creer" /></button>
			</a>
			<a href="../viderPanier.do">
				<button type="submit" class="projectButtonTop"><bean:message key="general.bouton.viderPanier" /></button>
			</a>
		</p>
	</div>
</body>
</html:html>