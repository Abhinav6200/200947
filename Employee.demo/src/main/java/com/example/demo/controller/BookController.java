package com.example.demo.controller;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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

@RestController
@RequestMapping("/api/v1/books")

public class BookController {
	@Autowired
	BookService service;
	
	//http://localhost:8080/api/v1/books
	@GetMapping
	public ResponseEntity<List<Book>>getAllBooks(Pageable g){
		return new ResponseEntity<List<Book>> (service.findAll(g),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Book>addBook(@RequestBody Book books)
	{
		return new ResponseEntity<Book>(service.addBook(books),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> findById(@PathVariable long id){
		return new ResponseEntity<Book>(service.findById(id),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Book> updateBooks(@PathVariable("id") long booksId,@RequestBody Book books)
	{
		System.out.println(books);
		return new ResponseEntity<Book>(service.updateBook(booksId, books),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delById(@PathVariable("id") long Id)
	{
		service.deleteBook(Id);
		return "deleted sucessfully";
	}

}
