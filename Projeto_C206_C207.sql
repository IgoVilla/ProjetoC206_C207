DROP DATABASE IF EXISTS LocadoraDeFilmes;
CREATE DATABASE LocadoraDeFilmes;
USE LocadoraDeFilmes;

CREATE TABLE FILME(
NOME VARCHAR(30),
GENERO VARCHAR(20),
DISPONIVEL BOOLEAN,
CODIGO INT
);

CREATE TABLE CLIENTE(
NOME VARCHAR(50),
CPF VARCHAR(11),
ENDERECO VARCHAR(50)
);

CREATE TABLE ALUGADO(
DATA_ALUGADO VARCHAR(20),
DATA_DEVOLUCAO VARCHAR(20),
CODIGO_FILME INT
);
select*from cliente;
select*from alugado;
select*from filme;

INSERT INTO FILME()
VALUES("HARRY POTTER", "FANTASIA",0, "1"), ("MATRIX", "FICÇÃO CIENTIFICA",0, "2"),
("DEADPOOL", "AÇÃO",0, "3"),("FROZEN", "DESENHO ANIMADO",0, "4"),
("SE BEBER N", "COMEDIA",0, "5"),("TITANIC", "DRAMA",0, "6"),
("AVATAR", "FICÇÃO CIENTIFICA",0, "7"),("DETROIT ROCK CITY", "MUSICA", 0,"8"),
("REI LEÃO", "DESENHO ANIMADO",0, "9"),("BATMAN CAVALEIRO DAS TREVAS", "AÇÃO",0, "10");

