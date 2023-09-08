package com.testproject.zoomarket.client;

import com.testproject.zoomarket.model.Pet;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface PetClient {

    @GetExchange("/pets/pet-store/{id}")
    List<Pet> getPetsByPetStoreId(@PathVariable Long id);
}