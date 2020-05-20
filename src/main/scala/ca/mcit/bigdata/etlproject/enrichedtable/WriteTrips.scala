package ca.mcit.bigdata.etlproject.enrichedtable

class WriteTrips {
val write_trips = " INSERT OVERWRITE TABLE fall2019_mihir.enriched_trips PARTITION(wheelchair_accessible) " +
  " SELECT a.route_id, " +
  " a.service_id, " +
  " a.trip_id, " +
  " a.trip_headsign, " +
  " a.direction_id, " +
  " a.shape_id, " +
  " a.note_fr, " +
  " a.note_en, " +
  " b.date, " +
  " b.exception_type, " +
  " c.start_time, " +
  " c.end_time, " +
  " c.headway_secs, " +
  " a.wheelchair_accessible " +
  " FROM ext_trips a " +
  " LEFT JOIN ext_calendar_dates b ON a.service_id = b.service_id " +
  " LEFT JOIN ext_frequencies c ON a.trip_id = c.trip_id "
}
