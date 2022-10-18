package com.bookapp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bookapp.model.Book;
@Component
public class BookDetails {
	
private List<Book> showBooks(){
	return Arrays.asList(
			new Book(1,"Secret","Ram","Action",200),
			new Book(2,"Rocket","Ramya","Love",100),
			new Book(3,"Taj Mahal","Somani","Action",200),
			new Book(4,"Red Fort","Ravir","Fantacy",150),
			new Book(5,"Island","Kapoor","Love",250)
			);
}

public List<Book> getBooks(){
	return showBooks();
}
}
