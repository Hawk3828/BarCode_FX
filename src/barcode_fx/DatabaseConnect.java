package barcode_fx;

 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnect {

	private static final String USERNAME = "Hawk";
	private static final String PASSWORD = "Maxzot3828##";
	private static final String CON_STRING = 
						"jdbc:mysql://localhost/barcodefx";
			
	
	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = DriverManager.getConnection(CON_STRING, USERNAME, PASSWORD);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(CON_STRING);
			System.out.println("Connected!");
		} catch (SQLException e) {
			System.err.println(e);
		}finally{
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}
	}

}
