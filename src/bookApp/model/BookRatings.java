package bookApp.model;

public class BookRatings {

		
		private int user_id;
		private Long isbn13;
		private double rating;
		

		public int getUser_id() {
			return user_id;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}
		public Long getIsbn13() {
			return isbn13;
		}
		public void setIsbn13(Long isbn13) {
			this.isbn13 = isbn13;
		}
		public double getRating() {
			return rating;
		}
		public void setRating(double rating) {
			this.rating = rating;
		}
	}

