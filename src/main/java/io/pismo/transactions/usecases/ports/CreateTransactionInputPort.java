package io.pismo.transactions.usecases.ports;

import io.pismo.transactions.entity.Transaction;
import io.pismo.transactions.interfaces.adapter.gateway.database.TransactionData;
import reactor.core.publisher.Mono;

public interface CreateTransactionInputPort {

    Mono<TransactionData> execute(final String requestId, final Transaction transaction);
}
