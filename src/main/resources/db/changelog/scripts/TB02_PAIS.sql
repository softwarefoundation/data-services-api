--liquibase formatted sql
--changeset dherkyan.silva:1

CREATE TABLE tb02_pais
(
    id_pais   INT PRIMARY KEY AUTO_INCREMENT,
    nome      VARCHAR(100) UNIQUE,
    alpha2    VARCHAR(2) UNIQUE,
    alpha3    VARCHAR(3) UNIQUE,
    numerico3 VARCHAR(3) UNIQUE,
    dominio   VARCHAR(3)
);