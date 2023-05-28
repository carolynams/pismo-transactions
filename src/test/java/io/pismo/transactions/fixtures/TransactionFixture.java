package io.pismo.transactions.fixtures;

import io.pismo.transactions.entity.Transaction;
import io.pismo.transactions.interfaces.adapter.gateway.database.enums.OperationType;

import java.math.BigDecimal;
import java.util.UUID;

public class TransactionFixture {

    public static Transaction createTransaction() {
        return Transaction.builder()
                .accountId(UUID.randomUUID().toString())
                .operationType(OperationType.SAQUE.getValue())
                .amount(BigDecimal.TEN)
                .build();
    }
}
