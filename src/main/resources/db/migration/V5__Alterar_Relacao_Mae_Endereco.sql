-- Remover a chave estrangeira antiga (se existir)
ALTER TABLE tb_adress DROP CONSTRAINT IF EXISTS fk_tb_adress_mae_id;

-- Adicionar uma nova coluna UNIQUE para a relação @OneToOne
ALTER TABLE tb_adress ADD CONSTRAINT fk_tb_adress_mae_id
FOREIGN KEY (mae_id) REFERENCES tb_mae(id);

-- Garantir que cada endereço esteja associado a uma única mãe
ALTER TABLE tb_adress ADD CONSTRAINT uq_tb_adress_mae_id UNIQUE (mae_id);
