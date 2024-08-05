package com.lovilovasz.vac.tracker.domain.horse;

import lombok.Data;

import java.util.List;

@Data
public class HorseResponse {
    private int total;
    private int page;
    private int records;
    private List<Horse> rows;
}