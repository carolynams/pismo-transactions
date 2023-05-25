package io.pismo.transactions.interfaces.adapter.controller;

import io.pismo.transactions.interfaces.adapter.controller.converter.CreateTransactionConverter;
import io.pismo.transactions.interfaces.adapter.controller.model.transaction.TransactionRequest;
import io.pismo.transactions.interfaces.adapter.controller.model.transaction.TransactionResponse;
import io.pismo.transactions.usecases.ports.CreateTransactionInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionsControllerImpl implements TransactionController {

    private CreateTransactionInputPort createTransactionInputPort;

    @Override
    public Mono<TransactionResponse> createTransaction(final String requestId, final TransactionRequest transactionRequest) {
        log.info("[{}] Request received.", requestId);
        final var transaction = CreateTransactionConverter.toModel(transactionRequest);
        return this.createTransactionInputPort.execute(requestId, transaction)
                .map(response -> TransactionResponse.builder()
                        .transactionId(response.getTransactionId())
                        .build());
    }
}
