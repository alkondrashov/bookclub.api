package com.bookclub.service.impl;

import com.bookclub.domain.Book;
import com.bookclub.domain.Status;
import com.bookclub.repository.BookRepository;
import com.bookclub.service.BookClubService;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookClubServiceImpl implements BookClubService {

	@Autowired
	public BookRepository bookRepository;

	@Override
	public List<Book> findAll() {
		List retval = new ArrayList();
		retval = getListAvailable();
		retval.addAll(getListRented());
		return retval;
	}
	
	@Override
	public List<Book> findByStaus(String status){
		List retval = new ArrayList();
		if(status.equals("available")) {
			retval=getListAvailable();
		}else if(status.equals("rented")) {
			retval=getListRented();
		}	
			
		return retval;
	}

	private List<Book> getListAvailable(){
		List retval = new ArrayList();
		retval.add(new Book("Title three", "James", "ISBN", Status.available, "0"));
		retval.add(new Book("Title four", "Mark", "ISBN", Status.available, "1"));
		return retval;
	}
	
	private List<Book> getListRented(){
		List retval = new ArrayList();
		retval.add(new Book("Title", "Author", "ISBN", Status.rented, "0"));
		retval.add(new Book("Title one", "Aydin", "ISBN", Status.rented, "1"));
		retval.add(new Book("Title two", "Alex", "ISBN", Status.rented, "2"));
		return retval;
	}
	
	@Override
	public boolean addNewBook(String title, String author, String isbn, String id) {
		Book book = createBook(title, author, isbn, id);
		bookRepository.addNewBook(book);
		return true;
	}
	
	
	private Book createBook(String title, String author, String isbn ,String id) {
		return new Book(title,author,isbn, Status.available, id);
	}

	private Book updateBook(String title, String author, String isbn ,String id) {
		return new Book(title,author,isbn, Status.available, id);
	}
	
}
