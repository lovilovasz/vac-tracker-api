package com.lovilovasz.vac.tracker.controller;

import com.lovilovasz.vac.tracker.domain.Pet;
import com.lovilovasz.vac.tracker.domain.Vaccination;
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

    @PostMapping("/{petId}/vaccinations")
    public void addVaccinationToPet(@PathVariable UUID petId, @RequestBody Vaccination vaccination) {
        petService.addVaccinationToPet(petId, vaccination);
    }
}
