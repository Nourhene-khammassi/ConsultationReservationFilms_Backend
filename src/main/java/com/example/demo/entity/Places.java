
  package com.example.demo.entity;
  
  import javax.persistence.Entity; import javax.persistence.GeneratedValue;
  import javax.persistence.GenerationType; import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor; import lombok.Builder; import
  lombok.Getter; import lombok.NoArgsConstructor; import lombok.Setter;
  
  @Entity
  
  @Getter
  
  @Setter
  
  @AllArgsConstructor
  
  @NoArgsConstructor
  
  @Builder public class Places {
  
  @Id
  
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  
  private Long idPlace; 
  private String matricule ;
  
  @ManyToOne
  @JoinColumn(name = "id_salle")
  private Salle salle;
  
  }
 