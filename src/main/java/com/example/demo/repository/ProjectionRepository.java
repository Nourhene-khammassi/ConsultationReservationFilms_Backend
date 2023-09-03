package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Projection;
@Repository
public interface ProjectionRepository extends JpaRepository<Projection, Long> {
	
	//projection des image by id film sup  
	@Query("SELECT p FROM Projection p WHERE p.film.idFilm = :idFilm")
	  List<Projection> findByFilmId(@Param("idFilm") Long idFilm);
	  
	
	
	
	 }
