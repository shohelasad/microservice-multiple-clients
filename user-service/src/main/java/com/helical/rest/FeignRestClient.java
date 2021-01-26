package com.helical.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.helical.dto.PaymentTermDto;

@FeignClient(name = "payment-service")
public interface FeignRestClient {
	
	@RequestMapping("/payment-term/find/{code}")
	PaymentTermDto findByCode(@RequestParam("code") String code);
	
}
