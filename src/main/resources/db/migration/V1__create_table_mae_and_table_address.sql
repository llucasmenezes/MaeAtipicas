-- V1__create_mae_and_address_tables.sql

-- Criando a tabela tb_mae
CREATE TABLE IF NOT EXISTS tb_mae (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    name VARCHAR(255),
    lastName VARCHAR(255)
    );

-- Criando a tabela tb_address
CREATE TABLE IF NOT EXISTS tb_address (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(255),
    postalcode VARCHAR(20),
    country VARCHAR(100),
    mae_id BIGINT UNIQUE NOT NULL
    );