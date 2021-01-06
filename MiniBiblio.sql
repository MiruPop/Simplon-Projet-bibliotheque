DROP DATABASE IF EXISTS MiniBiblio;

CREATE DATABASE IF NOT EXISTS MiniBiblio;

USE MiniBiblio;

create table Adherent(
matricule int not null auto_increment,
nom varchar(20) not null,
prenom varchar(20),
dateNaissance date,
adresse varchar(60),
telephone varchar(24),
categoriePro varchar(30),
dateAdhesion date,
constraint pk_adherent PRIMARY KEY (matricule)
);
CREATE INDEX `matricule` ON `Adherent` (`matricule`);

create table Exemplaire(
codeRayon int not null auto_increment,
auteur varchar(50),
titre varchar(100) not null,
editeur varchar(50),
anneeEdition varchar(4),
constraint pk_exemplaire PRIMARY KEY (codeRayon)
);
CREATE INDEX `codeRayon` ON `Exemplaire` (`codeRayon`);

create table Emprunt (
idEmprunt int not null auto_increment,
datePret date,
dateRetour date,
idAdherent int not null,
idExemplaire int not null,
constraint pk_emprunt PRIMARY KEY (idEmprunt)
);
CREATE INDEX `idEmprunt` ON `Emprunt` (`idEmprunt`);
# ----------------------------------------------- #
# Adherent data                                   #
# ----------------------------------------------- #
INSERT INTO Adherent (nom, prenom, dateNaissance, adresse, telephone, categoriePro, dateAdhesion)
VALUES('DUPONT', 'Toto', '1989-05-12', '10 rue Courte, 75018 Paris', '06.01.23.45.67', 'fonctionnaire', '2020-02-26');
INSERT INTO Adherent (nom, prenom, dateNaissance, adresse, telephone, categoriePro, dateAdhesion)
VALUES('FONTAINE', 'Mimi', '1975-07-01', '35 rue de la Paix, 93210 La Plaine St-Denis', '06.99.88.77.66', 'ingénieur', '2018-05-06');
INSERT INTO Adherent (nom, prenom, dateNaissance, adresse, telephone, categoriePro, dateAdhesion)
VALUES('CHANEL', 'Coco', '1925-10-25', 'Paris', '', 'couturière', '2018-04-06');
# ----------------------------------------------- #
# Exemplaire data                                 #
# ----------------------------------------------- #
INSERT INTO Exemplaire (auteur, titre, editeur, anneeEdition)
VALUES ('Isaac ASIMOV', 'Fondation', 'Gallimard', '2009');
INSERT INTO Exemplaire (auteur, titre, editeur, anneeEdition)
VALUES ('Edgar Allan POE', 'La Chute De LA Maison Usher', 'Hatier', '2008');
INSERT INTO Exemplaire (auteur, titre, editeur, anneeEdition)
VALUES ('Douglas ADAMS', 'Le Guide du voyageur galactique', 'Gallimard', '2005');

# ----------------------------------------------- #
# Clés etrangères                                 #
# ----------------------------------------------- #
ALTER TABLE `Emprunt` ADD CONSTRAINT `FK_Emprunts_Adherents`
FOREIGN KEY (`idAdherent`) REFERENCES `Adherent` (`matricule`);

ALTER TABLE `Emprunt` ADD CONSTRAINT `FK_Emprunts_Exemplaire`
FOREIGN KEY (`idExemplaire`) REFERENCES `Exemplaire` (`codeRayon`);
