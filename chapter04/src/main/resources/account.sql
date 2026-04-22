CREATE DATABASE IF NOT EXISTS spring;
USE spring;
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(20),
    `balance` DOUBLE
);
