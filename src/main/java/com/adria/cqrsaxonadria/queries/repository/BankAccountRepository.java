package com.adria.cqrsaxonadria.queries.repository;

import com.adria.cqrsaxonadria.queries.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
