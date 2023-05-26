package io.pismo.transactions.interfaces.adapter.gateway.database.repository;

import io.pismo.transactions.interfaces.adapter.gateway.database.TransactionData;
import reactor.core.publisher.Mono;

public interface TransactionRepository {

    <T extends TransactionData> Mono<T> insert(final TransactionData transactionData);

}
