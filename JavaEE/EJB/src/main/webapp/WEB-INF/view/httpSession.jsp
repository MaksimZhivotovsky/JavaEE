<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

<h2>Hello Max</h2>
<br />

<p><c:out value = "${requestScope.dataForView}"/></p>

<br />
<form method="post" action="">
    <input type="text" name="data" />
    <input type="submit" value="Send" />
</form>

</body>
</html>