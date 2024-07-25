package com.lovilovasz.vac.tracker.repository.medicalhistory;

import com.lovilovasz.vac.tracker.entity.medicalhistory.MedicalConditionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MedicalConditionRepository extends JpaRepository<MedicalConditionEntity, UUID>, MedicalHistoryRepository<MedicalConditionEntity> {
}
