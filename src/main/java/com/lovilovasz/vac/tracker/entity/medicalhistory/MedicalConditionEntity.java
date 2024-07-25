package com.lovilovasz.vac.tracker.entity.medicalhistory;

import com.lovilovasz.vac.tracker.domain.medicalhistory.MedicalCondition;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "medical_condition")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalConditionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String conditionName;
    private LocalDate diagnosisDate;
    private String treatment;
    private String status;

    private UUID petId;

    public MedicalCondition toDomain() {
        return MedicalCondition.builder()
                .id(this.id)
                .conditionName(this.conditionName)
                .diagnosisDate(this.diagnosisDate)
                .treatment(this.treatment)
                .status(this.status)
                .build();
    }
}
