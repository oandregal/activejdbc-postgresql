DROP TABLE IF EXISTS employees;
CREATE TABLE employees (
      id  SERIAL,
      first_name VARCHAR(56),
      last_name VARCHAR(56)
  );

DROP SCHEMA IF EXISTS people CASCADE;
CREATE SCHEMA people;

DROP TABLE IF EXISTS people.teachers;
CREATE TABLE people.teachers (
      id  SERIAL,
      name_first VARCHAR(56),
      name_last VARCHAR(56),
      card_id INTEGER
  );

DROP TABLE IF EXISTS people.employees;
CREATE TABLE people.employees (
      id  SERIAL,
      name_first VARCHAR(56),
      name_last VARCHAR(56),
      card_id INTEGER
  );
