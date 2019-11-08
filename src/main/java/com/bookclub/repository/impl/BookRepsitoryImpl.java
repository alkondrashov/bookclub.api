package com.bookclub.repository.impl;

import com.bookclub.domain.Book;
import com.bookclub.domain.Status;
import com.bookclub.repository.BookRepository;
import com.bookclub.service.BookClubService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepsitoryImpl implements BookRepository {

	@Override
	public void addNewBook(Book book) {
		try {
			FileOutputStream f = new FileOutputStream(new File("data.txt"));
			ObjectOutputStream outputStream = new ObjectOutputStream(f);

			outputStream.writeObject(book);
			
			outputStream.flush();  
			outputStream.close();  
		}
		catch (FileNotFoundException e) {
			
		}
		catch(IOException e) {

		}
	}
	
}
