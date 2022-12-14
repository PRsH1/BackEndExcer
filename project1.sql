CREATE DATABASE  IF NOT EXISTS `project1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `project1`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: project1
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `assignment`
--

DROP TABLE IF EXISTS `assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `projectId` int NOT NULL,
  `engineerId` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_assign_project_idx` (`projectId`),
  KEY `FK_assign_engineer_idx` (`engineerId`),
  CONSTRAINT `FK_assign_engineer` FOREIGN KEY (`engineerId`) REFERENCES `engineer` (`id`),
  CONSTRAINT `FK_assign_project` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignment`
--

LOCK TABLES `assignment` WRITE;
/*!40000 ALTER TABLE `assignment` DISABLE KEYS */;
INSERT INTO `assignment` VALUES (1,1,6),(2,1,12),(3,1,18),(4,1,21),(5,1,22),(6,1,26),(7,1,32),(8,1,37),(9,2,3),(10,2,11),(11,2,21),(12,2,22),(13,2,23),(14,2,29),(15,2,30),(16,2,36),(17,2,37),(18,2,38),(19,3,2),(20,3,4),(21,3,8),(22,3,9),(23,3,11),(24,3,17),(25,3,18),(26,3,19),(27,3,24),(28,3,29),(29,3,33),(30,4,1),(31,4,10),(32,4,17),(33,4,19),(34,4,20),(35,4,22),(36,4,26),(37,4,29),(38,4,33),(39,4,39),(40,4,40),(41,5,1),(42,5,2),(43,5,9),(44,5,14),(45,5,15),(46,5,19),(47,5,35),(48,5,36),(49,5,37),(50,6,2),(51,6,13),(52,6,14),(53,6,18),(54,6,26),(55,6,29),(56,6,32),(57,6,37),(58,7,4),(59,7,10),(60,7,12),(61,7,14),(62,7,18),(63,7,19),(64,7,20),(65,7,26),(66,7,33),(67,8,3),(68,8,5),(69,8,7),(70,8,9),(71,8,10),(72,8,13),(73,8,14),(74,8,19),(75,8,21),(76,8,22),(77,8,25),(78,8,29),(79,8,32),(80,8,35),(81,9,2),(82,9,6),(83,9,14),(84,9,15),(85,9,16),(86,9,18),(87,9,20),(88,9,21),(89,9,25),(90,9,29),(91,9,32),(92,9,35),(93,10,2),(94,10,7),(96,10,10),(97,10,11),(98,10,14),(99,10,18),(100,10,21),(101,10,24),(102,10,27),(103,10,31),(104,10,35),(105,10,38),(106,10,39);
/*!40000 ALTER TABLE `assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `engineer`
--

DROP TABLE IF EXISTS `engineer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `engineer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `employeeNo` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `roleId` int NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_engineer_role_idx` (`id`,`roleId`),
  KEY `FK_engineer_role_idx1` (`roleId`),
  CONSTRAINT `FK_engineer_role` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `engineer`
--

LOCK TABLES `engineer` WRITE;
/*!40000 ALTER TABLE `engineer` DISABLE KEYS */;
INSERT INTO `engineer` VALUES (1,'88387','?????????',1,'010-8443-9236','???','sin061@skhu.com'),(2,'54314','?????????',1,'010-8473-3925','???','song261@skhu.com'),(3,'88571','?????????',4,'010-8527-2048','???','hwang201@skhu.com'),(4,'54119','?????????',3,'010-8682-7816','???','lee111@skhu.net'),(5,'25439','?????????',2,'010-8970-8993','???','kim121@skhu.com'),(6,'83007','?????????',2,'010-8991-5565','???','kim261@skhu.com'),(7,'88505','?????????',3,'010-9229-4003','???','lee151@skhu.com'),(8,'19877','?????????',4,'010-9456-3850','???','kim181@skhu.com'),(9,'82981','?????????',3,'010-9474-5563','???','park242@skhu.com'),(10,'59694','?????????',2,'010-9514-7047','???','lee062@skhu.com'),(11,'25595','?????????',1,'010-9599-4595','???','park249@skhu.net'),(12,'25532','?????????',2,'010-6094-7885','???','kim192@skhu.com'),(13,'54080','?????????',2,'010-6263-7067','???','kim082@skhu.com'),(14,'54145','?????????',4,'010-6290-9650','???','lee132@skhu.com'),(15,'83020','?????????',3,'010-6682-2463','???','lee272@skhu.com'),(16,'82851','?????????',1,'010-2897-1525','???','hong142@skhu.net'),(17,'25478','?????????',2,'010-2969-8319','???','park152@skhu.com'),(18,'19721','?????????',3,'010-3031-2894','???','kim063@skhu.com'),(19,'82877','?????????',4,'010-3221-1956','???','sin163@skhu.com'),(20,'54340','?????????',3,'010-3234-5973','???','lee283@skhu.com'),(21,'88634','?????????',2,'010-3317-7481','???','song253@skhu.com'),(22,'88582','?????????',3,'010-3398-7216','???','ko213@skhu.com'),(23,'25634','?????????',1,'010-3603-9475','???','ko273@skhu.com'),(24,'20033','?????????',1,'010-3727-4761','???','cheon303@skhu.net'),(25,'82838','?????????',1,'010-3791-1522','???','kim133@skhu.com'),(26,'88530','?????????',1,'010-3913-6827','???','yeo173@skhu.com'),(27,'82955','?????????',4,'010-3951-2464','???','yu223@skhu.com'),(28,'19838','?????????',2,'010-4005-3498','???','ko154@skhu.com'),(29,'19955','?????????',3,'010-4076-4155','???','song244@skhu.com'),(30,'83059','?????????',1,'010-4194-2860','???','kim304@skhu.com'),(31,'82890','?????????',3,'010-4310-1965','???','seo174@skhu.net'),(32,'82747','?????????',1,'010-4361-1145','???','choi064@skhu.com'),(33,'25491','?????????',2,'010-4467-8333','???','han164@skhu.com'),(34,'82825','?????????',3,'010-4624-1467','???','joo124@skhu.com'),(35,'25505','?????????',1,'010-4717-8565','???','kim174@skhu.net'),(36,'25413','?????????',4,'010-4847-8088','???','kim104@skhu.com'),(37,'88426','?????????',1,'010-4991-6330','???','jeong094@skhu.com'),(38,'88504','?????????',3,'010-5188-6690','???','song155@skhu.com'),(39,'19916','?????????',2,'010-5265-3975','???','park215@skhu.com'),(40,'25556','?????????',2,'010-5426-9109','???','jeong215@skhu.com');
/*!40000 ALTER TABLE `engineer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manager` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `office` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (1,'?????????','010-3814-3042','A301','kimbm30@skhu.com'),(2,'?????????','010-5504-2911','A302','young43@skhu.com'),(3,'?????????','010-3043-1135','B304','dong12@skhu.com'),(4,'?????????','010-1291-6332','C305','jo98@skhu.com'),(5,'?????????','010-4263-7067','B401','kimss@skhu.com');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `managerId` int NOT NULL,
  `progress` int NOT NULL,
  `priority` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `KF_project_manager_idx` (`managerId`),
  CONSTRAINT `KF_project_manager` FOREIGN KEY (`managerId`) REFERENCES `manager` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'???????????????',1,100,'????????????'),(2,'?????????????????????',2,100,'??????'),(3,'OAuth??????',3,85,'??????'),(4,'CMS??????',4,80,'??????'),(5,'?????????v2',5,75,'??????'),(6,'???????????????v2',1,60,'??????'),(7,'SSO??????',2,55,'????????????'),(8,'CMSv2',3,40,'??????'),(9,'?????????v3',4,30,'??????'),(10,'???????????????v1',5,10,'????????????');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'??????????????????'),(2,'????????????????????????'),(3,'QA????????????'),(4,'?????????????????????');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-16 11:59:48
