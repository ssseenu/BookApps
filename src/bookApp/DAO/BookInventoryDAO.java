package bookApp.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;

import bookApp.model.BookInventory;
import bookApp.util.ConnectionUtil;

public class BookInventoryDAO {
	
		
		/*Admin can increase the quantity of Books */
		
		public void increaseQuantity(BookInventory bookInventory) throws Exception {
			
			// 1. Get the connection
	        Connection conn = ConnectionUtil.getConnection();
	 
	        // 2. Query
			String query = "update bookInventory set quantity = ? where isbn13 = ?";
			
			// 3. Set the input
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, bookInventory.getQuantity());
			pst.setLong(2, bookInventory.getIsbn13());
			
			// 4. Query execute
			int row = pst.executeUpdate();
			System.out.println(row + " book quantity updated.");
			
			// 5. Close DB resources
			ConnectionUtil.close(conn, pst, null);

		}
		
		/* Once the stock is not available, user should not be able to place an order */

		public void availableStock(BookInventory bookInventory) throws Exception {
			
			// 1. Get the connection
	        Connection conn = ConnectionUtil.getConnection();
	 
	        // 2. Query
			String query = "update bookSales set status = 'Out of stock' where ((select quantity from bookInventory where isbn13 = ?) > 0)";
			
			// 3. Set the input
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setLong(1, bookInventory.getIsbn13());
			
			// 4. Query execute
			try {
				int rows = pst.executeUpdate();
				System.out.println("No of rows inserted: " + rows);
				throw new Exception("OUT OF STOCK");	
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// 5. Close DB resources
			ConnectionUtil.close(conn, pst, null);
		}
	

}
