package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@RestController
public class BookController {
	@Autowired
private IBookService bookService;

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}
//	https://localhost:8080/books/author/Ram
	@GetMapping("/books/author/{author}")
	List<Book> getByAuthor(@PathVariable("author")String author){
		return bookService.getByAuthor(author);
	}
//	https://localhost:8080/books/author/Ram/category/Love
	@GetMapping("/books/author/{author}/category/{category}")
	List<Book> getByCatAuth(@PathVariable("category")String category,@PathVariable("author")String author){
		return bookService.getByCatAuth(category, author);
	}
//	https://localhost:8080/books/bookId?bookId=1
	@RequestMapping(value="/books/bookId",method=RequestMethod.GET)
	Book getById(@RequestParam("bookId") Integer bookId) {
		return bookService.getById(bookId);
	}
//	https://localhost:8080/books/
	@GetMapping("/books")
	List<Book> getByAll(){
		return bookService.getByAll();
	}
}
