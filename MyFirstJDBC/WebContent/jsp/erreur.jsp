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
	</head>
	<body>
		<h1>Une erreur est survenue lors des traitements</h1>
		<div class="fondBlanc">${message}</div>
		<a href="afficheCatalogue.do">
			<button class="projectButtonTop"><bean:message key="panier.bouton.accueil" /></button>
		</a>
	</body>
</html:html>