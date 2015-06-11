-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 11 Juin 2015 à 17:37
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `ministere`
--
CREATE DATABASE IF NOT EXISTS `ministere` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `ministere`;

-- --------------------------------------------------------

--
-- Structure de la table `diplomes`
--

DROP TABLE IF EXISTS `diplomes`;
CREATE TABLE IF NOT EXISTS `diplomes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libellé` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Vider la table avant d'insérer `diplomes`
--

TRUNCATE TABLE `diplomes`;
--
-- Contenu de la table `diplomes`
--

INSERT INTO `diplomes` (`id`, `libellé`) VALUES
(1, 'MIAGE'),
(2, 'STAPS'),
(3, 'Management Spécialité Administration des Entreprises'),
(4, 'Droit'),
(5, 'Psychologie'),
(6, 'Biologie'),
(7, 'Nanorobotique et augmentation humaine appliquée'),
(8, 'Arts plastiques'),
(9, 'Histoire de la musique'),
(10, 'Ornithorynquologie'),
(11, 'Cinéma');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;