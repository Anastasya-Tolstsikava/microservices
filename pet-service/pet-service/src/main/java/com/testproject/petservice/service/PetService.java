package com.testproject.petservice.service;

import com.testproject.petservice.model.Pet;
import com.testproject.petservice.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet getPet(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    public void addPet(Pet pet) {
        petRepository.save(pet);
    }

    public void updatePet(Pet updatedPet) {
        petRepository.save(updatedPet);
    }

    public void deletePet(Long id) {
        petRepository.delete(getPet(id));
    }

    public List<Pet> getPetsByPetStoreId(Long id) {
        return petRepository.getPetsByPetStoreId(id);
    }
}
