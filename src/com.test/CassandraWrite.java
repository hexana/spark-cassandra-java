package com.test;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CassandraWrite implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void writeToCassandraTable(Dataset<Row> dataset,String tableName, String keySpace) {
	    Map<String, String> tableProperties = new HashMap<String, String>();
	    tableProperties.put("keyspace", keySpace);
	    tableProperties.put("table", tableName);
	    //tableProperties.put("confirm.truncate", "true");
	    dataset.write().format("org.apache.spark.sql.cassandra").options(tableProperties).mode(SaveMode.Ignore).save();
	}

}
