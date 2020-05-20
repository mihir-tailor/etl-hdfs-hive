package ca.mcit.bigdata.etlproject.stagingtables

class ExtCalendarDates {
  val ext_calendar_dates = "CREATE EXTERNAL TABLE ext_calendar_dates ("+
    " service_id STRING, " +
    " date STRING, " +
    " exception_type INT) " +
    " ROW FORMAT DELIMITED " +
    " FIELDS TERMINATED BY ',' " +
    " STORED AS TEXTFILE " +
    " LOCATION '/user/fall2019/mihir/project4/calendar_dates/' " +
    " tblproperties (" +
    " 'skip.header.line.count' = '1', " +
    " 'serialization.null.format' = '' )"
}
