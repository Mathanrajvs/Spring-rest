package com.bookapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//Native Queries
//@NamedQueries({
//	@NamedQuery(name="findByTitleAuth",query="from Book b where b.title=?1 and b.author=?2"),
//	@NamedQuery(name="findByAuth"),query="from Book b where b.author=?1")
//})
@NamedQuery(name="findByAuth",query= "from Book b where b.author=?1")

//Named Native Queries
@NamedNativeQueries({
@NamedNativeQuery(name="findByTitleAuthor",query="select * from book  where title=?1 and author=?2", resultClass=Book.class)
//@NamedNativeQuery(name="findByAuth",query= "from Book b where b.author=?1")
})
@Entity
public class Book {
@Id
private Integer bookId;
private String title;
private String category;
private String author;
@Column(name="cost")
private double price;
public Book() {
	super();
	// TODO Auto-generated constructor stub
}
public Book(Integer bookId, String title, String category, String author, double price) {
	super();
	this.bookId = bookId;
	this.title = title;
	this.category = category;
	this.author = author;
	this.price = price;
}
public Integer getBookId() {
	return bookId;
}
public void setBookId(Integer bookId) {
	this.bookId = bookId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
@Override
public String toString() {
	return "Book [bookId=" + bookId + ", title=" + title + ", category=" + category + ", author=" + author + ", price="
			+ price + "]";
}

}
