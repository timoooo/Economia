<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="includes/bootstrapMeta.inc"%>
<title>Economia Warfare</title>
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
								color=#fff>Logout</font></a></li>
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
			<p>Winning a fight gives you 25% of the opponents resources.</p>
			<p>Losing a fight costs you 20% of your units</p>
			<p>
				<c:if test="${winner != null}">
					<div class="alert alert-dismissible alert-success">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
						<strong>YOU WON!</strong> You gained following ressources:

						<p>
							<img alt="" style="width: 35px; height: 35px;"
								src="images/ress/gold-icon.png"> Gold: ${gold} <img alt=""
								style="width: 35px; height: 35px;"
								src="images/ress/stone-icon.png"> Stone: ${stone} <img
								alt="" style="width: 35px; height: 35px;"
								src="images/ress/food-icon.png"> Food: ${food} <img alt=""
								style="width: 35px; height: 35px;"
								src="images/ress/wood-icon.png"> Wood: ${wood}
						</p>
						<p></p>
						</a>
					</div>

				</c:if>
				<c:if test="${loser != null}">
					<div class="alert alert-dismissible alert-danger">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
						<strong>Oh snap! You lost!</strong> <a href="#"
							class="alert-link">You have lost following units:</a>
						<p>Footman: ${lost1}</p>
						<p>Archer: ${lost2}</p>
						<p>2-Handed: ${lost3}</p>
						<p>Knight: ${lost4}</p>
						<p>Longbow Archer: ${lost5}</p>

					</div>

				</c:if>

			</p>
			<p>
				Your Attackpower: ${attack} <img alt=""
					style="width: 35px; height: 35px;" src="images/ress/sword-icon.png">
				<br>
			</p>
			<p>
				Your Deffpower: ${defense} <img alt=""
					style="width: 35px; height: 35px;"
					src="images/ress/shield-icon.png"><br>
			</p>
			<p>
				Your Accuracy: ${acc} <img alt="" style="width: 35px; height: 35px;"
					src="images/ress/accuracy-icon.png"> <br>
			</p>
			<div class="row">
				<div class="col-md-12">
					<form action="fightnow" method="GET" modelAttribute="player">
						<table data-toggle="table" class="table table-striped">
							<thead>
								<tr>
									<th>Player</th>
									<th>Attackpower <img alt=""
										style="width: 35px; height: 35px;"
										src="images/ress/sword-icon.png"></th>
									<th>Deffpower <img alt=""
										style="width: 35px; height: 35px;"
										src="images/ress/shield-icon.png"></th>
									<th>Accuracy <img alt=""
										style="width: 35px; height: 35px;"
										src="images/ress/accuracy-icon.png"></th>
									<th>Wood <img alt="" style="width: 35px; height: 35px;"
										src="images/ress/wood-icon.png"></th>
									<th>Stone <img alt="" style="width: 35px; height: 35px;"
										src="images/ress/stone-icon.png"></th>
									<th>Food <img alt="" style="width: 35px; height: 35px;"
										src="images/ress/food-icon.png"></th>
									<th>Gold <img alt="" style="width: 35px; height: 35px;"
										src="images/ress/gold-icon.png"></th>
									<th>Fight!</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${players}" var="player">
									<tr>
										<td>${player.username}</td>
										<td>${player.attackPowerUnits}</td>
										<td>${player.deffPowerUnits}</td>
										<td>${player.accuracyUnits}</td>
										<td>${player.wood}</td>
										<td>${player.stone}</td>
										<td>${player.food}</td>
										<td>${player.gold}</td>
										<td><button type="submit" class="btn btn-danger btn-lg"
												action="fightnow" name="username" value="${player.username}"
												autofocus>Fight</button></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</form>
					<hr>
				</div>
			</div>
		</div>
	</div>



<div id="footer" >
		<div class="row" > <!--  style="z-index:110; -->
			<div class="col-md-6 col-md-offset-3">
				<table class="table" style="background-color:#ee4d2e;">
					<thead>
						<tr>
							<th>
						        <div class="well well-sm" >
								  <center> <img alt="" style="width: 20px; height: 20px;" src="images/ress/wood-icon.png"> Wood: <b>${player.wood}</b></center>
								</div>			
							</th>
							<th>
						        <div class="well well-sm" >
								  <center> <img alt="" style="width: 20px; height: 20px;" src="images/ress/stone-icon.png"> Stone: <b>${player.stone}</b></center>
								</div>			
							</th>
							<th>
						        <div class="well well-sm" >
								  <center> <img alt="" style="width: 20px; height: 20px;" src="images/ress/food-icon.png"> Food: <b>${player.food}</b></center>
								</div>		
							</th>
							<th>
						        <div class="well well-sm" >
								  <center> <img alt="" style="width: 20px; height: 20px;" src="images/ress/gold-icon.png"> Gold: <b>${player.gold} </b></center>
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