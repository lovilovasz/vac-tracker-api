package com.lovilovasz.vac.tracker.entity.medicalhistory;

import com.lovilovasz.vac.tracker.domain.medicalhistory.MedicalHistory;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MedicalHistoryEntity {
    private List<MedicalConditionEntity> medicalConditions;
    private List<VaccinationRecordEntity> vaccinationRecords;
    private List<MedicationRecordEntity> medicationRecords;
    private List<AllergyEntity> allergies;
    private List<SurgeryEntity> surgeries;
    private List<CheckUpEntity> checkUps;

    public MedicalHistory toDomain() {
        return MedicalHistory.builder()
                .medicalConditions(this.medicalConditions.stream()
                        .map(MedicalConditionEntity::toDomain)
                        .toList())
                .vaccinationRecords(this.vaccinationRecords.stream()
                        .map(VaccinationRecordEntity::toDomain)
                        .toList())
                .medicationRecords(this.medicationRecords.stream()
                        .map(MedicationRecordEntity::toDomain)
                        .toList())
                .allergies(this.allergies.stream()
                        .map(AllergyEntity::toDomain)
                        .toList())
                .surgeries(this.surgeries.stream()
                        .map(SurgeryEntity::toDomain)
                        .toList())
                .checkUps(this.checkUps.stream()
                        .map(CheckUpEntity::toDomain)
                        .toList())
                .build();
    }
}
