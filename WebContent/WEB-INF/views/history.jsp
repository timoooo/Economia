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
							<a href="login">My Castle</a>
						</li>
						<li>
							<a href="#">Build</a>
						</li>
						<li>
							<a href="#">Fight</a>
						</li>

						

					</ul>
					
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a class="btn btn-info disabled" href="history"><font color=#fff>History</font></a>
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
					Hello, world!
				</h2>
				<p>
					This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.
				</p>
				<p>
					<a class="btn btn-primary btn-large" href="#">Learn more</a>
				</p>
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