package com.example.demo.configimage;
// les étapes : 
//class 1 : FileStorageProperties apres exception : FileStorageException, interface responsable upload image dans service 
// implementation de cette image dans le service , controler , creation folder uploads qui contient un autre folder Film Images (stockage des images 
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "file")
//@NoArgsConstructor
//@AllArgsConstructor
@Component
public class FileStorageProperties {
	// attribut pour prendre la valeur upload image 
    private String uploadImgFilmDir;

	public String getUploadImgFilmDir() {
		return uploadImgFilmDir;
	}

	public void setUploadImgFilmDir(String uploadImgFilmDir) {
		this.uploadImgFilmDir = uploadImgFilmDir;
	}

    

}
