CREATE TABLE training731.state (
	-- SERIAL in PostgreSQL is equivalent to 'AUTO_INCREMENT' in MySQL
	-- This will automatically create a new value for the PK if I don't declare it when inserting data
	state_id SERIAL PRIMARY KEY,
	state_name VARCHAR(100) UNIQUE NOT NULL
);

INSERT INTO training731.state VALUES (DEFAULT, 'Colorado');

CREATE TABLE training731.sports (
	sport_id SERIAL PRIMARY KEY,
	sport_name VARCHAR(100) UNIQUE
);

CREATE TABLE training731.team (
	team_id SERIAL PRIMARY KEY,
	team_name VARCHAR(100),
	team_state INT REFERENCES training731.state(state_id),
	team_sport INT,
	CONSTRAINT team_sport_fk FOREIGN KEY (team_sport) REFERENCES training731.sports(sport_id)
);

CREATE TABLE training731.players (
	player_id SERIAL PRIMARY KEY,
	team_id INT REFERENCES training731.team(team_id),
	player_name VARCHAR(200) CHECK(LENGTH(player_name) > 1) UNIQUE,
	player_salary DECIMAL UNIQUE,
	draft_date DATE UNIQUE
);

DROP TABLE training731.players;