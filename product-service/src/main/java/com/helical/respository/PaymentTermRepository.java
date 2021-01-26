package com.helical.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.helical.entity.PaymentTerm;

@Repository
@Component
public interface PaymentTermRepository extends JpaRepository<PaymentTerm, Long> {

	PaymentTerm findByCode(String code);
}