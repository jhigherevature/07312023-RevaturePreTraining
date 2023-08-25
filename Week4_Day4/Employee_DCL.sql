-- USING DDL AND DCL we will CREATE users AND provide PRIVILEGES TO them
CREATE USER training WITH PASSWORD 'password';

-- Using DCL we will provide the privileges
-- GRANT <permissions> ON <entity> TO <user>
GRANT INSERT ON training731.employees TO training;
GRANT SELECT, UPDATE, DELETE ON training731.employees TO training;
GRANT USAGE ON SCHEMA training731 TO training;

-- GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA <schema_name> TO <user_name>;
-- GRANT ALL PRIVILEGES ON SCHEMA <schema_name> TO <user_name>;