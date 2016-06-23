<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="includes/bootstrapMeta.inc"%>
<title>Economia Trade Success</title>
<%@include file="includes/bootstrapCss.css"%>
<%@include file="includes/treeView.css"%>


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
							<li>
								<a href="list">My Castle</a>
							</li>
							<li>
								<a href="buildings">Buildings</a>
							</li>
							<li>
								<a href="recruits">Recruits</a>
							</li>
							<li class="active">
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
				
	<div class="container" role="main">
		<div class="jumbotron">
			<h2>Trade Success!</h2>
			
			<a class="btn btn-primary btn-large" href="trade"> Back </a>
			
			<br>
			<br>
			
	
			<c:if test="${not empty errorMessage}">
				<div class="alert alert-danger" role="alert">${errorMessage}</div>
			</c:if>
			<!--  Error message ----------------------------------------------------------- -->
	
			<!--  Warning message ----------------------------------------------------------- -->
			<c:if test="${not empty warningMessage}">
				<div class="alert alert-warning" role="warning">
					${warningMessage}</div>
			</c:if>
			<!--  Warning message ----------------------------------------------------------- -->
	
			<!--   message ----------------------------------------------------------- -->
			<c:if test="${not empty message}">
				<div class="alert alert-success" role="warning">${message}</div>
			</c:if>
	        
	        <img align=right alt=""
			style="width: 250px; height:150px;"
			src="images/bigPics/market.png">
			
			<br>
			
			<p>
				Your Trade was published to the rest of the world!
				Be patient! I can take a while until somebody buys your goods.
				If you want your resources back, just delete your offer. 
			</p>
			<br>
			
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