package com.elmarrakchy.tp1_bank_account_service.entities;

import com.elmarrakchy.tp1_bank_account_service.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class, name = "projection1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
}
