package com.lovilovasz.vac.tracker.service;

import com.lovilovasz.vac.tracker.repository.medicalhistory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MedicalHistoryService {
    @Autowired
    private MedicalConditionRepository medicalConditionRepository;
    @Autowired
    private VaccinationRecordRepository vaccinationRecordRepository;
    @Autowired
    private MedicationRecordRepository medicationRecordRepository;
    @Autowired
    private AllergyRepository allergyRepository;
    @Autowired
    private SurgeryRepository surgeryRepository;
    @Autowired
    private CheckUpRepository checkUpRepository;

    public void deleteMedicalCondition(UUID id) {
        medicalConditionRepository.deleteById(id);
    }
    public void deleteVaccinationRecord(UUID id) {
        vaccinationRecordRepository.deleteById(id);
    }
    public void deleteMedication(UUID id) {
        medicationRecordRepository.deleteById(id);
    }
    public void deleteAllergy(UUID id) {
        allergyRepository.deleteById(id);
    }
    public void deleteSurgery(UUID id) {
        surgeryRepository.deleteById(id);
    }
    public void deleteCheckUp(UUID id) {
        checkUpRepository.deleteById(id);
    }
}
