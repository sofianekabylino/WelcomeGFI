<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-bean-1.2.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html-1.2.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic-1.2.tld" prefix="logic" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
  <head>
    <title>Accueil</title>
    <html:base/>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  </head>
  <body bgcolor="white">
     <h1> <bean:message key="page.welcome.text"/> <bean:write name="loginForm" property="nomUtilisateur"/></h1>
  </body>
</html:html>