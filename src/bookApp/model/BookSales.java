package bookApp.model;

import java.time.LocalDate;

public class BookSales {
	
		
		private int sales_id;
		private int user_id;
		private Long isbn13;
		private int quantity;
		private double totalAmount;
		private LocalDate orderDate;
		private String status;
		private double price;
		
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public int getSales_id() {
			return sales_id;
		}
		public void setSales_id(int sales_id) {
			this.sales_id = sales_id;
		}
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
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public double getTotalAmount() {
			return totalAmount;
		}
		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}
		public LocalDate getOrderDate() {
			return orderDate;
		}
		public void setOrderDate(LocalDate orderDate) {
			this.orderDate = orderDate;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
		
	}

