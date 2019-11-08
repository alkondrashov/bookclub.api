package com.bookclub.controller;

import com.bookclub.domain.Book;
import com.bookclub.dto.RequestBook;
import com.bookclub.service.BookClubService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
	
	@RequestMapping(value = "/addbook/", method = RequestMethod.POST)
	public DeferredResult<Boolean> requestNewBookAdd(@RequestBody RequestBook book) {
		String title = book.getTitle();
		String isbn = book.getISBN();
		String author = book.getAuthor();
		String id = book.getId();
		
		DeferredResult<Boolean> output = new DeferredResult<>();
		
		output.setResult(bookClubService.addNewBook(title, author, isbn, id));
		
		return output;
	}
}
