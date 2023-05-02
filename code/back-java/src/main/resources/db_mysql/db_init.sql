DROP TABLE IF EXISTS rubrique;

CREATE TABLE rubrique (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    libelle VARCHAR(250) NOT NULL
);

INSERT INTO rubrique (libelle) VALUES
    ('Son'),
    ('Lumière'),
    ('Règles DJ'),
    ('Equipement divers');