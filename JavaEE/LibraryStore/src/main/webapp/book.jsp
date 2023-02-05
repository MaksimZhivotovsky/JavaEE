<%@page import="max.connection.DbCon"%>
<%-- <%@page import="max.dao.ProductDao"%> --%>
<%@page import="max.model.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
		<%
	User auth = (User) request.getSession().getAttribute("auth");
	if(auth != null) {
		request.setAttribute("auth", auth);
	}
	%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<title>Library Market</title>

</head>
<body>
	<%@include file="/includes/navbar.jsp"%>

	<%@include file="/includes/footer.jsp"%>
</body>
</html>