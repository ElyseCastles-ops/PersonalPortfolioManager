CREATE DATABASE personalportfolio;

use personalportfolio;

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
  `account_id` INT NOT NULL,
  `ticker` VARCHAR(100) NOT NULL,
  `quantity` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_h_account_id_idx` (`account_id` ASC) VISIBLE,
  CONSTRAINT `fk_h_account_id`
    FOREIGN KEY (`account_id`)
    REFERENCES `personalportfolio`.`accounts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    INSERT INTO `personalportfolio`.`accounts` (name, type, description, balance) VALUES 
     ('Citi', 'Cash', 'checking', 0),
	 ('Citi', 'Investment', 'Savings', 0),
     ('Citi', 'Investment', '401k', 0),
     ('Chase', 'Investment', 'IRA', 0),
     ('Cappital One', 'Cash', 'Business Operating', 0),
	 ('Cappital One', 'Investment', 'Business Reserve', 0),
     ('Cappital One', 'Cash', 'Business Tax', 0),
     ('Cappital One', 'Cash', 'Business Marketing', 0),
     ('Cappital One', 'Cash', 'Business Innovation', 0);

    INSERT INTO `personalportfolio`.`holdings` (account_id, ticker, quantity) VALUES
		 (2, 'NASDAQ: AMZN', 10),
		 (2, 'NYSE: BRK.B', 75),
	     (2, 'NYSE: Y', 4),
	     (2, 'NYSE: FUN', 60),
	     (2, 'NASDAQ: NFLX', 5),
         (3, 'NASDAQ: CSCO', 33),
         (3, 'NYSE: D', 76),
         (3, 'NYSE: FSR', 143),
         (3, 'NYSE: E', 44),
         (3, 'NYSE: G', 94),
		 (4, 'NASDAQ: TSLA', 57),
         (4, 'NASDAQ: TSLA', 86),
         (4, 'NASDAQ: TSLA', 57),
         (4, 'NASDAQ: TSLA', 35),
         (4, 'NASDAQ: TSLA', 25),
         (6, 'NASDAQ: APPS', 79),
         (6, 'NYSE: PFE', 132),
         (6, 'NASDAQ: SESN', 90),
         (6, 'NYSE: TAP', 65),
         (6, 'NYSE: XOM', 22);
         
	INSERT INTO `personalportfolio`.`cashtransactions` (account_id, name, amount, date) VALUES
		(1, 'NASDAQ: AMZN', 105, '2021-03-11 15:23:44'),
		(4, 'NASDAQ: AMZN', 566, '2020-01-19 09:23:44'),
		(7, 'NASDAQ: AMZN', 23.65, '2021-05-28 10:23:44'),
		(8, 'NASDAQ: AMZN', 19.99, '2020-07-16 11:23:44'),
		(9, 'NASDAQ: AMZN', 300, '2020-06-23 13:23:44');

    INSERT INTO `personalportfolio`.`investmenttransactions` (account_id, ticker, priceper, quantity, date) VALUES
		(2, 'NASDAQ: AMZN', 952.20, 10, '2021-04-10 13:23:44'),
		(3, 'NASDAQ: AMZN', 20.56, 15, '2020-06-19 13:23:44'),
		(4, 'NASDAQ: AMZN', 96.32, 13, '2021-03-20 13:23:44'),
		(6, 'NASDAQ: AMZN', 23.12, 12, '2021-05-25 13:23:44');


         


         



    
    
