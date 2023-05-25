package io.pismo.transactions.interfaces.adapter.gateway.converters;

import io.pismo.transactions.entity.Transaction;
import io.pismo.transactions.interfaces.adapter.gateway.database.AccountData;
import io.pismo.transactions.interfaces.adapter.gateway.database.TransactionData;

import java.time.ZonedDateTime;

public class TransactionDataConverter {

    public TransactionData toDomain(final Transaction transaction) {
        return TransactionData.builder()
                .account(AccountData.builder()
                        .id(transaction.getAccountId().toString())
                        .build())
                .operationType(transaction.getOperationType())
                .eventDate(ZonedDateTime.now())
                .build();
    }
}
