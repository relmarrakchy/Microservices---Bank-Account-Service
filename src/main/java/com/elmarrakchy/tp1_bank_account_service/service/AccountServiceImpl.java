package com.elmarrakchy.tp1_bank_account_service.service;

import com.elmarrakchy.tp1_bank_account_service.dto.*;
import com.elmarrakchy.tp1_bank_account_service.entities.BankAccount;
import com.elmarrakchy.tp1_bank_account_service.mappers.AccountMapper;
import com.elmarrakchy.tp1_bank_account_service.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
    private BankAccountRepository bankAccountRepository;
    private AccountMapper accountMapper;

    public AccountServiceImpl(BankAccountRepository bankAccountRepository, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public List<BankAccountResponseDTO> getAllAccounts() {
        return bankAccountRepository.findAll().stream()
                .map(accountMapper::fromBankAccount)
                .collect(Collectors.toList());
    }

    @Override
    public BankAccountResponseDTO getAccountById(String id) {
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Bank account with id %s not found", id)));
        return accountMapper.fromBankAccount(bankAccount);
    }

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = accountMapper.toBankAccount(bankAccountDTO);
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO requestDTO) {
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Bank account with id %s not found", id)));

        if (requestDTO.getBalance() != null) bankAccount.setBalance(requestDTO.getBalance());
        if (requestDTO.getCurrency() != null) bankAccount.setCurrency(requestDTO.getCurrency());
        if (requestDTO.getType() != null) bankAccount.setType(requestDTO.getType());
        bankAccount.setCreatedAt(new Date());

        BankAccount updatedBankAccount = bankAccountRepository.save(bankAccount);
        return accountMapper.fromBankAccount(updatedBankAccount);
    }

    @Override
    public void deleteAccount(String id) {
        bankAccountRepository.deleteById(id);
    }
}
