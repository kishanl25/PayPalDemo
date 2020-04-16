package com.kishan.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kishan.example.entity.Book;
import com.kishan.example.entity.Library;
import com.kishan.example.service.BookService;
import com.kishan.example.service.LibraryService;

@RestController
@RequestMapping(path="/library")
public class LibraryController {
	
	@Autowired
	LibraryService libraryService;
	
	@Autowired
	BookService bookService;
	
	@GetMapping(path = "/libraries", produces = "application/json")
    @ResponseBody
	public Iterable<Library> getLibraries(){
		Iterable<Library> libraryList = libraryService.getAllLibraries();
		for (Library lib : libraryList) {
			System.out.println(lib.getLibraryName());
		}
		return libraryList;
	}
	
	@GetMapping(path = "/books", produces = "application/json")
    @ResponseBody
	public Iterable<Book> getAllBooks(){
		Iterable<Book> bookList = bookService.getAllBooks();
		for (Book book : bookList) {
			System.out.println(book.getBookName());
		}
		return bookList;
	}	
	 
	 @PostMapping(path= "/addLibrary", consumes = "application/json", produces = "application/json")
	    public void addLibrary(@RequestBody Library library) 
	    {
	        libraryService.saveLibrary(library);
	         
	        	         
	    }

}
