package com.bookclub.service.impl;

import com.bookclub.domain.Book;
import com.bookclub.domain.Status;
import com.bookclub.service.BookClubService;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookClubServiceImpl implements BookClubService {


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
		retval.add(new Book("Title three", "James", "ISBN", Status.available));
		retval.add(new Book("Title four", "Mark", "ISBN", Status.available));
		return retval;
	}
	
	private List<Book> getListRented(){
		List retval = new ArrayList();
		retval.add(new Book("Title", "Author", "ISBN", Status.rented));
		retval.add(new Book("Title one", "Aydin", "ISBN", Status.rented));
		retval.add(new Book("Title two", "Alex", "ISBN", Status.rented));
		return retval;
	}
	
	@Override
	public boolean addNewBook(String title, String author, String isbn) {
		Book book = createBook(title, author, isbn);
		List retval = new ArrayList();
		return retval.add(book);
	}
	
	
	private Book createBook(String title, String author, String isbn) {
		return new Book(title,author,isbn, Status.available);
	}
	
}
