package bookApp.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {

		public static Connection getConnection() throws Exception {
			 
	        Connection con = null;
	        String url = "jdbc:mysql://localhost:3306/book_db?useSSL=false";
	        String userName = "root";
	        String passWord = "root";
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection(url, userName, passWord);
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new Exception(e);
	        }
	        return con;
	    }
	     
	    public static void close(Connection conn , PreparedStatement stmt, ResultSet rs){
	         
	        try
	        {
	            if ( rs != null ){
	                rs.close();
	            }
	            if ( stmt != null ) {
	                stmt.close();
	            }
	            if ( conn != null ){
	                conn.close();
	            }
	        }
	        catch(SQLException e){
	             
	        }
	    }
	}
	 
	
