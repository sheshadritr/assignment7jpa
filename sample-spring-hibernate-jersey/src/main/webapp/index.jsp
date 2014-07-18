<!DOCTYPE html>
<html lang="en" ng-app="myApp">
<head>
	<meta charset="utf-8">
	<title>SO: AngularJS Dashboard</title>
	<link href="assets/css/bootstrap.css" rel="stylesheet">
	<link href="assets/css/bootstrap.min.css" rel="stylesheet">
	<link href="assets/css/main.css" rel="stylesheet">
</head>
<body>
	<div class="header">
		<div class="navbar navbar-fixed-top navbar-bg" role="navigation">
			<div class="container">
				<div class="navbar-header navbar-brand-width">
					<span class="navbar-brand">AngularJS Dashboard </span>
				</div>
					<ul class="nav navbar-nav navbar-right navbar-center">
						<li class="active"><a href="http://0.0.0.0:8080/#/tagchart">Tags</a></li>
						<li><a href="http://0.0.0.0:8080/#/questionchart">Questions</a></li>
					</ul>
			</div>
		</div>
	</div>
	<div ng-view></div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular.js" type="text/javascript"></script>
	<script src="https://www.google.com/jsapi" type="text/javascript"></script>
	<script src="assets/js/controllers.js" type="text/javascript"></script>
	<script src="assets/js/ngGoogleCharts.js" type="text/javascript"></script>
	<script src="assets/js/jquery-1.8.3.js"></script>
	<script src="assets/js/bootstrap.js"></script>
	<script src="assets/js/app.js"></script>
	<script src="assets/js/services.js"></script>
	<script src="assets/js/controllers.js"></script>
	<script src="assets/js/filters.js"></script>
	<script src="assets/js/directives.js"></script>
</body>
</html>
