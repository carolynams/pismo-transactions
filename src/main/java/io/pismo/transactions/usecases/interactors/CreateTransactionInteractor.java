package io.pismo.transactions.usecases.interactors;

import io.pismo.transactions.entity.Transaction;
import io.pismo.transactions.interfaces.adapter.gateway.converters.TransactionDataConverter;
import io.pismo.transactions.interfaces.adapter.gateway.database.TransactionData;
import io.pismo.transactions.interfaces.adapter.gateway.database.repository.AccountRepository;
import io.pismo.transactions.interfaces.adapter.gateway.database.repository.TransactionRepository;
import io.pismo.transactions.usecases.exceptions.AccountNotFoundException;
import io.pismo.transactions.usecases.ports.CreateTransactionInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static io.pismo.transactions.interfaces.adapter.gateway.database.enums.OperationType.PAGAMENTO;
import static io.pismo.transactions.interfaces.adapter.gateway.database.enums.OperationType.getOperationType;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateTransactionInteractor implements CreateTransactionInputPort {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    @Override
    public Mono<TransactionData> execute(String requestId, Transaction transaction) {
        log.info("[{}] Creating transaction.", requestId);
        return this.accountRepository.findById(transaction.getAccountId())
                .switchIfEmpty(Mono.error(new AccountNotFoundException()))
                .map(t -> {
                    if (getOperationType(transaction.getOperationType()).equals(PAGAMENTO)) {
                        return TransactionDataConverter.toDomain(transaction, transaction.getAmount());
                    }
                    return TransactionDataConverter.toDomain(transaction, transaction.getAmount().negate());
                })
                .flatMap(this.transactionRepository::insert);
    }
}
