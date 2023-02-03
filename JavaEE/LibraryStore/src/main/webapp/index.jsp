<%@page import="max.connection.DbCon"%>
<%@page import="org.hibernate.dialect.DB2390Dialect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome to Library Market</title>
<%@include file="/includes/head.jsp"%>

</head>
<body>
	<%@include file="/includes/navbar.jsp"%>

	<% out.print(DbCon.getConnection()); %>

	<%@include file="/includes/footer.jsp"%>
</body>
</html>