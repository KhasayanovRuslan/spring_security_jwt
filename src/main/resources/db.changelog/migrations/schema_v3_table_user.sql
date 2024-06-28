-- liquibase formatted sql

-- changeset Ruslan:1

CREATE TABLE openschool_ss_jwt.users
(
id BIGSERIAL PRIMARY KEY,
username VARCHAR(255) UNIQUE NOT NULL,
email VARCHAR(255) UNIQUE NOT NULL,
password VARCHAR(255) NOT NULL,
role VARCHAR(255) NOT NULL
);