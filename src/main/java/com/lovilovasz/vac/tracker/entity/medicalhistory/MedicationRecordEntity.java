package com.lovilovasz.vac.tracker.entity.medicalhistory;

import com.lovilovasz.vac.tracker.domain.medicalhistory.MedicationRecord;
import com.lovilovasz.vac.tracker.entity.PetEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "medication_record")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicationRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String medicationName;
    private String dosage;
    private LocalDate startDate;
    private LocalDate endDate;
    private String instructions;
    private UUID petId;

    public MedicationRecord toDomain() {
        return MedicationRecord.builder()
                .id(this.id)
                .medicationName(this.medicationName)
                .dosage(this.dosage)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .instructions(this.instructions)
                .build();
    }
}
