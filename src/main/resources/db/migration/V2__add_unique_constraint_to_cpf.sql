--V2 deixando a coluna cpf como unica, para nao ter repeticao de cpf iguais.

ALTER TABLE tb_mae
ADD CONSTRAINT unique_cpf UNIQUE (cpf);