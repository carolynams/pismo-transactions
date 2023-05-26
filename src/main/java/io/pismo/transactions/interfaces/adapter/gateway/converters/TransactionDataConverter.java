package io.pismo.transactions.interfaces.adapter.gateway.converters;

import io.pismo.transactions.entity.Transaction;
import io.pismo.transactions.interfaces.adapter.gateway.database.TransactionData;

import java.time.ZonedDateTime;

public class TransactionDataConverter {

    public TransactionData toDomain(final Transaction transaction) {
        return TransactionData.builder()
                .accountId(transaction.getAccountId().toString())
                .operationType(transaction.getOperationType())
                .eventDate(ZonedDateTime.now())
                .build();
    }
}
