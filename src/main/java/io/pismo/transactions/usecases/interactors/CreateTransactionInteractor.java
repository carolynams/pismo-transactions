package io.pismo.transactions.usecases.interactors;

import io.pismo.transactions.entity.Transaction;
import io.pismo.transactions.interfaces.adapter.gateway.converters.TransactionDataConverter;
import io.pismo.transactions.interfaces.adapter.gateway.database.AccountData;
import io.pismo.transactions.interfaces.adapter.gateway.database.TransactionData;
import io.pismo.transactions.interfaces.adapter.gateway.database.repository.AccountRepository;
import io.pismo.transactions.interfaces.adapter.gateway.database.repository.TransactionRepository;
import io.pismo.transactions.usecases.exceptions.AccountNotFoundException;
import io.pismo.transactions.usecases.exceptions.AccountWithoutLimitAvaliableException;
import io.pismo.transactions.usecases.ports.CreateTransactionInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

import static io.pismo.transactions.interfaces.adapter.gateway.database.enums.OperationType.PAGAMENTO;
import static io.pismo.transactions.interfaces.adapter.gateway.database.enums.OperationType.getOperationType;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateTransactionInteractor implements CreateTransactionInputPort {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    private BigDecimal transactionAmount;

    @Override
    public Mono<TransactionData> execute(String requestId, Transaction transaction) {
        log.info("[{}] Creating transaction.", requestId);
        return this.accountRepository.findById(transaction.getAccountId())
                .switchIfEmpty(Mono.error(new AccountNotFoundException()))
                .filter(response -> this.isAvailableCredit(transaction, response) || this.isOperationTypePayment(transaction))
                .switchIfEmpty(Mono.error(new AccountWithoutLimitAvaliableException()))
                .map(account -> {
                    if (!this.isOperationTypePayment(transaction)) {
                        transactionAmount = transaction.getAmount().negate();
                    } else {
                        transactionAmount = transaction.getAmount();
                    }
                    return account;
                })
                .flatMap(response -> this.updateAccountAvailableCreditLimit(transactionAmount, response))
                .map(response -> TransactionDataConverter.toDomain(transaction, transactionAmount))
                .flatMap(this.transactionRepository::insert);
    }

    private boolean isAvailableCredit(Transaction transaction, AccountData response) {
        return response.getAvailableCreditLimit().compareTo(transaction.getAmount()) >= 0;
    }

    private boolean isOperationTypePayment(Transaction transaction) {
        return getOperationType(transaction.getOperationType()).equals(PAGAMENTO);
    }

    private Mono<AccountData> updateAccountAvailableCreditLimit(final BigDecimal transactionAmount, final AccountData accountData) {
        final var account = AccountData.builder()
                .id(accountData.getId())
                .documentNumber(accountData.getDocumentNumber())
                .availableCreditLimit(accountData.getAvailableCreditLimit().add(transactionAmount))
                .build();
        return this.accountRepository.save(account);
    }
}
