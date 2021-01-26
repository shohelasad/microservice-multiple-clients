package com.helical.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.helical.dto.PaymentTermDto;
import com.helical.entity.Invoice;
import com.helical.rest.FeignRestClient;
import com.helical.service.InvoiceService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class ReminderScheduler {
	
	private final String status = "UNPAID";
	private static final Logger LOGGER = LoggerFactory.getLogger(ReminderScheduler.class);	
	
	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private FeignRestClient feignRestClient;
	
	//@Scheduled(cron = "0 0 0 * * ?")
	@Scheduled(cron = "0 0 0 * * ?")
	public void cronJobSch() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		porcessInvoice();
		System.out.println("Reminder sent for Invoice :: " + strDate);
		
	}
	
	private void porcessInvoice() {
		List<Invoice> invoices = invoiceService.findByStatus(status);
		invoices.forEach(invoice-> {
			PaymentTermDto paymentTerm = findPaymentTermByCode(invoice.getCode());
			if(reminderActivated(paymentTerm, invoice.getInvoiceDate())) {
				LOGGER.info("Reminder sent for Invoice " + invoice.getCode());
			}
		});
	}
	
	@HystrixCommand(fallbackMethod = "getFallback", commandKey = "fallback", groupKey = "fallback")
	PaymentTermDto findPaymentTermByCode(String code) {
		return feignRestClient.findByCode(code);
	}
	
	private boolean reminderActivated(PaymentTermDto paymentTerm, Date invoiceDate) {
		int daysToRemind = paymentTerm.getDays() - paymentTerm.getRemindBeforeDays();
		Date today = new Date();
		long diffInMillies = Math.abs(invoiceDate.getTime() - today.getTime());
	    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		
		if(diff > 0 && diff <=  daysToRemind) {
			return true;
		}
			
		return false;
	}
	
	public PaymentTermDto getFallback() {
	    return new PaymentTermDto(); 
	}

	
}