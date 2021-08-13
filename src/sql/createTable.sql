CREATE DATABASE personalportfolio;

CREATE TABLE `personalportfolio`.`accounts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  `balance` DOUBLE NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `personalportfolio`.`cashtransactions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `account_id` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `amount` DOUBLE NOT NULL,
  `date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `account_id_idx` (`account_id` ASC) VISIBLE,
  CONSTRAINT `fk_ct_account_id`
    FOREIGN KEY (`account_id`)
    REFERENCES `personalportfolio`.`accounts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `personalportfolio`.`investmenttransactions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `account_id` INT NOT NULL,
  `ticker` VARCHAR(45) NOT NULL,
  `priceper` DOUBLE NOT NULL,
  `quantity` INT NOT NULL,
  `date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `account_id_idx` (`account_id` ASC) VISIBLE,
  CONSTRAINT `fk_it_account_id`
    FOREIGN KEY (`account_id`)
    REFERENCES `personalportfolio`.`accounts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    CREATE TABLE `personalportfolio`.`holdings` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `acount_id` INT NOT NULL,
  `ticker` VARCHAR(100) NOT NULL,
  `quantity` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_h_acount_id_idx` (`acount_id` ASC) VISIBLE,
  CONSTRAINT `fk_h_acount_id`
    FOREIGN KEY (`acount_id`)
    REFERENCES `personalportfolio`.`accounts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

    
    
