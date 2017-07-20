<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<spring:url value="/resources/css/index.css" var="index" />
	<spring:url value="/resources/css/bootstrap.css" var="bootstrap" />
	
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	
	<spring:url value="/resources/js/bootstrap.js" var="bootstrapjs" />
	
	<spring:url value="/resources/js/jquery.js" var="jquery" /> 
	
	<link href="${index}" rel="stylesheet" />
	<link href="${bootstrap}" rel="stylesheet"/>
	 <script src="${jquery}"></script>
	<script src="${bootstrapjs}"></script>
    
     
     
     <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
	google.charts.load('current', {packages: ['corechart', 'bar']});
	google.charts.setOnLoadCallback(drawBasic);

  $(".back").click(function(){
    location.replace("index.html");
  });


	function drawBasic() {

      var data = google.visualization.arrayToDataTable([
        ['January', '2010 Users',],
        ['February', 81750],
        ['March', 37920],
        ['April', 26950],
        ['May', 20990],
        ['June', 15260]
      ]);

      var options1 = {
        title: 'Logged in Users',
        chartArea: {width: '50%'},
        hAxis: {
          title: 'Logged in Users',
          minValue: 0
        },
        vAxis: {
          title: 'Time'
        }
      };

      var chart = new google.visualization.BarChart(document.getElementById('chart_div'));

      chart.draw(data, options1);
	  
	  var data = new google.visualization.DataTable();
      data.addColumn('number', 'X');
      data.addColumn('number', 'Users');

      data.addRows([
        [0, 0],   [1, 10],  [2, 23],  [3, 17],  [4, 18],  [5, 9],
        [6, 11],  [7, 27],  [8, 33],  [9, 40],  [10, 32], [11, 35],
        [12, 30], [13, 40], [14, 42], [15, 47], [16, 44], [17, 48],
        [18, 52], [19, 54], [20, 42], [21, 55], [22, 56], [23, 57],
        [24, 60], [25, 50], [26, 52], [27, 51], [28, 49], [29, 53],
        [30, 55], [31, 60], [32, 61], [33, 59], [34, 62], [35, 65],
        [36, 62], [37, 58], [38, 55], [39, 61], [40, 64], [41, 65],
        [42, 63], [43, 66], [44, 67], [45, 69], [46, 69], [47, 70],
        [48, 72], [49, 68], [50, 66], [51, 65], [52, 67], [53, 70],
        [54, 71], [55, 72], [56, 73], [57, 75], [58, 70], [59, 68],
        [60, 64], [61, 60], [62, 65], [63, 67], [64, 68], [65, 69],
        [66, 70], [67, 72], [68, 75], [69, 80]
      ]);

      var options2 = {
        hAxis: {
          title: 'Time'
        },
        vAxis: {
          title: 'Users'
        }
      };

      var chart = new google.visualization.LineChart(document.getElementById('chart_div2'));

      chart.draw(data, options2);
	  
	   var data = google.visualization.arrayToDataTable([
          ['January', 'Hours per Day'],
          ['February',     11],
          ['March',      2],
          ['April',  2],
          ['May', 2],
          ['June',    7]
        ]);

        var options3 = {
          title: 'Logged in Users'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options3);
		
		//other grphic
		var data = google.visualization.arrayToDataTable([
        ["Element", "Density", { role: "style" } ],
        ["User", 8.94, "silver"],
        ["Contact", 10.49, "silver"],
        ["Appointment book", 13.30, "silver"],
        ["Calendar", 14.45, "color: silver"],
		["Employee", 15.45, "color: silver"],
		["Professor", 16.45, "color: silver"],
		["Payment", 17.45, "color: silver"],
		["Client", 18.45, "color: silver"],
		["Profile", 19.45, "color: silver"],
		["Product", 20.46, "color: silver"]
      ]);

      var view = new google.visualization.DataView(data);
      view.setColumns([0, 1,
                       { calc: "stringify",
                         sourceColumn: 1,
                         type: "string",
                         role: "annotation" },
                       2]);

      var options = {
        title: "Top 10 DB Charts",
        width: 550,
        height: 290,
        bar: {groupWidth: "55%"},
        legend: { position: "none" },
      };
      var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
      chart.draw(view, options);
	  
	  // espaço livre em disco
	  var data = google.visualization.arrayToDataTable([
          ['January', 'Hours per Day'],
          ['Using',     ${cpuUsage}],
          ['Available',    ${freeCpu}]
        ]);

        var options5 = {
          title: 'CPU Usage'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart2'));

        chart.draw(data, options5);
		
		//histórico
		var data = new google.visualization.DataTable();
      data.addColumn('number', 'X');
      data.addColumn('number', 'Users');

      data.addRows([
        [0, 0],   [1, 10],  [2, 23],  [3, 17],  [4, 18],  [5, 9],
        [6, 11],  [7, 27],  [8, 33],  [9, 40],  [10, 32], [11, 35],
        [12, 30], [13, 40], [14, 42], [15, 47], [16, 44], [17, 48],
        [18, 52], [19, 54], [20, 42], [21, 55], [22, 56], [23, 57],
        [24, 60], [25, 50], [26, 52], [27, 51], [28, 49], [29, 53],
        [30, 55], [31, 60], [32, 61], [33, 59], [34, 62], [35, 65],
        [36, 62], [37, 58], [38, 55], [39, 61], [40, 64], [41, 65],
        [42, 63], [43, 66], [44, 67], [45, 69], [46, 69], [47, 70],
        [48, 72], [49, 68], [50, 66], [51, 65], [52, 67], [53, 70],
        [54, 71], [55, 72], [56, 73], [57, 75], [58, 70], [59, 68],
        [60, 64], [61, 60], [62, 65], [63, 67], [64, 68], [65, 69],
        [66, 70], [67, 72], [68, 75], [69, 80]
      ]);

      var options6 = {
        hAxis: {
          title: 'Historic'
        },
        vAxis: {
          title: 'Access'
        }
      };

      var chart = new google.visualization.LineChart(document.getElementById('chart_div6'));

      chart.draw(data, options6);
	  
	}   
	
    </script>
    <title>Peloton Monitor</title>
      <style>
          .invisi{
              visibility: hidden;
          }
            .object-hidden{
                display: none;
            }
          .btn-h4 h4{
              cursor: pointer;
          }
          .btn-h4 h4:hover{
              color: #006699;
          }
        </style>
        <script>
        $(document).ready(function () {
            function vis(){
                $('#tab-1').removeClass('invisi');
                $('#tab-1').addClass('object-hidden');
                $('#tab-2').removeClass('invisi');
                $('#tab-2').addClass('object-hidden');
                $('#tab-3').removeClass('invisi');
                $('#tab-3').addClass('object-hidden');
            }
            setTimeout(vis, 500);
            $('#aba-1').bind('click', function () {
                $('#tab-1').toggleClass('object-hidden');
                if($('#tab-2').is(':visible')){
                    $('#tab-2').addClass('object-hidden');
                }
                if($('#tab-3').is(':visible')){
                    $('#tab-3').addClass('object-hidden');
                }
            });
            $('#aba-2').bind('click', function () {
                $('#tab-2').toggleClass('object-hidden');
                if($('#tab-1').is(':visible')){
                    $('#tab-1').addClass('object-hidden');
                }
                if($('#tab-3').is(':visible')){
                    $('#tab-3').addClass('object-hidden');
                }
            });
            $('#aba-3').bind('click', function () {
                $('#tab-3').toggleClass('object-hidden');
                if($('#tab-2').is(':visible')){
                    $('#tab-2').addClass('object-hidden');
                }
                if($('#tab-1').is(':visible')){
                    $('#tab-1').addClass('object-hidden');
                }
            });
        });
        </script>
  </head>
  
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
				<li><a class="waves-effect waves-light" href="" ng-click="newConnection()">Back to Connection</a></li>
				<li><a class="waves-effect waves-light" href="">About</a></li>
			  </ul>  
			</div>
		  </div>
		</nav>  
	</header>

  <body ng-app="myApp" ng-controller="myCtrl">
  
  	<div class="container-fluid">
          <div class="col-md-2">
              <h3>Graphics</h3>
                  <ul class="list-unstyled btn-h4">
                      <li><a id="aba-1">Logged in Users / Access Historic</a></li>
                      <li><a id="aba-2">Top 10 DB Charts / Users</a></li>
                      <li><a id="aba-3">Available disk space / Logged in Users </a></li>
                  </ul>
          </div>
          <div class="col-ms-10">
        		<h1>Peloton Graphics</h1>
        	  <p>Below some graphics</p>
        	  <div id="tab-1" class="row invisi">
    		      <div class="col-md-6" id="piechart" style="width: 480px; height: 300px;border: 1px solid; border-color:gray;"></div>
              <div class="col-md-6" id="chart_div6" style="width: 545px; height: 300px;border: 1px solid; border-color:gray;"></div>		
        				
        	  </div>

        	  <div id="tab-2" class="row invisi">
        		  <div class="col-md-6" id="columnchart_values" style="width: 545px; height: 300px;border: 1px solid; border-color:gray;"></div>
        		  <div class="col-md-6" id="chart_div2" border="1" style="width: 545px; height: 300px;border: 1px solid; border-color:gray;"></div>
        	  </div>

          	<div id="tab-3" class="row invisi">
          		<div class="col-md-6" id="piechart2" style="width: 480px; height: 300px;border: 1px solid; border-color:gray;"></div>		
          		<div class="col-md-6" id="chart_div" border="1" style="width: 545px; height: 300px;border: 1px solid; border-color:gray;"></div>		
  	       </div>
        </div>
  	</div>  
  
  </body>
</html>