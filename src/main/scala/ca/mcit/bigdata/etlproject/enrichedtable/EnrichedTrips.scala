package ca.mcit.bigdata.etlproject.enrichedtable

class EnrichedTrips {
  val en_trips = "CREATE TABLE fall2019_mihir.enriched_trips ("+
    " route_id INT, " +
    " service_id STRING, " +
    " trip_id STRING, " +
    " trip_headsign STRING, " +
    " direction_id INT, " +
    " shape_id INT, " +
    " note_fr STRING, " +
    " note_en STRING, " +
    " date STRING, " +
    " exception_type INT, " +
    " start_time STRING, " +
    " end_time STRING, " +
    " headway_secs INT) " +
    " PARTITIONED BY (wheelchair_accessible  INT) " +
    " ROW FORMAT DELIMITED " +
    " FIELDS TERMINATED BY ',' " +
    " STORED AS PARQUET "
}
