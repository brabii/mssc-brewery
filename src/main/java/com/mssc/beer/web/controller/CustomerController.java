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
import com.mssc.beer.web.model.CustomerDto;
import com.mssc.beer.web.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping(ApiPath.API_CUSTOMER)
@RestController
@Slf4j
public class CustomerController {
	private final CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@DeleteMapping({ "/{customerId}" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable("customerId") UUID customerId) {
		customerService.deleteCustomer(customerId);
	}

	@PutMapping({ "/{customerId}" })
	public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("customerId") UUID customerId,
			@RequestBody CustomerDto customer) {
		customerService.updateCustomer(customerId, customer);
		return new ResponseEntity<CustomerDto>(customer, HttpStatus.NO_CONTENT);
	}
	

	@PostMapping
	public ResponseEntity<CustomerDto> saveNewCustomer(@RequestBody CustomerDto customer) {
		log.info("adding new customer..................");
		CustomerDto saved = customerService.saveNewCustomer(customer);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", ApiPath.API_CUSTOMER + "/" + saved.getId().toString());
		return new ResponseEntity<CustomerDto>(headers, HttpStatus.CREATED);
	}

	@GetMapping({ "/{customerId}" })
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {
		return new ResponseEntity<CustomerDto>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}
}
