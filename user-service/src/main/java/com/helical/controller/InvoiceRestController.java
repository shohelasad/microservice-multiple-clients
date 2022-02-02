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

import com.helical.dto.InvoiceDto;
import com.helical.dto.PaymentTermDto;
import com.helical.entity.Invoice;
import com.helical.exception.NotFoundException;
import com.helical.service.InvoiceService;

@RestController
//@CrossOrigin
public class InvoiceRestController {
	
	@Autowired
	private InvoiceService invoiceService;
	
	@GetMapping("/invoice/{id}")
	public Invoice find(@PathVariable long id) {
		Invoice invoice = invoiceService.findById(id).get();

		if (invoice == null)
			throw new NotFoundException("Invoice Not Found!");

		return invoice;
	}
	
	@GetMapping("/invoice/find/{code}")
	public PaymentTermDto findByCode(@PathVariable String code) {
		PaymentTermDto paymentTearmDto = invoiceService.findPaymentTermByCode(code);

		if (paymentTearmDto == null)
			throw new NotFoundException("Payment Term Not Found!");

		return paymentTearmDto;
	}

	@GetMapping("/invoice")
	public List<Invoice> findAll() {
		return invoiceService.findAll();
	}
	
	@PostMapping("/invoice")
	public Invoice save(@RequestBody InvoiceDto invoice) {
        return invoiceService.save(invoice);
    }
 
    @PutMapping("/invoice/{id}")
    public Invoice update(@RequestBody InvoiceDto invoice, @PathVariable Long id) {
    	return invoiceService.update(invoice, id);
    }
 
    @DeleteMapping("/invoice/{id}")
    public void deleteEmployee(@PathVariable Long id) {
    	invoiceService.delete(id);
    }

}
