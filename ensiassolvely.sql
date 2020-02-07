-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 07 fév. 2020 à 01:05
-- Version du serveur :  5.5.16
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ensiassolvely`
--

-- --------------------------------------------------------

--
-- Structure de la table `aimer`
--

DROP TABLE IF EXISTS `aimer`;
CREATE TABLE IF NOT EXISTS `aimer` (
  `id_probleme` int(11) NOT NULL,
  `numEleve` int(11) NOT NULL,
  PRIMARY KEY (`id_probleme`,`numEleve`),
  KEY `Aimer_Eleve_FK` (`numEleve`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `boite`
--

DROP TABLE IF EXISTS `boite`;
CREATE TABLE IF NOT EXISTS `boite` (
  `numboite` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(300) DEFAULT NULL,
  `numEleve` int(11) DEFAULT NULL,
  PRIMARY KEY (`numboite`),
  KEY `Boite_Eleve_FK` (`numEleve`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `comite`
--

DROP TABLE IF EXISTS `comite`;
CREATE TABLE IF NOT EXISTS `comite` (
  `id_comite` int(11) NOT NULL AUTO_INCREMENT,
  `nom_comite` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_comite`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `comite`
--

INSERT INTO `comite` (`id_comite`, `nom_comite`) VALUES
(1, 'batiment'),
(2, 'divers'),
(3, 'Eleve');

-- --------------------------------------------------------

--
-- Structure de la table `eleve`
--

DROP TABLE IF EXISTS `eleve`;
CREATE TABLE IF NOT EXISTS `eleve` (
  `numEleve` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telephone` varchar(50) DEFAULT NULL,
  `chambre` varchar(50) DEFAULT NULL,
  `login` varchar(100) DEFAULT NULL,
  `motDePasse` varchar(100) DEFAULT NULL,
  `id_comite` int(11) DEFAULT NULL,
  PRIMARY KEY (`numEleve`),
  KEY `Eleve_Comite_FK` (`id_comite`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `eleve`
--

INSERT INTO `eleve` (`numEleve`, `nom`, `prenom`, `email`, `telephone`, `chambre`, `login`, `motDePasse`, `id_comite`) VALUES
(5, 'SAOUDI', 'Mehdi', 'mehdisaoudi270@gmail.com', '0618880918', 'B56', 'Mehdi', 'Saoudi', 1),
(6, 'ZANATI', 'Zakaria', 'zakariazanati@gmail.com', '0656852145', 'C50', 'Zakaria', 'zanati', 3),
(7, 'TENNIA', 'Youssef', 'tenniayoussef@gmail.com', '0623541236', 'C42', 'Youssef', 'Tennia', 2),
(8, 'YOUNESS', 'Mouad', 'younessmouad@gmail.com', '0632541269', 'C58', 'Mouad', 'Youness', 2);

-- --------------------------------------------------------

--
-- Structure de la table `probleme`
--

DROP TABLE IF EXISTS `probleme`;
CREATE TABLE IF NOT EXISTS `probleme` (
  `id_probleme` int(11) NOT NULL AUTO_INCREMENT,
  `lieu` varchar(100) DEFAULT NULL,
  `description` varchar(300) DEFAULT NULL,
  `date_demande` date DEFAULT NULL,
  `statut` varchar(50) DEFAULT NULL,
  `id_comite` int(11) NOT NULL,
  `numEleve` int(11) NOT NULL,
  `id_type` int(11) NOT NULL,
  `likes` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_probleme`),
  KEY `Probleme_Comite_FK` (`id_comite`),
  KEY `Probleme_Eleve0_FK` (`numEleve`),
  KEY `Probleme_Type_Probleme1_FK` (`id_type`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `probleme`
--

INSERT INTO `probleme` (`id_probleme`, `lieu`, `description`, `date_demande`, `statut`, `id_comite`, `numEleve`, `id_type`, `likes`) VALUES
(36, 'Chambre B54', 'Fuite d\'eau', '2020-02-02', 'Actif', 1, 6, 2, 0),
(37, 'Cuisine Batiment A', 'Problème d\'hygiène', '2020-02-02', 'Solved', 1, 7, 1, 0),
(38, 'Terrain de foot ', 'Terrain de foot occupé depuis plus de 3 heures', '2020-02-02', 'Not Solved', 2, 6, 5, 0),
(39, 'Terrain de basketball', 'Pas de panneau depuis 2 mois', '2020-02-02', 'Solved', 2, 7, 5, 0),
(40, 'Grand amphi', 'Problème d\'éclairage', '2020-02-02', 'Solved', 2, 5, 6, 0);

-- --------------------------------------------------------

--
-- Structure de la table `type_probleme`
--

DROP TABLE IF EXISTS `type_probleme`;
CREATE TABLE IF NOT EXISTS `type_probleme` (
  `id_type` int(11) NOT NULL AUTO_INCREMENT,
  `libelle_type` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_type`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `type_probleme`
--

INSERT INTO `type_probleme` (`id_type`, `libelle_type`) VALUES
(1, 'CUISINE'),
(2, 'CHAMBRE'),
(3, 'BLOC SANITAIRE'),
(4, 'URGENCE'),
(5, 'ESPACE SPORTIF'),
(6, 'BUVETTES ET AUTRES');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `aimer`
--
ALTER TABLE `aimer`
  ADD CONSTRAINT `Aimer_Eleve_FK` FOREIGN KEY (`numEleve`) REFERENCES `eleve` (`numEleve`),
  ADD CONSTRAINT `Aimer_Probleme_FK` FOREIGN KEY (`id_probleme`) REFERENCES `probleme` (`id_probleme`);

--
-- Contraintes pour la table `boite`
--
ALTER TABLE `boite`
  ADD CONSTRAINT `Boite_Eleve_FK` FOREIGN KEY (`numEleve`) REFERENCES `eleve` (`numEleve`);

--
-- Contraintes pour la table `eleve`
--
ALTER TABLE `eleve`
  ADD CONSTRAINT `Eleve_Comite_FK` FOREIGN KEY (`id_comite`) REFERENCES `comite` (`id_comite`);

--
-- Contraintes pour la table `probleme`
--
ALTER TABLE `probleme`
  ADD CONSTRAINT `Probleme_Comite_FK` FOREIGN KEY (`id_comite`) REFERENCES `comite` (`id_comite`),
  ADD CONSTRAINT `Probleme_Eleve0_FK` FOREIGN KEY (`numEleve`) REFERENCES `eleve` (`numEleve`),
  ADD CONSTRAINT `Probleme_Type_Probleme1_FK` FOREIGN KEY (`id_type`) REFERENCES `type_probleme` (`id_type`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
