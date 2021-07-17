package com.adria.cqrsaxonadria.events;

import com.adria.cqrsaxonadria.enums.AccountStatus;
import lombok.Getter;

import java.math.BigDecimal;

public class AccountActivatedEvent extends BaseEvent<String> {
    @Getter private final AccountStatus status;
    public AccountActivatedEvent(String id, AccountStatus status) {
        super(id);
        this.status = status;
    }
}
