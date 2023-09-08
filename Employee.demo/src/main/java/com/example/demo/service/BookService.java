package com.example.demo.service;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.BookDbRepo;
import com.example.demo.entity.Book;

@Service
public class BookService {
	@Autowired
	BookDbRepo bookRepo;
	
	public List<Book> findAll(org.springframework.data.domain.Pageable pageable)
	{
		return bookRepo.findAll(pageable).toList();
	}
	
	public Book findById(long id)
	{
		Optional<Book> b= bookRepo.findById(id);
		return b.orElseThrow(()-> new RuntimeException("Book Not Found id : " + id));
	}
	
	public Book updateBook(long id,Book b) {
		Book b1 = findById(id);
		b1.setAuthor(b.getAuthor());
		b1.setTitle(b.getTitle());
		b1.setPublished(b.isPublished());
		bookRepo.save(b1);
		return b1;
	}
	
	public Book addBook(Book b) {
		return bookRepo.save(b);
	}
	
	public void deleteBook(long id) {
		Book b = findById(id);
		bookRepo.delete(b);
	}
	

}
