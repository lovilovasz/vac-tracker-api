package com.lovilovasz.vac.tracker.domain.horse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Horse {
    @JsonProperty("Id")
    private String id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("BirthDate")
    private String birthDate;

    @JsonProperty("Color")
    private String color;

    @JsonProperty("Sex")
    private String sex;

    @JsonProperty("Chip")
    private String chip;

    @JsonProperty("Owner")
    private String owner;

    @JsonProperty("BreedName")
    private String breedName;
}

