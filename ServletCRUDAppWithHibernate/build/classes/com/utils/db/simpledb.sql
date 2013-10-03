# HeidiSQL Dump 
#
# --------------------------------------------------------
# Host:                 127.0.0.1
# Database:             simpledb
# Server version:       5.0.45-community-nt
# Server OS:            Win32
# Target-Compatibility: Standard ANSI SQL
# HeidiSQL version:     3.1 RC1 Revision: 1064
# --------------------------------------------------------

/*!40100 SET CHARACTER SET latin1;*/
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ANSI';*/
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;*/


#
# Database structure for database 'simpledb'
#

CREATE DATABASE /*!32312 IF NOT EXISTS*/ "simpledb" /*!40100 DEFAULT CHARACTER SET latin1 */;

USE "simpledb";


#
# Table structure for table 'employee'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "employee" (
  "employeeid" int(10) unsigned NOT NULL,
  "employeename" varchar(255) default NULL,
  "salary" double unsigned default NULL,
  PRIMARY KEY  ("employeeid")
) /*!40100 DEFAULT CHARSET=latin1*/;



#
# Dumping data for table 'employee'
#

/*!40000 ALTER TABLE "employee" DISABLE KEYS;*/
LOCK TABLES "employee" WRITE;
REPLACE INTO "employee" ("employeeid", "employeename", "salary") VALUES
	('111','AAA','100');
REPLACE INTO "employee" ("employeeid", "employeename", "salary") VALUES
	('333','CMC','1200');
REPLACE INTO "employee" ("employeeid", "employeename", "salary") VALUES
	('555','eee','2000');
REPLACE INTO "employee" ("employeeid", "employeename", "salary") VALUES
	('777','ggg','500');
REPLACE INTO "employee" ("employeeid", "employeename", "salary") VALUES
	('999','sri hari','500');
REPLACE INTO "employee" ("employeeid", "employeename", "salary") VALUES
	('1010','dog','5000');
REPLACE INTO "employee" ("employeeid", "employeename", "salary") VALUES
	('1111','ele','2000');
REPLACE INTO "employee" ("employeeid", "employeename", "salary") VALUES
	('1212','fff','1000');
UNLOCK TABLES;
/*!40000 ALTER TABLE "employee" ENABLE KEYS;*/
/*!40101 SET SQL_MODE=@OLD_SQL_MODE;*/
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;*/
