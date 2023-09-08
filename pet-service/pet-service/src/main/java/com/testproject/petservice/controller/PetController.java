package com.testproject.petservice.controller;

import com.testproject.petservice.model.Pet;
import com.testproject.petservice.service.PetService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pets")
@RestController
@RequiredArgsConstructor
public class PetController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PetController.class);
    private final PetService petService;

    @GetMapping
    public List<Pet> getAllPets() {
        LOGGER.info("Pets:");
        return petService.getAllPets();
    }

    @GetMapping("/{id}")
    public Pet getPet(@PathVariable Long id) {
        LOGGER.info("Pet with id={}:", id);
        return petService.getPet(id);
    }

    @GetMapping("/pet-store/{id}")
    public List<Pet> getPetsByPetStoreId(@PathVariable Long id){
        LOGGER.info("Pets from Pet Store with id={}:", id);
        return petService.getPetsByPetStoreId(id);
    }

    @PostMapping
    public void addPet(@RequestBody Pet pet) {
        petService.addPet(pet);
        LOGGER.info("Pet is added: {}", pet);
    }

    @PutMapping(value = "/{id}")
    public void updatePet(@RequestBody Pet pet) {
        petService.updatePet(pet);
        LOGGER.info("Pet is updated: {}", pet);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePet(@PathVariable Long id) {
        Pet petToDelete = petService.getPet(id);
        petService.deletePet(id);
        LOGGER.info("Pet was deleted: {}", petToDelete);
    }
}
