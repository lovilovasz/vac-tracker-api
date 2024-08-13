package com.lovilovasz.vac.tracker.service;

import com.lovilovasz.vac.tracker.domain.horse.HorseResponse;
import com.lovilovasz.vac.tracker.domain.horse.HorseSearchParams;
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

    @Value("${mlosz.api.host}")
    private String apiHost;

    public HorseResponse searchHorse(HorseSearchParams horseSearchParams) {
        URI url = UriComponentsBuilder.fromHttpUrl(apiHost + "/api/search/detailed-search")
                .build().toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");
        headers.set("content-type", "application/json");

        HttpEntity<HorseSearchParams> entity = new HttpEntity<>(horseSearchParams, headers);

        ResponseEntity<HorseResponse> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                HorseResponse.class
        );

        return response.getBody();
    }
}
