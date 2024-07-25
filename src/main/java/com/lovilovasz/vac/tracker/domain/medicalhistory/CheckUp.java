package com.lovilovasz.vac.tracker.domain.medicalhistory;

import com.lovilovasz.vac.tracker.entity.medicalhistory.CheckUpEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class CheckUp {
    private UUID id;
    private LocalDate visitDate;
    private String veterinarian;
    private String notes;

    public CheckUpEntity toEntity(UUID petId) {
        return CheckUpEntity.builder()
                .id(this.id)
                .visitDate(this.visitDate)
                .veterinarian(this.veterinarian)
                .notes(this.notes)
                .petId(petId) // Directly set petId
                .build();
    }
}
