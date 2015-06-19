-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 19, 2015 at 04:25 PM
-- Server version: 5.5.43-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ministere`
--
CREATE DATABASE IF NOT EXISTS `ministere` DEFAULT CHARACTER SET latin1 COLLATE latin1_general_ci;
USE `ministere`;

-- --------------------------------------------------------

--
-- Table structure for table `diplomes`
--

DROP TABLE IF EXISTS `diplomes`;
CREATE TABLE IF NOT EXISTS `diplomes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) CHARACTER SET utf8 NOT NULL,
  `dip_prerequis` varchar(10000) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=12 ;

--
-- Dumping data for table `diplomes`
--

INSERT INTO `diplomes` (`id`, `libelle`, `dip_prerequis`) VALUES
(1, 'MIAGE', '{"requis":["L3 MIAGE","Licence pro"]}'),
(2, 'STAPS', '{"requis":["Glandage","L3 Dressage de pingouins"]}'),
(3, 'Management Spécialité Administration des Entreprises', '{"requis":["Licence manager","Licence assistant manager","Licence grh"]}'),
(4, 'Droit', '{"requis":["Licence droit"]}'),
(5, 'Psychologie', '{"requis":["Licence psychologie"]}'),
(6, 'Biologie', '{"requis":["Licence biologie","Licence pro"]}'),
(7, 'Nanorobotique et augmentation humaine appliquée', '{"requis":["Licence nanorobotique","Licence pro"]}'),
(8, 'Arts plastiques', '{"requis":["Licence arts"]}'),
(9, 'Histoire de la musique', '{"requis":["Licence hard-rock","Licence blues"]}'),
(10, 'Ornithorynquologie', '{"requis":["Licence Ornithorynquologie","Licence pro"]}'),
(11, 'Cinéma', '{"requis":["Licence cinema"]}');

-- --------------------------------------------------------

--
-- Table structure for table `rectorats`
--

DROP TABLE IF EXISTS `rectorats`;
CREATE TABLE IF NOT EXISTS `rectorats` (
  `rectorats_id` varchar(20) COLLATE latin1_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `rectorats`
--

INSERT INTO `rectorats` (`rectorats_id`) VALUES
('rectorat1'),
('rectorat2');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
