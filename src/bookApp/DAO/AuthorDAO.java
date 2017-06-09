package bookApp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

import bookApp.model.Book;
import bookApp.util.ConnectionUtil;

public class AuthorDAO {
	
		
		public void createBook(Book book) throws Exception {
		 // Step 1:Get the connection
	    Connection conn = ConnectionUtil.getConnection();

	    // Step 2: Query
	    String sql = "insert into book ( isbn13, title, author, publishDate, content, price, status) value ( ?, ? ,?, ?, ?, ?, ? )";

	    // 3. Set the input
	    PreparedStatement pst = conn.prepareStatement(sql);
	    pst.setLong(1, book.getIsbn13());
	    pst.setString(2, book.getTitle());
	    pst.setString(3, book.getAuthor());
	    pst.setDate(4, Date.valueOf(book.getPublishDate()));
	    pst.setString(5, book.getContent());
	    pst.setFloat(6, book.getPrice());
	    pst.setString(7, book.getStatus());

	    // 4. Query execute
	    int rows = pst.executeUpdate();
	    System.out.println("No of rows inserted: " + rows);
	    
	    //5.close DB sources
	    ConnectionUtil.close(conn,pst,null);
	   }
		
		/* Author able to upload content */
		public void updateContent(Book book, String newContent) throws Exception {
			
			 // Step 1:Get the connection
	        Connection conn = ConnectionUtil.getConnection();
			
	         // Step 2: Query
			String query = "update book set content = ? where (isbn13 = ?)";
			
			// 3. Set the input
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, newContent);
			pst.setLong(2, book.getIsbn13());
			
			// 4. Query execute
			int rows = pst.executeUpdate();
			if (rows == 1) {
				System.out.println("No of rows inserted: " + rows);
				System.out.println("Content Uploaded Sucessful");
			} else if (rows == 0) {
				System.out.println("No of rows inserted: " + rows);
				System.out.println("Please upload the content again");
			} else {
				System.out.println("No of rows inserted: " + rows);
				System.out.println("Error in Uploading");
			}
			
			// 5. Close DB resources
			ConnectionUtil.close(conn, pst, null);
		}
		
		/* Author can view the book and contents */
		public void viewBook_Content(Book book) throws Exception {
			 // Step 1:Get the connection
	        Connection conn = ConnectionUtil.getConnection();
	        
	        // Step 2: Query
			String query = "select title,content from book where author = ? ";
			
			// 3. Set the input
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, book.getAuthor());
			
			 //Step 05: Get the result set
	        ResultSet rs = pst.executeQuery(query);
	         
	        //Step 06: Iterate the result
	        while ( rs.next()) {
	            String title = rs.getString("title");
	            String content = rs.getString("content");
	             
	            System.out.println("Title:" + title +", Content:" + content);
	        }
			
	        // 5. Close DB resources
	        ConnectionUtil.close(conn,pst,rs);
			
		}
		
		public void deleteBook(Book book) throws Exception {
			 
	        // Step 1:Get the connection
	        Connection conn = ConnectionUtil.getConnection();
	 
	        // Step 2: Query
	        String sql = "delete from book  where isbn13 = ?";
	 
	        // 3. Set the input
	        PreparedStatement pst = conn.prepareStatement(sql);
	        pst.setLong(1, book.getIsbn13());
	 
	        // 4. Query execute
	        int rows = pst.executeUpdate();
	        System.out.println("No of rows deleted: " + rows);
	 
	        // 5. Close DB resources
	        ConnectionUtil.close(conn,pst,null);
	    }
		
		public void viewBooks(Book book) throws Exception {
			 
			// Step 1:Get the connection
	        Connection conn = ConnectionUtil.getConnection();
	        
	        // Step 2: Query
			String query = "select title from book where author = ? ";
			
			// 3. Set the input
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, book.getAuthor());
			
			 //Step 05: Get the result set
	        ResultSet rs = pst.executeQuery(query);
	         
	        //Step 06: Iterate the result
	        while ( rs.next()) {
	            long isbn13 = rs.getLong("isbn13");
	            String title = rs.getString("title");
	            String author = rs.getString("author");
	            Date publishDate = rs.getDate("publishDate");
	            String content = rs.getString("content");
	            float price = rs.getFloat("price");
	            String status = rs.getString("status");
	             
	            System.out.println("Isbn:" +isbn13 +", Title:" + title +", Author:" +author +", PublishDate:" +publishDate +", Content:" +content +", Price:" +price +", Status:" +status);
	        }
			
	        // 5. Close DB resources
	        ConnectionUtil.close(conn,pst,rs);
		
		}
	}
