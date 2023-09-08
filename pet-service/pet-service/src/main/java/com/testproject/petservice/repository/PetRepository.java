package com.testproject.petservice.repository;

import com.testproject.petservice.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

    @Query("SELECT p FROM Pet p WHERE p.petStoreId = ?1")
    List<Pet> getPetsByPetStoreId (Long id);
}
