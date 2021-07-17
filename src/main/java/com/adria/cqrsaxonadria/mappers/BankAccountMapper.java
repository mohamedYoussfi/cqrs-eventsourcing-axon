package com.adria.cqrsaxonadria.mappers;

import com.adria.cqrsaxonadria.queries.dto.AccountOperationResponseDTO;
import com.adria.cqrsaxonadria.queries.dto.BankAccountResponseDTO;
import com.adria.cqrsaxonadria.queries.entities.AccountOperation;
import com.adria.cqrsaxonadria.queries.entities.BankAccount;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankAccountMapper {
    BankAccountResponseDTO bankAccountToBankAccountDTO(BankAccount bankAccount);
    AccountOperationResponseDTO accountOperationToAccountOperationDTO(AccountOperation accountOperation);
}
