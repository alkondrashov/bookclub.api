package com.bookclub.dto;

import com.bookclub.domain.Status;

public class RequestBook {
	
	String author;
	String isbn;
	String title;
	int id;
	Status status;
	
	RequestBook(String author, String isbn, String title, int id) {
		this.author = author;
		this.isbn = isbn;
		this.title = title;
		this.id = id;
		this.status = Status.available;
		
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

	public int getId() {
		return id;
	}

	public Status getStatus() {
		return status;
	}
}