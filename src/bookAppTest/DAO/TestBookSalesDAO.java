package bookAppTest.DAO;

import java.time.LocalDate;

import bookApp.DAO.BookSalesDAO;

public class TestBookSalesDAO {
	
		public static void main(String[] args) {
			
			LocalDate searchDate = LocalDate.parse("2017-06-09");
			
			BookSalesDAO bookSalesDAO = new BookSalesDAO();
			
			/* Author can able to view- how many books sold */
			/* Weekly */
			try {
				bookSalesDAO.bookSalesWeekly(searchDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			/* Author can able to view- how many books sold */
			/* Monthly */
			try {
				bookSalesDAO.bookSalesMonthly(searchDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			/* Author can able to view- how many books sold */
			/* Yearly */
			try {
				bookSalesDAO.bookSalesYearly(searchDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
}
