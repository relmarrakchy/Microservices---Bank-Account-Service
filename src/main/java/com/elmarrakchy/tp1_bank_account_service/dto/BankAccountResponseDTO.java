package com.elmarrakchy.tp1_bank_account_service.dto;

import com.elmarrakchy.tp1_bank_account_service.entities.Customer;
import com.elmarrakchy.tp1_bank_account_service.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountResponseDTO {
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    private AccountType type;
    private Customer customer;
}
