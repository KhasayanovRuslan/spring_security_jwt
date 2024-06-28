-- liquibase formatted sql

-- changeset Ruslan:1

CREATE TABLE IF NOT EXISTS openschool_ss_jwt.person
(
id BIG_SERIAL PRIMARY KEY,
name VARCHAR(100) NOT NULL,
surname VARCHAR(150) NOT NULL,
age INT NOT NULL,
number_phone VARCHAR(30) NOT NULL,
city_of_living VARCHAR(200) NOT NULL
);