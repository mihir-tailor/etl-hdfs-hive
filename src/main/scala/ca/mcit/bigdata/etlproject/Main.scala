package ca.mcit.bigdata.etlproject

import java.sql.{Connection, DriverManager}

import ca.mcit.bigdata.etlproject.enrichedtable.{EnrichedTrips, WriteTrips}
import ca.mcit.bigdata.etlproject.hdfs.HdfsConfig
import ca.mcit.bigdata.etlproject.stagingtables.{ExtCalendarDates, ExtFrequencies, ExtTrips}

object Main extends App {
  /*Hadoop Configuration*/
  val hdfs : HdfsConfig = new HdfsConfig()

  /* JDBC - HiveDriver */
  val driverName: String = "org.apache.hive.jdbc.HiveDriver"
  Class.forName(driverName)

  /* Connection String */
  val connection: Connection = DriverManager.getConnection("jdbc:hive2://172.0.0.58:10000/fall2019_mihir;user=;password=")
  val stmt = connection.createStatement()

  /* Query for External Tables */
  stmt.execute("DROP TABLE IF EXISTS fall2019_mihir.ext_trips")
  val ext_trip = new ExtTrips().ext_trips
  stmt.execute(ext_trip)
  println("EXTERNAL TABLE fall2019_mihir.ext_trips CREATED SUCCESSFULLY.")

  stmt.execute("DROP TABLE IF EXISTS fall2019_mihir.ext_calendar_dates")
  val ext_cal = new ExtCalendarDates().ext_calendar_dates
  stmt.execute(ext_cal)
  println("EXTERNAL TABLE fall2019_mihir.ext_calendar_dates CREATED SUCCESSFULLY.")

  stmt.execute("DROP TABLE IF EXISTS ext_frequencies")
  val ext_freq = new ExtFrequencies().ext_frequencies
  stmt.execute(ext_freq)
  println("EXTERNAL TABLE fall2019_mihir.ext_frequencies CREATED SUCCESSFULLY.\n------")

  /* Query for Managed Table */
  stmt.execute("DROP TABLE IF EXISTS fall2019_mihir.enriched_trips")
  val en_trips = new EnrichedTrips().en_trips
  stmt.execute(en_trips)
  println("MANAGED TABLE enriched_trips CREATED SUCCESSFULLY.")

  stmt.execute("set hive.exec.dynamic.partition.mode=nonstrict")
  stmt.execute("set hive.mapred.mode=nonstrict")
  println("WRITING DATA TO enriched_trips Table...")
  val wr_trips = new WriteTrips().write_trips
  stmt.execute(wr_trips)
  println("----- WRITE SUCCESSFUL. -----")

  stmt.close()
  connection.close()
}

