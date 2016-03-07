<%@ page language="java"%>
<%@ taglib uri="/WEB-INF/struts-bean-1.2.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html-1.2.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic-1.2.tld" prefix="logic"%>
<html:html>
<head>
<title>Authentification</title>
<link rel="stylesheet" href="css/myCSS.css">
<html:base />
</head>
<body bgcolor="white">
	<html:form action="login" focus="nomUtilisateur">
		<table>
			<tr>
				<td align="right"><bean:message key="login.form.user" /></td>
				<td align="left"><html:text property="nomUtilisateur" size="20"
						maxlength="20" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="login.form.password" /></td>
				<td align="left"><html:password property="mdpUtilisateur"
						size="20" maxlength="20" redisplay="false" /></td>
			</tr>
			<tr>
				<td align="right"><html:submit property="submit"><bean:message key="login.form.button.submit"/></html:submit>
				</td>
				<td align="left"><html:reset><bean:message key="login.form.button.reset"/></html:reset></td>
			</tr>
		</table>
		<span style="color: red;"><html:errors /></span>
	</html:form>
</body>
</html:html>