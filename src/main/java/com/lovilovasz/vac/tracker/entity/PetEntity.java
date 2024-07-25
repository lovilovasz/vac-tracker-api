package com.lovilovasz.vac.tracker.entity;

import com.lovilovasz.vac.tracker.domain.Pet;
import com.lovilovasz.vac.tracker.domain.medicalhistory.VaccinationRecords;
import com.lovilovasz.vac.tracker.entity.medicalhistory.MedicalHistoryEntity;
import com.lovilovasz.vac.tracker.entity.medicalhistory.VaccinationRecordEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pet")
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Pet toDomain(MedicalHistoryEntity medicalHistoryEntity) {
        Pet pet = new Pet();
        pet.setId(this.id);
        pet.setName(this.name);
        pet.setSpecies(this.species);
        pet.setBreed(this.breed);
        pet.setGender(this.gender);
        pet.setWeight(this.weight);
        pet.setColor(this.color);
        pet.setMedicalHistory(medicalHistoryEntity.toDomain());
        pet.setOwner(this.owner);
        pet.setMicrochipNumber(this.microchipNumber);
        pet.setDateOfBirth(this.dateOfBirth);
        return pet;
    }
}
