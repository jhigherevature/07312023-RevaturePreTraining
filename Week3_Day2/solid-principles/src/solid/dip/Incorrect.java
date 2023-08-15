package solid.dip;

/*
 * This class Demonstrates an example that violates the "Dependency Inversion Principle" (DIP)
 * of the SOLID Design principles
 */
public class Incorrect {
	class DatabaseHandler {
	    private final MySQLDatabase mySQLDatabase;
	    private final PostgresSQLDatabase postgresSQLDatabase;

	    DatabaseHandler(MySQLDatabase mySQLDatabase, PostgresSQLDatabase postgresSQLDatabase) {
	        this.mySQLDatabase = mySQLDatabase;
	        this.postgresSQLDatabase = postgresSQLDatabase;
	    }

	    void performOperation(String type) {
	    	if (type.equals("MySql")) {
		        // Perform MySQL database operations
		    	mySQLDatabase.connect();
		    	mySQLDatabase.disconnect();
	    	
	    	} else if (type.equals("Postgres")) {
		        // Perform PostgresSQL database operations
	    		postgresSQLDatabase.connect();
	    		postgresSQLDatabase.disconnect();
	    	}
	    }
	    // This class is tightly coupled to the database implementations, making it harder to extend, modify and maintain
	}
	
	// Incorrect way
	class MySQLDatabase {
	    void connect() {
	        // Connect to MySQL
	    }

	    void disconnect() {
	        // Disconnect from MySQL
	    }
	}

	class PostgresSQLDatabase {
	    public void connect() {
	        // Connect to PostgresSQL
	    }

	    public void disconnect() {
	        // Disconnect from PostgreSQL
	    }
	}
}
