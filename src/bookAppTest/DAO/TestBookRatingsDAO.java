package bookAppTest.DAO;

import bookApp.DAO.BookRatingsDAO;
import bookApp.model.BookRatings;

public class TestBookRatingsDAO {
	
		public static void main(String[] args) {
			
			BookRatings bookratings = new BookRatings();
			bookratings.setIsbn13(1234567890123l);
			bookratings.setUser_id(101);
			bookratings.setRating(4.5);
			
			BookRatingsDAO bookRatingsDAO = new BookRatingsDAO();
			
			/* Users can provide ratings for the book */
			try {
				bookRatingsDAO.addRating(bookratings);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
}
