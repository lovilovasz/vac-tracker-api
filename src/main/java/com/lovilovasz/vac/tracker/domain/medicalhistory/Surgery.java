package com.lovilovasz.vac.tracker.domain.medicalhistory;

import com.lovilovasz.vac.tracker.entity.medicalhistory.SurgeryEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class Surgery {
    private UUID id;
    private String surgeryType;
    private LocalDate surgeryDate;
    private String outcome;

    public SurgeryEntity toEntity(UUID petId) {
        return SurgeryEntity.builder()
                .id(this.id)
                .surgeryType(this.surgeryType)
                .surgeryDate(this.surgeryDate)
                .outcome(this.outcome)
                .petId(petId) // Directly set petId
                .build();
    }
}
