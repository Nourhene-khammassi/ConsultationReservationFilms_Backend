package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PlacesDTO;
import com.example.demo.service.IPlaces;
import com.example.demo.service.PlasesServiceImple;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/GestionPlacesByAdmin/auth")
public class PlacesController {
	@Autowired
	private IPlaces iPlaces;
@PostMapping("/addPlaces")
	public PlacesDTO addPlace( @RequestBody PlacesDTO placeDTO) {
		return iPlaces.addPlace(placeDTO);
	}
@GetMapping("/findByid/{id}")
	public PlacesDTO findByid(@RequestBody Long id) {
		return iPlaces.findByid(id);
	}
@DeleteMapping("/deleteById/{id}")
	public void deleteById(Long id) {
		iPlaces.deleteById(id);
	}
@GetMapping("/findAll")

	public List<PlacesDTO> findAll() {
		return iPlaces.findAll();
	}
	
	

}
