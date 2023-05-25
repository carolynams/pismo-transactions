package io.pismo.transactions.usecases.ports;

import io.pismo.transactions.entity.Transaction;
import io.pismo.transactions.interfaces.adapter.controller.model.transaction.TransactionResponse;
import reactor.core.publisher.Mono;

public interface CreateTransactionInputPort {

    Mono<TransactionResponse> execute(final String requestId, final Transaction transaction);
}
