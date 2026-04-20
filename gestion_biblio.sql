CREATE DATABASE IF NOT EXISTS gestion_biblio;
USE gestion_biblio;

-- Table Livre (Catalogue) 
CREATE TABLE Livre (
    isbn VARCHAR(20) PRIMARY KEY,
    titre VARCHAR(255) NOT NULL,
    auteur VARCHAR(255),
    annee INT
);

-- Table Membre 
CREATE TABLE Membre (
    idMembre INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    email VARCHAR(150) UNIQUE,
    actif BOOLEAN DEFAULT TRUE
);

-- Table Emprunt (inclut la gestion de la caisse/amendes) 
CREATE TABLE Emprunt (
    idEmprunt INT PRIMARY KEY AUTO_INCREMENT,
    idMembre INT,
    idExemplaire INT,
    dateEmprunt DATE,
    dateRetourPrevue DATE,
    dateRetourEff DATE NULL,
    amende_reglee DECIMAL(10,2) DEFAULT 0.0,
    FOREIGN KEY (idMembre) REFERENCES Membre(idMembre)
);