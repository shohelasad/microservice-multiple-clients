package com.helical.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helical.entity.PaymentTerm;
import com.helical.respository.PaymentTermRepository;

@Service
public class PaymentTermService {
	
	@Autowired
	PaymentTermRepository paymentTermRepository;
	
	public Optional<PaymentTerm> findById(Long id) {
		return paymentTermRepository.findById(id);
	}
	
	public List<PaymentTerm> findAll() {
		return paymentTermRepository.findAll();
	}
	
	public PaymentTerm save(PaymentTerm paymentTerm) {
		
		return paymentTermRepository.save(paymentTerm);
	}
	
	public PaymentTerm update(PaymentTerm paymentTerm) {
	
		return paymentTermRepository.save(paymentTerm);
	}
	
	public void delete(Long id) {
		
		paymentTermRepository.deleteById(id);
	}
	
	public PaymentTerm findByCode(String code) {
		return paymentTermRepository.findByCode(code);
	}
	

}