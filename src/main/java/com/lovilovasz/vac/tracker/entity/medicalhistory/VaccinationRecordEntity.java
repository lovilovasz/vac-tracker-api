package com.lovilovasz.vac.tracker.entity.medicalhistory;

import com.lovilovasz.vac.tracker.domain.medicalhistory.VaccinationRecord;
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

    public VaccinationRecord toDomain() {
        VaccinationRecord vaccinationRecord = new VaccinationRecord();
        vaccinationRecord.setId(this.id);
        vaccinationRecord.setVaccinationDate(this.vaccinationDate);
        vaccinationRecord.setVaccineName(this.vaccineName);
        vaccinationRecord.setExpirationDate(this.expirationDate);
        vaccinationRecord.setAdministeredBy(this.administeredBy);
        return vaccinationRecord;
    }
}
