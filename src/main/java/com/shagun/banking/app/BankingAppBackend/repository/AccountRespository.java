package com.shagun.banking.app.BankingAppBackend.repository;

import com.shagun.banking.app.BankingAppBackend.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRespository extends JpaRepository<Account,Long> {

}
