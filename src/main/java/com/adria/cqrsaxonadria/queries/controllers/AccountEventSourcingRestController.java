package com.adria.cqrsaxonadria.queries.controllers;

import com.adria.cqrsaxonadria.queries.services.EventSourcingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(path = "/eventSourcing")
public class AccountEventSourcingRestController {
    private final EventSourcingService accountQueryService;

    public AccountEventSourcingRestController(EventSourcingService accountQueryService) {
        this.accountQueryService = accountQueryService;
    }

    @GetMapping(path = "/accountEvents/{id}")
    public Stream eventsByAccountId(@PathVariable String id){
        return accountQueryService.eventsByAccountId(id).asStream();
    }
}
