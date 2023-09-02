package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.FilmDTO;
import com.example.demo.dto.ProjectionDTO;
import com.example.demo.entity.Projection;

public interface IProjectionService {

	ProjectionDTO saveProjection(ProjectionDTO projectionDTO);

	ProjectionDTO findById (Long id);
    void deleteById (Long id);
    List<ProjectionDTO> findAll();
    ProjectionDTO updateProjection(Long id, ProjectionDTO projectionDTO);
     List<Projection> getProjectionsByFilmId(Long idFilm);
}

