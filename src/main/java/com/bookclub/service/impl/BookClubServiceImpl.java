package com.bookclub.service.impl;

import com.bookclub.domain.Book;
import com.bookclub.domain.Status;
import com.bookclub.repository.BookRepository;
import com.bookclub.service.BookClubService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		retval.add(new Book(0, "Title three", "James", "ISBN", Status.available));
		retval.add(new Book(1, "Title four", "Mark", "ISBN", Status.available));
		return retval;
	}
	
	private List<Book> getListRented(){
		List retval = new ArrayList();
		retval.add(new Book(0, "Title", "Author", "ISBN", Status.rented));
		retval.add(new Book(1, "Title one", "Aydin", "ISBN", Status.rented));
		retval.add(new Book(2, "Title two", "Alex", "ISBN", Status.rented));
		return retval;
	}
	
	@Override
	public boolean addNewBook(int id, String title, String author, String isbn) {
		Book book = createBook(id, title, author, isbn);
		bookRepository.addNewBook(book);
		return true;
	}
	
	
	private Book createBook(int id, String title, String author, String isbn) {
		return new Book(id, title,author,isbn, Status.available);
	}

	@Override
	public boolean updateBook(int id, String title, String author, String isbn) {
		Book book = createBook(id, title, author, isbn);
		
		book.setTitle(title);
		book.setAuthor(author);
		book.setISBN(isbn);
		book.setId(id);
		
		book.setStatus(Status.rented);
		
		bookRepository.updateBook(book);
		
		return true;
	}

	@Override
	public boolean deleteBook(int id){
		bookRepository.deleteBook(id);
		List<Book> books = getListAvailable().stream().filter(it -> it.getId() == id).collect(Collectors.toList());
		return (books.size() == 0);
	}

	
	
}
