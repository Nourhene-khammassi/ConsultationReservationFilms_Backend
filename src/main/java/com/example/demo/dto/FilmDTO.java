
  package com.example.demo.dto;
  import java.util.List;

import javax.persistence.ElementCollection;

import com.example.demo.entity.Film;
  
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
			  //.images(film.getImages())


			  .build(); } }
  
 