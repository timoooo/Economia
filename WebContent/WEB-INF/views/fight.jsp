<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="includes/bootstrapMeta.inc"%>
<title>Economia Warfear</title>
<%@include file="includes/bootstrapCss.css"%>
<%@include file="includes/treeView.css"%>
<body class="" sytle="">
	<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
				<div class="container">
					<div class="navbar-header">
						<p class="navbar-text">
							<font color=#ee4d2e><b>Economia</b></font>
						</p>
					</div>

					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li><a href="list">My Castle</a></li>
							<li><a href="buildings">Buildings</a></li>
							<li><a href="recruits">Recruits</a></li>
							<li><a href="trade">Trade</a></li>
							<li class="active"><a href="fight">Fight</a></li>
						</ul>

						<ul class="nav navbar-nav navbar-right">
							<li><a class="btn btn-info" href="history"><font
									color=#fff>History</font></a></li>
							<li>`</li>
							<li><a class="btn btn-danger" href="logout"><font
									color=#fff>Logout</font></a>
								</li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</div>
		
	<div class="container">
		<div class="jumbotron">
			<h2>Fight against your enemies!</h2>
			<br>
			<p>Here is a list of your opponents, you can battle with.</p>
			<p>

			<br>
			</p>
			
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<table data-toggle="table" class="table table-striped">
						<thead>
							<tr>
								<th>Player</th>
								<th>Castle</th>
								<th>Last Fight</th>
								<th>Buildings</th>
								<th>tag</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${robots}" var="player">
								<tr>
									<td>${player.firstName}</td>
									<td>${player.firstName}</td>
									<td><fmt:formatDate value="${player.dayOfBirth}"
											pattern="dd.MM.yyyy" /></td>
									<td>${player.lastName}</td>
									<td>${player.nickName}</td>
									<td><a class="btn btn-danger btn-large" href="FightAgainst?id=${player.id}">Fight</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<hr>
				</div>
			</div>
		</div>
	</div>



	<div id="footer">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<table class="table" style="background-color:#ee4d2e;">
					<thead>
						<tr>
							<th>
						        <div class="well well-sm" >
								  <center>Wood: <b>${wood}</b></center>
								</div>			
							</th>
							<th>
						        <div class="well well-sm" >
								  <center>Stone: <b>${stone}</b></center>
								</div>			
							</th>
							<th>
						        <div class="well well-sm" >
								  <center>Food: <b>${food}</b></center>
								</div>		
							</th>
							<th>
						        <div class="well well-sm" >
								  <center>Gold: <b>${gold}</b></center>
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