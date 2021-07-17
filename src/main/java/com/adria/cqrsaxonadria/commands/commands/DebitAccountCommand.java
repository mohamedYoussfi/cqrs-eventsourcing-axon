package com.adria.cqrsaxonadria.commands.commands;

import lombok.Getter;

import java.math.BigDecimal;

public class DebitAccountCommand extends BaseCommand<String> {
    @Getter private BigDecimal amount;
    @Getter private String currency;
    public DebitAccountCommand(String id, BigDecimal amount, String currency) {
        super(id);
        this.amount = amount;
        this.currency = currency;
    }
}
