package com.lovilovasz.vac.tracker.entity.medicalhistory;

import com.lovilovasz.vac.tracker.domain.medicalhistory.VaccinationRecords;
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
@Table(name = "vaccination_record")
public class VaccinationRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private LocalDate vaccinationDate;
    private String vaccineName;
    private LocalDate expirationDate;
    private String administeredBy;
    private UUID petId;

    public VaccinationRecords toDomain() {
        VaccinationRecords vaccinationRecords = new VaccinationRecords();
        vaccinationRecords.setId(this.id);
        vaccinationRecords.setVaccinationDate(this.vaccinationDate);
        vaccinationRecords.setVaccineName(this.vaccineName);
        vaccinationRecords.setExpirationDate(this.expirationDate);
        vaccinationRecords.setAdministeredBy(this.administeredBy);
        return vaccinationRecords;
    }
}
