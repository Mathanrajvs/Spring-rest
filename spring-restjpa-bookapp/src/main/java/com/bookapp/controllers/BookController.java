package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

//@RestController
@RequestMapping("book-api")
public class BookController {
	private IBookService bookService;
	@Autowired
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}
	@PostMapping("/books")
void addBook(@RequestBody Book book) {
		bookService.addBook(book);
	}
	@PutMapping("/books")
	void updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
	}
	@DeleteMapping("/books/{bookId}")
	void deleteBook(@PathVariable("bookId")int bookId) {
		bookService.deleteBook(bookId);
	}
	@GetMapping("/books/bookId/{bookId}")
	Book getById(@PathVariable("bookId")int bookId) {
		return bookService.getById(bookId);
	}
	@GetMapping("/books")
	List<Book> getAll(){
		return bookService.getAll();
	}
	@GetMapping("/books/author/{author}")
	List<Book> getByAuthor(@PathVariable("author")String author){
		return bookService.getByAuthor(author);
	}
	@GetMapping("/books/category/{category}")
	List<Book> getByCategory(@PathVariable("category")String category){
		return bookService.getByCategory(category);
	}
	@GetMapping("/books/price/{price}")
	List<Book> getByPrice(@PathVariable("price")double price){
		return bookService.getByPrice(price);
	}

	@GetMapping("/books/author/{author}/cost/{cost}")
	List<Book> getByPriceAuth(@PathVariable("cost")double cost,@PathVariable("author")String author){
		return bookService.getByPriceAuth(cost, author);
	}
	@GetMapping("/books/author/{author}/category/{category}")
	List<Book> getByCatAndAuth(@PathVariable("category")String category,@PathVariable("author")String author){
		return bookService.getByCatAndAuth(category, author);
	}

}
