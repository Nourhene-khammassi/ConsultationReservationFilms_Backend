package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.FilmDTO;
import com.example.demo.entity.Film;
import com.example.demo.service.FilmServiceImplemeptation;
import com.example.demo.service.IFilmService;
import com.example.demo.service.ImageStorage;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/GestionFilmsByAdmin/auth")
@RequiredArgsConstructor
public class FilmController {
	@Autowired
	private IFilmService servicefilm;
	@Autowired
	private ImageStorage imagestorage ;
	
	
	    
	@PostMapping("/addFilm")
    public FilmDTO addFilm(@RequestBody FilmDTO filmDTO) {

        return servicefilm.addFilm(filmDTO);
    }
	@GetMapping("/findById/{id}")
	    public FilmDTO findById(@PathVariable Long id) {
	        return servicefilm.findByid(id);
	    }
	@DeleteMapping("/deleteById/{id}")
	    public void deleteById(@PathVariable Long id) {
		servicefilm.deleteById(id);
	    }
	@GetMapping("findAll")
	    public List<FilmDTO> findAll() {
	        return servicefilm.findAll();
	    }
	
	   @PutMapping("updateFilm/{id}")
	    public FilmDTO updateFilm(@PathVariable Long id, @RequestBody FilmDTO filmDTO) {
	        return servicefilm.updateFilm(id, filmDTO);
	    }
	   
	   @PostMapping("/uploadImage/{id}")
	   public FilmDTO uploadImageFilms(@PathVariable Long id, MultipartFile image) {
	   	return servicefilm.uploadImageFilm(id, image);
	   }
	   
	   @GetMapping("/downloadFilmImage/{imageName}")
		public ResponseEntity<Resource> downloadFilmImage(@PathVariable String imageName, HttpServletRequest request) {
			return this.imagestorage.downloadFilmImage(imageName, request);
		}
	   
	   @GetMapping("/maxFilmId")
	    public FilmDTO getMaxFilmId() {
	        return servicefilm.getMaxFilmId();
	    }
	   
		
		  @GetMapping("/aftertoday") 
		  public List<FilmDTO> getFilmsAfterToday()
		  { return servicefilm.findFilmsAfterToday(); }
		 
}


