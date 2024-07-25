package com.lovilovasz.vac.tracker.repository.medicalhistory;

import com.lovilovasz.vac.tracker.entity.medicalhistory.AllergyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AllergyRepository extends JpaRepository<AllergyEntity, UUID>, MedicalHistoryRepository<AllergyEntity> {
}
