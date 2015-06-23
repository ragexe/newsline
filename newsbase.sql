-- MySQL dump 10.13  Distrib 5.6.21, for Win32 (x86)
--
-- Host: localhost    Database: newsbase
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Table structure for table `persistent_logins`
--

DROP TABLE IF EXISTS `persistent_logins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persistent_logins`
--

LOCK TABLES `persistent_logins` WRITE;
/*!40000 ALTER TABLE `persistent_logins` DISABLE KEYS */;
/*!40000 ALTER TABLE `persistent_logins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_category`
--

DROP TABLE IF EXISTS `t_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_category` (
  `F_CATEGORY_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `F_TITLE` varchar(80) NOT NULL,
  `F_TITLE4MENU` varchar(50) NOT NULL,
  `F_STATUS` varchar(8) NOT NULL,
  PRIMARY KEY (`F_CATEGORY_ID`),
  UNIQUE KEY `unique_F_ID` (`F_CATEGORY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_category`
--

LOCK TABLES `t_category` WRITE;
/*!40000 ALTER TABLE `t_category` DISABLE KEYS */;
INSERT INTO `t_category` VALUES (0,'main','main','SAVED'),(1,'Экономика и бизнес','Экономика','SAVED'),(2,'Финансы','Финансы','SAVED'),(3,'Политика','Политика','SAVED'),(4,'Туризм','Туризм','SAVED'),(5,'Общество','Общество','SAVED'),(6,'В мире','В мире','SAVED'),(7,'Спорт','Спорт','SAVED'),(8,'Культура','Культура','SAVED'),(9,'Происшествия','Происшествия','SAVED');
/*!40000 ALTER TABLE `t_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_comment`
--

DROP TABLE IF EXISTS `t_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_comment` (
  `F_COMMENT_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `F_PAGE_ID` bigint(20) NOT NULL,
  `F_USER_ID` bigint(20) NOT NULL,
  `F_TEXT` varchar(199) NOT NULL,
  `F_DATE` date DEFAULT NULL,
  `F_STATUS` varchar(8) NOT NULL,
  PRIMARY KEY (`F_COMMENT_ID`),
  UNIQUE KEY `unique_F_COMMENT_ID` (`F_COMMENT_ID`),
  KEY `FK_aut70tpvm02gw4mlm8iiov4j3` (`F_PAGE_ID`),
  KEY `FK_ehh4qkjvnwh5g6ppsy80l37t5` (`F_USER_ID`),
  CONSTRAINT `FK_aut70tpvm02gw4mlm8iiov4j3` FOREIGN KEY (`F_PAGE_ID`) REFERENCES `t_page` (`F_PAGE_ID`),
  CONSTRAINT `FK_ehh4qkjvnwh5g6ppsy80l37t5` FOREIGN KEY (`F_USER_ID`) REFERENCES `t_user` (`F_USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_comment`
--

LOCK TABLES `t_comment` WRITE;
/*!40000 ALTER TABLE `t_comment` DISABLE KEYS */;
INSERT INTO `t_comment` VALUES (1,19,1,'коментарий 1','0001-10-04','SAVED'),(2,19,2,'коментарий автора новости','2015-06-18','SAVED');
/*!40000 ALTER TABLE `t_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_page`
--

DROP TABLE IF EXISTS `t_page`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_page` (
  `F_PAGE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `F_CATEGORY_ID` bigint(20) DEFAULT NULL,
  `F_TITLE` varchar(80) DEFAULT NULL,
  `F_TITLE4MENU` varchar(50) DEFAULT NULL,
  `F_USER_ID` bigint(20) DEFAULT NULL,
  `F_DATE` date DEFAULT NULL,
  `F_MAINTEXT` longtext,
  `F_STATUS` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`F_PAGE_ID`),
  UNIQUE KEY `unique_F_ID` (`F_PAGE_ID`),
  KEY `FK_bs926pi9hjnktstp3a41qunqi` (`F_USER_ID`),
  KEY `FK_2nucpdfibn1ynyiv1u4wlpowb` (`F_CATEGORY_ID`),
  CONSTRAINT `FK_2nucpdfibn1ynyiv1u4wlpowb` FOREIGN KEY (`F_CATEGORY_ID`) REFERENCES `t_category` (`F_CATEGORY_ID`),
  CONSTRAINT `FK_bs926pi9hjnktstp3a41qunqi` FOREIGN KEY (`F_USER_ID`) REFERENCES `t_user` (`F_USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_page`
--

LOCK TABLES `t_page` WRITE;
/*!40000 ALTER TABLE `t_page` DISABLE KEYS */;
INSERT INTO `t_page` VALUES (0,0,'Главная страница','Главная',1,'2015-04-01','Текст главной страницы','SAVED'),(1,1,'Экономика','Экономика',1,'2015-04-26','Текст пункта1','SAVED'),(2,4,'титл','титл4меню',1,'2015-04-27','майнтекстt','SAVED'),(3,2,'Политическая ситуация в мире','Политика',1,'2015-04-28','Текст пункта3','SAVED'),(4,3,'Финансы','Финансы',1,'2015-05-20','Каста здесь','SAVED'),(5,1,'Курсы валют','Курсы валют',1,'2015-04-27','текст пп11','SAVED'),(6,1,'Финансовые показатели','Финпоказатели',1,'2015-04-27','текст пп12','SAVED'),(7,1,'Экономика на пальцах','Экономика на пальцах',1,'2015-04-28','29 апреля президент Беларуси Александр Лукашенко выступил с традиционным посланием народу и Национальному собранию, которое длилось 2 часа 40 минут. В очередной программе Сергея Чалого мы попробовали разобрать экономическую составляющую этого послания.\r\n\r\n','SAVED'),(8,2,'котики','котикитрусы',1,'2015-05-24','котики','SAVED'),(9,2,'Охота','Охота',1,'2015-04-30','текст пп21','SAVED'),(10,2,'Рыбалка','Рыбалка',1,'2015-03-31','текст пп22','SAVED'),(11,3,'Предвыборная компания','Выборы',1,'2015-04-02','текст пп31','SAVED'),(13,3,'Политические споры','Политические споры',1,'2015-04-10','текст пп 32','SAVED'),(14,4,'Каста','Кастата',1,'2015-03-05','Ляляляляля','SAVED'),(16,4,'jklafgu','askdjgd',6,'2012-12-12','vkjgjklghv','SAVED'),(17,1,'add','add',1,'2015-06-03','add','SAVED'),(18,2,'Вентилятор','Вентилятор',1,'2015-06-03','Вентилятор','SAVED'),(19,2,'Выпей отвар трав','Выпей отвар трав',2,'2015-06-03','Выпей отвар трав','SAVED'),(20,4,'addadd','addadd',2,'2015-06-03','addadd','SAVED'),(21,1,'title','title',2,'2015-06-10','titl','SAVED'),(22,1,'лала','лала',1,'2015-06-10','щал','SAVED');
/*!40000 ALTER TABLE `t_page` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `F_USER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `F_NAME` varchar(20) DEFAULT NULL,
  `F_LASTNAME` varchar(30) DEFAULT NULL,
  `F_EMAIL` varchar(30) DEFAULT NULL,
  `F_PASSWORD` varchar(20) DEFAULT NULL,
  `F_STATUS` varchar(8) DEFAULT NULL,
  `F_ACCESS` varchar(10) DEFAULT NULL,
  `F_ROLE` int(11) DEFAULT NULL,
  PRIMARY KEY (`F_USER_ID`),
  UNIQUE KEY `unique_F_ID` (`F_USER_ID`),
  UNIQUE KEY `unique_F_EMAIL` (`F_EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'ragexe','ragexe','ragexe','1234','SAVED','ROLE_ADMIN',0),(2,'1234','1234','1234','1234','SAVED','ROLE_USER',0),(3,'123','123','123','123','SAVED','ROLE_USER',0),(4,'ro','ro','ro','ro','SAVED','ROLE_USER',0),(5,'happyq','ivan','ivan','1234','SAVED','ROLE_ADMIN',0),(6,'roma','roma','roma','roma','SAVED','ROLE_USER',0),(7,'krabbi','ichigo','krabbi','1234','SAVED','ROLE_ADMIN',0);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-23  3:07:17
