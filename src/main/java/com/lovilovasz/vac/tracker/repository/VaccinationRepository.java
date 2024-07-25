package com.lovilovasz.vac.tracker.repository;

import com.lovilovasz.vac.tracker.entity.VaccinationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VaccinationRepository extends JpaRepository<VaccinationEntity, UUID> {
    List<VaccinationEntity> findByPetId(UUID petId);
    void deleteByPetId(UUID petId);
}
