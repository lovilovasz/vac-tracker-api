package com.lovilovasz.vac.tracker.domain.medicalhistory;

import com.lovilovasz.vac.tracker.entity.medicalhistory.VaccinationRecordEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccinationRecords {
    private UUID id;
    private LocalDate vaccinationDate;
    private String vaccineName;
    private LocalDate expirationDate;
    private String administeredBy;

    public VaccinationRecordEntity toEntity(UUID petId) {
        VaccinationRecordEntity vaccinationRecordEntity = new VaccinationRecordEntity();
        vaccinationRecordEntity.setId(this.id);
        vaccinationRecordEntity.setVaccinationDate(this.vaccinationDate);
        vaccinationRecordEntity.setVaccineName(this.vaccineName);
        vaccinationRecordEntity.setExpirationDate(this.expirationDate);
        vaccinationRecordEntity.setAdministeredBy(this.administeredBy);
        vaccinationRecordEntity.setPetId(petId);
        return vaccinationRecordEntity;
    }
}
