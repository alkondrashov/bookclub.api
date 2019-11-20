package com.bookclub.service;

import com.bookclub.domain.Book;
import java.util.List;

public interface BookClubService {

	public List<Book> findAll();
	public List<Book> findByStaus(String status);
	public boolean addNewBook(int id, String title, String author, String isbn);
	public boolean updateBook(int id, String title, String author, String isbn);
	public boolean deleteBook(int id);
}
