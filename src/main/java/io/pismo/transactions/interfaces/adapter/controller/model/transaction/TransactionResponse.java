package io.pismo.transactions.interfaces.adapter.controller.model.transaction;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionResponse {

    private String transactionId;
}
