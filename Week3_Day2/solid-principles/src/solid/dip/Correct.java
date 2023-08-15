package solid.dip;

/*
 * This class Demonstrates a correct example of the "Dependency Inversion Principle" (DIP)
 * from the SOLID Design principles
 */
public class Correct {
	class DatabaseHandler {
	    private final Database database;

	    DatabaseHandler(Database database) {
	        this.database = database;
	    }

	    void performOperation() {
	        database.connect();
	        // Perform database operations
	        database.disconnect();
	    }
	}
	
	interface Database {
	    void connect();

	    void disconnect();
	}

	class MySQLDatabase implements Database {
	    public void connect() {
	        // Connect to MySQL
	    }

	    public void disconnect() {
	        // Disconnect from MySQL
	    }
	}
	
	class PostgresSQLDatabase implements Database {
	    public void connect() {
	        // Connect to PostgresSQL
	    }

	    public void disconnect() {
	        // Disconnect from PostgreSQL
	    }
	}
}
