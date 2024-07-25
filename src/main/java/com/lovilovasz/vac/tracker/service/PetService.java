package com.lovilovasz.vac.tracker.service;

import com.lovilovasz.vac.tracker.domain.Pet;
import com.lovilovasz.vac.tracker.domain.Vaccination;
import com.lovilovasz.vac.tracker.entity.PetEntity;
import com.lovilovasz.vac.tracker.entity.VaccinationEntity;
import com.lovilovasz.vac.tracker.repository.PetRepository;
import com.lovilovasz.vac.tracker.repository.VaccinationRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;
    @Autowired
    private VaccinationRepository vaccinationRepository;

    @Transactional
    public Pet savePet(Pet pet) {
        PetEntity petEntity = petRepository.save(pet.toEntity());
        List<VaccinationEntity> vaccinationEntityList = pet.getVaccinations()
                .stream()
                .map(vac -> vac.toEntity(petEntity.getId()))
                .toList();
        List<VaccinationEntity> savedVaccinationEntityList = vaccinationRepository.saveAll(vaccinationEntityList);
        return petEntity.toDomain(savedVaccinationEntityList);

    }

    @Transactional
    public void deletePet(UUID petId) {
        vaccinationRepository.deleteByPetId(petId);
        petRepository.deleteById(petId);
    }

    public List<Pet> getPetsByOwner(String ownerName) {
        List<PetEntity> petEntities = petRepository.findByOwner(ownerName);
        return petEntities
                .stream()
                .map(petEntity ->
                        petEntity.toDomain(vaccinationRepository.findByPetId(petEntity.getId())))
                .toList();
    }

    public void addVaccinationToPet(UUID petId, Vaccination vaccination) {
        Optional<PetEntity> optionalPet = petRepository.findById(petId);
        if (optionalPet.isPresent()) {
            vaccinationRepository.save(vaccination.toEntity(petId));
        } else {
            throw new EntityNotFoundException("Pet not found");
        }
    }
}
