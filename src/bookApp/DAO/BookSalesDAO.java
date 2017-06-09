package bookApp.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import bookApp.util.ConnectionUtil;

public class BookSalesDAO {
		
		/* Author can able to view- how many books sold */
		/* Weekly */
		
		public void bookSalesWeekly(LocalDate searchDate) throws Exception {
			// 1. Get the connection
	        Connection conn = ConnectionUtil.getConnection();
	 
	        // 2. Query
			String sql = "select isbn13, orderDate from bookSales where (orderDate <= ? AND orderDate >= DATEADD (day , 7 , ?))";
			
			// 3. Set the input
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setDate(1, Date.valueOf(searchDate));
			pst.setDate(2, Date.valueOf(searchDate));
			
			// 4. Query execute
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Long isbn13 = rs.getLong("isbn13");
				String orderDate = rs.getString("orderDate");
				System.out.println("ISBN = " + isbn13);
				System.out.println("Order Date = " + orderDate);
				System.out.println();
			}
			
			// 5. Close DB resources
			ConnectionUtil.close(conn, pst, rs);
		}
		
		/* Monthly */
		public void bookSalesMonthly(LocalDate searchDate) throws Exception {
			// 1. Get the connection
	        Connection conn = ConnectionUtil.getConnection();
	 
	        // 2. Query
			String sql = "select isbn13, orderDate from bookSales where (MONTH(?))";
			
			// 3. Set the input
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setDate(1, Date.valueOf(searchDate));
			
			// 4. Query execute
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Long isbn13 = rs.getLong("isbn13");
				String orderDate = rs.getString("orderDate");
				System.out.println("ISBN = " + isbn13);
				System.out.println("Order Date = " + orderDate);
				System.out.println();
			}
			
			// 5. Close DB resources
			ConnectionUtil.close(conn, pst, rs);
		}
		
		/* Yearly */
		public void bookSalesYearly(LocalDate searchDate) throws Exception {
			// 1. Get the connection
	        Connection conn = ConnectionUtil.getConnection();
	 
	        // 2. Query
			String sql = "select isbn13, orderDate from bookSales where (YEAR(?))";
			
			// 3. Set the input
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setDate(1, Date.valueOf(searchDate));
			
			// 4. Query execute
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Long isbn13 = rs.getLong("isbn13");
				String orderDate = rs.getString("orderDate");
				System.out.println("ISBN = " + isbn13);
				System.out.println("Order Date = " + orderDate);
				System.out.println();
			}
			
			// 5. Close DB resources
			ConnectionUtil.close(conn, pst, rs);
		}

}
