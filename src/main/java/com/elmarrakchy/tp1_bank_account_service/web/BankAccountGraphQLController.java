package com.elmarrakchy.tp1_bank_account_service.web;

import com.errami.bankaccountservice.dto.BankAccountRequestDTO;
import com.errami.bankaccountservice.dto.BankAccountResponseDTO;
import com.errami.bankaccountservice.entities.BankAccount;
import com.errami.bankaccountservice.repositories.BankAccountRepository;
import com.errami.bankaccountservice.service.AccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;

    public BankAccountGraphQLController(BankAccountRepository bankAccountRepository, AccountService accountService) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
    }

    @QueryMapping
    public List<BankAccount> accountsList() {
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount getBankAccountById(@Argument String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Bank account with id %s not found", id)));
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount) {
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccount) {
        return accountService.updateAccount(id, bankAccount);
    }

    @MutationMapping
    public void deleteAccount(@Argument String id) {
        accountService.deleteAccount(id);
    }
}