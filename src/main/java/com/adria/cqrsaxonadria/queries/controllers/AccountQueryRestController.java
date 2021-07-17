package com.adria.cqrsaxonadria.queries.controllers;

import com.adria.cqrsaxonadria.queries.dto.*;
import com.adria.cqrsaxonadria.queries.entities.AccountOperation;
import com.adria.cqrsaxonadria.queries.entities.BankAccount;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryBackpressure;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping(path = "/query")
public class AccountQueryRestController {

    private QueryGateway queryGateway;
    public AccountQueryRestController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping(path = "/accounts/{id}")
    public BankAccountResponseDTO getBanAccount(@PathVariable String id){
        GetAccountQueryDTO queryDTO=new GetAccountQueryDTO();
        queryDTO.setId(id);
        return queryGateway.query(queryDTO, BankAccountResponseDTO.class).join();
    }

    @GetMapping(path = "/accounts")
    public List<BankAccountResponseDTO> getAll(){
        return queryGateway.query(new GetAllAccountsRequestDTO(),
                ResponseTypes.multipleInstancesOf(BankAccountResponseDTO.class)).join();
    }

    @GetMapping(path = "/accountOperations/{accountId}")
    public List<AccountOperationResponseDTO> accountOperationList(@PathVariable String accountId){
        return queryGateway.query(new GetAccountOperationsQueryDTO(accountId),ResponseTypes.multipleInstancesOf(AccountOperationResponseDTO.class)).join();
    }
    @GetMapping(value = "/{accountId}/watch",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<BankAccountResponseDTO> watch(@PathVariable String accountId){

        SubscriptionQueryResult<BankAccountResponseDTO,BankAccountResponseDTO> result=
                queryGateway.subscriptionQuery(
                        new GetAccountQueryDTO(accountId),
                        ResponseTypes.instanceOf(BankAccountResponseDTO.class),
                        ResponseTypes.instanceOf(BankAccountResponseDTO.class)
                        );
        return result.initialResult().concatWith(result.updates());
    }

}
