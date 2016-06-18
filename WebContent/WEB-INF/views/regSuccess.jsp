<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="includes/bootstrapMeta.inc"%>
<%@include file="includes/bootstrapCss.css"%>
<html>
<head>

<title>Registration Successful!</title>
</head>
<body>
	<div class="row">
		<div class="col-md-3 col-md-offset-5">

			<div class="alert alert-dismissible alert-success">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>Well done!</strong> You successfully signed up for <a
					href="#" class="alert-link">Economia</a>.

			</div>
			<table class="table table-striped table-hover ">

				<tr>
					<td>User Name:</td>
					<td>${username}</td>
				</tr>
				<tr>
					<td>E-mail:</td>
					<td>${email}</td>
				</tr>
				<tr>
					<td>Password:</td>
					<td>:^) I am just joking! You are not going to see the
						Password in Cleartext</td>
				</tr>

			</table>

			<form action="login" method="get">
				<div align="center">
					<button type="submit" method="get" action="login"
						class="btn btn-info">Play</button>
				</div>
			</form>




			<%-- <table border="0" class="table table-striped table-hover ">
				<tr class="active">
					<td class="form-signin-heading" colspan="2" align="center"><h2>Registration
							Succeeded!</h2></td>
				</tr>
				<tr>
					<td class="form-signin-heading" colspan="2" align="center">
						<h3>Thank you for registering! Here's the review of your
							details:</h3>
					</td>
				</tr>
				<tr>
					<td>User Name:</td>
					<td>${username}</td>
				</tr>
				<tr>
					<td>E-mail:</td>
					<td>${email}</td>
				</tr>
				<tr>
					<td>Password</td>
					<td>${password}</td>
				</tr>



			</table> --%>
		</div>
	</div>
</body>
</html>