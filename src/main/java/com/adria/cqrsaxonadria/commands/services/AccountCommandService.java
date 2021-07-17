package com.adria.cqrsaxonadria.commands.services;

import com.adria.cqrsaxonadria.commands.dto.CreateAccountRequestDTO;
import com.adria.cqrsaxonadria.commands.dto.CreditAccountRequestDTO;
import com.adria.cqrsaxonadria.commands.dto.DebitAccountRequestDTO;

import java.util.concurrent.CompletableFuture;

public interface AccountCommandService {
    CompletableFuture<String> createAccount(CreateAccountRequestDTO accountRequestDTO);
    CompletableFuture<String> debitAccount(DebitAccountRequestDTO debitAccountRequestDTO);
    CompletableFuture<String> creditAccount(CreditAccountRequestDTO creditAccountRequestDTO);
}
