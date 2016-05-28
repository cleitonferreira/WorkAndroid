CREATE DATABASE  IF NOT EXISTS `android` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `android`;
-- MySQL dump 10.13  Distrib 5.5.49, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: android
-- ------------------------------------------------------
-- Server version	5.5.49-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `an_car`
--

DROP TABLE IF EXISTS `an_car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `an_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `model` varchar(45) DEFAULT NULL,
  `brand` varchar(45) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `engine` varchar(45) DEFAULT NULL,
  `image_path` varchar(100) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `an_car`
--

LOCK TABLES `an_car` WRITE;
/*!40000 ALTER TABLE `an_car` DISABLE KEYS */;
INSERT INTO `an_car` VALUES (1,'Car 1','Brand 1',2010,'W8','car_01.jpg','R$556.033,00'),(2,'Car 2','Brand 2',2014,'V12','car_02.jpg','R$997.486,00'),(3,'Car 3','Brand 3',2010,'24 valvs','car_03.jpg','R$84.602,00'),(4,'Car 4','Brand 4',2013,'V12','car_04.jpg','R$477.001,00'),(5,'Car 5','Brand 5',2013,'V6','car_05.jpg','R$693.625,00'),(6,'Car 6','Brand 6',2012,'24 valvs','car_06.jpg','R$925.185,00'),(7,'Car 7','Brand 7',2010,'V8','car_07.jpg','R$663.261,00'),(8,'Car 8','Brand 8',2012,'V6','car_08.jpg','R$90.742,00'),(9,'Car 9','Brand 9',2013,'W8','car_09.jpg','R$965.297,00'),(10,'Car 10','Brand 10',2015,'V8','car_10.jpg','R$514.515,00'),(11,'Car 11','Brand 11',2013,'V6','car_11.jpg','R$838.344,00'),(12,'Car 12','Brand 12',2011,'V6','car_12.jpg','R$324.303,00'),(13,'Car 13','Brand 13',2009,'V8','car_13.jpg','R$498.101,00'),(14,'Car 14','Brand 14',2007,'V4','car_14.jpg','R$517.235,00'),(15,'Car 15','Brand 15',2011,'V10','car_15.jpg','R$741.894,00'),(16,'Car 16','Brand 16',2015,'valvs','car_16.jpg','R$845.234,00'),(17,'Car 17','Brand 17',2016,'V8','car_17.jpg','R$981.548,00'),(18,'Car 18','Brand 18',2014,'V6','car_18.jpg','R$659.239,00');
/*!40000 ALTER TABLE `an_car` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-27 21:42:02
