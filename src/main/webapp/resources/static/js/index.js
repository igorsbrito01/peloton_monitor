var app = angular.module("myApp", []).controller("myCtrl",function($scope, $window, $http) {
  /*
  message = "menssagem de erro ao retornar query"
  */
  $scope.message = "";
  //$scope.values = [];
 // $scope.attributs = [];
  $scope.script = "";
  $scope.connectionName = "";
  $scope.connectionIp = "localhost";
  $scope.connectionPort = "5432";
  $scope.connectionPassword = "12345";


  //investigar dois valores iguais no mesmo array ocorre um problema
  function dataEmployes(){
	  
	  $scope.values = [
      ["1","Igor","1000","2"],
      ["2","Pedro","1500","1"],
      ["3","Carlos","1500","2"],
      ["4","Lucas", "1000", "1"],
      ["5","Jorge", "1300", "2"],
      ["6", "Fabio", "1500", "1"]
    ];
    $scope.attributs = ["id","name", "salary" ,"department_id"];
  }

  function dataDepartments(){

	  $scope.values = [
      ["1","sales", "2"],
      ["2","technology","3"]
    ];
    $scope.attributs = ["id","name", "boss_id"];
  }

  function dataClients(){
	  
	  $scope.values = [
      ["1","Henrique", "2"],
      ["2","Lucas","3"],
      ["3", "Paulo", "4"]
    ];
    $scope.attributs = ["id","name", "salesman_id"];
  }


  $(function(){
     if($scope.connectionName == ""){
      $scope.newConnection();
     }
  });


 /* $scope.play =function(){
    $scope.values = [];
    $scope.attributs = [];
    $scope.menssagem = "";

    console.log("TESTANDO");
    if($scope.script.toLowerCase() == "select * from employee"){
      dataEmployes();
    }else if($scope.script.toLowerCase() == "select * from departments"){
      dataDepartments();
    }else if($scope.script.toLowerCase() == "select * from clients"){
      dataClients();
    }else{
      $scope.message= "Essa função ainda não está disponivel";
    }
    
  }*/
	
  
  $scope.openGrafics = function(){
    console.log("TESTE");
    //location.replace("graficos.html");
    $window.open("graficos.html");
  }  

  $scope.newConnection = function(){
    $("#modal-mensagem").modal(); 
  }

  $scope.consultar = function(){
	  
	  
	  if($scope.script != ""){
		  var aux = $scope.script.split(" ");
		  
		  if(aux[0].toLowerCase() == "select"){
			  consultaDefault($scope.connectionIp, $scope.connectionPort, $scope.script);
		  }else if(aux[0].toLowerCase() == "insert"){
			  insertionDefault($scope.connectionIp, $scope.connectionPort, $scope.script);
		  }
		  
		  
	  }
	  
  }


  $("#btnConnection").click(function(){

    var connectionName  = $("#connection-name").val();

    connectionStart($scope.connectionIp,$scope.connectionPort,$scope.connectionPassword );
   
    console.log(connectionName);
  });

  function showTable(valores, attributos){
	    $scope.values = valores;
	    $scope.attributs = attributos;
	   
	  }
  
  $scope.teste = function(){

    var val = [
      ["1","Henrique", "2"],
      ["2","Lucas","3"],
      ["3", "Paulo", "4"]
    ];
     var at = ["id","name", "salesman_id"];
     
     showTable(val, at);
  }

 
  function insertionDefault(ip, port, query){
	  
	  var xhr = new createCORSRequest();

	    xhr.open("GET", "http://localhost:8080/monitor/insertion/"+ip+"/"+port+"/"+query);

	    xhr.withCredentials = true;
	    xhr.setRequestHeader('enctype', 'multipart/form-data');
	    xhr.setRequestHeader('Access-Control-Allow-Origin','*');



	    xhr.withCredentials = false;
	    //xhr.responseType = 'json';
	    // Response handlers.
	    xhr.onload = function() {
	      var text = xhr.responseText;
	      
	      if(text == ""){
	    	  $scope.message= "wasn`t possible to execute the query";
	    	  return ;
	      }
	      $scope.messag = "";
	      var response = this.responseText;
	      var resp = JSON.parse(response);
	      console.log(resp);
	      
	     
	    };


	    xhr.onerror = function(){
	      alert("Error");
	      console.log(this.status);
	      console.log(this.responseText);
	    };

	    xhr.send();
	  
  }
  
  function consultaDefault(ip, port, query){
	    var xhr = new createCORSRequest();

	    xhr.open("GET", "http://localhost:8080/monitor/query/"+ip+"/"+port+"/"+query);

	    xhr.withCredentials = true;
	    xhr.setRequestHeader('enctype', 'multipart/form-data');
	    xhr.setRequestHeader('Access-Control-Allow-Origin','*');



	    xhr.withCredentials = false;
	    //xhr.responseType = 'json';
	    // Response handlers.
	    xhr.onload = function() {
	      var text = xhr.responseText;
	      
	      if(text == ""){
	    	  $scope.message= "wasn`t possible to execute the query";
	    	  return ;
	      }
	      $scope.messag = "";
	      var response = this.responseText;
	      var resp = JSON.parse(response);
	      console.log(resp);
	      
	      var at = resp.attrs;
	      
	     var val = [];
	      
	      for(i in resp.attrsVal){
	    	  var aux = [];
	    	  
	    	  for(j in resp.attrsVal[i]){
	    		  aux.push(resp.attrsVal[i][j]);
	    	  }
	    	  val.push(aux);
	      }
	      console.log(val[0]);
	      showTable(val, resp.attrs);
	      showTable(val, resp.attrs);
	     
	    };


	    xhr.onerror = function(){
	      alert("Error");
	      console.log(this.status);
	      console.log(this.responseText);
	    };

	    xhr.send();


	}
 
});
