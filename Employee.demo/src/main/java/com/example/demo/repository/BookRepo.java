package com.example.demo.repository;
import com.example.demo.entity.Book;
import java.util.List;
import java.util.ArrayList;


import org.springframework.stereotype.Repository;

@Repository

public class BookRepo {
	
	private List<Book>books = new ArrayList<>();
	
	public BookRepo() {
		books.add(new Book(1,"java","patric",true));
		books.add(new Book(2,"c++","Dennis",true));
		books.add(new Book(3,"python","patric",false));
	}
	
	public List<Book> findAll(){
		return books;
	}
	
	public Book findById(long id)
	{
	     java.util.Optional<Book> b = books.stream().filter((b1)->b1.getId()==id).findAny();
		
		return b.orElseThrow(()-> new RuntimeException("Book Not Found"));
	}
	
	public Book addBook (Book book)
	{
		books.add(book);
		return book;
	}
	
	public Book updateBook(long id, Book book)
	{
		Book book1= findById(id);
		book1.setAuthor(book.getAuthor());
		book1.setTitle(book.getTitle());
		book1.setPublished(book.isPublished());
		System.out.println(book);
		return book1;
	}
	
	public void deleteBook(long id) {
		Book book1 = findById(id);
		books.remove(book1);
		
	}
	

}
