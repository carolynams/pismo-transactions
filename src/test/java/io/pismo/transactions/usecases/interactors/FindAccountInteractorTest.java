package io.pismo.transactions.usecases.interactors;

import io.pismo.transactions.fixtures.AccountDataFixture;
import io.pismo.transactions.interfaces.adapter.gateway.database.repository.AccountRepository;
import io.pismo.transactions.usecases.exceptions.AccountNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindAccountInteractorTest {

    private static final String REQUEST_ID = UUID.randomUUID().toString();
    private static final String ACCOUNT_ID = UUID.randomUUID().toString();

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private FindAccountInteractor interactor;

    @Test
    public void shouldFindAccount() {
        final var accountData = AccountDataFixture.createAccountData();
        when(this.accountRepository.findById(any())).thenReturn(Mono.just(accountData));

        final var result = this.interactor.execute(REQUEST_ID, ACCOUNT_ID);
        StepVerifier.create(result)
                .expectNext(accountData)
                .verifyComplete();
    }

    @Test
    public void shouldThrowAccountNotFoundException() {
        when(this.accountRepository.findById(any())).thenReturn(Mono.error(new AccountNotFoundException()));

        final var result = this.interactor.execute(REQUEST_ID, ACCOUNT_ID);
        StepVerifier.create(result)
                .expectError(AccountNotFoundException.class)
                .verify();
    }
}