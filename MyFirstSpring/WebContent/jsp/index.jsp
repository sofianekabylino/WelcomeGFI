<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean-1.2.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html-1.2.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic-1.2.tld" prefix="logic"%>
<html:html lang="true">
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<title><bean:message key="login.form.nomPage" /></title>
	<html:base />
</head>
<body>
	<h1><bean:message key="index.authentification"/></h1>
	<div  class="authentification">
	<html:form action="login" focus="nomUtilisateur">
		<table>
			<tr>
				<td align="right"><bean:message key="login.form.user" /></td>
				<td align="left"><html:text property="nomUtilisateur" size="20" maxlength="20" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="login.form.password" /></td>
				<td align="left"><html:password property="mdpUtilisateur" size="20" maxlength="20" redisplay="false" /></td>
			</tr>
			<tr>
				<td align="right"><html:submit property="submit"><bean:message key="login.form.submit"/></html:submit></td>
				<td align="left"><html:reset ><bean:message key="login.form.reset"/></html:reset></td>
			</tr>
		</table>
		<span style="color: red;"> <html:errors />
		</span>
	</html:form>
	</div>
</body>
</html:html>