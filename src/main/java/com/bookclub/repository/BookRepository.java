package com.bookclub.repository;

import com.bookclub.domain.Book;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface BookRepository {
	
	public void addNewBook(Book book) throws FileNotFoundException, IOException;

}
