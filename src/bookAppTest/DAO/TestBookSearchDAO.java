package bookAppTest.DAO;

import java.time.LocalDate;

import bookApp.DAO.BookSearchDAO;
import bookApp.model.Book;

public class TestBookSearchDAO {
	
		public static void main(String[] args) {
			
			Book book1 = new Book();
			book1.setIsbn13(1234567890123l);
			book1.setTitle("Wings Of Fire");
			book1.setAuthor("Dr.A.P.J.Abdul kalam");
			book1.setPublishDate(LocalDate.parse("1995-02-11"));
			book1.setContent("Wings Of Fire is a autobiography of Dr.A.P.J.Abdul kalam");
			book1.setPrice(500);
			book1.setStatus("published");
			
			BookSearchDAO bookSearchDAO = new BookSearchDAO();
			
			/* List all books */
			try {
				bookSearchDAO.ViewAllBooks();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			/* Search by title */
			try {
				bookSearchDAO.searchByTitle(book1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			/* Search by Author */
			try {
				bookSearchDAO.searchByAuthor(book1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			/* Search by price range */
			try {
				bookSearchDAO.searchByPrice(250.00, 500.00);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			/* Search by Isbn */
			try {
				bookSearchDAO.searchByIsbn(book1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
