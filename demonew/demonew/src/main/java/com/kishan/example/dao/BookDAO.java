package com.kishan.example.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kishan.example.entity.Book;
import com.kishan.example.entity.Library;

@Repository
public interface BookDAO extends CrudRepository<Book, Long>{
	
	public List<Book> getBooksByLibrary(Library library);
	
	/*@Query("select * from Book b")
	public List<Book> getAllBooks();
*/
}
