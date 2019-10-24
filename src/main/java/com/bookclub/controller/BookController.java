package com.bookclub.controller;

import com.bookclub.domain.Book;
import com.bookclub.service.BookClubService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookClubService bookClubService;

	@RequestMapping(value = "/all")
	public DeferredResult<List<Book>> getClient() {

		DeferredResult<List<Book>> output = new DeferredResult<>();

		output.setResult(bookClubService.findAll());

		return output;
	}

}
