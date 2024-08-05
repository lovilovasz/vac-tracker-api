package com.lovilovasz.vac.tracker.service;

import com.lovilovasz.vac.tracker.domain.horse.HorseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class HorseSearchService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${dijugratas.api.url}")
    private String apiUrl;

    @Value("${dijugratas.api.progkey}")
    private String progKey;

    public HorseResponse searchHorse(String horseName) {
        URI url = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("sidx", "Name")
                .queryParam("page", "1")
                .queryParam("sord", "")
                .queryParam("rows", "10")
                .queryParam("searchTerm", horseName)
                .queryParam("fields", "Id,Name,BirthDate,Color,Sex,Chip,Owner,BreedName")
                .build().toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json, text/javascript, */*; q=0.01");
        headers.set("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
        headers.set("progkey", progKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<HorseResponse> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                HorseResponse.class
        );

        return response.getBody();
    }
}
