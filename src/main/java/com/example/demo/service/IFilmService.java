package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.FilmDTO;

public interface IFilmService {

	FilmDTO addFilm(FilmDTO filmDTO);
 FilmDTO findByid(Long id) ;
	void deleteById (Long id);
    List<FilmDTO> findAll();
    FilmDTO updateFilm(Long id, FilmDTO filmDTO);
    FilmDTO updateFilm(Long id);
    FilmDTO uploadImageFilm(Long filmId, MultipartFile image);
    ResponseEntity<FilmDTO> findByIdResponse(Long id);
}
