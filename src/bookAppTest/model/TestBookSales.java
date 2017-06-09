package bookAppTest.model;

import java.time.LocalDate;

import bookApp.model.BookSales;

public class TestBookSales {
	
		public static void main(String[] args) {
			BookSales bookSales1 = new BookSales();
			
			bookSales1.setSales_id(1001);
			bookSales1.setUser_id(101);
			bookSales1.setIsbn13(1234567890123l);
			bookSales1.setQuantity(3);
			bookSales1.setPrice(250.00);
			bookSales1.setTotalAmount(bookSales1.getPrice() * bookSales1.getQuantity());
			bookSales1.setOrderDate(LocalDate.parse("2017-06-09"));
			bookSales1.setStatus("Shipped");
			
			System.out.println("Sales ID = " + bookSales1.getSales_id());
			System.out.println("User ID = " + bookSales1.getUser_id());
			System.out.println("ISBN = " + bookSales1.getIsbn13());
			System.out.println("Quantity = " + bookSales1.getQuantity());
			System.out.println("Price = " + bookSales1.getPrice());
			System.out.println("Total Amount = " + bookSales1.getTotalAmount());
			System.out.println("Order Date = " + bookSales1.getOrderDate());
			System.out.println("Status = " + bookSales1.getStatus());
		}

}
