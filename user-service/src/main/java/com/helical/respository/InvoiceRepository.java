package com.helical.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.helical.entity.Invoice;

//@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

	List<Invoice> findByStatus(String status);
}