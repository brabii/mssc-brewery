package com.mssc.beer.web.service;

import java.util.UUID;

import com.mssc.beer.web.model.CustomerDto;

public interface CustomerService {
	public CustomerDto getCustomerById(UUID customerId);
}
