package com.lovilovasz.vac.tracker.domain;

import com.lovilovasz.vac.tracker.entity.PetEntity;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class Pet {
    private UUID id;
    private String name;
    private String species;
    private String breed;
    private String gender;
    private double weight;
    private String color;
    private List<Vaccination> vaccinations;
    private String owner;
    private String microchipNumber;
    private LocalDate dateOfBirth;

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
