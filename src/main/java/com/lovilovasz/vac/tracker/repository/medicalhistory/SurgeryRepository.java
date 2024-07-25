package com.lovilovasz.vac.tracker.repository.medicalhistory;

import com.lovilovasz.vac.tracker.entity.medicalhistory.SurgeryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SurgeryRepository extends JpaRepository<SurgeryEntity, UUID>, MedicalHistoryRepository<SurgeryEntity> {
}
