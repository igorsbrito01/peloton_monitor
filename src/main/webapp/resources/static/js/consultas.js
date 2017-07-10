function consultaDefault(ip, port, query){
    var xhr = new createCORSRequest();

    xhr.open("GET", "http://localhost:8080/query/connect/"+ip+"/"+port+"/"+query);

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
      //console.log(resp);
      
      montarArvore(text);
      
    };


    xhr.onerror = function(){
      alert("Error");
      console.log(this.status);
      console.log(this.responseText);
    };

    xhr.send();


}