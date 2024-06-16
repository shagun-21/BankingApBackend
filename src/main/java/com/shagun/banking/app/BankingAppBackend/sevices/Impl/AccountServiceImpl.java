package com.shagun.banking.app.BankingAppBackend.sevices.Impl;

import com.shagun.banking.app.BankingAppBackend.dto.AccountDto;
import com.shagun.banking.app.BankingAppBackend.entity.Account;
import com.shagun.banking.app.BankingAppBackend.mapper.AccountMapper;
import com.shagun.banking.app.BankingAppBackend.repository.AccountRespository;
import com.shagun.banking.app.BankingAppBackend.sevices.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AccountServiceImpl implements AccountService {

    private AccountRespository accountRepository;

    public AccountServiceImpl(AccountRespository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountdto) {
        Account account= AccountMapper.mapToAccount(accountdto);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);

    }

    @Override
    public AccountDto getAccountById(Long Id) {
        Account account=accountRepository.findById(Id).orElseThrow(()->new RuntimeException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {

        Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account does not exist"));
        double total= account.getBalance()+amount;
        account.setBalance(total);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account does not exist"));

        if(account.getBalance()<amount){
            throw new RuntimeException("Insufficient balance");
        }
        double total=account.getBalance()-amount;
        account.setBalance(total);
        Account savedAcc=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAcc);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts=accountRepository.findAll();
        return accounts.stream().map((account)->AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account does not exist"));
        accountRepository.deleteById(id);
    }
}
