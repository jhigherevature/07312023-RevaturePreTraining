INSERT INTO training731.employees VALUES (1000, 'Mary', 'CEO', 210000.00);
INSERT INTO training731.employees VALUES (1001,'Bin','Developer',120000.00);
INSERT INTO training731.employees VALUES (1002,'Dan','Tester',123000.00);

INSERT INTO training731.employees VALUES
	(1003,'Emmanuel','Developer',168000.00),
	(1004,'Jacob','Project Manager',195000.00),
	(1005,'Jessica','Project Manager',199000.00),
	(1006,'Steve','Developer',97000.00),
	(1007,'Maggie','Tester',88000.00),
	(1008,'Quincy','Developer',86000.00),
	(1009,'Leslie','Tester',151000.00),
	(1010,'Bill','Developer',114000.00);
	

INSERT INTO training731.employees VALUES (1011,'Joe',NULL,100000.00);

SELECT * FROM training731.employees;

SELECT emp_name, emp_salary FROM training731.employees;

DELETE FROM training731.employees;

/*
 * The Where clause is useful to determine exactly which records you want to search for 
 * or manipulate (Update and Delete)
 */
SELECT * FROM training731.employees WHERE emp_id = 1000;
SELECT emp_name, emp_title, emp_salary FROM training731.employees WHERE emp_title = 'Developer';
SELECT emp_name, emp_title, emp_salary FROM training731.employees WHERE emp_title != 'Developer';
SELECT emp_name, emp_title, emp_salary FROM training731.employees WHERE emp_salary > 120000;

SELECT * FROM training731.employees WHERE emp_salary > 100000 AND emp_title='Developer';

SELECT * FROM training731.employees WHERE emp_title IN ('Developer', 'Tester');

SELECT * FROM training731.employees WHERE emp_salary BETWEEN 86000 AND 97000;

SELECT * FROM training731.employees WHERE emp_salary > (SELECT avg(emp_salary) FROM training731.employees);

/*
 * LIKE : allow you to filter the results of a query based on character matching sequences
 * LIKE is used in combination with the WHERE keyword.
 * 
 * '%' - (percent) Wildcard to represent ANY character and ANY number of those characters 
 * '_' - (underscore) Wildcard to represent ANY SINGLE character
 */
SELECT * FROM training731.employees WHERE emp_name LIKE 'J_c%'; -- Jessica & Jacob
SELECT * FROM training731.employees WHERE emp_name LIKE '__n'; -- Bin & Dan
SELECT * FROM training731.employees WHERE emp_name LIKE '_i_%'; -- Bin & Bill

SELECT * FROM training731.employees WHERE emp_title IS NULL;

-- Aliases allow you to add a TEMPORARY name to an entity (table or columns) 
-- in your query for easier reference
SELECT emp_name AS name, emp_title AS title, emp_salary AS salary FROM training731.employees;


-- We will discuss joins and set operations in more detail later...here is a small preview: 
--SELECT a.emp_id AS id FROM training731.animals AS a
--RIGHT JOIN training731.vet AS b ON a.vet_id = b.vet_id;

