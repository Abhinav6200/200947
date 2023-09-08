package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name ="book_db")
public class Book {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	long id;
	@Column(nullable = false,unique = true)
	@NotEmpty(message ="Title Can not be Empty")
	@Size(min = 3, message = "Title Must be More Than 3 Chars")
	String title;
	String author;
	boolean published;

}
