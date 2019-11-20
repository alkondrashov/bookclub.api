package com.bookclub.controller;

import com.bookclub.domain.Book;
import com.bookclub.domain.Status;
import com.bookclub.dto.RequestBook;
import com.bookclub.service.BookClubService;

import java.nio.charset.Charset;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookClubService bookClubService;

	@RequestMapping(value = "/all/")
	public DeferredResult<List<Book>> getAll() {

		DeferredResult<List<Book>> output = new DeferredResult<>();

		output.setResult(bookClubService.findAll());

		return output;
	}

	@RequestMapping(value = "/available/")
	public DeferredResult<List<Book>> getAvailable() {

		DeferredResult<List<Book>> output = new DeferredResult<>();

		output.setResult(bookClubService.findByStaus("available"));

		return output;
	}

	@RequestMapping(value = "/rented/")
	public DeferredResult<List<Book>> getRented() {

		DeferredResult<List<Book>> output = new DeferredResult<>();

		output.setResult(bookClubService.findByStaus("rented"));

		return output;
	}

	public void checkValidInformation(RequestBook book) throws Exception {
		if (book.getTitle() == null || book.getTitle().isEmpty()) {
			throw new Exception("Title is empty");
		}

		if (book.getAuthor() == null || book.getAuthor().isEmpty()) {
			throw new Exception("Author is empty");
		}

		if (book.getISBN() == null || book.getISBN().isEmpty()) {
			throw new Exception("ISBN is empty");
		}
	}
	
	@RequestMapping(value = "/addbook/", method = RequestMethod.POST)
	public ResponseEntity<String> requestNewBookAdd(@RequestBody RequestBook book) throws Exception{
		String title = book.getTitle();
		String isbn = book.getISBN();
		String author = book.getAuthor();
		int id = book.getId();
		Status status = book.getStatus();
		
		checkValidInformation(book);

		System.out.println("The following book has been added:");
		printBookAttributes(id, title, author, isbn, status);

		
		DeferredResult<Boolean> output = new DeferredResult<>();
		
		output.setResult(bookClubService.addNewBook(id, title, author, isbn));
		
		return new ResponseEntity<String>("New book added!",HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{bookId}/", method = RequestMethod.PATCH)
	public ResponseEntity<String> updateBook(@PathVariable("bookId") int bookId, @RequestBody RequestBook book) throws Exception {
		String title = book.getTitle();
		String isbn = book.getISBN();
		String author = book.getAuthor();
		int id = bookId;
		Status status = book.getStatus();

		checkValidInformation(book);

		System.out.println("The following book has been updated:");
		printBookAttributes(id, title, author, isbn, status);
		

		DeferredResult<Boolean> output = new DeferredResult<>();
		
		output.setResult(bookClubService.updateBook(id, title, author, isbn));
		
		return new ResponseEntity<String>("The book has been updated!",HttpStatus.OK);
	}

	private void printBookAttributes(int id, String title, String author, String isbn, Status status){
		System.out.println("Id " + id);
		System.out.println("Title: " + title);
		System.out.println("Isbn: " + isbn);
		System.out.println("Author: " + author);
		System.out.println("Status: " + status);
	}

	@RequestMapping(value="/delete/", method=RequestMethod.DELETE)
	public DeferredResult<Boolean> deleteBook(@RequestBody RequestBook book){
		DeferredResult<Boolean> output = new DeferredResult<>();
		output.setResult(bookClubService.deleteBook(book.getId()));
		return output;
	}
	
	
//	@RequestMapping(value = "/rentbook/", method = RequestMethod.POST)
//	public DeferredResult<Boolean> RequestUpdateBook(@RequestBody RequestBook book) {
//	
//		
//		DeferredResult<Boolean> output = new DeferredResult<>();
//		
//		output.setResult(bookClubService.updateBook(title, author, isbn, id));
//		
//		return output;
//	}
	
	
	
	
	
	
}
