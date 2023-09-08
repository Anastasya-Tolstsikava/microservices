package com.testproject.zoomarket.service;

import com.testproject.zoomarket.model.PetStore;
import com.testproject.zoomarket.repository.PetStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetStoreService {

    @Autowired
    private PetStoreRepository petStoreRepository;

    public List<PetStore> getAllPetStores() {
        return petStoreRepository.findAll();
    }

    public PetStore getPetStore(Long id) {
        return petStoreRepository.findById(id).orElse(null);
    }

    public void addPetStore(PetStore petStore) {
        petStoreRepository.save(petStore);
    }

    public void updatePetStore(PetStore updatedPetStore) {
        petStoreRepository.save(updatedPetStore);
    }

    public void deletePetStore(Long id) {
        petStoreRepository.delete(getPetStore(id));
    }
}
