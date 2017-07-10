package br.ufc.pelotonmonitor.controller;

import java.sql.Connection;
import java.sql.ResultSet;
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
import br.ufc.pelotonmonitor.model.Database;
import br.ufc.pelotonmonitor.model.TableMeta;

@Controller
public class DataBaseMetaController {

	
	 @RequestMapping(value="/connect/{ip}/{port}", method=RequestMethod.GET, produces="application/json") 
	    public @ResponseBody String connection(@PathVariable String ip, @PathVariable String port) {
	        //Perform logic with foo 
	    	System.out.println(ip);
	    	System.out.println(port+"123");
	    	
	    	DatabaseDao databaseDao = new DatabaseDao();
	    	try {
				Connection connection = databaseDao.connectionDatabaseMeta(ip, port,"");
				Statement statement = connection.createStatement();
				ResultSet bancos  = statement.executeQuery("select * from pg_catalog.pg_database");
				
				List<Database> databases = new ArrayList<Database>();
				while(bancos.next()){
					
					String id = bancos.getString(1);
					String name = bancos.getString(2);
					
					Database db = new Database(name, id);
					
					databases.add(db);
				}
				
				String idDefaultDatabase = "";
				for(Database db: databases){
					if(db.getName().equals("default_database")){
						idDefaultDatabase = db.getId();
					}
				}
				
				ResultSet tabelas  = statement.executeQuery("select * from pg_catalog.pg_table tb where tb.database_oid = "+idDefaultDatabase);
				
				List<TableMeta> tables = new ArrayList<TableMeta>();
				while(tabelas.next()){
					
					String id = tabelas.getString(1);
					String name = tabelas.getString(2);
					
					TableMeta tm = new TableMeta(name, id);
					
					tables.add(tm);
				}
				
				for(TableMeta tm : tables){
					ResultSet attrs  = statement.executeQuery("select column_name from pg_catalog.pg_attribute ta where ta.table_oid = "+tm.getTableId());
					
					List<String> aux = new ArrayList<String>();
					while(attrs.next()){
						
						String nameAttr = attrs.getString(1);
						aux.add(nameAttr);
					}
					
					tm.setAttrs(aux);
					
				}
				

				String json = new Gson().toJson(tables);
				//return "{status: success, ip:"+ip+",port:"+port+"}";
				return json;
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				List<TableMeta> tables = new ArrayList<TableMeta>();
				
				String json = new Gson().toJson(tables);
				return json;
			}
	    	
	    	//return "{status: success, ip:"+ip+",port:"+port+"}";
	    } 
}
