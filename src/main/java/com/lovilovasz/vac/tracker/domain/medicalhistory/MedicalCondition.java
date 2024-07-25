package com.lovilovasz.vac.tracker.domain.medicalhistory;

import com.lovilovasz.vac.tracker.entity.medicalhistory.MedicalConditionEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class MedicalCondition {
    private UUID id;
    private String conditionName;
    private LocalDate diagnosisDate;
    private String treatment;
    private String status;
    private UUID petId;

    public MedicalConditionEntity toEntity(UUID petId) {
        return MedicalConditionEntity.builder()
                .id(this.id)
                .conditionName(this.conditionName)
                .diagnosisDate(this.diagnosisDate)
                .treatment(this.treatment)
                .status(this.status)
                .petId(petId)
                .build();
    }
}
