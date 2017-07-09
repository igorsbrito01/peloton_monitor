package br.ufc.pelotonmonitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataBaseMetaController {

	
	 @RequestMapping(value="/connect/{ip}/{port}/{password}", method=RequestMethod.GET, produces="application/json") 
	    public @ResponseBody String connection(@PathVariable String ip, @PathVariable String port, @PathVariable String password) {
	        //Perform logic with foo 
	    	System.out.println(ip);
	    	System.out.println(port);
	    	System.out.println(password);
	    	
	        return "{ip:"+ip+",port:"+port+",password:"+password+"}";
	    } 
}
