-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 11 Juin 2015 à 17:38
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `rectorat`
--
CREATE DATABASE IF NOT EXISTS `rectorat` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `rectorat`;

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `mandant` int(5) NOT NULL,
  `etu_ine` int(11) NOT NULL,
  `etu_nom` varchar(20) NOT NULL,
  `etu_prenom` varchar(20) NOT NULL,
  `etu_adresse` varchar(50) NOT NULL,
  `etu_universite` int(5) NOT NULL,
  `etu_license` int(5) NOT NULL,
  `etu_notes` varchar(10000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Vider la table avant d'insérer `etudiant`
--

TRUNCATE TABLE `etudiant`;
-- --------------------------------------------------------

--
-- Structure de la table `voeux`
--

DROP TABLE IF EXISTS `voeux`;
CREATE TABLE IF NOT EXISTS `voeux` (
  `mandant` int(5) NOT NULL,
  `voeux_ine` int(11) NOT NULL,
  `voeux_master` int(5) NOT NULL,
  `voeux_universite` int(5) NOT NULL,
  `voeux_classement` int(1) NOT NULL,
  `voeux_inscription` int(1) NOT NULL,
  `voeux_etat_voeu` int(1) NOT NULL,
  `voeux_decision` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Vider la table avant d'insérer `voeux`
--

TRUNCATE TABLE `voeux`;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
