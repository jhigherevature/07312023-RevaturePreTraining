-- INNER JOIN : Join data across tables which match the column values
/*
 * Typically when joining records from multiple tables, the PK & associated
 * FK columns are referenced in an Equi-join condition. However, there is
 * nothing wrong with associating data from any column across both tables
 * so long as the datatype is similar
 */
-- This inner join will associate the players with their team name
SELECT p.player_name, t.team_name FROM training731.players AS p
INNER JOIN training731.team AS t ON p.team_id = t.team_id;

/* 
 * to be clear, when using joins we are matching on a specified values 
 * from the tables...the following examples aren't very useful, but shows
 * what happens when we match the player_id to the team_id
 */
SELECT p.player_id, p.player_name, t.team_id, t.team_name FROM training731.players AS p
INNER JOIN training731.team AS t ON p.player_id = t.team_id;

-- (FULL OUTER) JOIN 
SELECT * FROM training731.players p FULL OUTER JOIN
training731.team t ON p.player_id = t.team_id;

SELECT * FROM training731.players p FULL OUTER JOIN
training731.team t ON p.player_id = t.team_id WHERE t.team_id is null;

-- LEFT JOINS : The result set is based on the first table's values
SELECT p.player_name, t.team_name FROM training731.players p
LEFT JOIN training731.team t ON p.player_id = t.team_id;

SELECT p.player_name, t.team_name FROM training731.players p
LEFT JOIN training731.team t ON p.player_id = t.team_id WHERE t.team_id IS NULL;

-- RIGHT JOINS : The result set is based on the second table's values
SELECT p.player_name, t.team_name FROM training731.players p
RIGHT JOIN training731.team t ON p.player_id = t.team_id;

SELECT p.player_name, t.team_name FROM training731.players p
RIGHT JOIN training731.team t ON p.player_id = t.team_id WHERE p.player_id IS NULL;

-- CROSS JOIN : The result set produced is a every combination of records from both tables
SELECT s.state_name, t.team_name FROM training731.state s CROSS JOIN training731.team t;

-- SELF JOIN : The Result set is based on records on the same table
/*
 * Imagine that our Employees table had the following structure instead:
 * employees (
 * 	emp_id INT PRIMARY KEY,
 * 	emp_name VARCHAR,
 *  supervisor_id INT REFERENCES employees(emp_id)
 * );
 * 
 * We could use a 'Self-join' to reference ourself:
 * SELECT a.emp_name AS employee, b.emp_name AS supervisor FROM training731.employees a
 * INNER JOIN training731.employees b ON a.emp_id = b.supervisor_id;
 */


/*
 * SET Operations : Perform a query against mutliple result sets and
 * 		compare data from those sets to determine a final result set
 * 		that is provided
 * 
 * Note: The results of a set operation are comparisons against all of the 
 * 		queried columns. So if we want 'player_name' and 'team_name' some
 * 		set operations will always return no results from one or both tables
 * 		unless a player's name and a team's name happen to match...
 */
-- UNIONS : All records from both result sets displayed together
SELECT p.player_id AS id, p.player_name AS name FROM training731.players p
UNION SELECT t.team_id, t.team_name FROM training731.team t ORDER BY id ASC;

-- Lets try a Union with Just the ID values...
SELECT p.player_id AS id FROM training731.players p
UNION SELECT t.team_id FROM training731.team t ORDER BY id ASC;

-- Lets try a Union ALL now...
SELECT p.player_id AS id FROM training731.players p
UNION ALL SELECT t.team_id FROM training731.team t ORDER BY id ASC;

-- INTERSECT : Return data from 2 results sets that match values
SELECT p.player_id AS id FROM training731.players p
INTERSECT ALL SELECT t.team_id FROM training731.team t ORDER BY id ASC;

-- EXCEPT : Return data from 2 result sets that do NOT match values
SELECT p.player_id AS id FROM training731.players p
EXCEPT ALL SELECT t.team_id FROM training731.team t ORDER BY ID ASC;

/*
 * Subqueries : Performing multiple queries within the same query
 * 		operation. Specifically subqueries are performed with WHERE
 * 		clauses to specify some additional information that is searched
 * 		first.
 */
SELECT avg(player_salary) FROM training731.players;
SELECT player_name FROM training731.players WHERE player_salary > 590521;
SELECT player_name FROM training731.players WHERE player_salary < 590521;

SELECT player_name FROM training731.players WHERE player_salary > 
(SELECT avg(player_salary) FROM training731.players);

SELECT player_name FROM training731.players WHERE player_salary < 
(SELECT avg(player_salary) FROM training731.players);

-- VIEWS : Named virtual tables which we can reference at a later point
CREATE OR REPLACE VIEW training731.high_salaries AS
SELECT player_name, player_salary FROM training731.players WHERE player_salary > 
(SELECT avg(player_salary) FROM training731.players);

SELECT * FROM training731.high_salaries;


-- Bonus View (heres how we can combine many of these concepts together) : 
CREATE OR REPLACE VIEW training731.avg_team_salary AS
SELECT t.team_name AS "team name", avg(p.player_salary) AS "average player salary" 
FROM training731.players p 
RIGHT JOIN training731.team t 
ON p.team_id = t.team_id 
GROUP BY t.team_name;


SELECT * FROM training731.avg_team_salary;
