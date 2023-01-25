<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

<h1>Hello Max</h1><br />

<h2>Все книги</h2><br />

<c:forEach var="book" items="${requestScope.books}">
    <ul>

        <li>Название книги: <c:out value="${book.title}"/></li>

        <li>Автор книги: <c:out value="${book.author}"/></li>
    </ul>
    <hr />

</c:forEach>

<h2>Добавление новой книги</h2><br />

<form method="post" action="">

    <label><input type="text" name="title"></label>Название книги<br>

    <label><input type="text" name="author"></label>Автор книги<br>
<!--     <label><input type="number" name="author"></label>Возраст<br> -->

    <input type="submit" value="Ok" name="Ok"><br>
</form>

</body>
</html>