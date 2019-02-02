# spark-cassandra-java
Sample code to insert data to cassandra

Usage
This code is intended to provide an example to read parquet file and inserting data into Cassandra db.(create the keyspace and table in line with schema in cassandra)
To run the example download spark Cassandra connector jar-
spark-cassandra-connector_2.11-2.3.2.jar
Download the project:
git clone https://github.com/hexana/spark-examples/spark-cassandra-java

change below files:
(Cassandra server details needs to be given in PlayObj.scala class. In case Cassandra installed locally set
conf.set("spark.cassandra.connection.host", "localhost") or in case cassandra cluster setup is there provide comma separated list of ip’s
conf.set("spark.cassandra.connection.host", "ip1,ip2,ip3") and after that build the jar)

build the project
cd spark-cassandra-java; mvn clean install

Examples:
In case spark and Cassandra installed locally:
spark-submit --verbose --jars <folder where Cassandra jar stored>/spark-cassandra-connector_2.11-2.3.2.jar --packages com.datastax.spark:spark-cassandra-connector_2.11:2.3.2 --conf spark.cassandra.auth.username="<cassandra user name>" --conf spark.cassandra.auth.password="<cassandra password>" --class com.test.PlayObj --master local[*] <folder location of project jar>/com.test.learning-1.0-SNAPSHOT.jar <parquet file location>/<parquet file> <keyspace in cassandra> <table name>

in case spark is on yarn based cluster:
spark-submit --verbose --jars <folder where Cassandra jar stored>/spark-cassandra-connector_2.11-2.3.2.jar --packages com.datastax.spark:spark-cassandra-connector_2.11:2.3.2 --conf spark.cassandra.auth.username="<cassandra user name>" --conf spark.cassandra.auth.password="<cassandra password>" --class com.test.PlayObj --master yarn <folder location of project jar>/com.test.learning-1.0-SNAPSHOT.jar <parquet file location>/<parquet file> <keyspace in cassandra> <table name>




