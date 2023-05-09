DROP TABLE IF EXISTS section;

CREATE TABLE section (
    section_id INT AUTO_INCREMENT  PRIMARY KEY,
    label VARCHAR(250) NOT NULL
);

INSERT INTO section (label) VALUES
    ('Son'),
    ('Lumière'),
    ('Règles DJ'),
    ('Equipement divers');