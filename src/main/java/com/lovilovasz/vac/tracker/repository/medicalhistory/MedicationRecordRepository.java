package com.lovilovasz.vac.tracker.repository.medicalhistory;

import com.lovilovasz.vac.tracker.entity.medicalhistory.MedicationRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MedicationRecordRepository extends JpaRepository<MedicationRecordEntity, UUID>, MedicalHistoryRepository<MedicationRecordEntity> {
}
