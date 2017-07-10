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

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import br.ufc.pelotonmonitor.dao.DatabaseDao;
import br.ufc.pelotonmonitor.model.Database;
import br.ufc.pelotonmonitor.model.TableDefault;

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
			
			
			return new Gson().toJson(tableDefault);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		
	}
	
	//Metodos temporarios, usados apenas para demonstracao enquando o metodo generico nao fica pronto
	@RequestMapping(value="/queryEmployee", method=RequestMethod.GET, produces="application/json") 
	public @ResponseBody String queryEmployees() throws SQLException, ClassNotFoundException{
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/","default_database", "");
		Statement statement = connection.createStatement();
		ResultSet resultSet  = statement.executeQuery("select * from"
				+ " employees");
		
		List<List<String>> result = new ArrayList<List<String>>();
		System.out.println("Entrou aqui!!==================");
		while(resultSet.next()){
			List<String> list = new ArrayList<String>();
			
			String id = resultSet.getString(1);
			list.add(id);
			String name = resultSet.getString(2);
			list.add(name);
			String sal = resultSet.getString(3);
			list.add(sal);
			String dId = resultSet.getString(4);
			list.add(dId);
			
			result.add(list);
			
		}
		
		return new Gson().toJson(result);
			
	}
	
	@RequestMapping(value="/queryDepartments", method=RequestMethod.GET, produces="application/json") 
	public String queryDepartments() throws SQLException, ClassNotFoundException{
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/","default_database", "");
		Statement statement = connection.createStatement();
		ResultSet resultSet  = statement.executeQuery("select * from departments");
		
		List<List<String>> result = new ArrayList<List<String>>();
		
		while(resultSet.next()){
			List<String> list = new ArrayList<String>();
			
			String id = resultSet.getString(1);
			list.add(id);
			String name = resultSet.getString(2);
			list.add(name);
			String sal = resultSet.getString(3);
			list.add(sal);
			
			result.add(list);
			
		}
		
		return new Gson().toJson(result);
		
		
	}
	

	@RequestMapping(value="/queryClients", method=RequestMethod.GET, produces="application/json") 
	public String queryClients() throws SQLException, ClassNotFoundException{
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/","default_database", "");
		Statement statement = connection.createStatement();
		ResultSet resultSet  = statement.executeQuery("select * from clients");
		
		List<List<String>> result = new ArrayList<List<String>>();
		System.out.println("Entrou aqui!!==================");
		while(resultSet.next()){
			List<String> list = new ArrayList<String>();
			
			String id = resultSet.getString(1);
			list.add(id);
			String name = resultSet.getString(2);
			list.add(name);
			String sal = resultSet.getString(3);
			list.add(sal);
			
		
		
			result.add(list);
			
		}
		
		return new Gson().toJson(result);
		
		
	}
	

}
