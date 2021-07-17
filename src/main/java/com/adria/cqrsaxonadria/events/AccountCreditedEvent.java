package com.adria.cqrsaxonadria.events;

import lombok.Getter;

import java.math.BigDecimal;

public class AccountCreditedEvent extends BaseEvent<String> {
    @Getter private final BigDecimal amount;
    @Getter private final String currency;

    public AccountCreditedEvent(String id, BigDecimal amount, String currency) {
        super(id);
        this.amount = amount;
        this.currency = currency;
    }
}
