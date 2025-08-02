--liquibase formatted sql
--changeset dherkyan.silva:1

CREATE TABLE tb01_cidade
(
    id_cidade   INT PRIMARY KEY AUTO_INCREMENT,
    nome        VARCHAR(100),
    uf          VARCHAR(2),
    codigo_ibge VARCHAR(7) UNIQUE
);