package com.example.demo.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long idFilm ;
	private String nomFilm; 
	private String dureeFilm; 
	private String createur;
	private String description; 
	private boolean actif; 
	private String category;
	private String image ; 
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateFilm;
	//@ElementCollection // donne collection : tab associa
	//private List<String> images ; 

	@OneToMany(mappedBy = "film")
    private List<Projection> projections;
	

	
}
