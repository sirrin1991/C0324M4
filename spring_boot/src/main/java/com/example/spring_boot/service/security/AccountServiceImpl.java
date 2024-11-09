package com.example.spring_boot.service.security;


import com.example.spring_boot.model.Account;
import com.example.spring_boot.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findUserByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

}
