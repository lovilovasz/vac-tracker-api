package com.lovilovasz.vac.tracker.service;

import com.lovilovasz.vac.tracker.domain.Pet;
import com.lovilovasz.vac.tracker.domain.medicalhistory.MedicalHistory;
import com.lovilovasz.vac.tracker.domain.medicalhistory.VaccinationRecords;
import com.lovilovasz.vac.tracker.entity.PetEntity;
import com.lovilovasz.vac.tracker.entity.medicalhistory.*;
import com.lovilovasz.vac.tracker.repository.PetRepository;
import com.lovilovasz.vac.tracker.repository.medicalhistory.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;
    @Autowired
    private MedicalConditionRepository medicalConditionRepository;
    @Autowired
    private VaccinationRepository vaccinationRepository;
    @Autowired
    private MedicationRecordRepository medicationRecordRepository;
    @Autowired
    private AllergyRepository allergyRepository;
    @Autowired
    private SurgeryRepository surgeryRepository;
    @Autowired
    private CheckUpRepository checkUpRepository;

    @Transactional
    public Pet savePet(Pet pet) {
        PetEntity petEntity = petRepository.save(pet.toEntity());
        MedicalHistory medicalHistory = pet.getMedicalHistory() != null ? pet.getMedicalHistory() : MedicalHistory.builder().build();
        MedicalHistoryEntity medicalHistoryEntity = saveMedicalHistoryEntity(medicalHistory, petEntity);
        return petEntity.toDomain(medicalHistoryEntity);
    }

    @Transactional
    public void deletePet(UUID petId) {
        medicalConditionRepository.deleteByPetId(petId);
        vaccinationRepository.deleteByPetId(petId);
        medicationRecordRepository.deleteByPetId(petId);
        allergyRepository.deleteByPetId(petId);
        surgeryRepository.deleteByPetId(petId);
        checkUpRepository.deleteByPetId(petId);
        petRepository.deleteById(petId);
    }

    public List<Pet> getPetsByOwner(String ownerName) {
        List<PetEntity> petEntities = petRepository.findByOwner(ownerName);
        return petEntities
                .stream()
                .map(petEntity -> {
                    UUID petId = petEntity.getId();
                    return petEntity.toDomain(MedicalHistoryEntity.builder()
                            .medicalConditions(medicalConditionRepository.findByPetId(petId))
                            .vaccinationRecords(vaccinationRepository.findByPetId(petId))
                            .medicationRecords(medicationRecordRepository.findByPetId(petId))
                            .allergies(allergyRepository.findByPetId(petId))
                            .surgeries(surgeryRepository.findByPetId(petId))
                            .checkUps(checkUpRepository.findByPetId(petId))
                            .build()
                    );
                })
                .toList();
    }

    public void addVaccinationToPet(UUID petId, VaccinationRecords vaccinationRecords) {
        Optional<PetEntity> optionalPet = petRepository.findById(petId);
        if (optionalPet.isPresent()) {
            vaccinationRepository.save(vaccinationRecords.toEntity(petId));
        } else {
            throw new EntityNotFoundException("Pet not found");
        }
    }

    private MedicalHistoryEntity saveMedicalHistoryEntity(MedicalHistory medicalHistory, PetEntity petEntity) {
        List<MedicalConditionEntity> medicalConditionEntities = medicalHistory.getMedicalConditions() != null
                ? medicalHistory.getMedicalConditions().stream()
                .map(d -> d.toEntity(petEntity.getId()))
                .toList()
                : Collections.emptyList();

        List<VaccinationRecordEntity> vaccinationRecordEntityList = medicalHistory.getVaccinationRecords() != null
                ? medicalHistory.getVaccinationRecords().stream()
                .map(d -> d.toEntity(petEntity.getId()))
                .toList()
                : Collections.emptyList();

        List<MedicationRecordEntity> medicationRecordEntities = medicalHistory.getMedicationRecords() != null
                ? medicalHistory.getMedicationRecords().stream()
                .map(d -> d.toEntity(petEntity.getId()))
                .toList()
                : Collections.emptyList();

        List<AllergyEntity> allergyEntities = medicalHistory.getAllergies() != null
                ? medicalHistory.getAllergies().stream()
                .map(d -> d.toEntity(petEntity.getId()))
                .toList()
                : Collections.emptyList();

        List<SurgeryEntity> surgeryEntities = medicalHistory.getSurgeries() != null
                ? medicalHistory.getSurgeries().stream()
                .map(d -> d.toEntity(petEntity.getId()))
                .toList()
                : Collections.emptyList();

        List<CheckUpEntity> checkUpEntities = medicalHistory.getCheckUps() != null
                ? medicalHistory.getCheckUps().stream()
                .map(d -> d.toEntity(petEntity.getId()))
                .toList()
                : Collections.emptyList();
        List<MedicalConditionEntity> savedMedicalCondition = medicalConditionRepository.saveAll(medicalConditionEntities);
        List<VaccinationRecordEntity> savedVaccinationRecordEntityList = vaccinationRepository.saveAll(vaccinationRecordEntityList);
        List<MedicationRecordEntity> savedMedicationRecordEntities = medicationRecordRepository.saveAll(medicationRecordEntities);
        List<AllergyEntity> savedAllergyEntities = allergyRepository.saveAll(allergyEntities);
        List<SurgeryEntity> savedSurgeryEntities = surgeryRepository.saveAll(surgeryEntities);
        List<CheckUpEntity> savedCheckUpEntities = checkUpRepository.saveAll(checkUpEntities);
        return MedicalHistoryEntity.builder()
                .medicalConditions(savedMedicalCondition)
                .vaccinationRecords(savedVaccinationRecordEntityList)
                .medicationRecords(savedMedicationRecordEntities)
                .allergies(savedAllergyEntities)
                .surgeries(savedSurgeryEntities)
                .checkUps(savedCheckUpEntities)
                .build();
    }
}
