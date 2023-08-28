--DROP SCHEMA IF EXISTS training731;

CREATE SCHEMA training731;

--ALTER SCHEMA training731 RENAME TO training0731;

CREATE TABLE training731.employees (
	emp_id INT,
	emp_name VARCHAR(200),
	emp_title VARCHAR(50),
	emp_salary DECIMAL
);

ALTER TABLE training731.employees ADD PRIMARY KEY (emp_id);


CREATE TABLE training731.checkerTable (
	id_val INT PRIMARY KEY,
	str_name VARCHAR
);

