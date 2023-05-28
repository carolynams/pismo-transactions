package io.pismo.transactions.fixtures;

import io.pismo.transactions.interfaces.adapter.gateway.database.TransactionData;
import io.pismo.transactions.interfaces.adapter.gateway.database.enums.OperationType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionDataFixture {

    public static TransactionData createTransactionData() {
        return TransactionData.builder()
                .accountId(UUID.randomUUID().toString())
                .operationType(OperationType.SAQUE.getValue())
                .amount(BigDecimal.TEN)
                .eventDate(LocalDateTime.now())
                .build();
    }
}
