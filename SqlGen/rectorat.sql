-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 12 Juin 2015 à 00:41
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
-- Contenu de la table `etudiant`
--

INSERT INTO `etudiant` (`mandant`, `etu_ine`, `etu_nom`, `etu_prenom`, `etu_adresse`, `etu_universite`, `etu_license`, `etu_notes`) VALUES
(1, 1111111111, 'Guidoin', 'Yvan', '10 Rue des artistes', 1, 1, '{"s1":{"moyenne":"20","quartile":"1","moyenObtention":"1","numSemestre":"1"},"s2":{"moyenne":"20","quartile":"1","moyenObtention":"1","numSemestre":"2"},"s3":{"moyenne":"20","quartile":"1","moyenObtention":"1","numSemestre":"3"},"s4":{"moyenne":"20","quartile":"1","moyenObtention":"1","numSemestre":"4"},"s5":{"moyenne":"20","quartile":"1","moyenObtention":"1","numSemestre":"5"},"s6":{"moyenne":"20","quartile":"1","moyenObtention":"1","numSemestre":"6"}}'),
(1, 222222222, 'Paille', 'Mathias', '11 Rue des écrans', 2, 10, '{"s1":{"moyenne":"10","quartile":"3","moyenObtention":"1","numSemestre":"1"},"s2":{"moyenne":"16","quartile":"1","moyenObtention":"1","numSemestre":"2"},"s3":{"moyenne":"9","quartile":"4","moyenObtention":"2","numSemestre":"3"},"s4":{"moyenne":"11","quartile":"3","moyenObtention":"2","numSemestre":"4"},"s5":{"moyenne":"16","quartile":"1","moyenObtention":"1","numSemestre":"5"},"s6":{"moyenne":"15","quartile":"1","moyenObtention":"1","numSemestre":"6"}}'),
(2, 333333333, 'Tascin', 'Teddy', '20 Avenue de la rigolade', 2, 1, '{"s1":{"moyenne":"10","quartile":"3","moyenObtention":"2","numSemestre":"1"},"s2":{"moyenne":"11","quartile":"3","moyenObtention":"2","numSemestre":"2"},"s3":{"moyenne":"10","quartile":"3","moyenObtention":"2","numSemestre":"3"},"s4":{"moyenne":"10","quartile":"3","moyenObtention":"2","numSemestre":"4"},"s5":{"moyenne":"8","quartile":"3","moyenObtention":"2","numSemestre":"5"},"s6":{"moyenne":"12","quartile":"2","moyenObtention":"2","numSemestre":"6"}}'),
(1, 444444444, 'Masqué', 'Concombre', 'rue des poiriers', 1, 2, '{"s1":{"moyenne":"16","quartile":"1","moyenObtention":"1","numSemestre":"1"},"s2":{"moyenne":"14","quartile":"1","moyenObtention":"1","numSemestre":"2"},"s3":{"moyenne":"10","quartile":"2","moyenObtention":"2","numSemestre":"3"},"s4":{"moyenne":"10","quartile":"2","moyenObtention":"1","numSemestre":"4"},"s5":{"moyenne":"8","quartile":"4","moyenObtention":"2","numSemestre":"5"},"s6":{"moyenne":"18","quartile":"1","moyenObtention":"1","numSemestre":"6"}}');

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

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
