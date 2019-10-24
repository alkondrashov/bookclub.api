package com.bookclub.service;

import com.bookclub.domain.Book;
import java.util.List;
import java.util.Optional;

public interface BookClubService {

	public List<Book> findAll();
	public List<Book> findAvailable(String status);

}
