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
-- Table structure for table `t_page`
--

DROP TABLE IF EXISTS `t_page`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_page` (
  `F_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `F_PARENTID` bigint(20) DEFAULT NULL,
  `F_TITLE` varchar(80) DEFAULT NULL,
  `F_TITLE4MENU` varchar(50) DEFAULT NULL,
  `F_AUTHOR` bigint(20) DEFAULT NULL,
  `F_DATE` date DEFAULT NULL,
  `F_MAINTEXT` longtext,
  `F_STATUS` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`F_ID`),
  UNIQUE KEY `unique_F_ID` (`F_ID`),
  KEY `F_AUTHOR` (`F_AUTHOR`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_page`
--

LOCK TABLES `t_page` WRITE;
/*!40000 ALTER TABLE `t_page` DISABLE KEYS */;
INSERT INTO `t_page` VALUES (0,-1,'Главная страница','Главная',1,'2015-04-01','Текст главной страницы','SAVED'),(1,0,'Экономика','Экономика',1,'2015-04-26','Текст пункта1','SAVED'),(2,0,'титл','титл4меню',1,'2015-04-27','майнтекстt','SAVED'),(3,0,'Политическая ситуация в мире','Политика',1,'2015-04-28','Текст пункта3','SAVED'),(4,0,'Финансы','Финансы',1,'2015-05-20','Каста здесь','SAVED'),(5,1,'Курсы валют','Курсы валют',1,'2015-04-27','текст пп11','SAVED'),(6,1,'Финансовые показатели','Финпоказатели',1,'2015-04-27','текст пп12','SAVED'),(7,1,'Экономика на пальцах','Экономика на пальцах',1,'2015-04-28','29 апреля президент Беларуси Александр Лукашенко выступил с традиционным посланием народу и Национальному собранию, которое длилось 2 часа 40 минут. В очередной программе Сергея Чалого мы попробовали разобрать экономическую составляющую этого послания.\r\n\r\n','SAVED'),(8,2,'котики','котикитрусы',1,'2015-05-24','котики','SAVED'),(9,2,'Охота','Охота',1,'2015-04-30','текст пп21','SAVED'),(10,2,'Рыбалка','Рыбалка',1,'2015-03-31','текст пп22','SAVED'),(11,3,'Предвыборная компания','Выборы',1,'2015-04-02','текст пп31','SAVED'),(13,3,'Политические споры','Политические споры',1,'2015-04-10','текст пп 32','SAVED'),(14,4,'Каста','Кастата',1,'2015-03-05','Ляляляляля','SAVED'),(16,4,'jklafgu','askdjgd',6,'2012-12-12','vkjgjklghv','SAVED'),(17,1,'add','add',1,'2015-06-03','add','SAVED'),(18,2,'Вентилятор','Вентилятор',1,'2015-06-03','Вентилятор','SAVED'),(19,2,'Выпей отвар трав','Выпей отвар трав',2,'2015-06-03','Выпей отвар трав','SAVED'),(20,4,'addadd','addadd',2,'2015-06-03','addadd','SAVED');
/*!40000 ALTER TABLE `t_page` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `F_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `F_NAME` varchar(20) DEFAULT NULL,
  `F_LASTNAME` varchar(30) DEFAULT NULL,
  `F_EMAIL` varchar(30) DEFAULT NULL,
  `F_PASSWORD` varchar(20) DEFAULT NULL,
  `F_ROLE` int(11) DEFAULT NULL,
  `F_STATUS` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`F_ID`),
  UNIQUE KEY `unique_F_ID` (`F_ID`),
  UNIQUE KEY `unique_F_EMAIL` (`F_EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'ragexe','ragexe','ragexe','1234',1,'SAVED'),(2,'1234','1234','1234','1234',0,'SAVED'),(3,'123','123','123','123',0,'SAVED'),(4,'ro','ro','ro','ro',0,'SAVED'),(5,'ivan','ivan','ivan','1234',0,'SAVED'),(6,'roma','roma','roma','roma',0,'SAVED');
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

-- Dump completed on 2015-06-10 18:54:37
