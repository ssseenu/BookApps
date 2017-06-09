package bookApp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bookApp.model.Book;
import bookApp.util.ConnectionUtil;


public class BookSearchDAO {
		
	/* List all books */
		
		public void ViewAllBooks() throws Exception {
			
			// 1. Get the connection
	        Connection conn = ConnectionUtil.getConnection();
	 
	        // 2. Query
			String sql = "select isbn13, title, author, content, price, status from book";
			
			// 3. Set the input
			PreparedStatement pst = conn.prepareStatement(sql);

			// 4. Query execute
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				long isbn13 = rs.getLong("isbn13");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String content = rs.getString("content");
				Float price = rs.getFloat("price");
				String status = rs.getString("status");
				System.out.println("Isbn = " + isbn13);
				System.out.println("Title = " + title);
				System.out.println("Author = " + author);
				System.out.println("Content = " + content);
				System.out.println("Price = " + price);
				System.out.println("Status = " + status);
			}
			
			// 5. Close DB resources
	    	ConnectionUtil.close(conn, pst, rs); 
		}
		
		/* Search by title */
		public void searchByTitle(Book book) throws Exception {
			
			// 1. Get the connection
	        Connection conn = ConnectionUtil.getConnection();
			
	        // 2. Query
	        String sql = "select isbn13, title, author, content, price from book where title = ?";
			
	        // 3. Set the input
	        PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, book.getTitle());
			
			// 4. Query execute
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				long isbn13 = rs.getLong("isbn13");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String content = rs.getString("content");
				Float price = rs.getFloat("price");
				System.out.println("Isbn = " + isbn13);
				System.out.println("Title = " + title);
				System.out.println("Author = " + author);
				System.out.println("Content = " + content);
				System.out.println("Price = " + price);
			}
			
			// 5. Close DB resources
	    	ConnectionUtil.close(conn, pst, rs);
		}
		
		/* Search by Author */
		public void searchByAuthor(Book book) throws Exception {
			
			// 1. Get the connection
	        Connection conn = ConnectionUtil.getConnection();
			
	        // 2. Query
	        String sql = "select isbn13, title, author, content, price from book where author=?";
			
	        // 3. Set the input
	        PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, book.getAuthor());
			
			// 4. Query execute
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				long isbn13 = rs.getLong("isbn13");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String content = rs.getString("content");
				Double price = rs.getDouble("price");
				System.out.println("Isbn = " + isbn13);
				System.out.println("Title = " + title);
				System.out.println("Author = " + author);
				System.out.println("Content = " + content);
				System.out.println("Price = " + price);
			}
			
			// 5. Close DB resources
	    	ConnectionUtil.close(conn, pst, rs);
		}
		
		/* Search by price range */
			
		public void searchByPrice(double minPrice, double maxPrice) throws Exception {
			// 1. Get the connection
		    Connection conn = ConnectionUtil.getConnection();
				
		    // 2. Query
			String sql = "select isbn13 , title, author, content, price from book where price between ? and ?";
			
			// 3. Set the input
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setDouble(1, minPrice);
			pst.setDouble(2, maxPrice);
			
			//4. Query execute
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				long isbn13 = rs.getLong("isbn13");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String content = rs.getString("content");
				double price = rs.getDouble("price");
				System.out.println("Isbn = " + isbn13);
				System.out.println("Title = " + title);
				System.out.println("Author = " + author);
				System.out.println("Content = " + content);
				System.out.println("Price = " + price);	
			}
			
			// 5. Close DB resources
	    	ConnectionUtil.close(conn, pst, rs);
		}

		/* Search by Isbn */
		public void searchByIsbn(Book book) throws Exception {
			
			// 1. Get the connection
	        Connection conn = ConnectionUtil.getConnection();
			
	        // 2. Query
	        String sql = "select isbn13, title, author, content, price from book where isbn=?";
			
	        // 3. Set the input
	        PreparedStatement pst = conn.prepareStatement(sql);
			pst.setLong(1, book.getIsbn13());
			
			// 4. Query execute
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				long isbn13 = rs.getLong("isbn13");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String content = rs.getString("content");
				Double price = rs.getDouble("price");
				System.out.println("Isbn = " + isbn13);
				System.out.println("Title = " + title);
				System.out.println("Author = " + author);
				System.out.println("Content = " + content);
				System.out.println("Price = " + price);
			}
			
			// 5. Close DB resources
	    	ConnectionUtil.close(conn, pst, rs);
		}
}
