package io.pismo.transactions.interfaces.adapter.controller.converter;

import io.pismo.transactions.entity.Transaction;
import io.pismo.transactions.interfaces.adapter.controller.model.transaction.TransactionRequest;

public class CreateTransactionConverter {

    public static Transaction toModel(final TransactionRequest request) {
        return Transaction.builder()
                .accountId(request.getAccountId())
                .operationType(request.getOperationTypeId())
                .amount(request.getAmount())
                .build();
    }
}
