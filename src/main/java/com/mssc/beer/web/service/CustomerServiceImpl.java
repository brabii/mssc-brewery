package com.mssc.beer.web.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mssc.beer.web.model.CustomerDto;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDto getCustomerById(UUID customerId) {
		return CustomerDto.builder()
				.id(UUID.randomUUID())
				.customerName("rabii")
				.build();
	}
}
