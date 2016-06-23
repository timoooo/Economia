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
		<div class="jumbotron" align="center">
			<center>
			<!--  Search + Fill ----------------------------------------------------------- -->
				<h1>Welcome to Economia!</h1>
			</center>
				<br><br>
			<h2>We await orders Lord ${player.username}! </h2>
				<br> 
				<br> 
				<br> 
			<p><b>Your Power</b><br><br> 
			Attack 
			<img alt="" style="width: 35px; height: 35px;" src="images/ress/sword-icon.png"> 
			: ${player.attackPowerUnits} <br> 
			Deffend
			<img alt="" style="width: 35px; height: 35px;" src="images/ress/shield-icon.png">
			: ${player.deffPowerUnits}   <br>
			Accuracy
			<img alt="" style="width: 35px; height: 35px;" src="images/ress/accuracy-icon.png">
			: ${player.accuracyUnits}  <br> 
			</p>
			<br>
			<br>
			 
			<br>
			<br>
			<!-- short javascript fpr random image -->
			<script type="text/javascript">
				var total_images = 10;
				var random_number = Math.floor((Math.random()*total_images));
				var random_img = new Array();
				random_img[0] = '<img align="middle" alt="" style="width: 500px; height:310px;" src="images/bigPics/village.jpg">';
				random_img[1] = '<img align="middle" alt="" style="width: 500px; height:310px;" src="images/bigPics/castle1.jpg">';
				random_img[2] = '<img align="middle" alt="" style="width: 500px; height:310px;" src="images/bigPics/castle2.jpg">';
				random_img[3] = '<img align="middle" alt="" style="width: 500px; height:310px;" src="images/bigPics/castle3.jpg">';
				random_img[4] = '<img align="middle" alt="" style="width: 500px; height:310px;" src="images/bigPics/castle4.jpg">';
				random_img[5] = '<img align="middle" alt="" style="width: 500px; height:310px;" src="images/bigPics/castle5.jpg">';
				random_img[6] = '<img align="middle" alt="" style="width: 500px; height:310px;" src="images/bigPics/castle6.jpg">';
				random_img[7] = '<img align="middle" alt="" style="width: 500px; height:310px;" src="images/bigPics/castle7.jpg">';
				random_img[8] = '<img align="middle" alt="" style="width: 500px; height:310px;" src="images/bigPics/castle8.jpg">';
				random_img[9] = '<img align="middle" alt="" style="width: 500px; height:310px;" src="images/bigPics/castle9.jpg">';
				document.write(random_img[random_number]);
			</script>
			
			<br><br><br>Feel your greatness in the battle against your enemies!
		</div>
	</div>	 
						
	
	
	
		<!--  list all players ----------------------------------------------------------- -->
	
	
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

