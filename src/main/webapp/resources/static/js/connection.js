function connectionStart(ip, port, password){
    var xhr = new createCORSRequest();

    xhr.open("GET", "http://localhost:8080/monitor/connect/"+ip+"/"+port);

    xhr.withCredentials = true;
    xhr.setRequestHeader('enctype', 'multipart/form-data');
    xhr.setRequestHeader('Access-Control-Allow-Origin','*');



    xhr.withCredentials = false;
    //xhr.responseType = 'json';
    // Response handlers.
    xhr.onload = function() {
      var text = xhr.responseText;
      
      var response = this.responseText;
      var resp = JSON.parse(response);
      console.log(resp);
      
      montarArvore(resp)
      
    };


    xhr.onerror = function(){
      alert("Error");
      console.log(this.status);
      console.log(this.responseText);
    };

    xhr.send();


}

function montarArvore(resp){
	var connectionName = {text: "default_detabase"}
	var auxArray = [];

	for( i in resp){

		var table = {text:resp[i].tableName};
		var aux = [];

		for(j in resp[i].attrs){
			var obj = {text:resp[i].attrs[j]}
			aux.push(obj);
		}

		table['nodes'] =  aux;

		auxArray.push(table);

	}

	connectionName['nodes']=auxArray;

	var  treeArray= [connectionName];


	$('#tree').treeview({data: treeArray ,levels: 2,  showBorder: true });
}

