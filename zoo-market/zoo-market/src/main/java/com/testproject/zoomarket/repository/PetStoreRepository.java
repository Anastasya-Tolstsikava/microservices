package com.testproject.zoomarket.repository;

import com.testproject.zoomarket.model.PetStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetStoreRepository extends JpaRepository<PetStore, Long> {
}
