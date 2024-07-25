package com.lovilovasz.vac.tracker.domain.medicalhistory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalHistory {
    private List<MedicalCondition> medicalConditions;
    private List<VaccinationRecord> vaccinationRecords;
    private List<MedicationRecord> medicationRecords;
    private List<Allergy> allergies;
    private List<Surgery> surgeries;
    private List<CheckUp> checkUps;
}
