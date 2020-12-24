package com.mssc.beer.web.service;

import java.util.UUID;

import com.mssc.beer.web.model.BeerDto;

public interface BeerService {
	public BeerDto getBeerById(UUID id);

	public BeerDto saveNewBeer(BeerDto beer);

	public void update(UUID beerId, BeerDto beer);

	public void deleteById(UUID beerId);
}
