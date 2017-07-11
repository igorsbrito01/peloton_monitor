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

  $("#voltar").click(function(){
	 // window.location.replace("http://localhost:8080/monitor/");
	  window.location= "http://localhost:8080/monitor/";
  });


	function drawBasic() {

      var data = google.visualization.arrayToDataTable([
        ['Janeiro', '2010 Usuários',],
        ['Fevereiro', 81750],
        ['Março', 37920],
        ['Abril', 26950],
        ['Maio', 20990],
        ['Junho', 15260]
      ]);

      var options1 = {
        title: 'Usuários logados',
        chartArea: {width: '50%'},
        hAxis: {
          title: 'Usuários logados',
          minValue: 0
        },
        vAxis: {
          title: 'Tempo'
        }
      };

      var chart = new google.visualization.BarChart(document.getElementById('chart_div'));

      chart.draw(data, options1);
	  
	  var data = new google.visualization.DataTable();
      data.addColumn('number', 'X');
      data.addColumn('number', 'Usuários');

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
          title: 'Tempo'
        },
        vAxis: {
          title: 'Usuários'
        }
      };

      var chart = new google.visualization.LineChart(document.getElementById('chart_div2'));

      chart.draw(data, options2);
	  
	   var data = google.visualization.arrayToDataTable([
          ['Janeiro', 'Hours per Day'],
          ['Fevereiro',     11],
          ['Marco',      2],
          ['Abril',  2],
          ['Maio', 2],
          ['Junho',    7]
        ]);

        var options3 = {
          title: 'Usuários logados'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options3);
		
		//other grphic
		var data = google.visualization.arrayToDataTable([
        ["Element", "Density", { role: "style" } ],
        ["Usuario", 8.94, "silver"],
        ["Contato", 10.49, "silver"],
        ["Agenda", 13.30, "silver"],
        ["Calendario", 14.45, "color: silver"],
		["Funcionario", 15.45, "color: silver"],
		["Professor", 16.45, "color: silver"],
		["Pagamento", 17.45, "color: silver"],
		["Cliente", 18.45, "color: silver"],
		["Perfil", 19.45, "color: silver"],
		["Produto", 20.46, "color: silver"]
      ]);

      var view = new google.visualization.DataView(data);
      view.setColumns([0, 1,
                       { calc: "stringify",
                         sourceColumn: 1,
                         type: "string",
                         role: "annotation" },
                       2]);

      var options = {
        title: "10 maiores tabelas do BD",
        width: 750,
        height: 290,
        bar: {groupWidth: "55%"},
        legend: { position: "none" },
      };
      var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
      chart.draw(view, options);
	  
	  // espaço livre em disco
	  var data = google.visualization.arrayToDataTable([
          ['Janeiro', 'Hours per Day'],
          ['Ocupado',     11],
          ['Disponível',      89]
        ]);

        var options5 = {
          title: 'Espaço disponível em disco'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart2'));

        chart.draw(data, options5);
		
		//histórico
		var data = new google.visualization.DataTable();
      data.addColumn('number', 'X');
      data.addColumn('number', 'Usuários');

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
          title: 'Histórico'
        },
        vAxis: {
          title: 'Acesso'
        }
      };

      var chart = new google.visualization.LineChart(document.getElementById('chart_div6'));

      chart.draw(data, options6);
	  
	}   
	
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
			 <!--  <ul class="nav navbar-nav navbar-right" style="padding-right: 20px">
				<li><a class="waves-effect waves-light volar" href="">voltar</a></li>
				<li><a class="waves-effect waves-light" href="">About</a></li>
			  </ul>  -->
			</div>
		  </div>
		</nav>  
	</header>

  <body>
  
	<div class="container-fluid">
	  <h1>Gráficos Peloton</h1>
	  <p>Abaixo alguns gráficos</p>
	  <div class="row">
		<div class="col-md-6" id="piechart" style="width: 600px; height: 300px;border: 1px solid; border-color:gray;"></div>		
		<div class="col-md-6" id="columnchart_values" style="width: 745px; height: 300px;border: 1px solid; border-color:gray;"></div>		
	  </div>
	  <div class="row">
		  <div id="chart_div" border="1" style="border: 1px solid; border-color:gray;"></div>
		  <div id="chart_div2" border="1" style="border: 1px solid; border-color:gray;"></div>
	  </div>
	  <div class="row">
		<div class="col-md-6" id="piechart2" style="width: 600px; height: 300px;border: 1px solid; border-color:gray;"></div>		
		<div class="col-md-6" id="chart_div6" style="width: 745px; height: 300px;border: 1px solid; border-color:gray;"></div>		
	  </div>
	</div>  
    
  </body>
</html>