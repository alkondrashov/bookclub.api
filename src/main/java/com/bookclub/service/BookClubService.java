package com.bookclub.service;

import com.bookclub.domain.Book;
import java.util.List;

public interface BookClubService {

	public List<Book> findAll();
	public List<Book> findByStaus(String status);

}
