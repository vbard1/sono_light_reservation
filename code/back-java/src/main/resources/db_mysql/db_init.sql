-- sonoLightReservation.`section` definition

CREATE TABLE `section` (
  `section_id` int  AUTO_INCREMENT,
  `label` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ,
  PRIMARY KEY (`section_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- sonoLightReservation.`user` definition

CREATE TABLE `user` (
  `user_id` int  AUTO_INCREMENT COMMENT 'auto increment',
  `firstname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ,
  `phone` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ,
  `address` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `email_validation` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '0' COMMENT 'O validé, N non',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  COMMENT 'hash uniquement',
  `level` int  DEFAULT '3' COMMENT '1=superAdmin, 2=admin, 3=user',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- sonoLightReservation.category definition

CREATE TABLE `category` (
  `category_id` int  AUTO_INCREMENT,
  `label` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ,
  `description` varchar(1000) DEFAULT NULL,
  `picture_link` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `section_id` int DEFAULT NULL,
  PRIMARY KEY (`category_id`),
  KEY `categorie_FK` (`section_id`),
  CONSTRAINT `category_FK` FOREIGN KEY (`section_id`) REFERENCES `section` (`section_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- sonoLightReservation.equipment definition

CREATE TABLE `equipment` (
  `equipement_id` int  AUTO_INCREMENT,
  `label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ,
  `model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `owner` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'KLS/CVA',
  `cable_size` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `comment` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `wear_rate_return` int DEFAULT NULL,
  `date_buy` date DEFAULT NULL,
  `dayly_price` decimal(10,2) DEFAULT NULL,
  `replacement_price` decimal(10,2) DEFAULT NULL,
  `category_id` int ,
  PRIMARY KEY (`equipement_id`),
  KEY `categorie_id` (`category_id`),
  CONSTRAINT `equipment_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- sonoLightReservation.event definition

CREATE TABLE `event` (
  `event_id` int  AUTO_INCREMENT,
  `title` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ,
  `location` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `type` int  COMMENT '1 = assos insa / 2 = interne KLS / 3 = particulier/autre',
  `user_comment` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `admin_comment` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `description` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `date_start` datetime DEFAULT NULL,
  `date_end` datetime DEFAULT NULL,
  `technician_asked` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'O / N',
  `user_id` int ,
  PRIMARY KEY (`event_id`),
  KEY `event_FK` (`user_id`),
  CONSTRAINT `event_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- sonoLightReservation.reservation definition

CREATE TABLE `reservation` (
  `reservation_id` int  AUTO_INCREMENT,
  `reservation_label` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ,
  `reservation_state` int DEFAULT NULL COMMENT '(1=enAttente, 2=validée, 3=enCours, 4=terminée)',
  `equipment_id` int DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  `event_id` int DEFAULT NULL,
  PRIMARY KEY (`reservation_id`),
  UNIQUE KEY `reservation_UN` (`event_id`),
  KEY `reservation_FK_1` (`category_id`),
  KEY `reservation_FK_2` (`equipment_id`),
  CONSTRAINT `reservation_FK` FOREIGN KEY (`event_id`) REFERENCES `event` (`event_id`),
  CONSTRAINT `reservation_FK_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`),
  CONSTRAINT `reservation_FK_2` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`equipement_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO section (label) VALUES
    ('Son'),
    ('Lumière'),
    ('Règles DJ'),
    ('Equipement divers');

INSERT INTO user (user_id, firstname, name, email, phone, address, email_validation, password, level)
VALUES
  (1, 'Homer', 'Simpson', 'homer@example.com', '123456789', '742 Evergreen Terrace', true, 'password123', 1),
  (2, 'Marge', 'Simpson', 'marge@example.com', '987654321', '742 Evergreen Terrace', true, 'password456', 1),
  (3, 'Bart', 'Simpson', 'bart@example.com', '555555555', '742 Evergreen Terrace', true, 'password789', 2),
  (4, 'Lisa', 'Simpson', 'lisa@example.com', '999999999', '742 Evergreen Terrace', true, 'passwordabc', 2),
  (5, 'Maggie', 'Simpson', 'maggie@example.com', '111111111', '742 Evergreen Terrace', true, 'passwordxyz', 3);