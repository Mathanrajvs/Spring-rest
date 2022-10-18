package com.bookapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookapp.model.Book;
@Repository
public interface IBookRepository extends JpaRepository<Book, Integer > {
  //derived queries
	List<Book> findByAuthor(String author);
	List<Book> readByCategory(String category);
	List<Book> getByPriceLessThanEqual(double price);
	
	
	//custom queries
	@Query("from Book b where b.author=?2 and b.price<=?1")//from Book -->Model,Instance Variables are used
	List<Book> getByPriceAuth(double cost,String author);
	@Query("from Book b where b.author=?2 and b.category=?1")
	List<Book> getByCatAndAuth(String category,String author);
	//@Query("from Book b where b.author=?1")
	
	//Named Query
	@Query(name="findByAuth")
	List<Book> findBooksByAuth(String author);
	


}
