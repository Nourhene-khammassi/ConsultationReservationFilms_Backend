package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.FilmDTO;
import com.example.demo.dto.PlacesDTO;

public interface IPlaces {
	PlacesDTO addPlace(PlacesDTO placeDTO);
	PlacesDTO findByid(Long id) ;
		void deleteById (Long id);
	    List<PlacesDTO> findAll();
	
}
