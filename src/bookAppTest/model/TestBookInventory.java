package bookAppTest.model;

import bookApp.model.BookInventory;

public class TestBookInventory {
	
		public static void main(String[] args) {
			
			BookInventory bookInventory1 = new BookInventory();
			bookInventory1.setIsbn13(1234567890123l);
			bookInventory1.setQuantity(10);
			
			System.out.println("ISBN = " + bookInventory1.getIsbn13());
			System.out.println("Quantity = " + bookInventory1.getQuantity());
		}

}
