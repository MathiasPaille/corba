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
-- Base de données :  `rectorat`
--
CREATE DATABASE IF NOT EXISTS `rectorat` DEFAULT CHARACTER SET latin1 COLLATE latin1_general_ci;
USE `rectorat`;

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `mandant` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `etu_ine` int(11) NOT NULL,
  `etu_nom` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `etu_prenom` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `etu_adresse` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `etu_universite` varchar(40) COLLATE latin1_general_ci NOT NULL,
  `etu_license` varchar(40) COLLATE latin1_general_ci NOT NULL,
  `etu_notes` varchar(10000) COLLATE latin1_general_ci NOT NULL,
  `password` varchar(20) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`mandant`,`etu_ine`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Contenu de la table `etudiant`
--

INSERT INTO `etudiant` (`mandant`, `etu_ine`, `etu_nom`, `etu_prenom`, `etu_adresse`, `etu_universite`, `etu_license`, `etu_notes`, `password`) VALUES
('rectorat1', 222222222, 'Paille', 'Mathias', '11 Rue des écrans', 'Université Toulouse Capitole', 'L3 MIAGE', '{"s1":{"moyenne":"10","quartile":"2","moyenObtention":"0","numSemestre":"1"},"s2":{"moyenne":"16","quartile":"0","moyenObtention":"0","numSemestre":"2"},"s3":{"moyenne":"9","quartile":"3","moyenObtention":"1","numSemestre":"3"},"s4":{"moyenne":"11","quartile":"2","moyenObtention":"1","numSemestre":"4"},"s5":{"moyenne":"16","quartile":"0","moyenObtention":"0","numSemestre":"5"},"s6":{"moyenne":"15","quartile":"0","moyenObtention":"0","numSemestre":"6"}}', 'aaaa'),
('rectorat1', 444444444, 'Masqué', 'Concombre', 'rue des poiriers', 'Université Toulouse Mirail', 'L3 Dressage de pingouins', '{"s1":{"moyenne":"16","quartile":"0","moyenObtention":"0","numSemestre":"1"},"s2":{"moyenne":"14","quartile":"0","moyenObtention":"0","numSemestre":"2"},"s3":{"moyenne":"10","quartile":"1","moyenObtention":"1","numSemestre":"3"},"s4":{"moyenne":"10","quartile":"1","moyenObtention":"0","numSemestre":"4"},"s5":{"moyenne":"8","quartile":"3","moyenObtention":"1","numSemestre":"5"},"s6":{"moyenne":"18","quartile":"0","moyenObtention":"0","numSemestre":"6"}}', 'aaaa'),
('rectorat1', 1111111111, 'Guidoin', 'Yvan', '10 Rue des artistes', 'Université Paul Sabatier', 'L3 MIAGE', '{"s1":{"moyenne":"20","quartile":"0","moyenObtention":"0","numSemestre":"1"},"s2":{"moyenne":"20","quartile":"0","moyenObtention":"0","numSemestre":"2"},"s3":{"moyenne":"20","quartile":"0","moyenObtention":"0","numSemestre":"3"},"s4":{"moyenne":"20","quartile":"0","moyenObtention":"0","numSemestre":"4"},"s5":{"moyenne":"20","quartile":"0","moyenObtention":"0","numSemestre":"5"},"s6":{"moyenne":"20","quartile":"0","moyenObtention":"0","numSemestre":"6"}}', 'aaaa'),
('rectorat2', 333333333, 'Tascin', 'Teddy', '20 Avenue de la rigolade', 'Université Toulouse Capitole', 'L3 MIAGE', '{"s1":{"moyenne":"10","quartile":"2","moyenObtention":"1","numSemestre":"1"},"s2":{"moyenne":"11","quartile":"2","moyenObtention":"1","numSemestre":"2"},"s3":{"moyenne":"10","quartile":"2","moyenObtention":"1","numSemestre":"3"},"s4":{"moyenne":"10","quartile":"2","moyenObtention":"1","numSemestre":"4"},"s5":{"moyenne":"8","quartile":"2","moyenObtention":"1","numSemestre":"5"},"s6":{"moyenne":"12","quartile":"1","moyenObtention":"1","numSemestre":"6"}}', 'aaaa');

-- --------------------------------------------------------

--
-- Structure de la table `rectorat_universite`
--

DROP TABLE IF EXISTS `rectorat_universite`;
CREATE TABLE IF NOT EXISTS `rectorat_universite` (
  `mandant` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `universite_id` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `universite_name` varchar(250) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`mandant`,`universite_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Contenu de la table `rectorat_universite`
--

INSERT INTO `rectorat_universite` (`mandant`, `universite_id`, `universite_name`) VALUES
('rectorat1', 'universite1', 'Université Paul Sabatier'),
('rectorat2', 'universite2', 'Université Moulticoultourelle d''Antarctique');

-- --------------------------------------------------------

--
-- Structure de la table `voeux`
--

DROP TABLE IF EXISTS `voeux`;
CREATE TABLE IF NOT EXISTS `voeux` (
  `mandant` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `voeux_ine` int(11) NOT NULL,
  `voeux_master` int(5) NOT NULL,
  `voeux_universite` int(5) NOT NULL,
  `voeux_classement` int(1) NOT NULL,
  `voeux_inscription` int(1) NOT NULL,
  `voeux_etat_voeu` int(1) NOT NULL,
  `voeux_decision` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
