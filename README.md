Utilizo XAMPP para conectar la base de datos con IntelliJ, el usuario por defecto creado es "root" sin contraseña, con el puerto 3306.
En el archivo "import.sql" ya hay creados dos usuarios, uno administrador y otro que no lo es, la contraseña de los dos es "dani". El puerto utilizado para conectar android con intellij es 8080.

El administrador está representado de tal forma que 1 es administrador y 0 no lo es.
Lo he puesto así porque en workbench al crear la base de datos no me dejaba poner un boolean, ya que
automáticamente se cambiaba a "tinyint", y por eso está en Byte.

Creación de la base de datos, los datos están en el archivo "import.sql":

CREATE SCHEMA IF NOT EXISTS `frasescelebres` DEFAULT CHARACTER SET utf8 ;
USE `frasescelebres` ;

-- -----------------------------------------------------
-- Table `frasescelebres`.`autor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `frasescelebres`.`autor`;

CREATE TABLE IF NOT EXISTS `frasescelebres`.`autor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(128) NULL,
  `nacimiento` INT NULL,
  `muerte` VARCHAR(5) NULL,
  `profesion` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `frasescelebres`.`categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `frasescelebres`.`categoria`;

CREATE TABLE IF NOT EXISTS `frasescelebres`.`categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(128) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `frasescelebres`.`frase`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `frasescelebres`.`frase`;

CREATE TABLE IF NOT EXISTS `frasescelebres`.`frase` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `texto` VARCHAR(300) NULL,
  `fechaprogramada` DATE NULL,
  `autor_id` INT NOT NULL,
  `categoria_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_frase_autor_idx` (`autor_id` ASC),
  INDEX `fk_frase_categoria1_idx` (`categoria_id` ASC),
  CONSTRAINT `fk_frase_autor`
    FOREIGN KEY (`autor_id`)
    REFERENCES `frasescelebres`.`autor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_frase_categoria1`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `frasescelebres`.`categoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `frasescelebres`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `frasescelebres`.`usuario`;

CREATE TABLE IF NOT EXISTS `frasescelebres`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `contrasenya` VARCHAR(100) NULL,
  `admin` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;
