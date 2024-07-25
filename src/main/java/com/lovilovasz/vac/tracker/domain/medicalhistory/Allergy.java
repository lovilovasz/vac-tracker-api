package com.lovilovasz.vac.tracker.domain.medicalhistory;

import com.lovilovasz.vac.tracker.entity.medicalhistory.AllergyEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class Allergy {
    private UUID id;
    private String allergen;
    private String reaction;
    private LocalDate dateIdentified;

    public AllergyEntity toEntity(UUID petId) {
        return AllergyEntity.builder()
                .id(this.id)
                .allergen(this.allergen)
                .reaction(this.reaction)
                .dateIdentified(this.dateIdentified)
                .petId(petId)
                .build();
    }
}
