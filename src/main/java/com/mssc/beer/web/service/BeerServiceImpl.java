package com.mssc.beer.web.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mssc.beer.web.model.BeerDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
	@Override
	public BeerDto getBeerById(UUID id) {
		return BeerDto.builder().id(UUID.randomUUID()).beerName("Galaxy Cat").beerStyle("Pale Ale").build();
	}

	// BeerDto beer = new BeerDto()
	@Override
	public BeerDto saveNewBeer(BeerDto beer) {
		return BeerDto.builder().id(UUID.randomUUID()).build();
	}

	@Override
	public void update(UUID beerId, BeerDto beer) {
		log.debug("updating......");
		log.info("info updating ........................");
	}

	@Override
	public void deleteById(UUID beerId) {
		log.debug("deleting .......");
		log.info("info deleting ........................");
	}
}
