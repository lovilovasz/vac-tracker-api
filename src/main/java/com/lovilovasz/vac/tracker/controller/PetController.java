package com.lovilovasz.vac.tracker.controller;

import com.lovilovasz.vac.tracker.domain.Pet;
import com.lovilovasz.vac.tracker.domain.medicalhistory.*;
import com.lovilovasz.vac.tracker.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    public Pet createPet(@RequestBody Pet pet) {
        pet.setMedicalHistory(MedicalHistory.builder().build());
        return petService.savePet(pet);
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable UUID id) {
        petService.deletePet(id);
    }

    @GetMapping("/owner/{ownerName}")
    public List<Pet> getPetsByOwner(@PathVariable String ownerName) {
        return petService.getPetsByOwner(ownerName);
    }

    @PostMapping("/{petId}/medicalConditions")
    public void addMedicalConditionsToPet(@PathVariable UUID petId, @RequestBody MedicalCondition medicalCondition) {
        petService.addMedicalConditionToPet(petId, medicalCondition);
    }

    @PostMapping("/{petId}/vaccinations")
    public void addVaccinationToPet(@PathVariable UUID petId, @RequestBody VaccinationRecord vaccinationRecord) {
        petService.addVaccinationToPet(petId, vaccinationRecord);
    }

    @PostMapping("/{petId}/medications")
    public void addMedicationToPet(@PathVariable UUID petId, @RequestBody MedicationRecord medicationRecord) {
        petService.addMedicationToPet(petId, medicationRecord);
    }

    @PostMapping("/{petId}/allergies")
    public void addAllergyToPet(@PathVariable UUID petId, @RequestBody Allergy allergy) {
        petService.addAllergyToPet(petId, allergy);
    }

    @PostMapping("/{petId}/surgeries")
    public void addSurgeryToPet(@PathVariable UUID petId, @RequestBody Surgery surgery) {
        petService.addSurgeryToPet(petId, surgery);
    }

    @PostMapping("/{petId}/checkUps")
    public void addCheckUpToPet(@PathVariable UUID petId, @RequestBody CheckUp checkUp) {
        petService.addCheckUpToPet(petId, checkUp);
    }
}
