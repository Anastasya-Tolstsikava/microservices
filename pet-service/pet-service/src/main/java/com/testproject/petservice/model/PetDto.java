package com.testproject.petservice.model;

public record PetDto(Long id, Long petStoreId, String type, String Description) {
}
