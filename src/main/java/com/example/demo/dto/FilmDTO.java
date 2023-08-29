
  package com.example.demo.dto;
  import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;

import com.example.demo.entity.Film;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
  import lombok.Builder; 
  import lombok.Getter;
  import lombok.NoArgsConstructor; 
  import lombok.Setter;
  
  @Getter
  @Setter
  @AllArgsConstructor
  
  @NoArgsConstructor
  
  @Builder 
  public class FilmDTO {
  
 
  
  private Long idFilm ;
  private String nomFilm;
  private String dureeFilm;
  private String createur;
  private String description;
  private boolean actif; 
	private String category;
	private String image ; 
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateFilm;

	//@ElementCollection // donne collection : tab associaciation pour stocker plusieurs images
	//private List<String> images ; 


  public static Film toEntity (FilmDTO dto){
	  return Film.builder()
			  .idFilm(dto.getIdFilm())
			  .nomFilm(dto.getNomFilm())
			  .dureeFilm(dto.getDureeFilm())
			  .createur(dto.getCreateur())
			  .description(dto.getDescription()) 
			  .category(dto.getCategory())
			  .image(dto.getImage())
			  .actif(dto.isActif())
			  .dateFilm(dto.getDateFilm())
			  //.images(dto.getImages())
			  .build(); }
  
  public static FilmDTO fromEntity (Film film){ 
	  return FilmDTO.builder()
			  .idFilm(film.getIdFilm())
			  .nomFilm(film.getNomFilm()) 
			  .dureeFilm(film.getDureeFilm())
			  .createur(film.getCreateur()) 
			  .description(film.getDescription())
			  .category(film.getCategory())
			  .image(film.getImage())
			  .actif(film.isActif())
			  .dateFilm(film.getDateFilm())

			  //.images(film.getImages())


			  .build(); } }
  
 