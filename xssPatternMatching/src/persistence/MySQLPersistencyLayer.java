package persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import dd.DBCredentials;
import dd.Finding;
import dd.Source;


public class MySQLPersistencyLayer{

	private final DBCredentials dbCredentials;
	private final Connection con;

	private final PreparedStatement prepSelectFindingStmt;
	private final PreparedStatement prepSelectFindingSourcesStmt;
	
	private ResultSet findingResultSet;
	
	private boolean findingIsOpen = false;
	
	public MySQLPersistencyLayer(DBCredentials dbCredentials) throws SQLException{
		this.dbCredentials = dbCredentials;
		this.con = openConnection();

		this.prepSelectFindingStmt = createSelectFindingStatement(); 
		this.prepSelectFindingSourcesStmt = createSelectFindingSourcesStatement();
	}
	
	private PreparedStatement createSelectFindingStatement() throws SQLException {
		PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM exploitable_flows WHERE sink_id = ?");//FIXME: Why do I sort this????  ORDER BY id ASC"); 
		return prepStmt;
	}
	
	private PreparedStatement createSelectFindingSourcesStatement() throws SQLException {
		PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM exploitable_flows_sources  WHERE finding_id = ?"); //
		return prepStmt;
	}
	

	private Connection openConnection() throws SQLException{		
		String url = "jdbc:mysql://" + dbCredentials.getHost() + ":" + dbCredentials.getPort() + "/" +  dbCredentials.getDatabase();
	
		Connection con = DriverManager.getConnection(url, dbCredentials.getUsername(), dbCredentials.getPassword());
		con.setAutoCommit(false);
		return con;
	}
	
	public void openFindings(int sinkId) throws SQLException{
		
		if(!findingIsOpen){
			prepSelectFindingStmt.setFetchSize(50);
			prepSelectFindingStmt.setInt(1, sinkId);
			prepSelectFindingStmt.execute();
			
			findingResultSet = prepSelectFindingStmt.getResultSet();
			findingIsOpen = true;
		}else{
			throw new RuntimeException("findings are already opened");
		}
	}
	
	public Finding nextFinding() throws SQLException{
		if(!findingIsOpen){
			throw new RuntimeException("Finding statment is closed! please open first!");
		}

		if(findingResultSet.next()){
			int id = findingResultSet.getInt(1);
			String url = findingResultSet.getString(4);
			String domain = findingResultSet.getString(5);
			Integer sinkId = findingResultSet.getInt(7);
			String value = findingResultSet.getString(8);
			String d1 = findingResultSet.getString(9);
			String d2 = findingResultSet.getString(10);
			String d3 = findingResultSet.getString(11);
		
		
			prepSelectFindingSourcesStmt.setInt(1, id);
			prepSelectFindingSourcesStmt.execute();
			Map<String, Source> sources = new HashMap<String, Source>();
	
			ResultSet sourceRs = prepSelectFindingSourcesStmt.getResultSet();
	
			while(sourceRs.next()){
				String position = sourceRs.getString(2);
				int startPosition = Integer.parseInt((position.split("-")[0]));
				int endPosition = Integer.parseInt((position.split("-")[1]));
				
				int sourceId = sourceRs.getInt(3);
				String sourceName = sourceRs.getString(4);
				String sourcePart = sourceRs.getString(5);
				int hasEscaping = sourceRs.getInt(6);
				int hasEncodeURI = sourceRs.getInt(7);
				int hasEncodeURIComponent = sourceRs.getInt(8);
			
				sources.put(String.valueOf(startPosition) + "-" + String.valueOf(endPosition), new Source(sourceId, sourceName, sourcePart, startPosition, endPosition, hasEscaping, hasEncodeURI, hasEncodeURIComponent));
			}
	
			return new Finding(id, sinkId, url, domain, value, sources, d1, d2, d3);
		}else{
			return null;
		}
	}
	
	public void closeFinding() throws SQLException{
		if(findingIsOpen){
			findingResultSet.close();
			prepSelectFindingStmt.close();
			findingIsOpen = false;
		}else{
			throw new RuntimeException("findings are already closed");
		}
	}
}
