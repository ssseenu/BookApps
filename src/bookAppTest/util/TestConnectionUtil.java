package bookAppTest.util;

import java.sql.Connection;

import bookApp.util.ConnectionUtil;

public class TestConnectionUtil {
		public static void main(String[] args) throws Exception {
			 
	        Connection connection = ConnectionUtil.getConnection();
	        System.out.println(connection);
	 
	    }
	


}
