package com.elmarrakchy.tp1_bank_account_service.web;

import com.elmarrakchy.tp1_bank_account_service.dto.BankAccountRequestDTO;
import com.elmarrakchy.tp1_bank_account_service.dto.BankAccountResponseDTO;
import com.elmarrakchy.tp1_bank_account_service.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private final AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccountResponseDTO> getBankAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccountResponseDTO getBankAccount(@PathVariable String id) {
        return accountService.getAccountById(id);
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO) {
        return accountService.addAccount(requestDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccountResponseDTO update(@PathVariable String id, @RequestBody BankAccountRequestDTO requestDTO) {
        return accountService.updateAccount(id, requestDTO);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable String id) {
        accountService.deleteAccount(id);
    }
}
