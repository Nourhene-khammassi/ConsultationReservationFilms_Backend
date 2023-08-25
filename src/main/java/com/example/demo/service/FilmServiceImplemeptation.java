package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.Exception.EntityNotFoundException;
import com.example.demo.Exception.ErrorCodes;
import com.example.demo.Exception.InvalidOperationException;
import com.example.demo.dto.FilmDTO;
import com.example.demo.dto.SalleDTO;
import com.example.demo.entity.Film;
import com.example.demo.entity.Salle;
import com.example.demo.repository.FilmRepository;

@Service
public class FilmServiceImplemeptation implements IFilmService{
	@Autowired
    private FilmRepository repositoryFilm;
	@Autowired // injection ImageStorage dans film puisque on va ajouter des images des films 
	private ImageStorage imagestorage;

	@Override
	public FilmDTO addFilm(FilmDTO filmDTO) {
		 Film film = FilmDTO.toEntity(filmDTO);
	        Film filmSaved= repositoryFilm.save(film);
	        return FilmDTO.fromEntity(filmSaved);
	}
	
	  @Override
	  public FilmDTO findByid(Long id) { 
		  Optional<Film> optionalFilm =repositoryFilm.findById(id); 
		  if (optionalFilm.isPresent()) { 
			  Film film=optionalFilm.get(); 
			  return FilmDTO.fromEntity(film); } 
		  else { return null; } }
	 

	    @Override
	    public void deleteById(Long id) {
	    repositoryFilm.deleteById(id);
	    }

	    @Override
	    public List<FilmDTO> findAll() {
	        return repositoryFilm.findAll().stream().map(FilmDTO::fromEntity).collect(Collectors.toList());
	    }

	    
	    // Opération Update
	    public FilmDTO updateFilm(Long id, FilmDTO filmDTO) {
	        Optional<Film> existingFilm = repositoryFilm.findById(id);
	        if (existingFilm.isPresent()) {
	            Film updatedFilm = existingFilm.get();
	            updatedFilm.setCreateur(filmDTO.getCreateur());
	            updatedFilm.setDescription(filmDTO.getDescription());
	            updatedFilm.setDureeFilm(filmDTO.getDureeFilm());
	            updatedFilm.setNomFilm(filmDTO.getNomFilm());
	            updatedFilm.setCategory(filmDTO.getCategory());
	            updatedFilm.setImage(filmDTO.getImage());
	            //updatedFilm.isActif()()
	            // Mettre à jour d'autres propriétés de l'utilisateur si nécessaire
	            Film savedFilm = repositoryFilm.save(updatedFilm);

	            FilmDTO savedFilmDTO = new FilmDTO();
	            savedFilmDTO.setCreateur(savedFilm.getCreateur());
	            savedFilmDTO.setDescription(savedFilm.getDescription());
	            savedFilmDTO.setDureeFilm(savedFilm.getDureeFilm());
	            savedFilmDTO.setCategory(savedFilm.getCategory());
	            savedFilmDTO.setImage(savedFilm.getImage());
	            savedFilmDTO.setNomFilm(savedFilm.getNomFilm());


	            //updatedFilm.setIsactif(false);
	            // Copier d'autres propriétés de l'utilisateur si nécessaire

	            return savedFilmDTO;
	        }
	        return null; // Gérer le cas où l'utilisateur n'est pas trouvé
	    }
	   @Override
	   public ResponseEntity<FilmDTO> findByIdResponse(Long id) {
			if (id == null) {
			
				throw new InvalidOperationException("Impossible de trouver un FILM avec un ID NULL", ErrorCodes.FILM_ID_IS_NULL);
			}
			Optional<Film> film = repositoryFilm.findById(id);

			return ResponseEntity.ok(Optional.of(FilmDTO.fromEntity(film.get())).orElseThrow(() ->
					new EntityNotFoundException(
							"Aucun film avec l'ID = " + id + " n'a été trouvé dans la BDD",
							ErrorCodes.FILM_NOT_FOUND)
			));
		}
	    public ResponseEntity<Film> findbyId(Long id) {
	        if (id == null) {
	          //  log.error("student ID is null");
	            return null;
	        }
	        return ResponseEntity.ok(repositoryFilm.findById(id).get());
	                
	    }
	    // meth ajouter film et mettre une image de film
	    @Override
		public FilmDTO uploadImageFilm(Long filmId, MultipartFile image) {
			 ResponseEntity<FilmDTO> FilmResponse = this.findByIdResponse(filmId);
		        String imageName=imagestorage.store(image);
		        //api de controller
		        String fileImageDownloadUrl= ServletUriComponentsBuilder.fromCurrentContextPath().path("api/v1/GestionFilmsByAdmin/auth/downloadFilmImage/").path(imageName).toUriString();
		        FilmDTO filmdto = FilmResponse.getBody();
		        if (filmdto!=null)
		        	filmdto.setImage(fileImageDownloadUrl);
		        return this.addFilm(filmdto);
		}
		@Override
		public FilmDTO updateFilm(Long id) {
			// TODO Auto-generated method stub
			return null;
		}
	    
	    
}
