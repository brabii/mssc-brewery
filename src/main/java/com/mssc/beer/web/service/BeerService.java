package com.mssc.beer.web.service;

import com.mssc.beer.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface BeerService {
    public BeerDto getBeerById(UUID id);
}
