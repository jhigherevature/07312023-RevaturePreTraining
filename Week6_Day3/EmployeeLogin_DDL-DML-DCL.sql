CREATE TABLE training731.employeelogin (
	login_id SERIAL PRIMARY KEY,
	emp_id INT REFERENCES training731.employees(emp_id),
	login_name VARCHAR(100),
	login_pass VARCHAR(100)
);

INSERT INTO training731.employeelogin VALUES
	(DEFAULT, 1000, 'maryLogin', 'password'),
	(DEFAULT, 1001, 'binLogin', 'password'),
	(DEFAULT, 1002, 'danLogin', 'password'),
	(DEFAULT, 1003, 'emmanuelLogin', 'password'),
	(DEFAULT, 1004, 'jacobLogin', 'password'),
	(DEFAULT, 1005, 'jessicaLogin', 'password'),
	(DEFAULT, 1006, 'steveLogin', 'password'),
	(DEFAULT, 1007, 'maggieLogin', 'password'),
	(DEFAULT, 1008, 'quincyLogin', 'password'),
	(DEFAULT, 1009, 'leslieLogin', 'password'),
	(DEFAULT, 1010, 'billLogin', 'password'),
	(DEFAULT, 1011, 'joeLogin', 'password'),
	(DEFAULT, 1012, 'javaLogin', 'password'),
	(DEFAULT, 1013, 'ottoLogin', 'password'),
	(DEFAULT, 1014, 'segundoLogin', 'password');
	
GRANT INSERT, SELECT, UPDATE, DELETE ON training731.employeelogin TO training;

