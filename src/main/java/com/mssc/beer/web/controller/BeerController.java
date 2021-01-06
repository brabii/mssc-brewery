package com.mssc.beer.web.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mssc.beer.utils.ApiPath;
import com.mssc.beer.web.model.BeerDto;
import com.mssc.beer.web.service.BeerService;

@RequestMapping(ApiPath.API_BEER)
@RestController
public class BeerController {
	private final BeerService beerService;

	@Autowired
	public BeerController(BeerService beerService) {
		this.beerService = beerService;
	}

	@DeleteMapping({ "/{beerId}" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable("beerId") UUID beerId) {
		beerService.deleteById(beerId);
	}

	@GetMapping({ "/{beerId}" })
	public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
		return new ResponseEntity<BeerDto>(beerService.getBeerById(beerId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<BeerDto> saveNewBeer(@RequestBody BeerDto beer) {
		BeerDto saved = beerService.saveNewBeer(beer);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/beer/" + saved.getId().toString());
		return new ResponseEntity<BeerDto>(headers, HttpStatus.CREATED);
	}

	@PutMapping({ "/{beerId}" })
	public ResponseEntity<BeerDto> updateBeer(@PathVariable("beerId") UUID beerId, BeerDto beer) {
		beerService.update(beerId, beer);
		return new ResponseEntity<BeerDto>(HttpStatus.NO_CONTENT);
	}
}
