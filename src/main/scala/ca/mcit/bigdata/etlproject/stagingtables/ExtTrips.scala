package ca.mcit.bigdata.etlproject.stagingtables

class ExtTrips {
  val ext_trips = "CREATE EXTERNAL TABLE ext_trips ("+
    " route_id INT, " +
    " service_id STRING, " +
    " trip_id STRING, " +
    " trip_headsign STRING, " +
    " direction_id INT, " +
    " shape_id INT, " +
    " wheelchair_accessible INT, " +
    " note_fr STRING, " +
    " note_en STRING) " +
    " ROW FORMAT DELIMITED " +
    " FIELDS TERMINATED BY ',' " +
    " STORED AS TEXTFILE " +
    " LOCATION '/user/fall2019/mihir/project4/trips/' " +
    " tblproperties (" +
    " 'skip.header.line.count' = '1', " +
    " 'serialization.null.format' = '' )"
}
