package com.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.model.Book;
import com.bookapp.repository.IBookRepository;

@Service
public class BookServiceImpl implements IBookService {

	IBookRepository bookRepository;

	@Autowired
	public void setBookRepository(IBookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public void addBook(Book book) {
		//if  the current id is not there is it will create a new row
		bookRepository.save(book);
	}

	@Override
	public void updateBook(Book book) {
		//if  the current id is there it will update
		//if  the current id is not there is it will create a new row
		bookRepository.save(book);
	}

	@Override
	public void deleteBook(int bookId) {
	 bookRepository.deleteById(bookId);
	}

	@Override
	public Book getById(int bookId) {
		return bookRepository.findById(bookId).get();
	}

	@Override
	public List<Book> getAll() {
		return bookRepository.findAll();
	}

	@Override
	public List<Book> getByAuthor(String author) {
		return bookRepository.findByAuthor(author);
	}

	@Override
	public List<Book> getByCategory(String category) {
		// TODO Auto-generated method stub
		return bookRepository.readByCategory(category);
	}

	@Override
	public List<Book> getByPrice(double price) {
		// TODO Auto-generated method stub
		return bookRepository.getByPriceLessThanEqual(price);
	}

	@Override
	public List<Book> getByPriceAuth(double cost, String author) {
		return bookRepository.getByPriceAuth(cost, author);
	}

	@Override
	public List<Book> getByCatAndAuth(String category, String author) {
		return bookRepository.getByCatAndAuth(category, author);
	}

	@Override
	public List<Book> getBooksByAuth(String auth) {
		return bookRepository.findBooksByAuth(auth);
	}


}
