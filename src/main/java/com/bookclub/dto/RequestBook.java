package com.bookclub.dto;

public class RequestBook {
	
	String author;
	String isbn;
	String title;
	
	RequestBook(String author, String isbn, String title) {
		this.author = author;
		this.isbn = isbn;
		this.title = title;
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


}