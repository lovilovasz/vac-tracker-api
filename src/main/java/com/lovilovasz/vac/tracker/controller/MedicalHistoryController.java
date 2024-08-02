package com.lovilovasz.vac.tracker.controller;

import com.lovilovasz.vac.tracker.domain.medicalhistory.*;
import com.lovilovasz.vac.tracker.service.MedicalHistoryService;
import com.lovilovasz.vac.tracker.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/medical/history")
public class MedicalHistoryController {

    @Autowired
    private PetService petService;
    @Autowired
    private MedicalHistoryService medicalHistoryService;

    @PostMapping("/{petId}/medicalConditions")
    public void addMedicalConditionsToPet(@PathVariable UUID petId, @RequestBody MedicalCondition medicalCondition) {
        petService.addMedicalConditionToPet(petId, medicalCondition);
    }

    @PostMapping("/{petId}/vaccinationRecords")
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

    @DeleteMapping("/medicalConditions/{id}")
    public void deleteMedicalConditionsToPet(@PathVariable UUID id) {
        medicalHistoryService.deleteMedicalCondition(id);
    }

    @DeleteMapping("/vaccinationRecords/{id}")
    public void deleteVaccinationToPet(@PathVariable UUID id) {
        medicalHistoryService.deleteVaccinationRecord(id);
    }

    @DeleteMapping("/medications/{id}")
    public void deleteMedicationToPet(@PathVariable UUID id) {
        medicalHistoryService.deleteMedication(id);
    }

    @DeleteMapping("/allergies/{id}")
    public void deleteAllergyToPet(@PathVariable UUID id) {
        medicalHistoryService.deleteAllergy(id);
    }

    @DeleteMapping("/surgeries/{id}")
    public void deleteSurgeryToPet(@PathVariable UUID id) {
        medicalHistoryService.deleteSurgery(id);
    }

    @DeleteMapping("/checkUps/{id}")
    public void deleteCheckUpToPet(@PathVariable UUID id) {
        medicalHistoryService.deleteCheckUp(id);
    }
}
