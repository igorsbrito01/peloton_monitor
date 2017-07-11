package br.ufc.pelotonmonitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getData() {

		ModelAndView model = new ModelAndView("hello");
	
		return model;

	}
	
	
	@RequestMapping(value = "/graphics", method = RequestMethod.GET)
	public ModelAndView getGraphics() {

		ModelAndView model = new ModelAndView("hello1");
	
		return model;

	}
	
	 @RequestMapping(value="/teste/{foo}", method=RequestMethod.GET, produces="application/json") 
	    public @ResponseBody String byParameter(@PathVariable String foo) {
	        //Perform logic with foo 
	    	System.out.println(foo);
	    	
	        return "{nome:teste5}";
	    } 

}