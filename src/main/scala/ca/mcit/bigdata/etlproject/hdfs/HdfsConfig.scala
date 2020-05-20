package ca.mcit.bigdata.etlproject.hdfs

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

class HdfsConfig {
  val conf = new Configuration()
  conf.addResource(new Path("/home/bd-user/opt/hadoop-2.7.3/etc/cloudera/core-site.xml"))
  conf.addResource(new Path("/home/bd-user/opt/hadoop-2.7.3/etc/cloudera/hdfs-site.xml"))
  val fs = FileSystem.get(conf)

  if(fs.exists(new Path("/user/fall2019/mihir")))
    if(fs.exists(new Path("/user/fall2019/mihir/project4")))
      fs.delete(new Path("/user/fall2019/mihir/project4"),true)
  fs.mkdirs(new Path("/user/fall2019/mihir/project4"))

  fs.mkdirs(new Path("/user/fall2019/mihir/project4/trips"))
  fs.copyFromLocalFile(new Path("/home/bd-user/project4_stm_gtfs/trips.txt"),
    new Path("/user/fall2019/mihir/project4/trips"))

  fs.mkdirs(new Path("/user/fall2019/mihir/project4/calendar_dates"))
  fs.copyFromLocalFile(new Path("/home/bd-user/project4_stm_gtfs/calendar_dates.txt"),
    new Path("/user/fall2019/mihir/project4/calendar_dates"))

  fs.mkdirs(new Path("/user/fall2019/mihir/project4/frequencies"))
  fs.copyFromLocalFile(new Path("/home/bd-user/project4_stm_gtfs/frequencies.txt"),
    new Path("/user/fall2019/mihir/project4/frequencies"))

  println("------\nFILE UPLOADED TO hdfs SUCCESSFULLY.\n------")
}
