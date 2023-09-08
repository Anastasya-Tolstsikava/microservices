package com.testproject.zoomarket.controller;

import com.testproject.zoomarket.client.PetClient;
import com.testproject.zoomarket.model.PetStore;
import com.testproject.zoomarket.service.PetStoreService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pet-stores")
@RestController
//@RequiredArgsConstructor
public class PetsStoreController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PetsStoreController.class);

    @Autowired
    private PetStoreService petStoreService;

    @Autowired
    private PetClient petClient;

    @GetMapping
    public List<PetStore> getAllPetStores() {
        //LOGGER.info("Pet Stores:");
        return petStoreService.getAllPetStores();
    }

    @GetMapping("/{id}")
    public PetStore getPetStore(@PathVariable Long id) {
        LOGGER.info("Pet Store with id={}:", id);
        return petStoreService.getPetStore(id);
    }

    @PostMapping
    public void addPetStore(@RequestBody PetStore petStore) {
        petStoreService.addPetStore(petStore);
        LOGGER.info("Pet Store is added: {}", petStore);
    }

    @PutMapping(value = "/{id}")
    public void updatePetStore(@RequestBody PetStore petStore) {
        petStoreService.updatePetStore(petStore);
        LOGGER.info("Pet Store is updated: {}", petStore);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePetStores(@PathVariable Long id) {
        PetStore petStoreToDelete = petStoreService.getPetStore(id);
        petStoreService.deletePetStore(id);
        LOGGER.info("Pet Store was deleted: {}", petStoreToDelete);
    }

    @GetMapping("/with-pets")
    public List<PetStore> getAllPetStoresWithPets() {
        List<PetStore> petStores = petStoreService.getAllPetStores();
        petStores.forEach(petStore ->
                petStore.setPets(petClient.getPetsByPetStoreId(petStore.getId())));
        LOGGER.info("Pet Stores with pets: {}", petStores);
        return petStores;
    }
}
