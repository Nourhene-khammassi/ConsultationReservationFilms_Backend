
  package com.example.demo.repository;
  
  import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
  
  import com.example.demo.entity.Places;
import com.example.demo.entity.Role;
  
  public interface PlacesRepository extends JpaRepository <Places, Long>{
		Optional<Places> findByMatricule(String place );

  }
 