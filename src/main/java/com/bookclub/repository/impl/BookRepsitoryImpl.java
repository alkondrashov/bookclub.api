package com.bookclub.repository.impl;

import com.bookclub.domain.Book;
import com.bookclub.domain.Status;
import com.bookclub.repository.BookRepository;
import com.bookclub.service.BookClubService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class BookRepsitoryImpl implements BookRepository {

	@Override
	public void addNewBook(Book book) throws FileNotFoundException, IOException {
		try {
			FileOutputStream f = new FileOutputStream(new File("data.txt"));
			ObjectOutputStream outputStream = new ObjectOutputStream(f);

			outputStream.writeObject(book);
			
			outputStream.flush();  
			outputStream.close();  
		}
		catch (FileNotFoundException ex) {
			
		}
	}
	
}
