package com.mssc.beer.web.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mssc.beer.web.model.BeerDto;
import com.mssc.beer.web.service.BeerService;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
	private final BeerService beerService;

	@Autowired
	public BeerController(BeerService beerService) {
		this.beerService = beerService;
		System.out.println("le beer service est =>" + beerService);
	}

	@GetMapping({ "/{beerId}" })
	public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
		return new ResponseEntity<BeerDto>(beerService.getBeerById(beerId), HttpStatus.OK);
	}
}
