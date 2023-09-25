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

-- Updated one of the test records in our table to match our sequence
UPDATE training731.employees SET emp_id=1012 WHERE emp_id=2000;

-- CREATE a SEQUENCE since we did NOT CREATE our employees TABLE USING SERIAL DATATYPE
CREATE SEQUENCE employees_emp_id_seq START WITH 1013 INCREMENT BY 1;

-- ALTER OUR TABLE SO THAT WE USE THIS SEQUENCE BY DEFAULT (this is what SERIAL actually does)
ALTER TABLE training731.employees ALTER COLUMN emp_id SET DEFAULT NEXTVAL('employees_emp_id_seq');

INSERT INTO training731.employees VALUES (DEFAULT,'Otto','Developer',100000.00);

-- Below example would not work (we need to either use 'DEFAULT' or we need to state the column names:
INSERT INTO training731.employees VALUES ('Tri', 'Manager',120000.00);