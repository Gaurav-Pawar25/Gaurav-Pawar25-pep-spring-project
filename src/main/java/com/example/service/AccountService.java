package com.example.service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class for managing Account entities.
 * This class provides methods to perform CRUD operations on Account entities.
 */

@Service
public class AccountService {
 // Injecting the AccountRepository dependency
    @Autowired
    private AccountRepository accountRepository;

    /**
     * Save a new account or update an existing account in the repository.
     *
     * @param account The Account entity to be saved.
     * @return The saved Account entity.
     */

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    /**
     * Find an account by its username.
     *
     * @param username The username of the account to be retrieved.
     * @return An Optional containing the Account if found, or empty if not found.
     */

    public Optional<Account> findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }


       /**
     * Find an account by its username and password.
     *
     * @param username The username of the account.
     * @param password The password of the account.
     * @return An Optional containing the Account if found with the provided credentials, or empty if not found.
     */

    public Optional<Account> findByUsernameAndPassword(String username, String password) {
        return accountRepository.findByUsernameAndPassword(username, password);
    }

  /**
     * Find an account by its ID.
     *
     * @param id The ID of the account to be retrieved.
     * @return An Optional containing the Account if found, or empty if not found.
     */

    public Optional<Account> findById(Integer id) {
        return accountRepository.findById(id);
    }
}
