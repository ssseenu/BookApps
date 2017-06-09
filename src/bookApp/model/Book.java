package bookApp.model;

import java.time.LocalDate;

public class Book {
	
			private long isbn13;
			private String title;
			private String author;
			private LocalDate publishDate;
			private String content;
			private float price;
			private String status;
			
			public long getIsbn13() {
				return isbn13;
			}
			public void setIsbn13(long isbn13) {
				this.isbn13 = isbn13;
			}
			public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
			}
			public String getAuthor() {
				return author;
			}
			public void setAuthor(String author) {
				this.author = author;
			}
			public LocalDate getPublishDate() {
				return publishDate;
			}
			public void setPublishDate(LocalDate publishDate) {
				this.publishDate = publishDate;
			}
			public String getContent() {
				return content;
			}
			public void setContent(String content) {
				this.content = content;
			}
			public float getPrice() {
				return price;
			}
			public void setPrice(float price) {
				this.price = price;
			}
			public String getStatus() {
				return status;
			}
			public void setStatus(String status) {
				this.status = status;
			}
	}



