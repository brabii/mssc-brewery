package com.mssc.beer.web.service;

import com.mssc.beer.web.model.BeerDto;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class BeerServiceImpl implements BeerService {
	@Override
	public BeerDto getBeerById(UUID id) {
		return BeerDto.builder()
				.id(UUID.randomUUID())
				.beerName("Galaxy Cat")
				.beerStyle("Pale Ale")
				.build();
	}
}
