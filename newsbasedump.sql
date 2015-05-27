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
-- Table structure for table `pages`
--

DROP TABLE IF EXISTS `pages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pages` (
  `id` char(10) NOT NULL,
  `parentid` char(10) NOT NULL,
  `title` char(80) NOT NULL,
  `title4menu` char(50) NOT NULL,
  `user` int(11) NOT NULL,
  `date` date NOT NULL,
  `maintext` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pages`
--

LOCK TABLES `pages` WRITE;
/*!40000 ALTER TABLE `pages` DISABLE KEYS */;
INSERT INTO `pages` VALUES ('main','null','Главная страница','Главная',1,'2015-04-01','Текст главной страницы'),('n1','main','Экономика','Экономика',1,'2015-04-26','Текст пункта1'),('n2','main','Спорт и туризм','Спорт',1,'2015-04-27','Текст пункта2'),('n2015','n1','котики','котикитрусы',1,'2015-05-24','котики'),('n3','main','Политическая ситуация в мире','Политика',1,'2015-04-28','Текст пункта3'),('n4','main','Финансы','Финансы',1,'2015-05-20','Каста здесь'),('nn1','n1','Курсы валют','Курсы валют',1,'2015-04-27','текст пп11'),('nn10','n1','титл101','титл4меню101',1,'2015-04-27','майнтекстt10'),('nn2','n1','Финансовые показатели','Финпоказатели',1,'2015-04-27','текст пп12'),('nn3','n2','Охота','Охота',1,'2015-04-30','текст пп21'),('nn30','n4','Каста','Кастата',1,'2015-03-05','Ляляляляля'),('nn4','n2','Рыбалка','Рыбалка',1,'2015-03-31','текст пп22'),('nn5','n3','Предвыборная компания','Выборы',1,'2015-04-02','текст пп31'),('nn6','n3','Политические споры','Политические споры',1,'2015-04-10','текст пп 32'),('nn9','n1','Экономика на пальцах','Экономика на пальцах',1,'2015-04-28','29 апреля президент Беларуси Александр Лукашенко выступил с традиционным посланием народу и Национальному собранию, которое длилось 2 часа 40 минут. В очередной программе Сергея Чалого мы попробовали разобрать экономическую составляющую этого послания.\r\n\r\n');
/*!40000 ALTER TABLE `pages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `idu` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(20) NOT NULL,
  `lastname` char(30) NOT NULL,
  `email` char(30) NOT NULL,
  `password` char(20) NOT NULL,
  `role` int(11) DEFAULT '0',
  PRIMARY KEY (`idu`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'ragexe','ragexe','ragexe','1234',1),(2,'1234','1234','1234','1234',0),(3,'123','123','123','123',0),(4,'ro','ro','ro','ro',0),(5,'ivan','ivan','ivan','1234',0),(6,'roma','roma','roma','roma',0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-27 20:42:17
