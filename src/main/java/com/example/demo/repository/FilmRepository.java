package com.example.demo.repository;

import java.util.List;

import org.springdoc.core.providers.JavadocProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Film;
@Repository
public interface FilmRepository  extends JpaRepository<Film, Long>{

	 @Query("SELECT MAX(f.id) FROM Film f")
	    Long findMaxId();
	 
	 @Query(value = "SELECT * FROM film WHERE date_film > CURDATE()", nativeQuery = true)
	 List<Film> findFilmsAfterToday();


	
}
