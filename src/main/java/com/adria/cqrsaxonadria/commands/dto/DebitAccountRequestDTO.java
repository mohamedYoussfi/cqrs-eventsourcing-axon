package com.adria.cqrsaxonadria.commands.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DebitAccountRequestDTO {
    private String accountId;
    private BigDecimal amount;
    private String currency;
}
