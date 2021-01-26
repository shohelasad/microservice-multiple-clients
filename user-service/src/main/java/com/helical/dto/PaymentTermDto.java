package com.helical.dto;

import java.util.Date;


public class PaymentTermDto {
 
    private Long id;
 
    private String code;
 
    private String description;
 
    private String email;
    
    private Date creationDate;
    
    private int days;
    
    private int remindBeforeDays;
    
 
    public PaymentTermDto() {
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	public int getDays() {
		return days;
	}


	public void setDays(int days) {
		this.days = days;
	}


	public int getRemindBeforeDays() {
		return remindBeforeDays;
	}


	public void setRemindBeforeDays(int remindBeforeDays) {
		this.remindBeforeDays = remindBeforeDays;
	}
    
    
}
