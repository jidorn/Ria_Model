create database if not exists al26_ria;
use al26_ria;
drop table if exists personnage;
create table personnage (
	id int(11) not null auto_increment primary key,
	nom VARCHAR(50) not null,
	date_naissance DATETIME not null,
	espece VARCHAR(50) not null,
	dessin_anime VARCHAR(100) not null
);
INSERT INTO personnage 
(nom, date_naissance, espece, dessin_anime)
VALUES 
('Raiponce', '1812-01-01', 'humain', 'Raiponce'),
('Pascal', '2010-11-24', 'cameléon', 'Raiponce'),
('Flynn Rider', '2010-11-24', 'humain', 'Raiponce'),
('Maximus', '2010-11-24', 'cheval', 'Raiponce'),
('Mère Gothel', '2010-11-24', 'humain', 'Raiponce'),
('Judy', '2016-02-17', 'lapin', 'Zootopie'),
('Nick', '2016-02-17', 'renard', 'Zootopie'),
('Mr. Big', '2016-02-17', 'taupe', 'Zootopie'),
('Bellwether', '2016-02-17', 'mouton', 'Zootopie');

