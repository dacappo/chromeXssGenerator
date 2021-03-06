package analytics.dacappo.sap.com;

import java.sql.SQLException;

import org.htmlparser.util.ParserException;

import dd.DBCredentials;
import dd.Finding;
import persistence.MySQLPersistencyLayer;

public class RunAnalyzing {
	
	/**
	* Main function call
	* - opens database connection
	* - queries database
	* - calls Analyzer for each Finding
	* - writes results to console
	*/	
	public static void main(String[] args) throws SQLException {
		
		Analyzer analyzer = Analyzer.getAnalyzer();
		
		/*
		 * Database connection settings: Server - Port - User - Password - Database
		 */
		DBCredentials credentials = new DBCredentials("localhost", 3306, "crawler", "crawler", "flows");
		
		/*
		 * Establish connection to database
		 */
		MySQLPersistencyLayer persistence = new MySQLPersistencyLayer(credentials);
		
		/*
		 * Query database for findings with special sink
		 */
		persistence.openFindings(2);
				
		/*
		 * Loop over findings and call analyzer
		 */
		long timestamp = System.currentTimeMillis();
		for (Finding f = persistence.nextFinding(); f != null; f = persistence.nextFinding()){
			try {
				analyzer.analyseFinding(f);
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				System.out.println("Parser error occured!");
			}
		}
		timestamp = System.currentTimeMillis() - timestamp;
		
		
		
		/*
		 * Print results
		 */
		
		System.out.println("Number of analyzed findings: " + analyzer.getNumOfAnalyses());
		System.out.println("Number of possible bypasses: " + analyzer.getNumberOfPossibleBypasses());
		System.out.println("-------------------------------------------------------");
		
		for(int i = 0; i < analyzer.getBypasses().size();i++) {
			System.out.println("Number of type " + String.valueOf(i+1)  + " bypasses: " + analyzer.getBypassConditionCount(i) + " : " + analyzer.getBypasCondition(i).getDescribtion());
		}
			
		System.out.println("-------------------------------------------------------");
		System.out.println("Time for analyzing: " + (int)timestamp/1000 + " seconds" );
				
	}
}
