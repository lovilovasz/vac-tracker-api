package com.lovilovasz.vac.tracker.repository.medicalhistory;

import com.lovilovasz.vac.tracker.entity.medicalhistory.VaccinationRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VaccinationRecordRepository extends JpaRepository<VaccinationRecordEntity, UUID>, MedicalHistoryRepository<VaccinationRecordEntity> {

}
