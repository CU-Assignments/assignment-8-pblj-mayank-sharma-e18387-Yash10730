CREATE DATABASE employee_db;
USE employee_db;

CREATE TABLE employees (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100)
);

INSERT INTO employees VALUES (1, 'John Doe', 'IT'), (2, 'Jane Smith', 'HR');
