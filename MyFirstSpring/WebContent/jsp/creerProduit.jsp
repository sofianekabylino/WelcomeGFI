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
	<title><bean:message key="creationProduit.nomPage" /></title>
	<html:base />
</head>
<body>
<h1><bean:message key="creer.form.ajouterProduit"/></h1>
<div class="fondBlanc">
	<html:form action="creerProduit" focus="reference">
		<table>
			<tr>
				<td align="right"><bean:message key="creer.form.reference" /></td>
				<td align="left"><html:text property="idProduit" size="20" maxlength="20" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="creer.form.nom" /></td>
				<td align="left"><html:text property="nomProduit" size="20" maxlength="20" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="creer.form.prix" /></td>
				<td align="left"><html:text property="prixProduit" size="20" maxlength="20" /></td>
			</tr>
			<tr>
				<td align="right"><html:submit property="submit"><bean:message key="creer.form.submit"/></html:submit></td>
				<td align="left"><html:reset /></td>
			</tr>
		</table>
		<span style="color: red;"> <html:errors />
		</span>
	</html:form>
	<a href="../afficheCatalogue.do">
		<button class="projectButtonTop"><bean:message key="panier.bouton.accueil" /></button>
	</a>
	</div>
</body>
</html:html>