package io.pismo.transactions.interfaces.adapter.controller.model.account.findaccount;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class FindAccountResponse {

    private String accountId;
    private String documentNumber;
    private BigDecimal availableCreditLimit;
}
