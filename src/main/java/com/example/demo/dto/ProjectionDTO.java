
  package com.example.demo.dto;
  
  import java.util.Date;

import com.example.demo.entity.Film;
import com.example.demo.entity.Projection;
import com.example.demo.entity.Salle;

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
  public class ProjectionDTO {
	  private  Long idProjection ;
		private Date dateProjection; 
		private String tarifProjection ;
		   private SalleDTO salledto; // ID de la salle associée
		      private FilmDTO filmdto;  // ID du film associé
		  	private String timeProjection;

  
		 public static Projection toEntity (ProjectionDTO dto){
			 return Projection.builder()
			   .dateProjection(dto.getDateProjection())
			   .tarifProjection(dto.getTarifProjection())
			   //mapping de 2 objects
			   .salle(SalleDTO.toEntity(dto.getSalledto()))
			   .film(FilmDTO.toEntity(dto.getFilmdto()))

			   .build(); }
			   
			   public static ProjectionDTO fromEntity (Projection projection){ 
			 	  return ProjectionDTO.builder()
			   .idProjection(projection.getIdProjection()) 
			   .dateProjection(projection.getDateProjection()) 
			   .tarifProjection(projection.getTarifProjection()) 
			   .salledto(SalleDTO.fromEntity(projection.getSalle()))
			   .filmdto(FilmDTO.fromEntity(projection.getFilm()))

			   .build(); } 
			  
}
 
 