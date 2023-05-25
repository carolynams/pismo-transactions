package io.pismo.transactions.interfaces.adapter.controller.converter;

import io.pismo.transactions.entity.Transaction;
import io.pismo.transactions.interfaces.adapter.controller.model.transaction.TransactionRequest;

import java.time.ZonedDateTime;
import java.util.UUID;

public class CreateTransactionConverter {

    public static Transaction toModel(final TransactionRequest request) {
        return Transaction.builder()
                .accountId(UUID.fromString(request.getAccountId()))
                .operationType(request.getOperationTypeId())
                .eventDate(ZonedDateTime.now())
                .build();
    }
}
