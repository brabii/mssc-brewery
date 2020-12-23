package com.mssc.beer.web.service;

import com.mssc.beer.web.model.BeerDto;

import java.util.UUID;

public class BeerServiceImpl implements BeerService{
    @Override
    public BeerDto getBeerById(UUID id) {
        return new BeerDto();// TODO: avoir aprés
    }
}
