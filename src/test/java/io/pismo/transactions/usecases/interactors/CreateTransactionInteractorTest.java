package io.pismo.transactions.usecases.interactors;

import io.pismo.transactions.fixtures.AccountDataFixture;
import io.pismo.transactions.fixtures.TransactionDataFixture;
import io.pismo.transactions.fixtures.TransactionFixture;
import io.pismo.transactions.interfaces.adapter.gateway.database.repository.AccountRepository;
import io.pismo.transactions.interfaces.adapter.gateway.database.repository.TransactionRepository;
import io.pismo.transactions.usecases.exceptions.AccountNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateTransactionInteractorTest {

    private static final String REQUEST_ID = UUID.randomUUID().toString();

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private CreateTransactionInteractor interactor;

    @Test
    public void shouldCreateTransaction() {
        final var transactionData = TransactionDataFixture.createTransactionData();
        final var transaction = TransactionFixture.createTransaction();
        final var accountData = AccountDataFixture.createAccountData();
        when(this.accountRepository.findById(any())).thenReturn(Mono.just(accountData));
        when(this.accountRepository.save(any())).thenReturn(Mono.just(accountData));
        when(this.transactionRepository.insert(any())).thenReturn(Mono.just(transactionData));

        final var result = this.interactor.execute(REQUEST_ID, transaction);
        StepVerifier.create(result)
                .assertNext(response -> {
                    assertNotNull(response);
                    assertEquals(transactionData.getAccountId(), response.getAccountId());
                })
                .verifyComplete();
    }

    @Test
    public void shouldThrowAccountNotFoundException() {
        final var transaction = TransactionFixture.createTransaction();

        when(this.accountRepository.findById(any())).thenReturn(Mono.empty());

        final var result = this.interactor.execute(REQUEST_ID, transaction);
        StepVerifier.create(result)
                .expectError(AccountNotFoundException.class)
                .verify();
    }
}