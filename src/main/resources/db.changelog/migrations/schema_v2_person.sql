-- liquibase formatted sql

-- changeset Ruslan:1

INSERT INTO openschool_ss_jwt.person
      (name, surname, age, number_phone, city_of_living)
VALUES('Jack', 'Ivanov', 30, '8-924-477-78-90', 'Tver'),
      ('Ivan', 'Petrov', 20, '8-913-903-07-67', 'Ufa'),
      ('Alexandra', 'Petrova', 19, '8-924-882-00-11', 'Moscow'),
      ('Ksenia', 'Sidorova', 47, '8-909-234-23-22', 'Moscow' );