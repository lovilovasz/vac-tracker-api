package com.lovilovasz.vac.tracker.repository.medicalhistory;

import com.lovilovasz.vac.tracker.entity.medicalhistory.CheckUpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CheckUpRepository extends JpaRepository<CheckUpEntity, UUID>, MedicalHistoryRepository<CheckUpEntity> {
}
