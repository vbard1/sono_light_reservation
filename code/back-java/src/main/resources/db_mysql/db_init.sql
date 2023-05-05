-- sonoLightReservation.rubrique definition

CREATE TABLE `rubrique` (
  `rubrique_id` int NOT NULL AUTO_INCREMENT,
  `libelle` varchar(250) NOT NULL,
  PRIMARY KEY (`rubrique_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- sonoLightReservation.utilisateur definition

CREATE TABLE `utilisateur` (
  `utilisateur_id` int NOT NULL AUTO_INCREMENT COMMENT 'auto increment',
  `prenom` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nom` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `mail` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `telephone` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `adresse` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `validation_email` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '0' COMMENT 'O validé, N non',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'hash uniquement',
  `niveau` int NOT NULL DEFAULT '3' COMMENT '1=superAdmin, 2=admin, 3=user',
  PRIMARY KEY (`utilisateur_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- sonoLightReservation.categorie definition

CREATE TABLE `categorie` (
  `categorie_id` int NOT NULL AUTO_INCREMENT,
  `libelle` varchar(1000) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `lien_images` varchar(1000) DEFAULT NULL,
  `rubrique_id` int DEFAULT NULL,
  PRIMARY KEY (`categorie_id`),
  KEY `categorie_FK` (`rubrique_id`),
  CONSTRAINT `categorie_FK` FOREIGN KEY (`rubrique_id`) REFERENCES `rubrique` (`rubrique_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- sonoLightReservation.evenement definition

CREATE TABLE `evenement` (
  `evenement_id` int NOT NULL AUTO_INCREMENT,
  `titre` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `lieu` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `type` int NOT NULL COMMENT '1 = assos insa / 2 = interne KLS / 3 = particulier/autre',
  `commentaire_user` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `commentaire_admin` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `date_debut` datetime DEFAULT NULL,
  `date_fin` datetime DEFAULT NULL,
  `technicien_demande` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'O / N',
  `user_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`evenement_id`),
  CONSTRAINT `evenement_FK` FOREIGN KEY (`evenement_id`) REFERENCES `utilisateur` (`utilisateur_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- sonoLightReservation.materiel definition

CREATE TABLE `materiel` (
  `materiel_id` int NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) DEFAULT NULL,
  `modele` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `proprietaire` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'KLS/CVA',
  `taille_cable` varchar(255) DEFAULT NULL,
  `commentaires` text,
  `etat_usure` int DEFAULT NULL,
  `date_achat` date DEFAULT NULL,
  `prix_jour` decimal(10,2) DEFAULT NULL,
  `prix_caution` decimal(10,2) DEFAULT NULL,
  `categorie_id` int NOT NULL,
  PRIMARY KEY (`materiel_id`),
  KEY `categorie_id` (`categorie_id`),
  CONSTRAINT `materiel_ibfk_1` FOREIGN KEY (`categorie_id`) REFERENCES `categorie` (`categorie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- sonoLightReservation.reservation definition

CREATE TABLE `reservation` (
  `reservation_id` int NOT NULL AUTO_INCREMENT,
  `reservation_libelle` varchar(1000) DEFAULT NULL,
  `reservation_etat` int DEFAULT NULL COMMENT '(1=enAttente, 2=validée, 3=enCours, 4=terminée)',
  `materiel_id` int DEFAULT NULL,
  `categorie_id` int DEFAULT NULL,
  `evenement_id` int DEFAULT NULL,
  PRIMARY KEY (`reservation_id`),
  UNIQUE KEY `reservation_UN` (`evenement_id`),
  KEY `reservation_FK_1` (`categorie_id`),
  KEY `reservation_FK_2` (`materiel_id`),
  CONSTRAINT `reservation_FK` FOREIGN KEY (`evenement_id`) REFERENCES `evenement` (`evenement_id`),
  CONSTRAINT `reservation_FK_1` FOREIGN KEY (`categorie_id`) REFERENCES `categorie` (`categorie_id`),
  CONSTRAINT `reservation_FK_2` FOREIGN KEY (`materiel_id`) REFERENCES `materiel` (`materiel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO rubrique (libelle) VALUES
    ('sono'),
    ('light'),
    ('other');