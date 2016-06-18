<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="includes/bootstrapMeta.inc"%>
<title>Player Spring Data JPA</title>
<%@include file="includes/bootstrapCss.css"%>
<%@include file="includes/treeView.css"%>


<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
				<div class="navbar-header">
					 <p class="navbar-text"><font color=#ee4d2e><b>Economia</b></font></p>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li>
							<a href="list">My Castle</a>
						</li>
						<li>
							<a href="buildings">Buildings</a>
						</li>
						<li class="active">
							<a href="troops">Troops</a>
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
						<li>
						<a></a>
						</li>
						
					</ul>
				</div>
				
			</nav>
			<div class="jumbotron">
				<h2>
					Prepare for fight.
				</h2>
				<p>
					Drill militants to win against your enemys and save your castle
				</p>
				<p>
						<a class="btn btn-success btn-large" href="#">prepare troops for action</a>
					</p>
				<h2>Your troops</h2>
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<table data-toggle="table" class="table table-striped">
							<thead>
								<tr>
									<th>Type</th>
									<th>Power Per Unity</th>
									<th>Precision</th>
									<th>Speed</th>
									<th>Quantity</th>
									<th>Total Power</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${robots}" var="player">
									<tr>
										<td>${player.firstName}</td>
										<td>${player.id}</td>
										<td>${player.lastName}</td>
										<td>${player.nickName}</td>
										<td>${player.nickName}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<hr>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div id="footer">
		<center>
		<br>
			Diverse Ressourcen wie Holz, Stein Gold, Einheiten blahblahblah
		</center>
	</div>
	
	
	
		<!--  end of container -->
	<%@include file="includes/bootstrapJs.js"%>

</body>
</html>