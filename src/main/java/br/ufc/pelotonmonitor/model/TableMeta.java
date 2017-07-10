package br.ufc.pelotonmonitor.model;

import java.io.Serializable;
import java.util.List;

public class TableMeta implements Serializable {
	
	String tableName;
	String tableId;
	
	List<String> attrs;

	public TableMeta(String tableName, String tableId, List<String> attrs){
		
		this.tableName = tableName;
		this.tableId = tableId;
		this.attrs = attrs;
	}
	
	public TableMeta(String tableName, String tableId){
		
		this.tableName = tableName;
		this.tableId = tableId;
	}
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<String> getAttrs() {
		return attrs;
	}

	public void setAttrs(List<String> attrs) {
		this.attrs = attrs;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}
	
	
	

}

