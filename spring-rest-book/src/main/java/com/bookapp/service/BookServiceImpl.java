package com.bookapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.model.Book;
@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private BookDetails bookDetails;
	@Override
	public List<Book> getByAuthor(String author) {
		return bookDetails.getBooks().stream().filter((book)->book.getAuthor().equalsIgnoreCase(author)).collect(Collectors.toList());
	}

	@Override
	public List<Book> getByCatAuth(String category, String author) {
		return  bookDetails.getBooks().stream().filter((book)->book.getAuthor().equalsIgnoreCase(author)&&book.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());
	}
	



	@Override
	public List<Book> getByAll() {
		return  bookDetails.getBooks().stream().collect(Collectors.toList());
	}
	

	@Override
	public Book getById(Integer bookId) {
		return  bookDetails.getBooks().stream().filter((book)->book.getBookId()==bookId).findAny().get();
	
	}

}
