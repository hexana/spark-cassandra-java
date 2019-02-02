package com.test

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession

object PlayObj {
  def main(args: Array[String]) {
    val inputPath =args(0)
    val keySpace = args(1)
    val tableName = args(2)
    val conf = new SparkConf();
    //conf.set("spark.cassandra.connection.host", "ip1, ip2, ip3");
    conf.set("spark.cassandra.connection.host", "localhost");
    conf.set("spark.cassandra.connection.port", "9042");
		val spark = SparkSession.builder().appName("FunPlay").config(conf).getOrCreate()
    val job = new ReaderClass(spark,inputPath,keySpace,tableName)
    job.execute()
    
  }
  
}