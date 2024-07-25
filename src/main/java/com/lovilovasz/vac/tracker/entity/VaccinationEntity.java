package com.lovilovasz.vac.tracker.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lovilovasz.vac.tracker.domain.Vaccination;
import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vaccination")
public class VaccinationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private LocalDate vaccinationDate;
    private String vaccineName;
    private LocalDate expirationDate;
    private UUID petId;

    public Vaccination toDomain() {
        Vaccination vaccination = new Vaccination();
        vaccination.setId(this.id);
        vaccination.setVaccinationDate(this.vaccinationDate);
        vaccination.setVaccineName(this.vaccineName);
        vaccination.setExpirationDate(this.expirationDate);
        return vaccination;
    }
}
