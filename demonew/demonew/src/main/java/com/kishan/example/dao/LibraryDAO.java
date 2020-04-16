package com.kishan.example.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kishan.example.entity.Library;

@Repository
public interface LibraryDAO extends CrudRepository<Library, Long>{
	
	/*@Query("select l from Library l")
	public List<Library> getAllLibraries();*/

}
