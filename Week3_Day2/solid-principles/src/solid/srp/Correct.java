package solid.srp;

/*
 * This class Demonstrates a correct example of the "Single Responsibility Principle" (SRP)
 * from the SOLID Design principles
 */
public class Correct {
	class Report {
		String generateReport() {
			// Code to generate a report
			return "This is your report data";
		}
	}
	
	class Printer {
		void printReport(Report report) {
			// Print data generated
			report.generateReport();
		}
	}
}
