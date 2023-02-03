<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<title>Library Market</title>
</head>
<body>
	<%@include file="/includes/navbar.jsp"%>
	<div class="container">
		<div class="card-header my-3">All Orders Books</div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
		</table>
	</div>
	<%@include file="/includes/footer.jsp"%>
</body>
</html>