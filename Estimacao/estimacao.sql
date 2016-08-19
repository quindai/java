SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `estimacao` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `estimacao` ;

-- -----------------------------------------------------
-- Table `estimacao`.`tbTipoPessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estimacao`.`tbTipoPessoa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estimacao`.`tbPessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estimacao`.`tbPessoa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cod_tipo_pessoa` INT NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `email` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  `usuario` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `tipo_pessoa_idx` (`cod_tipo_pessoa` ASC),
  CONSTRAINT `cod_tipo_pessoa`
    FOREIGN KEY (`cod_tipo_pessoa`)
    REFERENCES `estimacao`.`tbTipoPessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estimacao`.`tbTelefone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estimacao`.`tbTelefone` (
  `id` INT NOT NULL,
  `numero` VARCHAR(45) NULL,
  `cod_pessoa` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_pessoa_idx` (`cod_pessoa` ASC),
  CONSTRAINT `cod_pessoa`
    FOREIGN KEY (`cod_pessoa`)
    REFERENCES `estimacao`.`tbPessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estimacao`.`tbVenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estimacao`.`tbVenda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cod_pessoa` INT NOT NULL,
  `data` DATETIME NULL,
  `desconto` DECIMAL(10,2) NULL,
  PRIMARY KEY (`id`),
  INDEX `cod_pessoa_idx` (`cod_pessoa` ASC),
  CONSTRAINT `cod_pessoa`
    FOREIGN KEY (`cod_pessoa`)
    REFERENCES `estimacao`.`tbPessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estimacao`.`tbProduto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estimacao`.`tbProduto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `descricao` VARCHAR(100) NULL,
  `preco` DECIMAL(10,2) NULL,
  `quantidade` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estimacao`.`tbDetalhevenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estimacao`.`tbDetalhevenda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cod_venda` INT NOT NULL,
  `cod_produto` INT NOT NULL,
  `quantidade` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `cod_venda_idx` (`cod_venda` ASC),
  INDEX `cod_produto_idx` (`cod_produto` ASC),
  CONSTRAINT `cod_venda`
    FOREIGN KEY (`cod_venda`)
    REFERENCES `estimacao`.`tbVenda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cod_produto`
    FOREIGN KEY (`cod_produto`)
    REFERENCES `estimacao`.`tbProduto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
