package com.lovilovasz.vac.tracker.service;

import com.lovilovasz.vac.tracker.domain.Pet;
import com.lovilovasz.vac.tracker.domain.medicalhistory.MedicalHistory;
import com.lovilovasz.vac.tracker.entity.PetEntity;
import com.lovilovasz.vac.tracker.repository.PetRepository;
import com.lovilovasz.vac.tracker.repository.medicalhistory.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PetServiceTest {

    @Mock
    private PetRepository petRepository;
    @Mock
    private MedicalConditionRepository medicalConditionRepository;
    @Mock
    private VaccinationRecordRepository vaccinationRecordRepository;
    @Mock
    private MedicationRecordRepository medicationRecordRepository;
    @Mock
    private AllergyRepository allergyRepository;
    @Mock
    private SurgeryRepository surgeryRepository;
    @Mock
    private CheckUpRepository checkUpRepository;

    @InjectMocks
    private PetService underTest;

    @Test
    void savePetTest() {
        UUID petId = UUID.randomUUID();
        PetEntity expectedPetEntity = createPetEntity(petId);
        Pet expectedPet = createPet(petId);
        when(petRepository.save(any())).thenReturn(expectedPetEntity);
        Pet result = underTest.savePet(expectedPet);
        assertEquals(expectedPet, result);
    }

    @Test
    void deletePetTest() {
        UUID petId = UUID.randomUUID();
        underTest.deletePet(petId);
        verify(medicalConditionRepository).deleteByPetId(petId);
        verify(vaccinationRecordRepository).deleteByPetId(petId);
        verify(medicationRecordRepository).deleteByPetId(petId);
        verify(allergyRepository).deleteByPetId(petId);
        verify(surgeryRepository).deleteByPetId(petId);
        verify(checkUpRepository).deleteByPetId(petId);
        verify(petRepository).deleteById(petId);
    }

    @Test
    void findByOwnerTest() {
        String ownerName = "someone";
        UUID petId = UUID.randomUUID();
        when(petRepository.findByOwner(ownerName))
                .thenReturn(List.of(createPetEntity(petId)));

        underTest.getPetsByOwner(ownerName);
        verify(medicalConditionRepository).findByPetId(petId);
        verify(vaccinationRecordRepository).findByPetId(petId);
        verify(medicationRecordRepository).findByPetId(petId);
        verify(allergyRepository).findByPetId(petId);
        verify(surgeryRepository).findByPetId(petId);
        verify(checkUpRepository).findByPetId(petId);
    }

    private PetEntity createPetEntity(UUID id) {
        return PetEntity.builder()
                .id(id)
                .name("Buddy")
                .species("Dog")
                .breed("Golden Retriever")
                .gender("Male")
                .weight(30.0)
                .color("Golden")
                .owner("John Doe")
                .microchipNumber("1234567890")
                .dateOfBirth(LocalDate.of(2020, 1, 15))
                .build();
    }

    private Pet createPet(UUID id) {
        return Pet.builder()
                .id(id)
                .name("Buddy")
                .species("Dog")
                .breed("Golden Retriever")
                .gender("Male")
                .weight(30.0)
                .color("Golden")
                .owner("John Doe")
                .microchipNumber("1234567890")
                .dateOfBirth(LocalDate.of(2020, 1, 15))
                .medicalHistory(MedicalHistory.builder()
                        .medicalConditions(List.of())
                        .vaccinationRecords(List.of())
                        .medicationRecords(List.of())
                        .allergies(List.of())
                        .surgeries(List.of())
                        .checkUps(List.of())
                        .build())
                .build();
    }
}
