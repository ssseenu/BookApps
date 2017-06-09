package bookAppTest.model;

import bookApp.model.BookRatings;

public class TestBookRatings {
	
		public static void main(String[] args) {
			
			BookRatings bookratings1 = new BookRatings();
			bookratings1.setIsbn13(1234567890123l);
			bookratings1.setUser_id(101);
			bookratings1.setRating(4.7);
			
			System.out.println("ISBN = " + bookratings1.getIsbn13());
			System.out.println("User ID = " + bookratings1.getUser_id());
			System.out.println("Ratings = " + bookratings1.getRating());
		}

}
