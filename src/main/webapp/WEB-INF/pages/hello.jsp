<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
     <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
   <!--<script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
    <script src="<c:url value="/resources/js/main.js" />"></script> -->
    
    
  <!-- <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/index.css">  -->
    <ui:include src="moda.html" />
    <title>Peloton Monitor</title>
</head>
<body ng-app="myApp">
	<div class="container" ng-controller="myCtrl">
		<h1></h1>
		<header class="navbar navbar-default">
		    <nav>
		      <div class="container">
		        <div class="navbar-header">
		          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
		            <span class="sr-only">Toggle navigation</span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		          </button> 
		          <a class="navbar-brand" href="">Peloton Monitor</a>
		        </div>
		        <div id="navbar" class="collapse navbar-collapse">
		          <ul class="nav navbar-nav navbar-right" style="padding-right: 20px">
		            <li><a class="waves-effect waves-light" href="" ng-click="openGrafics()">Grafics</a></li>
		            <li><a class="waves-effect waves-light" href="" ng-click="newConnection()">Connection</a></li>
		            <li><a class="waves-effect waves-light" href="">About</a></li>
		          </ul>  
		        </div>
		      </div>
		  	</nav>  
		</header>
		<div class="page-content">
			<section class="">	
				<div class="row">
					<div class="col-md-4">
						 <div id="tree"></div>
					</div>
					<div class="col-md-8">	
						<div>
							<div class="form-group">	
								<!-- Projection -->
					    		<div class="lead">Scripts</div> 
					    		<textarea id="script" class="form-control input-lg" ng-model="script"  spellcheck="false"></textarea>

					    		<br/>
					    		<button id="submitFormula" class="btn btn-danger" ng-click="reqEmployees()"><!-- <span class="glyphicon glyphicon-stop" aria-hidden="true"></span>--> Stop</button>
			    				<button id="cleanScope" class="btn btn-success" ng-click="play()"> <!--<span class="glyphicon glyphicon-play" aria-hidden="true"></span> --> Execute Query</button>
			    				<hr />

					    		<div class="lead">OUTPUT</div>
								<div class="scripts panel panel-default ">

									<div>
							          <div class="error-msg">
							            {{message}}
							          </div>
							          <table class="table table-bordered table-striped table-sm">
							            <thead class="thead-inverse">
							              <tr>
							                <th ng-repeat="attr in attributs">{{attr}}</th>
							              </tr>
							            </thead>
							            <tbody>
							              <tr ng-repeat="item in values">
							                <td ng-repeat="i in item">{{i}}</td>
							              </tr>
							            </tbody>
							          </table>
							        </div>
								</div>
								
							</div>
							
						</div>	
					</div>
				</div>
				
			</section>				
		</div>

		  <!-- Modal to configure conecction with Pelotondb -->
	      <div id="modal-div">
	        <div class="modal fade" id="modal-mensagem">
	            <div class="modal-dialog">
	                 <div class="modal-content">
	                     <div class="modal-header">
	                         <button type="button" class="close" data-dismiss="modal"><span>×</span></button>
	                         <h4 class="modal-title">Setting Connection</h4>
	                     </div>
	                     <div class="modal-body">
	                        <form>
	                          <div class="form-group">
	                            <label for="recipient-name" class="form-control-label">Connection name</label>
	                            <input type="text" class="form-control" id="connection-name" ng-model="connectionName">
	                          </div> 
	                          <div class="form-group">
	                            <label for="recipient-name" class="form-control-label">IP Connection</label>
	                            <input type="text" class="form-control" id="ip" ng-model="connectionIp">
	                          </div> 
	                          <div class="form-group">
	                            <label for="recipient-name" class="form-control-label">Port N.</label>
	                            <input type="text" class="form-control" id="port" ng-model="connectionPort">
	                          </div> 
	                          <div class="form-group">
	                            <label for="recipient-name" class="form-control-label">Password</label>
	                            <input type="password" class="form-control" id="password" ng-model="connectionPassword">
	                          </div> 

	                        </form>
	                     </div>
	                     <div class="modal-footer">
	                         <button type="btnConnection" id="btnConnection" class="btn btn-default" data-dismiss="modal">Connect</button>
	                     </div>
	                 </div>
	             </div>
	         </div>

	      </div>
	</div>
</body>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
  <script src="<c:url value="/resources/js/consultas.js" />"></script>
  <script src="<c:url value="/resources/js/connection.js" />"></script>
  <script src="<c:url value="/resources/js/requests.js" />"></script>
  <script src="<c:url value="/resources/js/jquery.js" />"></script>
  <script src="<c:url value="/resources/js/bootstrap.js" />"></script>
  <script src="<c:url value="/resources/js/bootstrap-treeview.js" />"></script>
  <script src="<c:url value="/resources/js/tree.js" />"></script>
  <script src="<c:url value="/resources/js/index.js" />"></script>
  <script src="<c:url value="/resources/js/actions.js" />"></script>

</html>