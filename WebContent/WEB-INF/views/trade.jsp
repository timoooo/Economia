<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="includes/bootstrapMeta.inc"%>
<title>Economia Trade Ressources</title>
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
				
	<div class="container">
		<div class="jumbotron">
			<h2>
				Trade your resources! 
			</h2>
			<p>
				Become a dealers and sell your goods to the rest of the world.
			</p>
			<br>
			
			
			<div class="row">
	          <div class="col-lg-6">
	            <div class="well bs-component">
	              <form class="form-horizontal" method="post" action="${formAction}">
					<fieldset>
						<!-- Form Name -->
						<legend>Make an offer they can't refuse:</legend>
						<br>
						<!-- Appended Input-->
						<div class="col-md-1"></div>
						<h4>Your resources:</h4>
						<div class="form-group">
						  <label class="col-md-3 control-label" for="wood"></label>
						  <div class="col-md-7">
						    <div class="input-group">
						      <input id="wood" name="wood" class="form-control" placeholder="0" min=0 type="number">
						      <span class="input-group-addon">Wood</span>
						    </div>
						    
						  </div>
						</div>
						<!-- Appended Input-->
						<div class="form-group">
						  <label class="col-md-3 control-label" for="stone"></label>
						  <div class="col-md-7">
						    <div class="input-group">
						      <input id="stone" name="stone" class="form-control" placeholder="0" min=0 type="number">
						      <span class="input-group-addon">Stone</span>
						    </div>
						    
						  </div>
						</div>
						<!-- Appended Input-->
						<div class="form-group">
						  <label class="col-md-3 control-label" for="food"></label>
						  <div class="col-md-7">
						    <div class="input-group">
						      <input id="food" name="food" class="form-control" placeholder="0" min=0 type="number">
						      <span class="input-group-addon">Food</span>
						    </div>
						    
						  </div>
						</div>
						<div class="row"></div>
						<br>
						<!-- Appended Input-->
						<div class="col-md-5">
						<h4>Sell them for:</h4>
						</div>
						<div class="form-group">
						  <label class="col-md-5 control-label" for="appendedtext"></label>
						  <div class="col-md-6">
						    <div class="input-group">
						      <input id="price" name="price" class="form-control" placeholder="0" min=0 type="number">
						      <span class="input-group-addon">Gold</span>
						    </div>
						    
						  </div>
						</div>
						<br>
						<div align="right">
							<a class="btn btn-success btn-large"  href="#">Create</a>
						</div>
						<h5>
							your offer holds for 48h 
						</h5>
							
						</fieldset>
						</form>
					</div>
				</div>
			
			
			<div class="col-lg-4 col-lg-offset-1">
				<form class="bs-component">
				
					<div class="cotainer">
                	<img alt=""
						style="width: 335px; height:300px;"
						src="images/bigPics/market.png">
					</div>

					
						
					</form>
				</div>
      		</div>
	

				
			<h2>Offers:</h2>
			<br>
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<table data-toggle="table" class="table table-striped">
						<thead>
							<tr>
								<th>Date</th>
								<th>player</th>
								<th>Wood</th>
								<th>Stone</th>
								<th>Food</th>
								<th>Total Cost</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${robots}" var="player">
								<tr>
									<td>
									<fmt:formatDate value="${offer.date}"
										pattern="dd.MM.yyyy" /></td>
									<td>${offer.player}</td>
									<td>${offer.wood}</td>
									<td>${offer.stone}</td>
									<td>${offer.food}</td>
									<td>${offer.price}</td>
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