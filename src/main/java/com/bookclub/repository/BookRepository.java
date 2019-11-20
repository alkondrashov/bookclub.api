package com.bookclub.repository;

import com.bookclub.domain.Book;

public interface BookRepository {

	public void addNewBook(Book book);
	
	public void updateBook(Book book);

	public void deleteBook(int id);

}
