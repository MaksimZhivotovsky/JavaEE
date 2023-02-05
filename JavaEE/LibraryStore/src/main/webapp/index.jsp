<%@page import="max.model.Book"%>
<%@page import="java.util.List"%>
<%@page import="max.model.User"%>
<%@page import="max.dao.BookDao"%>
<%@page import="max.connection.DbCon"%>
<%@page import="org.hibernate.dialect.DB2390Dialect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
}

BookDao bookDao = new BookDao(DbCon.getConnection());
List<Book> books = bookDao.getAllBooks();
%>

<!DOCTYPE html>
<html>
<head>
<title>Welcome to Library Market</title>
<%@include file="/includes/head.jsp"%>

</head>
<body>
	<%@include file="/includes/navbar.jsp"%>

	<div class="container">
		<div class="card-header my-3">All Books</div>
		<div class="row">
			<%
			if (!books.isEmpty()) {
				for (Book b : books) {
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100" style="width: 18rem;">
					<img class="book-img-top" src="book-image/<%= b.getImage() %>"
						alt="Book image book">
					<div class="books-body">
						<h5 class="books-author"><%= b.getAuthor() %></h5>
						<h5 class="books-title"><%= b.getTitle() %></h5>
						<h6 class="books-price"><%= b.getPrice() %></h6>
						<h6 class="books-category"><%= b.getCategory() %></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a href="#" class="btn btn-primary">Add to Card</a> 
							<a href="#" class="btn btn-primary">Buy Now</a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			} else {
				out.println("There is no books");
				}
			%>


		</div>
	</div>

	<%@include file="/includes/footer.jsp"%>
</body>
</html>