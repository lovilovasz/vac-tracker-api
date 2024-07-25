package com.lovilovasz.vac.tracker.domain.medicalhistory;

import com.lovilovasz.vac.tracker.entity.medicalhistory.MedicationRecordEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class MedicationRecord {
    private UUID id;
    private String medicationName;
    private String dosage;
    private LocalDate startDate;
    private LocalDate endDate;
    private String instructions;

    public MedicationRecordEntity toEntity(UUID petId) {
        return MedicationRecordEntity.builder()
                .id(this.id)
                .medicationName(this.medicationName)
                .dosage(this.dosage)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .instructions(this.instructions)
                .petId(petId) // Directly set petId
                .build();
    }
}
