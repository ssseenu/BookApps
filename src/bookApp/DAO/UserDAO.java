package bookApp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bookApp.model.User;
import bookApp.util.ConnectionUtil; 

public class UserDAO {
	
		
		 public void insertUser(User user) throws Exception {
			 
		        // Step 1:Get the connection
		        Connection conn = ConnectionUtil.getConnection();
		 
		        // Step 2: Query
		        String sql = "insert into user ( name, id, userName, password, mobileNo, emailId, active, roleId) value ( ?, ? ,?, ?, ?, ?, ?, ? )";
		 
		        // 3. Set the input
		        PreparedStatement pst = conn.prepareStatement(sql);
		        pst.setString(1, user.getName());
		        pst.setInt(2, user.getId());
		        pst.setString(3, user.getUserName());
		        pst.setString(4, user.getPassword());
		        pst.setLong(5, user.getMobileNo());
		        pst.setString(6, user.getEmailId());
		        pst.setString(7, user.getActive());
		        pst.setString(8, user.getRoleId());
		 
		        // 4. Query execute
		        int rows = pst.executeUpdate();
		        System.out.println("No of rows inserted: " + rows);
		        
		 }
		        /* User Login Method */
		    	public void loginUser(User user) throws Exception {
		    		
		    		 // Step 1:Get the connection
		            Connection conn = ConnectionUtil.getConnection();
		    		
		            // Step 2: Query
		            String query = "update user set active = 'A' where (userName= ?) and (password = ?)";
		    		
		            // 3. Set the input
		            PreparedStatement pst = conn.prepareStatement(query);
		    		pst.setString(1, user.getUserName());
		    		pst.setString(2, user.getPassword());
		    		
		    		// 4. Query execute
		            int rows = pst.executeUpdate();
		            System.out.println("No of rows inserted: " + rows);
		    		System.out.println("Login Sucessfully completed");
		    		
		    		// 5. Close DB resources
		    		ConnectionUtil.close(conn, pst, null);
		    	}
		    	
		    	/* User can Reset Password */
		    	public void updatePassword(User user, String newPassword) throws Exception {
		    		
		    		 // Step 1:Get the connection
		            Connection conn = ConnectionUtil.getConnection();
		    		
		         // Step 2: Query
		    		String query = "update user set password = ? where ((username = ?) and (active = 'A')) and password=?";
		    		
		    		// 3. Set the input
		    		PreparedStatement pst = conn.prepareStatement(query);
		    		pst.setString(1, newPassword);
		    		pst.setString(2, user.getUserName());
		    		pst.setString(3, user.getPassword());
		    		
		    		// 4. Query execute
		    		int rows = pst.executeUpdate();
		    		if (rows == 1) {
		    			System.out.println("No of rows inserted: " + rows);
		    			System.out.println("Password Reset Sucessful");
		    		} else if (rows == 0) {
		    			System.out.println("No of rows inserted: " + rows);
		    			System.out.println("Please Login to reset the password");
		    		} else {
		    			System.out.println("No of rows inserted: " + rows);
		    			System.out.println("Error in Reset");
		    		}
		    		
		    		// 5. Close DB resources
		    		ConnectionUtil.close(conn, pst, null);
		    	}

}
