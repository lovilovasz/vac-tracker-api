package com.lovilovasz.vac.tracker.entity.medicalhistory;

import com.lovilovasz.vac.tracker.domain.medicalhistory.CheckUp;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "check_up")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckUpEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private LocalDate visitDate;
    private String veterinarian;
    private String notes;
    private UUID petId;

    public CheckUp toDomain() {
        return CheckUp.builder()
                .id(this.id)
                .visitDate(this.visitDate)
                .veterinarian(this.veterinarian)
                .notes(this.notes)
                .build();
    }
}
