package io.pismo.transactions.interfaces.adapter.gateway.converters;

import io.pismo.transactions.entity.Transaction;
import io.pismo.transactions.interfaces.adapter.gateway.database.TransactionData;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDataConverter {

    public static TransactionData toDomain(final Transaction transaction, final BigDecimal amount) {
        return TransactionData.builder()
                .accountId(transaction.getAccountId())
                .operationType(transaction.getOperationType())
                .amount(amount)
                .eventDate(LocalDateTime.now())
                .build();
    }
}
