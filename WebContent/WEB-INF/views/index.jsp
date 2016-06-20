<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="includes/bootstrapMeta.inc"%>
<title>Economia Admin Page</title>
<%@include file="includes/bootstrapCss.css"%>
<%@include file="includes/treeView.css"%>



</head>
<body class="" sytle="">
	<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
				<div class="container">
				<div class="navbar-header">
					 <p class="navbar-text"><font color=#ee4d2e><b>Economia</b></font></p>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active">
							<a href="list">My Castle</a>
						</li>
						<li>
							<a href="buildings">Buildings</a>
						</li>
						<li>
							<a href="recruits">Recruits</a>
						</li>
						<li>
							<a href="trade">Trade</a>
						</li>
						<li>
							<a href="fight">Fight</a>
						</li>

						

					</ul>
					
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a class="btn btn-info" href="history"><font color=#fff>History</font></a>
						</li>
						<li>
						`
						</li>
						<li>
							<a class="btn btn-danger" href="logout"><font color=#fff>Logout</font></a>
							</li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</div>
				
	<div class="container">
		<div class="jumbotron">
			<center>
				<h1>${type}</h1>
				<br>
				<!--  search by Id ----------------------------------------------------------- -->
				<form action="findById" method="post">
					Find by Id: <input type="text" name="id"> <input
						type="submit" value="Do it">
				</form>
				<hr>
	
				<!--  paging ----------------------------------------------------------- -->
				<form action="getPage" method="post">
					Paging: Page:<input type="text" name="page" value="0"> Size:<input
						type="text" name="size" value="10"> <input type="submit"
						value="Do it">
				</form>
				<hr>
	
				<!--  Search + Fill ----------------------------------------------------------- -->
				<div class="row">
					<form method="post" action="find">
						<label for="searchString">Search:</label> <select name="type">
							<option value="findAll" selected="selected">findAll</option>
							<option value="findByLastName">findByLastName</option>
							<option value="findByFirstName">findByFirstName</option>
							<option value="findByAnything">findByAnything</option>
							<option value="findByFirstNameEndsWith">findByFirstNameEndsWith</option>
							<option value="findByLastNameEndsWith">findByLastNameEndsWith</option>
							<option value="findByOrderByLastNameAsc">findByOrderByLastNameAsc</option>
							<option value="findTop10ByOrderByFirstNameAsc">findTop10ByOrderByFirstNameAsc</option>
							<option value="findTop10ByOrderByLastNameAsc">findTop10ByOrderByLastNameAsc</option>
							<option value="findByOrderByFirstNameAsc">findByOrderByFirstNameAsc</option>
							<option value="findBySomething">findBySomething</option>
	
	
	
	
						</select> <input type="text" name="searchString"> <input
							type="submit" value="Do it">
					</form>
				</div>
	
				<!--  Search + Fill ----------------------------------------------------------- -->
				<h1>Admin Page (later)</h1>
			</center>
	
	
	
			<!--  list all robots ----------------------------------------------------------- -->
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<h2>Players</h2>
					<table data-toggle="table" class="table table-striped">
						<thead>
							<tr>
								<th>Name</th>
								<th>E-mail</th>
								<th>Role</th>
								<th>Wood</th>
								<th>Stone</th>
								<th>Food</th>
								<th>Gold</th>
								<!--  <th>Buildings</th>
								<th>Recruits</th> -->
								<th><a href="fill"><button type="button"
											class="btn btn-success">Fill List</button></a>
								</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${players}" var="user">
								<tr>
									<td>${user.username}</td>
									<td>${user.email}</td>
									<td>${user.role}</td>
									<td>${user.wood}</td>
									<td>${user.stone}</td>
									<td>${user.food}</td>
									<td>${user.gold}</td>
									<!--<td><c:forEach items="${user.buildings}" var="building">
									$(building.name)<br>
									</c:forEach></td>
									<td>${users.buildings.}</td>
									<!-- td><a href="delete?id=${users.id}">Delete</a></td> -->
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<hr>
				</div>
			</div>
		</div>
		<!--  list all players ----------------------------------------------------------- -->
	</div>

<div id="footer">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<table class="table" style="background-color:#ee4d2e;">
					<thead>
						<tr>
							<th>
						        <div class="well well-sm" >
								  <center>Wood: <b>${player.wood}</b></center>
								</div>			
							</th>
							<th>
						        <div class="well well-sm" >
								  <center>Stone: <b>${player.stone}</b></center>
								</div>			
							</th>
							<th>
						        <div class="well well-sm" >
								  <center>Food: <b>${player.food}</b></center>
								</div>		
							</th>
							<th>
						        <div class="well well-sm" >
								  <center>Gold: <b>${player.gold}</b></center>
								</div>			
							</th>
						</tr>
					</thead>
				</table>
			</div>
		 </div>
	</div>
<!--  end of container -->
	<%@include file="includes/bootstrapJs.jsp"%>
</body>
</html>

