package com.example.demo.Utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
//autre meth pour ajouter des images 
@Service
public class StoargeImage {
	private final Path rootLocation = Paths.get("uploads/filmimages");


    public String store(MultipartFile file) {
        try {
        	// 
            String fileName = Integer.toString(new Random().nextInt(1000000000));
            String ext = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf('.'), file.getOriginalFilename().length());
            String name  = file.getOriginalFilename().substring(0, file.getOriginalFilename().indexOf('.'));
            String original = name + fileName + ext;
            Files.copy(file.getInputStream(), this.rootLocation.resolve(original));
            return original;


        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
    }


}
