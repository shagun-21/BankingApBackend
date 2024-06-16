package com.shagun.banking.app.BankingAppBackend.mapper;

import com.shagun.banking.app.BankingAppBackend.dto.AccountDto;
import com.shagun.banking.app.BankingAppBackend.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountdto){
        Account account= new Account(
            accountdto.getId(),
                accountdto.getAccountHolderName(),
                accountdto.getBalance()
        );

        return account;
    }

    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountdto= new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountdto;
    }

}
