package com.helical.dto;

import java.util.Date;

public class InvoiceDto {

    private Long id;
 
    private String invoiceNumber;
 
    private String code;
 
    private String status;
    
    private Date invoiceDate;
    
    private boolean reminder;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public boolean isReminder() {
		return reminder;
	}

	public void setReminder(boolean reminder) {
		this.reminder = reminder;
	}
    

}
