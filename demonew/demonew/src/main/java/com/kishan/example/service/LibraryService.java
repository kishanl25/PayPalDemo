package com.kishan.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kishan.example.dao.LibraryDAO;
import com.kishan.example.entity.Library;

@Service
public class LibraryService {
	
	@Autowired
	LibraryDAO libraryDao;
	
	public Iterable<Library> getAllLibraries(){
		return this.libraryDao.findAll();
	}
	
	public void saveLibrary(Library libraryObj){
		this.libraryDao.save(libraryObj);		
	}
	
	public boolean deleteLibrary(Library libraryObj){
		this.libraryDao.delete(libraryObj);
		return true;
	}
}
