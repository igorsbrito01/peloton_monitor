package br.ufc.pelotonmonitor.controller;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import br.ufc.pelotonmonitor.dao.DatabaseDao;
import br.ufc.pelotonmonitor.model.TableDefault;
import br.ufc.pelotonmonitor.model.TableMeta;
import br.ufc.pelotonmonitor.controller.DataBaseMetaController;

@Controller
public class DataBaseDefaultController {
	
	@RequestMapping(value="/query/{ip}/{port}/{query}", method=RequestMethod.GET, produces="application/json") 
	public @ResponseBody String  query(@PathVariable String ip, @PathVariable String port, @PathVariable String query){
		
		try {
			Connection connection = DatabaseDao.connectionDatabaseDefault(ip,port);
			//Statement statement = connection.createStatement();
			
			PreparedStatement ps= connection.prepareStatement(query);  
			
			ResultSet rs=ps.executeQuery();  
			ResultSetMetaData rsmd=rs.getMetaData();  
			
			int numeroAttr = rsmd.getColumnCount();
			
			List<String> listAttrs = new ArrayList<String>();
			
			List<List<String>> listAttrVals = new ArrayList<List<String>>();
			
			for(int i  = 1; i <= numeroAttr; i ++){
				listAttrs.add(rsmd.getColumnName(i));
				System.out.println(rsmd.getColumnTypeName(i));
			}
			
			
			Statement statement = connection.createStatement();
			ResultSet bancos  = statement.executeQuery(query);
			
			
			while(bancos.next()){
				List<String> aux = new ArrayList<String>();
				
				for(int j  = 1; j <= numeroAttr; j ++){
					
					if("int4" == rsmd.getColumnTypeName(j)){
						String val = String.valueOf(bancos.getInt(j));
						
						aux.add(val);
						
					}else if("text" == rsmd.getColumnTypeName(j)){
						String val = bancos.getString(j);
						
						aux.add(val);
					}
				}
				
				listAttrVals.add(aux);
				
			}
			
			TableDefault tableDefault = new TableDefault();
			tableDefault.setAttrs(listAttrs);
			tableDefault.setAttrsVal(listAttrVals);
			
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
			
			DataBaseMetaController dbmc = new DataBaseMetaController();
			
			tables =  dbmc.getTables(connection);
			
			String json = new Gson().toJson(tables);
			return json;
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
			
			String json = new Gson().toJson(tables);
			return json;
		}
		
		
	}

}
