package br.ufc.pelotonmonitor.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import br.ufc.pelotonmonitor.controllers.ScriptController;
import br.ufc.pelotonmonitor.daos.DatabaseDao;
import br.ufc.pelotonmonitor.models.TableMeta;

@Controller
public class DataBaseMetaService {

	
	 @RequestMapping(value="/connect/{ip}/{port}", method=RequestMethod.GET, produces="application/json") 
	    public @ResponseBody String connection(@PathVariable String ip, @PathVariable String port) {
	       
	    	List<TableMeta> tables = new ArrayList<TableMeta>();
	    	
			try {
				
				Connection connection = DatabaseDao.connectionDatabaseMeta(ip, port,"");
				
				tables = ScriptController.getTables(connection);
				
				String json = new Gson().toJson(tables);
				
				connection.close();
				
				return json;
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();	
				
				String json = new Gson().toJson(tables);
				return json;
				
			}
	    	
	    	
	  
	    } 
	 
	 
}
