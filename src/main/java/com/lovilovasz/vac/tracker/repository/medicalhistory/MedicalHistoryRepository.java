package com.lovilovasz.vac.tracker.repository.medicalhistory;


import java.util.List;
import java.util.UUID;

public interface MedicalHistoryRepository<T> {
    List<T> findByPetId(UUID petId);
    void deleteByPetId(UUID petId);
}
