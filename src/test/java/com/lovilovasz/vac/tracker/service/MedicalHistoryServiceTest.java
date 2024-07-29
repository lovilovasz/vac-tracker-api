package com.lovilovasz.vac.tracker.service;

import com.lovilovasz.vac.tracker.repository.medicalhistory.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MedicalHistoryServiceTest {
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
    private MedicalHistoryService underTest;

    @Test
    void deleteMedicalCondition() {
        UUID id = UUID.randomUUID();
        underTest.deleteMedicalCondition(id);
        verify(medicalConditionRepository).deleteById(id);
    }

    @Test
    void deleteVaccinationRecord() {
        UUID id = UUID.randomUUID();
        underTest.deleteVaccinationRecord(id);
        verify(vaccinationRecordRepository).deleteById(id);
    }

    @Test
    void deleteMedication() {
        UUID id = UUID.randomUUID();
        underTest.deleteMedication(id);
        verify(medicationRecordRepository).deleteById(id);
    }

    @Test
    void deleteAllergy() {
        UUID id = UUID.randomUUID();
        underTest.deleteAllergy(id);
        verify(allergyRepository).deleteById(id);
    }

    @Test
    void deleteSurgery() {
        UUID id = UUID.randomUUID();
        underTest.deleteSurgery(id);
        verify(surgeryRepository).deleteById(id);
    }

    @Test
    void deleteCheckUp() {
        UUID id = UUID.randomUUID();
        underTest.deleteCheckUp(id);
        verify(checkUpRepository).deleteById(id);
    }

}
