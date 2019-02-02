package com.test
import com.test.CassandraWrite
import org.apache.spark.sql.{Encoders, SparkSession}
import org.apache.spark.sql.types._


class ReaderClass (session:SparkSession,inputPath:String,keySpace:String,tableName:String) extends java.io.Serializable{

  def execute(): Unit ={
    val sampleCase=session.read.option("mode","PERMISSIVE").parquet(inputPath).toDF()

    CassandraWrite.writeToCassandraTable(sampleCase,tableName,keySpace)
    






  }

}