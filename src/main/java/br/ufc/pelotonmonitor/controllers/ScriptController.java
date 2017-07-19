package br.ufc.pelotonmonitor.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufc.pelotonmonitor.models.Database;
import br.ufc.pelotonmonitor.models.TableDefault;
import br.ufc.pelotonmonitor.models.TableMeta;

public class ScriptController {

	
	public static TableDefault queryController(Connection connection, String query){
		
		TableDefault tableDefault = new TableDefault();
		
		try {
			
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
			
			tableDefault.setAttrs(listAttrs);
			tableDefault.setAttrsVal(listAttrVals);
			
			return tableDefault;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return tableDefault;
		}
		
		
	}
	
	 public static List<TableMeta> getTables(Connection connection){
		 	
	    	try {
		
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
				
				connection.close();

				return tables;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				List<TableMeta> tables = new ArrayList<TableMeta>();
			
				return tables;
				
			}
		 
		 
	 }
}
