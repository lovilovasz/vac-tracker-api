package com.lovilovasz.vac.tracker.entity.medicalhistory;

import com.lovilovasz.vac.tracker.domain.medicalhistory.Surgery;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "surgery")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SurgeryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String surgeryType;
    private LocalDate surgeryDate;
    private String outcome;
    private UUID petId;

    public Surgery toDomain() {
        return Surgery.builder()
                .id(this.id)
                .surgeryType(this.surgeryType)
                .surgeryDate(this.surgeryDate)
                .outcome(this.outcome)
                .build();
    }
}
