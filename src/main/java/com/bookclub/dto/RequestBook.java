package com.bookclub.dto;

public class RequestBook {
	
	String author;
	String isbn;
	String title;
	String id;
	
	RequestBook(String author, String isbn, String title, String id) {
		this.author = author;
		this.isbn = isbn;
		this.title = title;
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getISBN() {
		return isbn;
	}

	public String getId() {
		return id;
	}
}