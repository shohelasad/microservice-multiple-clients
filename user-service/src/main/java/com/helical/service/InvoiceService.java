package com.helical.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helical.dto.InvoiceDto;
import com.helical.dto.PaymentTermDto;
import com.helical.entity.Invoice;
import com.helical.exception.NotFoundException;
import com.helical.respository.InvoiceRepository;
import com.helical.rest.FeignRestClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service
public class InvoiceService {
    
	private InvoiceRepository invoiceRepository;
	
	@Autowired
	private FeignRestClient feignRestClient;
	
	@Autowired
	public InvoiceService(InvoiceRepository invoiceRepository) {
		this.invoiceRepository = invoiceRepository;
	}
	
	public Optional<Invoice> findById(Long id) {
		return invoiceRepository.findById(id);
	}
	
	public List<Invoice> findAll() {
		return invoiceRepository.findAll();
	}
	
	public Invoice save(InvoiceDto invoiceDto) {
		Invoice invoice =  new Invoice();
		BeanUtils.copyProperties(invoiceDto, invoice);
		return invoiceRepository.save(invoice);
	}
	
	public Invoice update(InvoiceDto invoice, Long id) {
	   	Invoice newInvoice = invoiceRepository.findById(id).get();
    	if (invoice == null)
			throw new NotFoundException("Invoice Not Found!");
    	
    	BeanUtils.copyProperties(invoice, newInvoice);
	
		return invoiceRepository.save(newInvoice);
	}
	
	public void delete(Long id) {
		
		invoiceRepository.deleteById(id);
	}
	
	public List<Invoice> findByStatus(String status) {
		return invoiceRepository.findByStatus(status);
	}
	

	public PaymentTermDto findPaymentTermByCode(String code) {
		return feignRestClient.findByCode(code);
	}
	
	public PaymentTermDto getFallback() {
	    return new PaymentTermDto(); 
	}
	
}
