function connectionStart(ip, port, password){
    var xhr = new createCORSRequest();

    xhr.open("GET", "http://localhost:8080/pelotonMonitor/connect/"+ip+"/"+port+"/"+password);

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