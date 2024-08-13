package com.lovilovasz.vac.tracker.domain.horse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class HorseResponse {
    @JsonProperty("total")
    private String total;

    @JsonProperty("horses")
    private List<Horse> horses;
}