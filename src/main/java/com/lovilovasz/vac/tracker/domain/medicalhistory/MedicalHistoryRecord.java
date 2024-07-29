package com.lovilovasz.vac.tracker.domain.medicalhistory;

import java.util.UUID;

public interface MedicalHistoryRecord<T> {
    T toEntity(UUID petId);
}
