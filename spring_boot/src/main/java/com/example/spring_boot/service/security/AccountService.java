package com.example.spring_boot.service.security;

import com.example.spring_boot.model.Account;

public interface AccountService {
    Account findUserByEmail(String email);
}
