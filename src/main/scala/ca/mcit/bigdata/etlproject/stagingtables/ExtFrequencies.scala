package ca.mcit.bigdata.etlproject.stagingtables

class ExtFrequencies {
    val ext_frequencies : String =
      "CREATE EXTERNAL TABLE ext_frequencies ("+
      " trip_id STRING, " +
      " start_time STRING, " +
      " end_time STRING, " +
      " headway_secs INT) " +
      " ROW FORMAT DELIMITED " +
      " FIELDS TERMINATED BY ',' " +
      " STORED AS TEXTFILE " +
      " LOCATION '/user/fall2019/mihir/project4/frequencies/' " +
      " tblproperties (" +
      " 'skip.header.line.count' = '1', " +
      " 'serialization.null.format' = '' )"
}
