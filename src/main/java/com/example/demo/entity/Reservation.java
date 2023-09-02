package com.example.demo.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idReservation;
    private int nbPlaces;
    private String dateReservation;
    
	
	  @ManyToOne
	  @JoinColumn(name = "id_user")
	  private User user;
	 
    
    @ManyToOne
    @JoinColumn(name = "id_salle")
    private Salle salle;
    
    @ManyToMany(fetch = FetchType.EAGER)
       private Set<Places> places = new HashSet<>();
}
