package com.lovilovasz.vac.tracker.entity.medicalhistory;

import com.lovilovasz.vac.tracker.domain.medicalhistory.Allergy;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "allergy")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllergyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String allergen;
    private String reaction;
    private LocalDate dateIdentified;
    private UUID petId;

    public Allergy toDomain() {
        return Allergy.builder()
                .id(this.id)
                .allergen(this.allergen)
                .reaction(this.reaction)
                .dateIdentified(this.dateIdentified)
                .build();
    }
}
