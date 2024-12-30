package com.elmarrakchy.tp1_bank_account_service.repositories;

import com.elmarrakchy.tp1_bank_account_service.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
