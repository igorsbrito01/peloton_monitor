package br.ufc.pelotonmonitor.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
import br.ufc.pelotonmonitor.models.TableDefault;
import br.ufc.pelotonmonitor.models.TableMeta;

@Controller
public class DataBaseDefaultService {
	
	@RequestMapping(value="/query/{ip}/{port}/{query}", method=RequestMethod.GET, produces="application/json") 
	public @ResponseBody String  query(@PathVariable String ip, @PathVariable String port, @PathVariable String query){
		
		try {
			Connection connection = DatabaseDao.connectionDatabaseDefault(ip,port);

			TableDefault tableDefault = ScriptController.queryController(connection, query);
			
			connection.close();
			
			return new Gson().toJson(tableDefault);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return "";
		}
		
	}
	
	@RequestMapping(value="/insertion/{ip}/{port}/{query}", method=RequestMethod.GET, produces="application/json") 
	public @ResponseBody String  insertion(@PathVariable String ip, @PathVariable String port, @PathVariable String query){
		
		
		try {
			Connection connection = DatabaseDao.connectionDatabaseDefault(ip,port);
			
			PreparedStatement ps= connection.prepareStatement(query);  
			
			ps.executeUpdate();  
			
			connection.close();
			
			return "{status:success}";
			
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
			return "{status:fail}";
		}
		
		
	}
	
	
	@RequestMapping(value="/createtable/{ip}/{port}/{query}", method=RequestMethod.GET, produces="application/json") 
	public @ResponseBody String  createTable(@PathVariable String ip, @PathVariable String port, @PathVariable String query){
		
		
		List<TableMeta> tables = new ArrayList<TableMeta>();
		
		try {
			Connection connection = DatabaseDao.connectionDatabaseDefault(ip,port);
			
			PreparedStatement ps= connection.prepareStatement(query);  
			
			ps.executeUpdate();  
			
			
			tables =  ScriptController.getTables(connection);
			
			connection.close();
			
			String json = new Gson().toJson(tables);
			return json;
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
			
			String json = new Gson().toJson(tables);
			return json;
		}
		
		
	}

}
