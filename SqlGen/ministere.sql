-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 19 Juin 2015 à 17:10
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
CREATE DATABASE IF NOT EXISTS `ministere` DEFAULT CHARACTER SET latin1 COLLATE latin1_general_ci;
USE `ministere`;

-- --------------------------------------------------------

--
-- Structure de la table `diplomes`
--

DROP TABLE IF EXISTS `diplomes`;
CREATE TABLE IF NOT EXISTS `diplomes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) CHARACTER SET utf8 NOT NULL,
  `dip_prerequis` varchar(10000) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=12 ;

--
-- Contenu de la table `diplomes`
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
-- Structure de la table `rectorats`
--

DROP TABLE IF EXISTS `rectorats`;
CREATE TABLE IF NOT EXISTS `rectorats` (
  `rectorats_id` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `rectorats_name` varchar(250) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`rectorats_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Contenu de la table `rectorats`
--

INSERT INTO `rectorats` (`rectorats_id`, `rectorats_name`) VALUES
('rectorat1', 'Midi-Pyrénées'),
('rectorat2', 'Norfendre');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
