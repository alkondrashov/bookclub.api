package com.bookclub.service.impl;

import com.bookclub.domain.Book;
import com.bookclub.service.BookClubService;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookClubServiceImpl implements BookClubService {


	@Override
	public List<Book> findAll() {
		List retval = new ArrayList();
		retval.add(new Book("Title", "Author", "ISBN", "CHECKED_OUT"));
		retval.add(new Book("Title one", "Aydin", "ISBN", "CHECKED_OUT"));
		retval.add(new Book("Title two", "Alex", "ISBN", "CHECKED_OUT"));
		retval.add(new Book("Title three", "James", "ISBN", "CHECKED_OUT"));
		retval.add(new Book("Title four", "Mark", "ISBN", "CHECKED_OUT"));
		return retval;
	}

}
