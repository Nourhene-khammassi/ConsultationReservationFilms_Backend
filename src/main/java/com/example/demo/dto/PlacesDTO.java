package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.entity.Places;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

	
	@Getter
	@Setter
	
	@Builder
	public class PlacesDTO {
		
		
		
		private Long idPlace;
		private String matricule ;

		  public static Places toEntity (PlacesDTO dto){
			  return Places.builder()
					  .idPlace(dto.getIdPlace())
					  .matricule(dto.getMatricule())
					  .build(); }
		  
		  public static PlacesDTO fromEntity (Places place){ 
			  return PlacesDTO.builder()
					  .idPlace(place.getIdPlace())
					  .matricule(place.getMatricule()) 
					  .build(); } 
		  
		 
	}
