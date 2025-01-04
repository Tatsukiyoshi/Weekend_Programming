-- MySQLShell dump 2.0.1  Distrib Ver 9.1.0 for Win64 on x86_64 - for MySQL 9.1.0 (MySQL Community Server (GPL)), for Win64 (x86_64)
--
-- Host: localhost    Database: test    Table: tank_operation
-- ------------------------------------------------------
-- Server version	8.4.2

--
-- Table structure for table `tank_operation`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE IF NOT EXISTS `tank_operation` (
  `tank_operation_id` int NOT NULL AUTO_INCREMENT,
  `status` char(10) DEFAULT NULL,
  PRIMARY KEY (`tank_operation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
