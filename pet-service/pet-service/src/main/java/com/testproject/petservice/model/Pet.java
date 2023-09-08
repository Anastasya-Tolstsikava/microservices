package com.testproject.petservice.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String description;

    private Long petStoreId;

    public Pet(String type, String description, Long petStoreId) {
        this.type = type;
        this.description = description;
        this.petStoreId = petStoreId;
    }

    public Pet() {
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPetStoreId() {
        return petStoreId;
    }

    public void setPetStoreId(Long petStoreId) {
        this.petStoreId = petStoreId;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", petStoreId=" + petStoreId +
                '}';
    }
}
