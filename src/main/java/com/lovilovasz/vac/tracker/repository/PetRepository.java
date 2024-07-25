package com.lovilovasz.vac.tracker.repository;

import com.lovilovasz.vac.tracker.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PetRepository extends JpaRepository<PetEntity, UUID> {
    List<PetEntity> findByOwner(String ownerName);
}
