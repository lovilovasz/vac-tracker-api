package com.lovilovasz.vac.tracker.domain;

import com.lovilovasz.vac.tracker.domain.medicalhistory.MedicalHistory;
import com.lovilovasz.vac.tracker.entity.PetEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pet {
    private UUID id;
    private String name;
    private String species;
    private String breed;
    private String gender;
    private double weight;
    private String color;
    private String owner;
    private String microchipNumber;
    private LocalDate dateOfBirth;
    private MedicalHistory medicalHistory = new MedicalHistory();

    public PetEntity toEntity() {
        PetEntity petEntity = new PetEntity();
        petEntity.setId(this.id);
        petEntity.setName(this.name);
        petEntity.setSpecies(this.species);
        petEntity.setBreed(this.breed);
        petEntity.setGender(this.gender);
        petEntity.setWeight(this.weight);
        petEntity.setColor(this.color);
        petEntity.setOwner(this.owner);
        petEntity.setMicrochipNumber(this.microchipNumber);
        petEntity.setDateOfBirth(this.dateOfBirth);
        return petEntity;
    }
}
