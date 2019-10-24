package com.bookclub.domain;

public class Book {

	private String title;
	private String author;
	private String ISBN;
	private Status status;

	public Book(String title, String author, String ISBN, Status status) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.status = status;
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

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}