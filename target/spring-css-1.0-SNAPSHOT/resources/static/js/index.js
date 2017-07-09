function request(){
    var xhr = new createCORSRequest();

    xhr.open("GET", "http://localhost:8080/pelotonMonitor/teste/"+"Teste");

    xhr.withCredentials = true;
    xhr.setRequestHeader('enctype', 'multipart/form-data');
    xhr.setRequestHeader('Access-Control-Allow-Origin','*');



    xhr.withCredentials = false;
    //xhr.responseType = 'json';
    // Response handlers.
    xhr.onload = function() {
      var text = xhr.responseText;
      
      //var response = this.responseText;
      //var resp = JSON.parse(response);
      console.log(text);
      
    };


    xhr.onerror = function() {
      alert("Error");
      console.log(this.status);
      console.log(this.responseText);
    };

    xhr.send();


}

var app = angular.module("myApp", []).controller("myCtrl",function($scope, $window, $http) {
  /*
  message = "menssagem de erro ao retornar query"
  */
  $scope.message = "";
  $scope.values = [];
  $scope.attributs = [];
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


  $scope.play =function(){
    $scope.values = [];
    $scope.attributs = [];
    $scope.menssagem = "";

    console.log("TESTANDO");
    if($scope.script.toLowerCase() == "select * from employees"){
      dataEmployes();
    }else if($scope.script.toLowerCase() == "select * from departments"){
      dataDepartments();
    }else if($scope.script.toLowerCase() == "select * from clients"){
      dataClients();
    }else{
      $scope.message= "Essa função ainda não está disponivel";
    }
    
  }

  $scope.openGrafics = function(){
    console.log("TESTE");
    //location.replace("graficos.html");
    $window.open("graficos.html");
  }  

  $scope.newConnection = function(){
    $("#modal-mensagem").modal(); 
  }

  $scope.reqEmployees = function(){
	request();
  }


  /*$scope.reqEmployees = function(){
    $http.get("http://localhost:8080/monitorWeb/banco/employees").then( function(json) {
      console.log(json);
    }, function(erro) {
      console.log("The request failed with response " + erro);
    });
  }*/

  $("#btnConnection").click(function(){

    var connectionName  = $("#connection-name").val();

    connectionStart($scope.connectionIp,$scope.connectionPort,$scope.connectionPassword );
    
    console.log(connectionName);
    treeArray = [{
      text: connectionName,
      nodes:[
        {
        text:"Management_Database",
          nodes:[
            {
              text:"Employees",
              nodes:[
              {text:"id"},
              {text:"name"},
              {text:"salary"},
              {text:"department_id"}
              ]
            },
            {
              text:"Departments",
              nodes:[
              {text:"id"},
              {text:"name"},
              {text:"boss_id"}
              ]
            },
            {
              text:"Clients",
              nodes:[
              {text:"id"},
              {text:"name"},
              {text:"salesman_id"}
              ]
            }
          ]
        }
      ]
      }];

      $('#tree').treeview({data: treeArray ,levels: 3,  showBorder: true });
      //createTree(treeArray);
  });
});
