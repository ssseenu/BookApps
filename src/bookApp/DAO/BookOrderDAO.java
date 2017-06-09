package bookApp.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bookApp.model.Book;
import bookApp.model.BookSales;
import bookApp.util.ConnectionUtil;

public class BookOrderDAO {
		
		
			
			/* User can able to view the available books and place an order */
			
			public void orderBook(Book book,BookSales bookSales) throws Exception {
				
				// 1. Get the connection
		        Connection conn = ConnectionUtil.getConnection();
		 
		        // 2. Query
		        String sql = "select isbn13,title,author,price from book where status = 'published'";
				
		        // 3. Set the input
				PreparedStatement pst = conn.prepareStatement(sql);
				
				// 4. Query execute
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					long isbn13 = rs.getLong("isbn13");
					String title = rs.getString("title");
					String author = rs.getString("author");
					Float price = rs.getFloat("price");
					System.out.println("Isbn:" + isbn13);
					System.out.println("Title:" + title);
					System.out.println("Author:" + author);
					System.out.println("Price:" + price);
				}
				
				//For Placing an order
				// 2. Query
				String orderSql = "insert into bookSales (salesId, userId, isbn13, quantity, price ,totalAmount, orderDate, status) values (?, ?, ?, ?, ?, ?, ?)";
				
				// 3. Set the input
				PreparedStatement pst1 = conn.prepareStatement(orderSql);
				pst1.setInt(1, bookSales.getSales_id());
		        pst1.setInt(2, bookSales.getUser_id());
		        pst1.setLong(3, book.getIsbn13());
		        pst1.setInt(4, bookSales.getQuantity());
		        pst1.setDouble(5, book.getPrice());
		        pst1.setDouble(6, bookSales.getTotalAmount());
		        pst1.setDate(7, Date.valueOf(bookSales.getOrderDate()));
		        pst1.setString(8, bookSales.getStatus());
		        
		        // 4. Query execute
				int rows = pst1.executeUpdate();
				System.out.println("No of rows inserted: " + rows);
				if(rows == 1)
					System.out.println("Order Successful!");
				
				// 5. Close DB resources
				ConnectionUtil.close(conn, pst, rs);
				ConnectionUtil.close(conn, pst1, rs);
			}
		
			
			/* User can select the quantity of books */ 
			
			public void selectQuantity(BookSales bookSales) throws Exception {
				
				// 1. Get the connection
		        Connection conn = ConnectionUtil.getConnection();
		        
		        // 2. Query
				String query = "update bookSales set quantity=? where salesId=? and userId=?";
				
				// 3. Set the input
				PreparedStatement pst = conn.prepareStatement(query);
				pst.setInt(1, bookSales.getQuantity());
				pst.setInt(2, bookSales.getSales_id());
				pst.setInt(3, bookSales.getUser_id());
				
				// 4. Query execute
				int rows = pst.executeUpdate();
				System.out.println("No of rows inserted: " + rows);
				
				
				// 5. Close DB resources
				ConnectionUtil.close(conn, pst, null);
			}
			
			/* User can cancel the book order */
			public void cancelOrder(BookSales bookSales) throws Exception {
					
					// 1. Get the connection
			        Connection conn = ConnectionUtil.getConnection();
			        
			        // 2. Query
					String sql = "update bookSales set status='CANCELLED' where sales_id=? and user_id=?";
					
					// 3. Set the input
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.setInt(1, bookSales.getSales_id());
					pst.setInt(2, bookSales.getUser_id());
					
					// 4. Query execute
					int rows = pst.executeUpdate();
					System.out.println("No of rows inserted: " + rows);
					if(rows == 1)
						System.out.println("Order Cancelled!!");
					
					// 5. Close DB resources
					ConnectionUtil.close(conn, pst, null);

				}


}
