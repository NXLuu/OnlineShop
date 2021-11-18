-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: onlineshop
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `ID` int NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `customerID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Acocunt_Customer_idx` (`customerID`),
  CONSTRAINT `FK_Acocunt_Customer` FOREIGN KEY (`customerID`) REFERENCES `customer` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'test','test',1);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `ID` int NOT NULL,
  `number` int DEFAULT NULL,
  `street` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `district` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `city` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `customerID` int NOT NULL,
  PRIMARY KEY (`ID`,`customerID`),
  KEY `FK_customer_address_idx` (`customerID`),
  CONSTRAINT `FK_customer_address` FOREIGN KEY (`customerID`) REFERENCES `customer` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `author` (
  `ID` int NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Biography` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (1,'JOSÉ MAURO DE VASCONCELOS','JOSÉ MAURO DE VASCONCELOS (1920-1984) là nhà văn người Brazil. Sinh ra trong một gia đình nghèo ở ngoại ô Rio de Janeiro, lớn lên ông phải làm đủ nghề để kiếm sống.Ông bắt đầu sáng tác năm 22 tuổi.'),(2,'Matt Haig','Matt Haig (sinh năm 1975) là một nhà báo và tiểu thuyết gia người Anh.'),(3,'Hà Ân','Tên thật là Hoàng Hiển Mô, quê ở Hà Nội.Ông gia nhập Trung đoàn thủ đô liên khu I năm 1947, rồi làm trưởng ty Hoa kiều vụ tỉnh Lào Cai năm 1948.'),(4,'Nina George','Nina George (30 tháng 8 năm 1973) là một nhà văn người Đức,');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `ISBN` varchar(255) NOT NULL,
  `Title` varchar(45) NOT NULL,
  `Summary` varchar(255) DEFAULT NULL,
  `PublicationDate` varchar(45) DEFAULT NULL,
  `NumberOfPages` int DEFAULT NULL,
  `Language` varchar(45) DEFAULT NULL,
  `Size` varchar(45) DEFAULT NULL,
  `PublisherID` int NOT NULL,
  `SupplierID` int NOT NULL,
  PRIMARY KEY (`ISBN`),
  UNIQUE KEY `ISBN_UNIQUE` (`ISBN`),
  KEY `PublisherID` (`PublisherID`) /*!80000 INVISIBLE */,
  KEY `SupplierID` (`SupplierID`),
  CONSTRAINT `publisherID-fk` FOREIGN KEY (`PublisherID`) REFERENCES `publisher` (`ID`),
  CONSTRAINT `supplierID-fk` FOREIGN KEY (`SupplierID`) REFERENCES `supplier` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES ('978-0-07-575212-7','Người Thăng Long','Người Thăng Long bản trường ca hào hùng về các vị vương, tướng nhà Trần trong cuộc chiến chống Nguyên Mông lần thứ hai.','2021-09-01',292,'Tiếng Việt','16 x 24 cm',1,2),('978-0-7356-2387-3','Hiệu sách nhỏ ở Paris','Cuốn sách là câu chuyện về Monsieur Perdu, chủ tiệm sách bên bờ sông Seine, người tự gọi mình là dược sĩ văn chương.','2020-06-19',452,'Tiếng Việt','14 x 20.5 cm',6,1),('978-1-2345-6789-7','Thư viện nửa đêm','Cuộc đời Nora Seed tràn ngập khổ sở và nuối tiếc. Cô có nhiều khả năng nhưng lại ít thành tựu, và luôn cảm thấy mình đã làm mọi \nngười xung quanh mình thất vọng.','2021-08-01',424,'Tiếng Việt','14 x 20.5 cm',7,1),('978-1-78280808-4','Cây cam ngọt của tôi','Hãy làm quen với Zezé, cậu bé tinh nghịch siêu hạng đồng thời cũng đáng yêu bậc nhất, với ước mơ lớn lên trở thành nhà thơ cổ thắt nơ bướm.','2021-09-10',244,'Tiếng Việt','14 x 20.5 cm',7,1);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookauthor`
--

DROP TABLE IF EXISTS `bookauthor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookauthor` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `AuthorID` int NOT NULL,
  `BookID` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  KEY `AuthorID` (`AuthorID`),
  KEY `BookID` (`BookID`),
  CONSTRAINT `bookauthor_ibfk_1` FOREIGN KEY (`BookID`) REFERENCES `book` (`ISBN`),
  CONSTRAINT `bookauthor_ibfk_2` FOREIGN KEY (`AuthorID`) REFERENCES `author` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookauthor`
--

LOCK TABLES `bookauthor` WRITE;
/*!40000 ALTER TABLE `bookauthor` DISABLE KEYS */;
INSERT INTO `bookauthor` VALUES (1,4,'978-0-7356-2387-3'),(2,2,'978-1-2345-6789-7'),(3,3,'978-0-07-575212-7'),(4,1,'978-1-78280808-4');
/*!40000 ALTER TABLE `bookauthor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookcategory`
--

DROP TABLE IF EXISTS `bookcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookcategory` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `BookID` varchar(45) NOT NULL,
  `CategoryID` int NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  KEY `BookID` (`BookID`),
  KEY `CategoryID` (`CategoryID`),
  CONSTRAINT `bookcategory_ibfk_1` FOREIGN KEY (`BookID`) REFERENCES `book` (`ISBN`),
  CONSTRAINT `bookcategory_ibfk_2` FOREIGN KEY (`CategoryID`) REFERENCES `category` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookcategory`
--

LOCK TABLES `bookcategory` WRITE;
/*!40000 ALTER TABLE `bookcategory` DISABLE KEYS */;
INSERT INTO `bookcategory` VALUES (1,'978-0-7356-2387-3',1),(2,'978-1-2345-6789-7',2),(3,'978-1-78280808-4',2),(4,'978-1-78280808-4',3);
/*!40000 ALTER TABLE `bookcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booktranslator`
--

DROP TABLE IF EXISTS `booktranslator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booktranslator` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `BookID` varchar(45) NOT NULL,
  `TranslatorID` int NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  KEY `BookID` (`BookID`),
  KEY `TranslatorID` (`TranslatorID`),
  CONSTRAINT `booktranslator_ibfk_1` FOREIGN KEY (`BookID`) REFERENCES `book` (`ISBN`),
  CONSTRAINT `booktranslator_ibfk_2` FOREIGN KEY (`TranslatorID`) REFERENCES `translator` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booktranslator`
--

LOCK TABLES `booktranslator` WRITE;
/*!40000 ALTER TABLE `booktranslator` DISABLE KEYS */;
INSERT INTO `booktranslator` VALUES (1,'978-0-7356-2387-3',2),(2,'978-1-2345-6789-7',1),(3,'978-1-78280808-4',3),(4,'978-1-78280808-4',4);
/*!40000 ALTER TABLE `booktranslator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `quantity` int DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `item` varchar(45) DEFAULT NULL,
  `totalPrice` double DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (1,0,'2019-10-20','Dayf da loonj',NULL),(2,0,'2019-10-20','dsaf',NULL),(3,0,'2019-10-20','sgadsg',NULL),(4,0,'0000-00-00',NULL,NULL),(5,0,'0000-00-00',NULL,NULL),(6,0,'0000-00-00',NULL,NULL),(7,0,'0000-00-00',NULL,NULL),(8,0,'0000-00-00',NULL,NULL),(9,0,'0000-00-00',NULL,NULL),(10,0,'0000-00-00',NULL,NULL),(11,0,'0000-00-00',NULL,NULL),(12,0,'0000-00-00',NULL,NULL),(13,0,'0000-00-00',NULL,NULL),(14,0,'0000-00-00',NULL,NULL),(15,0,'0000-00-00',NULL,NULL),(16,0,'0000-00-00',NULL,NULL),(17,0,'0000-00-00',NULL,NULL),(18,0,'0000-00-00',NULL,NULL),(19,0,'0000-00-00',NULL,NULL),(20,0,'0000-00-00',NULL,NULL),(21,0,'0000-00-00',NULL,NULL),(22,0,'0000-00-00',NULL,NULL),(23,0,'0000-00-00',NULL,NULL),(24,24,'0000-00-00','null1@Dày lộn@1234.0\\',1234),(25,25,'0000-00-00','null1@Dày lộn@1234.0\\1@Dày lộn@1234.0\\',2468),(26,26,'0000-00-00','null1@Dày lộn@1234.0\\',1234),(27,27,'0000-00-00','null1@Dày lộn@1234.0-',1234),(28,28,'0000-00-00','null1@Dày lộn@1234.0-1@Dày lộn@1234.0-',2468),(29,29,'0000-00-00','null1-',1234),(30,30,'0000-00-00','null1-',1234),(31,31,'0000-00-00','null1-',1234),(32,0,'0000-00-00',NULL,NULL),(33,0,'0000-00-00',NULL,NULL),(34,34,'0000-00-00','null1-',1234),(35,35,'0000-00-00','1',2468),(36,36,'0000-00-00','1',1234),(37,37,'0000-00-00','1',1234),(38,0,'0000-00-00',NULL,NULL),(39,39,'0000-00-00','1',1234),(40,0,'0000-00-00',NULL,NULL),(41,41,'0000-00-00','1',3702),(42,42,'0000-00-00','',1234),(43,43,'0000-00-00','',1234),(44,0,'0000-00-00',NULL,NULL),(45,45,'0000-00-00',NULL,1234),(46,46,'0000-00-00','1',2468),(47,0,'0000-00-00',NULL,NULL),(48,0,'0000-00-00',NULL,NULL),(49,0,'0000-00-00',NULL,NULL),(50,0,'0000-00-00',NULL,NULL),(51,0,'0000-00-00',NULL,NULL),(52,0,'0000-00-00',NULL,NULL),(53,0,'0000-00-00',NULL,NULL),(54,54,'0000-00-00','1',1234),(55,0,'0000-00-00',NULL,NULL),(56,0,'0000-00-00',NULL,NULL),(57,0,'0000-00-00',NULL,NULL),(58,0,'0000-00-00',NULL,NULL),(59,0,'0000-00-00',NULL,NULL),(60,0,'0000-00-00',NULL,NULL),(61,61,'0000-00-00','1',1234),(62,0,'0000-00-00',NULL,NULL),(63,0,'0000-00-00',NULL,NULL),(64,0,'0000-00-00',NULL,NULL),(65,65,'0000-00-00','1',1234),(66,66,'0000-00-00','1',1234),(67,0,'0000-00-00',NULL,NULL),(68,0,'0000-00-00',NULL,NULL),(69,0,'0000-00-00',NULL,NULL),(70,70,'0000-00-00','s_1',1234),(71,0,'0000-00-00',NULL,NULL),(72,0,'0000-00-00',NULL,NULL),(73,73,'0000-00-00','s_1',1384),(74,0,'0000-00-00',NULL,NULL),(75,75,'0000-00-00','s_1',1384),(76,76,'0000-00-00','c_1',150),(77,77,'0000-00-00','c_2',1443),(78,78,'0000-00-00','c_1-c_2-s_1',1593),(79,79,'0000-00-00','-c_1',150),(80,80,'0000-00-00','-c_2',209),(81,81,'0000-00-00','-c_2',209),(82,82,'0000-00-00','-s_1-c_1-c_2',1593),(83,83,'0000-00-00',NULL,1443),(84,84,'0000-00-00',NULL,1593),(85,85,'0000-00-00',NULL,1234),(86,86,'0000-00-00','e_4-c_2-s_1-c_1',3336),(87,87,'0000-00-00','---c_2-c_1',359),(88,88,'0000-00-00','--c_2',209),(89,0,'0000-00-00',NULL,NULL),(90,90,'0000-00-00','-e_1-e_1',8800000),(91,91,'0000-00-00','--e_1',4400000),(92,92,'0000-00-00','e_1',4400000),(93,93,'0000-00-00','---e_1-e_2-e_3',17200000),(94,0,'0000-00-00',NULL,NULL),(95,0,'0000-00-00',NULL,NULL),(96,0,'0000-00-00',NULL,NULL),(97,0,'0000-00-00',NULL,NULL),(98,0,'0000-00-00',NULL,NULL),(99,0,'0000-00-00',NULL,NULL),(100,0,'0000-00-00',NULL,NULL),(101,101,'0000-00-00','e_1-s_1-e_1-c_1@s_1',8802618),(102,102,'0000-00-00','@e_2@s_1',10401234),(103,0,'0000-00-00',NULL,NULL),(104,0,'0000-00-00',NULL,NULL),(105,105,'0000-00-00','s_1',1234),(106,0,'0000-00-00',NULL,NULL),(107,0,'0000-00-00',NULL,NULL),(108,0,'0000-00-00',NULL,NULL),(109,0,'0000-00-00',NULL,NULL),(110,0,'0000-00-00',NULL,NULL),(111,0,'0000-00-00',NULL,NULL),(112,0,'0000-00-00',NULL,NULL),(113,0,'0000-00-00',NULL,NULL),(114,0,'0000-00-00',NULL,NULL),(115,115,'0000-00-00','e_1',4400000),(116,116,'0000-00-00','b_978-0-07-575212-7@b_978-0-07-575212-7',250000),(117,117,'0000-00-00','@@@@c_2@s_1@e_1@e_2@e_3@e_4',20501443),(118,0,'0000-00-00',NULL,NULL),(119,119,'0000-00-00','@@e_2@s_1',10401234),(120,0,'0000-00-00',NULL,NULL),(121,0,'0000-00-00',NULL,NULL),(122,122,'0000-00-00','@@s_1@e_2@e_2',20801234),(123,123,'0000-00-00',NULL,0);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_itemshoes`
--

DROP TABLE IF EXISTS `cart_itemshoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_itemshoes` (
  `cartID` int DEFAULT NULL,
  `itemShoesID` int DEFAULT NULL,
  KEY `FK_cart_itemshoes1_idx` (`itemShoesID`),
  KEY `FK_cart_itemshoes2` (`cartID`),
  CONSTRAINT `FK_cart_itemshoes1` FOREIGN KEY (`itemShoesID`) REFERENCES `itemshoes` (`ID`),
  CONSTRAINT `FK_cart_itemshoes2` FOREIGN KEY (`cartID`) REFERENCES `cart` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_itemshoes`
--

LOCK TABLES `cart_itemshoes` WRITE;
/*!40000 ALTER TABLE `cart_itemshoes` DISABLE KEYS */;
INSERT INTO `cart_itemshoes` VALUES (1,1),(1,1),(1,1),(1,1),(1,1),(1,1),(1,1),(1,1),(1,1),(1,1),(1,1),(1,1),(15,1),(15,1),(16,1),(16,1),(17,1),(17,1),(17,1),(17,1),(19,1),(19,1),(20,1),(20,1),(21,1),(21,1),(22,1),(22,1),(23,1),(23,1),(24,1),(24,1),(25,1),(25,1),(25,1),(25,1),(25,1),(25,1),(26,1),(26,1),(27,1),(27,1),(28,1),(28,1),(28,1),(28,1),(29,1),(29,1),(30,1),(30,1),(31,1),(31,1),(34,1),(34,1),(35,1),(35,1),(35,1),(35,1),(36,1),(36,1),(37,1),(37,1),(39,1),(39,1),(41,1),(41,1),(41,1),(41,1),(41,1),(41,1),(42,1),(42,1),(43,1),(43,1),(45,1),(45,1),(46,1),(46,1),(46,1),(46,1),(54,1),(54,1),(61,1),(61,1),(65,1),(65,1),(66,1),(66,1),(70,1),(70,1),(73,1),(73,1),(75,1),(75,1),(77,1),(77,1),(78,1),(78,1),(82,1),(82,1),(83,1),(83,1),(84,1),(84,1),(85,1),(85,1),(86,1),(86,1),(86,1),(86,1),(87,1),(87,1),(88,1),(88,1),(93,1),(93,1),(101,1),(101,1),(101,1),(101,1),(102,1),(102,1),(105,1),(105,1),(117,1),(117,1),(119,1),(119,1),(122,1),(122,1);
/*!40000 ALTER TABLE `cart_itemshoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `ID` int NOT NULL,
  `Type` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Tiểu thuyết'),(2,'Truyện giả tưởng,huyền bí'),(3,'Tác phẩm kinh điển');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clothes`
--

DROP TABLE IF EXISTS `clothes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clothes` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Brand` varchar(45) NOT NULL,
  `Color` varchar(45) NOT NULL,
  `Material` varchar(45) NOT NULL,
  `Design` varchar(45) NOT NULL,
  `Producer` varchar(45) NOT NULL,
  `Size` varchar(45) NOT NULL,
  `Delivery` varchar(45) NOT NULL,
  `PlaceSell` varchar(45) NOT NULL,
  `ClothesCategoryID` int NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `id_UNIQUE` (`ID`),
  KEY `ClothesCategoryID` (`ClothesCategoryID`),
  CONSTRAINT `clothes_ibfk_1` FOREIGN KEY (`ClothesCategoryID`) REFERENCES `clothescategory` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clothes`
--

LOCK TABLES `clothes` WRITE;
/*!40000 ALTER TABLE `clothes` DISABLE KEYS */;
INSERT INTO `clothes` VALUES (1,'Croptop','LV','Trang','Cotton','Ngan tay','Cong ty A','S','Hang noi đia','Shop B',1),(2,'Ao Polo','Chanel','Đen','Cotton','Ngan tay','Cong ty C','L','Hang quoc te','Shop B',3);
/*!40000 ALTER TABLE `clothes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clothescategory`
--

DROP TABLE IF EXISTS `clothescategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clothescategory` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Type` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clothescategory`
--

LOCK TABLES `clothescategory` WRITE;
/*!40000 ALTER TABLE `clothescategory` DISABLE KEYS */;
INSERT INTO `clothescategory` VALUES (1,'Ao nu'),(2,'Dam nu'),(3,'Ao thun nam');
/*!40000 ALTER TABLE `clothescategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `computer`
--

DROP TABLE IF EXISTS `computer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `computer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `version` varchar(500) NOT NULL,
  `ram` varchar(500) NOT NULL,
  `disk` varchar(500) NOT NULL,
  `screen_width` varchar(500) DEFAULT NULL,
  `type` varchar(500) DEFAULT NULL,
  `user_type` varchar(500) DEFAULT NULL,
  `des` varchar(500) DEFAULT NULL,
  `advantages` varchar(500) DEFAULT NULL,
  `defect` varchar(500) DEFAULT NULL,
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `computer`
--

LOCK TABLES `computer` WRITE;
/*!40000 ALTER TABLE `computer` DISABLE KEYS */;
INSERT INTO `computer` VALUES (1,'2.1.0','8GB','512GB SSD','15.6 inch',NULL,NULL,'Laptop 2020','Mỏng nhẹ','Máy nóng',_binary '\0','2021-11-17 00:00:00','2021-11-17 00:00:00'),(2,'3.2.0','16GB Bus 2666','256GB SSD','14 inch',NULL,NULL,'CASE DELL 2020','Mỏng nhẹ','Máy nóng',_binary '\0','2021-11-17 00:00:00','2021-11-17 00:00:00'),(3,'4.2.3','32GB Bus 1666','128GB SSD','16 inch',NULL,NULL,'Macbook pro 2020','Mỏng nhẹ, sang trọng','Máy nóng',_binary '\0','2021-11-17 00:00:00','2021-11-17 00:00:00'),(4,'3.2.1','4GB Bus 3200','1TB SSD','26 inch',NULL,NULL,'Laptop asus fx504gd','lap top gamming hot','Máy mát',_binary '\0','2021-11-17 00:00:00','2021-11-17 00:00:00'),(5,'4.5.1','16GB Bus 2666','512GB SSD','27 inch',NULL,NULL,'PC gamming','to, khó di chuyển','Máy mát',_binary '\0','2021-11-17 00:00:00','2021-11-17 00:00:00'),(6,'5.0.0','8GB Bus 1666','256GB SSD','15.6 inch',NULL,NULL,'Macbook Air 2018','Mỏng nhẹ','Máy nóng',_binary '\0','2021-11-17 00:00:00','2021-11-17 00:00:00');
/*!40000 ALTER TABLE `computer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `phone` varchar(45) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `img` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'0394214','1','2019-10-10','safd');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `electronic`
--

DROP TABLE IF EXISTS `electronic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `electronic` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(500) NOT NULL,
  `producer` varchar(500) NOT NULL,
  `type` varchar(500) DEFAULT NULL,
  `producer_date` datetime NOT NULL,
  `hold_house_id` int DEFAULT NULL,
  `mobile_id` int DEFAULT NULL,
  `pc_id` int DEFAULT NULL,
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `electronic`
--

LOCK TABLES `electronic` WRITE;
/*!40000 ALTER TABLE `electronic` DISABLE KEYS */;
INSERT INTO `electronic` VALUES (1,'Điều hoà','Panasonic',NULL,'2021-11-17 00:00:00',2,0,0,_binary '\0','2021-11-17 00:00:00','2021-11-17 00:00:00'),(2,'Điện thoại','XIAOMI',NULL,'2021-11-17 00:00:00',0,3,0,_binary '\0','2021-11-17 00:00:00','2021-11-17 00:00:00'),(3,'Máy tính','Dell',NULL,'2021-11-17 00:00:00',0,0,1,_binary '\0','2021-11-17 00:00:00','2021-11-17 00:00:00'),(4,'Tủ lạnh','SAMSUNG',NULL,'2021-11-17 00:00:00',4,0,0,_binary '\0','2021-11-17 00:00:00','2021-11-17 00:00:00');
/*!40000 ALTER TABLE `electronic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fullname`
--

DROP TABLE IF EXISTS `fullname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fullname` (
  `ID` int NOT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `midname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `customerID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_fullname_customer_idx` (`customerID`),
  CONSTRAINT `FK_fullname_customer` FOREIGN KEY (`customerID`) REFERENCES `customer` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fullname`
--

LOCK TABLES `fullname` WRITE;
/*!40000 ALTER TABLE `fullname` DISABLE KEYS */;
/*!40000 ALTER TABLE `fullname` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hold_house`
--

DROP TABLE IF EXISTS `hold_house`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hold_house` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(500) DEFAULT NULL,
  `power` float NOT NULL,
  `insurance` float DEFAULT NULL,
  `longevity` float DEFAULT NULL,
  `technology_used` varchar(500) DEFAULT NULL,
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hold_house`
--

LOCK TABLES `hold_house` WRITE;
/*!40000 ALTER TABLE `hold_house` DISABLE KEYS */;
INSERT INTO `hold_house` VALUES (1,NULL,250,3,5,'Tiết kiệm điện',_binary '\0','2021-11-17 00:00:00','2021-11-17 00:00:00'),(2,NULL,220,3,5,'Lọc không khí',_binary '\0','2021-11-17 00:00:00','2021-11-17 00:00:00'),(3,NULL,222,3,5,'Tự đông ngắt điện khi đầy',_binary '\0','2021-11-17 00:00:00','2021-11-17 00:00:00'),(4,NULL,225,3,5,'Tiết kiệm điện',_binary '\0','2021-11-17 00:00:00','2021-11-17 00:00:00'),(5,NULL,200,3,5,'Tiết kiệm điện',_binary '\0','2021-11-17 00:00:00','2021-11-17 00:00:00');
/*!40000 ALTER TABLE `hold_house` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_electronic`
--

DROP TABLE IF EXISTS `item_electronic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_electronic` (
  `id` int NOT NULL AUTO_INCREMENT,
  `price` float NOT NULL,
  `discount` float DEFAULT NULL,
  `electronic_id` int NOT NULL,
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `image` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `electronic_id` (`electronic_id`),
  CONSTRAINT `item_electronic_ibfk_1` FOREIGN KEY (`electronic_id`) REFERENCES `electronic` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_electronic`
--

LOCK TABLES `item_electronic` WRITE;
/*!40000 ALTER TABLE `item_electronic` DISABLE KEYS */;
INSERT INTO `item_electronic` VALUES (1,4400000,20,2,_binary '\0','2021-11-17 00:00:00','2021-11-17 00:00:00','https://cdn.fptshop.com.vn/Uploads/Originals/2020/10/26/637393169370716242_ip-xr-dd.png'),(2,10400000,0,1,_binary '\0','2021-11-17 00:00:00','2021-11-17 00:00:00','https://hc.com.vn/i/ecommerce/media/DL.001911_FEATURE_57602.jpg'),(3,2400000,25,4,_binary '\0','2021-11-17 00:00:00','2021-11-17 00:00:00','https://cdn01.dienmaycholon.vn/filewebdmclnew/public/picture/product/product16274/dmcl_450_product_16274_1.png'),(4,3300000,35,3,_binary '\0','2021-11-17 00:00:00','2021-11-17 00:00:00','https://cf.shopee.vn/file/3b590abab16c9023048a9bc166df9a22');
/*!40000 ALTER TABLE `item_electronic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itembook`
--

DROP TABLE IF EXISTS `itembook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itembook` (
  `Barcode` varchar(45) NOT NULL,
  `Price` float NOT NULL,
  `Intro` varchar(255) DEFAULT NULL,
  `Discount` varchar(45) DEFAULT NULL,
  `BookID` varchar(45) DEFAULT NULL,
  `image` varchar(555) DEFAULT NULL,
  PRIMARY KEY (`Barcode`),
  UNIQUE KEY `barcode_UNIQUE` (`Barcode`),
  KEY `bookId` (`BookID`),
  CONSTRAINT `itembook_ibfk_1` FOREIGN KEY (`BookID`) REFERENCES `book` (`ISBN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itembook`
--

LOCK TABLES `itembook` WRITE;
/*!40000 ALTER TABLE `itembook` DISABLE KEYS */;
INSERT INTO `itembook` VALUES ('1',120000,'Hiệu sách nhỏ ở Paris là một lá thư tình gửi đến sách.','','978-0-7356-2387-3','https://sach.review/wp-content/uploads/2021/08/nguoi-duoc-si-van-chuong.jpg'),('2',150000,'Thắng hạng mục sách hư cấu của Goodreads.',NULL,'978-1-2345-6789-7','https://salt.tikicdn.com/cache/400x400/ts/product/8e/32/3d/e4487c4c7e335bbda4f06dd54d8e35b8.jpg.webp'),('3',125000,'Người đọc như bị cuốn vào không khí hừng hực ý chí chiến đấu của hội nghị Diên Hồng…','','978-0-07-575212-7','https://isach.info/images/story/cover/nguoi_thang_long__ha_an.jpg'),('4',168000,'Một cách nhìn cuộc sống gần như hoàn chỉnh từ con mắt trẻ thơ… có sức mạnh sưởi ấm và làm tan nát cõi lòng, dù người đọc ở lứa tuổi nào.',NULL,'978-1-78280808-4','https://salt.tikicdn.com/cache/w1200/ts/product/5e/18/24/2a6154ba08df6ce6161c13f4303fa19e.jpg');
/*!40000 ALTER TABLE `itembook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemclothes`
--

DROP TABLE IF EXISTS `itemclothes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itemclothes` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Price` float NOT NULL,
  `Image` varchar(255) NOT NULL,
  `Description` varchar(45) NOT NULL,
  `ClothesID` int NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  KEY `ClothesID` (`ClothesID`),
  CONSTRAINT `itemclothes_ibfk_1` FOREIGN KEY (`ClothesID`) REFERENCES `clothes` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemclothes`
--

LOCK TABLES `itemclothes` WRITE;
/*!40000 ALTER TABLE `itemclothes` DISABLE KEYS */;
INSERT INTO `itemclothes` VALUES (1,150,'https://bizweb.dktcdn.net/100/287/440/products/tong.jpg?v=1629540867020','Duoi 42kg',1),(2,209,'https://taha.vn/images/thumbnails/380/475/detailed/16/Ao-thun-nam-Polo-Ralphlauren-009.jpg?t=1588846860','Duoi 60kg',2);
/*!40000 ALTER TABLE `itemclothes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemshoes`
--

DROP TABLE IF EXISTS `itemshoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itemshoes` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Price` float NOT NULL,
  `Image` varchar(255) DEFAULT NULL,
  `Discount` float NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemshoes`
--

LOCK TABLES `itemshoes` WRITE;
/*!40000 ALTER TABLE `itemshoes` DISABLE KEYS */;
INSERT INTO `itemshoes` VALUES (1,'Dày lộn',1234,'https://giayxshop.vn/wp-content/uploads/2021/01/z2261641090407_9a527dfa37fa44a1b8cfd0fd14d1ca77-scaled.jpg',0);
/*!40000 ALTER TABLE `itemshoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mobile`
--

DROP TABLE IF EXISTS `mobile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mobile` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ram` varchar(500) NOT NULL,
  `disk` varchar(500) NOT NULL,
  `screen_width` varchar(500) NOT NULL,
  `chipset` varchar(500) NOT NULL,
  `version` varchar(500) NOT NULL,
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mobile`
--

LOCK TABLES `mobile` WRITE;
/*!40000 ALTER TABLE `mobile` DISABLE KEYS */;
INSERT INTO `mobile` VALUES (1,'8GB','64GB','5 inch','snap 450','7.0.0',_binary '\0','2021-11-17 00:00:00','2021-11-17 00:00:00'),(2,'6GB','64GB','6 inch','snap 855','7.0.0',_binary '\0','2021-11-17 00:00:00','2021-11-17 00:00:00'),(3,'4GB','64GB','5 inch','snap 845','7.0.0',_binary '\0','2021-11-17 00:00:00','2021-11-17 00:00:00'),(4,'16GB','64GB','4 inch','snap 710','7.0.0',_binary '\0','2021-11-17 00:00:00','2021-11-17 00:00:00');
/*!40000 ALTER TABLE `mobile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `ID` int NOT NULL,
  `customerID` int DEFAULT NULL,
  `totalPrice` float DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_order_customer_idx` (`customerID`),
  CONSTRAINT `FK_order_customer` FOREIGN KEY (`customerID`) REFERENCES `customer` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publisher`
--

DROP TABLE IF EXISTS `publisher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publisher` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publisher`
--

LOCK TABLES `publisher` WRITE;
/*!40000 ALTER TABLE `publisher` DISABLE KEYS */;
INSERT INTO `publisher` VALUES (1,'NXB Kim Đồng','55 Quang Trung, Hà Nội, Việt Nam'),(2,'NXB Văn học','18 Nguyễn Trường Tộ - Ba Đình - Hà Nội'),(3,'NXB Trẻ','P.Võ Thị Sáu, Quận 3.Thành phố Hồ Chí Minh'),(4,'Alphabooks','282 Nguyễn Huy Tưởng, Thanh Xuân, Hà Nội'),(5,'Nhã Nam','Quận Cầu Giấy, Hà Nội'),(6,'NXB Hà Nội','Quận Hoàn Kiếm, Hà Nội'),(7,'NXB Hội nhà văn','65 Nguyễn Du, quận Hai Bà Trưng, Hà Nội ');
/*!40000 ALTER TABLE `publisher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment`
--

DROP TABLE IF EXISTS `shipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipment` (
  `ID` int NOT NULL,
  `shipmentMethod` varchar(45) DEFAULT NULL,
  `cost` float DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  `orderID` int DEFAULT NULL,
  `cartID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_shipment_order_idx` (`orderID`),
  CONSTRAINT `FK_shipment_order` FOREIGN KEY (`orderID`) REFERENCES `order` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment`
--

LOCK TABLES `shipment` WRITE;
/*!40000 ALTER TABLE `shipment` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shoes`
--

DROP TABLE IF EXISTS `shoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shoes` (
  `ID` int NOT NULL,
  `Type` varchar(20) NOT NULL,
  `Size` varchar(20) NOT NULL,
  `Trademark` varchar(20) NOT NULL,
  `Materia` varchar(20) NOT NULL,
  `Pattern` varchar(20) NOT NULL,
  `Color` varchar(20) NOT NULL,
  `Gender` tinyint(1) NOT NULL,
  `Description` varchar(20) NOT NULL,
  `Promotion` int NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoes`
--

LOCK TABLES `shoes` WRITE;
/*!40000 ALTER TABLE `shoes` DISABLE KEYS */;
INSERT INTO `shoes` VALUES (1,'Giày nam','100','Hà Nội','Da lôn','sadf','Xanh',0,'Giày rất là xịn',1);
/*!40000 ALTER TABLE `shoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `ID` int NOT NULL,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'Nhã Nam'),(2,'NXB Kim Đồng');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `translator`
--

DROP TABLE IF EXISTS `translator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `translator` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Biography` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `translator`
--

LOCK TABLES `translator` WRITE;
/*!40000 ALTER TABLE `translator` DISABLE KEYS */;
INSERT INTO `translator` VALUES (1,'Matryoshka',NULL),(2,'Chi Ân',NULL),(3,'Nguyễn Bích Lan',NULL),(4,'Tô Yến Ly',NULL);
/*!40000 ALTER TABLE `translator` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-18  9:56:00
