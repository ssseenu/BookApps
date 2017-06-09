package bookApp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bookApp.model.BookRatings;
import bookApp.util.ConnectionUtil;

public class BookRatingsDAO {
	
		/* Users can provide ratings for the book */
		
		public void addRating(BookRatings bookRatings) throws Exception {
			
			// Step 1:Get the connection
	        Connection conn = ConnectionUtil.getConnection();
	        
	        // Step 2: Query
			String sql = "update bookRatings set rating = ? where isbn13 = ?";
			
			// 3. Set the input
	        PreparedStatement pst = conn.prepareStatement(sql);
			pst.setDouble(1, bookRatings.getRating());
			pst.setLong(2, bookRatings.getIsbn13());
			
			// 4. Query execute
			int rows = pst.executeUpdate();
			System.out.println("No of rows updated : " + rows);

			// 5. Close DB resources
			ConnectionUtil.close(conn, pst, null);

		}

}
