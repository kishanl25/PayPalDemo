package com.kishan.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kishan.example.dao.BookDAO;
import com.kishan.example.entity.Book;
import com.kishan.example.entity.Library;

@Service
public class BookService {
	
	@Autowired
	BookDAO bookDao;
	
	public List<Book> getBookByLibrary(Library library){
		return this.bookDao.getBooksByLibrary(library);		
	}
	
	public Iterable<Book> getAllBooks(){
		return this.bookDao.findAll();
	}
	
	public void saveBook(Book bookObj){
		this.bookDao.save(bookObj);		
	}
	
	public boolean deleteBook(Book bookObj){
		this.bookDao.delete(bookObj);
		return true;
	}


}
