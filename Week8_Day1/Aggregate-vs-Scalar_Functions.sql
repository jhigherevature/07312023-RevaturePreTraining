/*
 * Aggregate Functions : Operations that are performed across multiple
 * rows (or every single row) of your records based on a specified column
 */
SELECT AVG(emp_salary) FROM training731.employees;

-- You can use them in combination...
SELECT ROUND ( AVG(emp_salary) ) FROM training731.employees;

-- As we have seen before, this can be used in combination with GROUP BY & HAVING
SELECT emp_title, AVG(emp_salary)
	FROM training731.employees
	GROUP BY emp_title
	HAVING AVG(emp_salary) > 150000;

SELECT COUNT(emp_id) FROM training731.employees;

/*
 * SCALAR FUNCTIONS : Operations which are performed on a record-by-record
 * basis across a column of our resultset that we specify
 */ 
-- STRING FUNCTIONS:
SELECT UPPER(emp_name) FROM training731.employees;
SELECT emp_name, CHAR_LENGTH(emp_name) FROM training731.employees; 

-- Mathematical Functions:
SELECT ABS(-175);