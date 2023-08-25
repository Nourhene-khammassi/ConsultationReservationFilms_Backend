package com.example.demo.service;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.FilmDTO;
import com.example.demo.entity.Film;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Path;
import java.util.stream.Stream;
// interface responsable upload image 
public interface ImageStorage {
    String store(MultipartFile file);
    Resource loadResource(String filename);
    void deleteAll();
    void init();
    Stream<Path> loadFiles();
    ResponseEntity<Resource> downloadFilmImage(String imageName, HttpServletRequest request);
    
}
