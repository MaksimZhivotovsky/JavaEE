<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<div>Название книги: <c:out value="${requestScope.book.title}"/> </div>
<div>Автор книги: <c:out value="${requestScope.book.author}"/> </div>

<br />

<form method="post" action="<c:url value='/update'/>">

    <label>Новое название: <input type="text" name="title" /></label><br>

    <label>Новый автор: <input type="text" name="author" /></label><br>

    <input type="number" hidden name="id" value="${requestScope.book.id}"/>

    <input type="submit" value="Ok" name="Ok"><br>
</form>
</body>
</html>