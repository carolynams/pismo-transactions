package io.pismo.transactions.usecases.interactors;

import io.pismo.transactions.entity.Transaction;
import io.pismo.transactions.interfaces.adapter.controller.model.transaction.TransactionResponse;
import io.pismo.transactions.interfaces.adapter.gateway.database.repository.TransactionRepository;
import io.pismo.transactions.usecases.ports.CreateTransactionInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateTransactionInteractor implements CreateTransactionInputPort {

    private final TransactionRepository repository;

    @Override
    public Mono<TransactionResponse> execute(String requestId, Transaction transaction) {
        return null;
    }
}
