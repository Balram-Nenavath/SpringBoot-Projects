--liquibase formatted sql
--changeset techgeeknext:create-tables

CREATE TABLE employee(
   id INT PRIMARY KEY,
   name VARCHAR(40)
   dept VARCHAR(40)
   sal VARCHAR(40)
);

CREATE TABLE dept(
   id INT PRIMARY KEY,
   name VARCHAR(40),
   emp_id INT,
   FOREIGN KEY(emp_id) REFERENCES employee(id) ON DELETE CASCADE
);
