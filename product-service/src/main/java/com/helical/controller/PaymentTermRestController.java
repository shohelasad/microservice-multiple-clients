package com.helical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.helical.entity.PaymentTerm;
import com.helical.exception.NotFoundException;
import com.helical.service.PaymentTermService;

@RestController
public class PaymentTermRestController {

	@Autowired
	private PaymentTermService paymentTermService;
	
	@GetMapping("/payment-term/{id}")
	public PaymentTerm find(@PathVariable long id) {
		PaymentTerm paymentTerm = paymentTermService.findById(id).get();

		if (paymentTerm == null)
			throw new NotFoundException("Payment Term Not Found!");

		return paymentTerm;
	}
	
	@GetMapping("/payment-term/find/{code}")
	public PaymentTerm findByCode(@PathVariable String code) {
		PaymentTerm paymentTerm = paymentTermService.findByCode(code);

		if (paymentTerm == null)
			throw new NotFoundException("Payment Term Not Found!");

		return paymentTerm;
	}

	@GetMapping("/payment-term")
	public List<PaymentTerm> findAll() {
		return paymentTermService.findAll();
	}
	
	@PostMapping("/payment-term")
	public PaymentTerm save(@RequestBody PaymentTerm paymentTerm) {
        return paymentTermService.save(paymentTerm);
    }
 
    @PutMapping("/payment-term/{id}")
    public PaymentTerm update(@RequestBody PaymentTerm paymentTerm, @PathVariable Long id) {
    	
    	PaymentTerm newPaymentTerm = paymentTermService.findById(id).get();
    	if (newPaymentTerm == null)
			throw new NotFoundException("Invoice Not Found!");
    
    	newPaymentTerm.setCode(paymentTerm.getCode());
    	newPaymentTerm.setCreationDate(paymentTerm.getCreationDate());
    	newPaymentTerm.setDays(paymentTerm.getDays());
    	newPaymentTerm.setDescription(paymentTerm.getDescription());
    	newPaymentTerm.setEmail(paymentTerm.getEmail());
    	newPaymentTerm.setRemindBeforeDays(paymentTerm.getRemindBeforeDays());
    	
    	return paymentTermService.save(newPaymentTerm);
		
    }
 
    @DeleteMapping("/payment-term/{id}")
    public void deleteEmployee(@PathVariable Long id) {
    	paymentTermService.delete(id);
    }

}
