package com.testproject.zoomarket.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.util.ArrayList;
import java.util.List;

@Entity
public class PetStore {

    @Id
    private Long id;

    private String address;
    private String workingHours;

    @Transient
    private List<Pet> pets = new ArrayList<>();

    public PetStore() {
    }

    public PetStore(Long id, String address, String workingHours) {
        this.id = id;
        this.address = address;
        this.workingHours = workingHours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "PetStore{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", workingHours='" + workingHours + '\'' +
                ", pets=" + pets +
                '}';
    }
}
