package bookAppTest.model;

import java.time.LocalDate;

import bookApp.model.Book;

public class TestBook {
	
		public static void main(String[] args) {
			Book book1 = new Book();
			book1.setIsbn13(1234567890123l);
			book1.setTitle("Wings Of Fire");
			book1.setAuthor("Dr.A.P.J.Abdul kalam");
			book1.setPublishDate(LocalDate.parse("1995-02-11"));
			book1.setContent("Wings Of Fire is a autobiography of Dr.A.P.J.Abdul kalam");
			book1.setPrice(500);
			book1.setStatus("published");
			
			System.out.println("ISBN = " + book1.getIsbn13());
			System.out.println("Title = " + book1.getTitle());
			System.out.println("Author = " + book1.getAuthor());
			System.out.println("Date = " + book1.getPublishDate());
			System.out.println("Content = " + book1.getContent());
			System.out.println("Price = " + book1.getPrice());
			System.out.println("Status = " + book1.getStatus());
		}

}
