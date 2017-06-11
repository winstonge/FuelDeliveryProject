-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: valerodb
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(100) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `fax` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `postal_code` varchar(45) DEFAULT NULL,
  `slogan` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `customer_sold_to` varchar(45) DEFAULT NULL,
  `customer_ship_to` varchar(45) DEFAULT NULL,
  `ship_to` varchar(45) DEFAULT NULL,
  `barcode` varchar(45) DEFAULT NULL,
  `company_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`company_id`),
  KEY `fk_customer_company1_idx` (`company_id`),
  CONSTRAINT `fk_customer_company1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `delivery_status`
--

DROP TABLE IF EXISTS `delivery_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(45) DEFAULT NULL,
  `company_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`company_id`),
  KEY `fk_department_company1_idx` (`company_id`),
  CONSTRAINT `fk_department_company1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `device`
--

DROP TABLE IF EXISTS `device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `device` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `device_no` int(11) DEFAULT NULL,
  `last_synch` datetime DEFAULT NULL,
  `department_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`department_id`),
  KEY `fk_device_department1_idx` (`department_id`),
  CONSTRAINT `fk_device_department1` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `driver` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `passnum` varchar(45) DEFAULT NULL,
  `uname` varchar(45) DEFAULT NULL,
  `department_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`department_id`),
  KEY `fk_driver_department1_idx` (`department_id`),
  CONSTRAINT `fk_driver_department1` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `fuel_delivery`
--

DROP TABLE IF EXISTS `fuel_delivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fuel_delivery` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `purchase_order_item` varchar(45) DEFAULT NULL,
  `device_id` int(11) NOT NULL,
  `meter_open_one` int(11) DEFAULT NULL,
  `meter_close_one` int(11) DEFAULT NULL,
  `meter_open_two` int(11) DEFAULT NULL,
  `meter_close_two` int(11) DEFAULT NULL,
  `total_fueled` int(11) DEFAULT NULL,
  `fuel_price` decimal(10,0) DEFAULT NULL,
  `extra_points` int(11) DEFAULT NULL,
  `truck_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`device_id`,`truck_id`),
  KEY `fk_fuel_delivery_device1_idx` (`device_id`),
  KEY `fk_fuel_delivery_truck1_idx` (`truck_id`),
  CONSTRAINT `fk_fuel_delivery_device1` FOREIGN KEY (`device_id`) REFERENCES `device` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_fuel_delivery_truck1` FOREIGN KEY (`truck_id`) REFERENCES `truck` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `fuel_price`
--

DROP TABLE IF EXISTS `fuel_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fuel_price` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `startdate` datetime DEFAULT NULL,
  `enddate` datetime DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `fuel_type_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`fuel_type_id`),
  KEY `fk_fuel_price_fuel_type1_idx` (`fuel_type_id`),
  CONSTRAINT `fk_fuel_price_fuel_type1` FOREIGN KEY (`fuel_type_id`) REFERENCES `fuel_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `fuel_type`
--

DROP TABLE IF EXISTS `fuel_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fuel_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fuel_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `fuelform`
--

DROP TABLE IF EXISTS `fuelform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fuelform` (
  `id` int(11) NOT NULL,
  `customer_sold_to` varchar(45) DEFAULT NULL,
  `cust_firstname` varchar(45) DEFAULT NULL,
  `cust_lastname` varchar(45) DEFAULT NULL,
  `company_id` int(11) NOT NULL,
  `fuelformcol` varchar(45) DEFAULT NULL,
  `payment_type_id` int(11) NOT NULL,
  `fuel_price_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`payment_type_id`,`fuel_price_id`),
  KEY `fk_fuelform_company1_idx` (`company_id`),
  KEY `fk_fuelform_payment_type1_idx` (`payment_type_id`),
  KEY `fk_fuelform_fuel_price1_idx` (`fuel_price_id`),
  CONSTRAINT `fk_fuelform_company1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_fuelform_fuel_price1` FOREIGN KEY (`fuel_price_id`) REFERENCES `fuel_price` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_fuelform_payment_type1` FOREIGN KEY (`payment_type_id`) REFERENCES `payment_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `payment_type`
--

DROP TABLE IF EXISTS `payment_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `purchase_order`
--

DROP TABLE IF EXISTS `purchase_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ticket_no` varchar(45) NOT NULL,
  `purchase_date` datetime NOT NULL,
  `customer_id` int(11) NOT NULL,
  `delivered_on` datetime DEFAULT NULL,
  `payment_type_id` int(11) NOT NULL,
  `purchase_volume` int(11) DEFAULT NULL,
  `fuel_price` decimal(10,0) DEFAULT NULL,
  `fuel_name` varchar(45) DEFAULT NULL,
  `truck_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`customer_id`,`payment_type_id`),
  KEY `fk_purchase_customer1_idx` (`customer_id`),
  KEY `fk_purchase_payment_type1_idx` (`payment_type_id`),
  CONSTRAINT `fk_purchase_customer1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_purchase_payment_type1` FOREIGN KEY (`payment_type_id`) REFERENCES `payment_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `refuel`
--

DROP TABLE IF EXISTS `refuel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `refuel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateadded` datetime DEFAULT NULL,
  `gross_liters` int(11) DEFAULT NULL,
  `tank_content` int(11) DEFAULT NULL,
  `device_id` int(11) NOT NULL,
  `truck_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`device_id`,`truck_id`),
  KEY `fk_refuel_device1_idx` (`device_id`),
  KEY `fk_refuel_truck1_idx` (`truck_id`),
  CONSTRAINT `fk_refuel_device1` FOREIGN KEY (`device_id`) REFERENCES `device` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_refuel_truck1` FOREIGN KEY (`truck_id`) REFERENCES `truck` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `truck`
--

DROP TABLE IF EXISTS `truck`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `truck` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `truck_code` varchar(45) DEFAULT NULL,
  `truck_volume` int(11) DEFAULT NULL,
  `number_of_meters` int(11) DEFAULT NULL,
  `bol` int(11) DEFAULT NULL,
  `department_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`department_id`),
  KEY `fk_truck_department1_idx` (`department_id`),
  CONSTRAINT `fk_truck_department1` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `truck_driver`
--

DROP TABLE IF EXISTS `truck_driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `truck_driver` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `startdate` datetime DEFAULT NULL,
  `enddate` datetime DEFAULT NULL,
  `truck_id` int(11) NOT NULL,
  `driver_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`truck_id`,`driver_id`),
  KEY `fk_truck_driver_truck1_idx` (`truck_id`),
  KEY `fk_truck_driver_driver1_idx` (`driver_id`),
  CONSTRAINT `fk_truck_driver_driver1` FOREIGN KEY (`driver_id`) REFERENCES `driver` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_truck_driver_truck1` FOREIGN KEY (`truck_id`) REFERENCES `truck` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping events for database 'valerodb'
--

--
-- Dumping routines for database 'valerodb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-11 13:34:56
