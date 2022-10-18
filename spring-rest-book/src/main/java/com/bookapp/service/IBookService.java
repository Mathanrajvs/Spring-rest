package com.bookapp.service;

import java.util.List;

import com.bookapp.model.Book;

public interface IBookService {
List<Book> getByAuthor(String author);
List<Book> getByCatAuth(String category,String author);
Book getById(Integer bookId);
List<Book> getByAll();
} 
