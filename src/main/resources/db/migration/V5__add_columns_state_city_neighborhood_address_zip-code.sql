-- V5 incluindo na tabela "mae" as colunas: estado, cidade, bairro, endereco e codigo-postal.


ALTER TABLE tb_mae
ADD COLUMN state VARCHAR(255),
ADD COLUMN city VARCHAR(255),
ADD COLUMN neighborhood VARCHAR(255),
ADD COLUMN address VARCHAR(255),
ADD COLUMN zip_code VARCHAR(255);