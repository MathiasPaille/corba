-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 13 Juin 2015 à 03:12
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `universite`
--
CREATE DATABASE IF NOT EXISTS `universite` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `universite`;

-- --------------------------------------------------------

--
-- Structure de la table `universite_diplome`
--

DROP TABLE IF EXISTS `universite_diplome`;
CREATE TABLE IF NOT EXISTS `universite_diplome` (
  `mandant` varchar(20) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL,
  `dip_id` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
