package com.netflix.api.service;

import com.netflix.api.client.MovieClient;
import com.netflix.api.dto.MovieDetailsDto;
import com.netflix.api.searchdto.SearchActorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    @Autowired
    private MovieClient client;

    @Value("${tmdb.api_key}")
    private String tmdbApiKey;

    public SearchActorDTO getPerson(String person) {
        System.out.println("person in Service before client call= " + person);
        System.out.println("call is = " + client.getPerson(tmdbApiKey, person));
        return client.getPerson(tmdbApiKey, person);
    }
}
