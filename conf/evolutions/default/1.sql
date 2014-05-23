# --- First database schema

# --- !Ups

use `bardemo`;


# -- DROP TABLE if exists bar;

CREATE TABLE IF NOT EXISTS `bardemo`.`bar`(
#  ---  `id`    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   `id`   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   `name` VARCHAR(128) NOT NULL);

# --- !Downs


