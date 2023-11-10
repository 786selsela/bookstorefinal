package com.bookStore.service;

import java.util.List;

import com.bookStore.repository.BookRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.Book;

@Service
public class BookService {

	@Autowired
	private BookRepository bRepo;
	private static final Logger logger = LogManager.getLogger(BookService.class);

	public void save(Book b) {
		bRepo.save(b);
	}

	public List<Book> getAllBook(){

		logger.info("Fetching all books from database");
		logger.debug("Debug log message");
		logger.info("Info log message");
		logger.warn("Warning log message");
		logger.error("Error log message");
		return bRepo.findAll();
	}

	public Book getBookById(int id) {
		return bRepo.findById(id).get();
	}
	public void deleteById(int id) {
		bRepo.deleteById(id);
	}
}