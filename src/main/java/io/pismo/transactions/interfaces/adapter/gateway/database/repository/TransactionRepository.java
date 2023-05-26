package io.pismo.transactions.interfaces.adapter.gateway.database.repository;

import io.pismo.transactions.interfaces.adapter.gateway.database.TransactionData;
import reactor.core.publisher.Mono;

public interface TransactionRepository {
    Mono<TransactionData> findById(final String id);

    Mono<TransactionData> insert(final TransactionData transactionData);

}
