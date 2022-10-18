package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@RestController
@RequestMapping("book-api")
public class BookResponseController {
	private IBookService bookService;
	@Autowired
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}
	@PostMapping("/books")
ResponseEntity<Void> addBook(@RequestBody Book book) {
		bookService.addBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@PutMapping("/books")
	ResponseEntity<Void> updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	@DeleteMapping("/books/{bookId}")
	ResponseEntity<Void> deleteBook(@PathVariable("bookId")int bookId) {
		bookService.deleteBook(bookId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	@GetMapping("/books/bookId/{bookId}")
	ResponseEntity<Book> getById(@PathVariable("bookId")int bookId) {
		HttpHeaders header=new HttpHeaders();
		header.add("desc", "get book by ID");
		return ResponseEntity.ok().headers(header).body(bookService.getById(bookId));
	}
	@GetMapping("/books")
	ResponseEntity<List<Book>> getAll(){
		HttpHeaders header=new HttpHeaders();
		header.add("desc", "Get All Books");
		List<Book> books=bookService.getAll();
		ResponseEntity<List<Book>> responseEntity=new ResponseEntity<>(books,header,HttpStatus.OK);
		return responseEntity;
	}
	@GetMapping("/books/author/{author}")
	ResponseEntity<List<Book>>  getByAuthor(@PathVariable("author")String author){
		HttpHeaders header=new HttpHeaders();
		header.add("desc", "Get the Author");
		List<Book> books=bookService.getByAuthor(author);
		return ResponseEntity.ok().headers(header).body(books);
	}
	@GetMapping("/books/category/{category}")
	ResponseEntity<List<Book>> getByCategory(@PathVariable("category")String category){
		HttpHeaders header=new HttpHeaders();
		header.add("desc", "Get the Category");
		List<Book> books=bookService.getByCategory(category);
		return ResponseEntity.ok().headers(header).body(books);
	}
	@GetMapping("/books/price/{price}")
	ResponseEntity<List<Book>>  getByPrice(@PathVariable("price")double price){
		HttpHeaders header=new HttpHeaders();
		header.add("desc", "Get the Price");
		List<Book> books=bookService.getByPrice(price);
		return ResponseEntity.ok().headers(header).body(books);
	}

	@GetMapping("/books/author/{author}/cost/{cost}")
	ResponseEntity<List<Book>> getByPriceAuth(@PathVariable("cost")double cost,@PathVariable("author")String author){
		HttpHeaders header=new HttpHeaders();
		header.add("desc", "Get the Author and Price");
		List<Book> books=bookService.getByPriceAuth(cost, author);
		return ResponseEntity.ok().headers(header).body(books);
	}
	@GetMapping("/books/author/{author}/category/{category}")
	ResponseEntity<List<Book>> getByCatAndAuth(@PathVariable("category")String category,@PathVariable("author")String author){
		HttpHeaders header=new HttpHeaders();
		header.add("desc", "Get the Category and Author");
		List<Book> books=bookService.getByCatAndAuth(category, author);
		return ResponseEntity.ok().headers(header).body(books);
	}

}
