DROP DATABASE IF EXISTS listaSpesaDB;
CREATE DATABASE IF NOT EXISTS listaSpesaDB;
USE listaSpesaDB;

CREATE TABLE IF NOT EXISTS lista (
	id	INT	PRIMARY KEY	AUTO_INCREMENT,
	voce	VARCHAR(32)	NOT NULL	UNIQUE
);

INSERT INTO lista (voce) VALUES
	('acqua'),
	('latte'),
	('farina'),
	('zucchero'),
	('uova'),
	('lievito');