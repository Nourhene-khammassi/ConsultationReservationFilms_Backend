package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PlacesDTO;
import com.example.demo.dto.SalleDTO;
import com.example.demo.entity.Places;
import com.example.demo.entity.Salle;
import com.example.demo.repository.PlacesRepository;
import com.example.demo.repository.SalleRepository;
@Service
public class PlasesServiceImple implements IPlaces{

	@Autowired
	private PlacesRepository repository;
    @Override
    public PlacesDTO addPlace(PlacesDTO placeDTO) {
        Places place = PlacesDTO.toEntity(placeDTO);
        Places placeSaved= repository.save(place);
        return PlacesDTO.fromEntity(placeSaved);
    }

    @Override
    public PlacesDTO findByid(Long id) {
        Optional<Places> optionalPlace =repository.findById(id);
        if (optionalPlace.isPresent()) {
            Places place=optionalPlace.get();
            return PlacesDTO.fromEntity(place);
        }
        else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
    repository.deleteById(id);
    }

    @Override
    public List<PlacesDTO> findAll() {
        return repository.findAll().stream().map(PlacesDTO::fromEntity).collect(Collectors.toList());
    }

    
    // Opération Update
	/*
	 * public PlacesDTO updatePlace(Long id, PlacesDTO placeDTO) { Optional<Places>
	 * existingPlaces = repository.findById(id); if (existingPlaces.isPresent()) {
	 * Places updatedPlace = existingPlaces.get();
	 * updatedPlace.set(placeDTO.getMatricule());
	 * updatedPlace.setNomSa(placeDTO.getNomSalle()); // Mettre à jour d'autres
	 * propriétés de l'utilisateur si nécessaire Salle savedSalle =
	 * repository.save(updatedSalle);
	 * 
	 * SalleDTO savedSalleDTO = new SalleDTO();
	 * savedSalleDTO.setIdSalle(savedSalle.getIdSalle());
	 * savedSalleDTO.setNbrPlaces(savedSalle.getNbrPlaces());
	 * savedSalleDTO.setNomSalle(savedSalle.getNomSalle()); // Copier d'autres
	 * propriétés de l'utilisateur si nécessaire
	 * 
	 * return savedSalleDTO; } return null; // Gérer le cas où l'utilisateur n'est
	 * pas trouvé }
	 */
}
