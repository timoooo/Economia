<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="includes/bootstrapMeta.inc"%>
<%@include file="includes/bootstrapCss.css"%>
<html>
<head>
<title>OOPS SOMETHING WENT WRONG</title>
<!-- <form action="register" method="get">
	<input type="submit" class="btn btn-lg btn-primary btn-block"
		value="Back to the Start-Page" /> 
</form>-->
</head>
<body>
	<div class="row">
		<div class="col-md-3 col-md-offset-5">
			<h2>OOPS SOMETHING WENT WRONG!!!!</h2>

			<c:if test="${not empty errorMessage}">
				<div class="alert alert-dismissible alert-danger">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<strong>Oh snap!</strong> <a href="#" class="alert-link">Change
						a few things up</a> and try submitting again. ._. ..i..
				</div>
				<div class="well">${errorMessage}</div>
			</c:if>

			<div align="center">
				<form action="register" method="get">
					<button type="submit" action="regProcess" class="btn btn-success">Try
						again</button>
				</form>
				<form action="login" method="get">
					<button type="submit" method="get" action="login"
						class="btn btn-info">Login-Page</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>