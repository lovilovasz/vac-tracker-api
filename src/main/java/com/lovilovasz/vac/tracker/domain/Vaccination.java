package com.lovilovasz.vac.tracker.domain;

import com.lovilovasz.vac.tracker.entity.VaccinationEntity;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class Vaccination {
    private UUID id;
    private LocalDate vaccinationDate;
    private String vaccineName;
    private LocalDate expirationDate;

    public VaccinationEntity toEntity(UUID petId) {
        VaccinationEntity vaccinationEntity = new VaccinationEntity();
        vaccinationEntity.setId(this.id);
        vaccinationEntity.setVaccinationDate(this.vaccinationDate);
        vaccinationEntity.setVaccineName(this.vaccineName);
        vaccinationEntity.setExpirationDate(this.expirationDate);
        vaccinationEntity.setPetId(petId);
        return vaccinationEntity;
    }
}
