package com.shagun.banking.app.BankingAppBackend.sevices;

import com.shagun.banking.app.BankingAppBackend.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountdto);
    AccountDto getAccountById(Long Id);
    AccountDto deposit(Long id,double amount);
    AccountDto withdraw(Long id,double amount);
    List<AccountDto> getAllAccounts();
    void deleteAccount(Long id);

}
