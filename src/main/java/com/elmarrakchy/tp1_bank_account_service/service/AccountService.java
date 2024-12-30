package com.elmarrakchy.tp1_bank_account_service.service;

import com.elmarrakchy.tp1_bank_account_service.dto.*;

import java.util.List;

public interface AccountService {
    List<BankAccountResponseDTO> getAllAccounts();
    BankAccountResponseDTO getAccountById(String id);
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO requestDTO);
    void deleteAccount(String id);
}
