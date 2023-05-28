package io.pismo.transactions.usecases.interactors;

import io.pismo.transactions.fixtures.AccountDataFixture;
import io.pismo.transactions.fixtures.AccountFixture;
import io.pismo.transactions.interfaces.adapter.gateway.database.repository.AccountRepository;
import io.pismo.transactions.usecases.exceptions.RepeatedAccountException;
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
public class CreateAccountInteractorTest {

    private static final String REQUEST_ID = UUID.randomUUID().toString();

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private CreateAccountInteractor interactor;

    @Test
    public void shouldCreateAccount() {
        final var account = AccountFixture.createAccount();
        final var accountData = AccountDataFixture.createAccountData();
        when(this.accountRepository.existsAccountByDocumentNumber(any())).thenReturn(Mono.just(false));
        when(this.accountRepository.save(any())).thenReturn(Mono.just(accountData));

        final var result = this.interactor.execute(REQUEST_ID, account);
        StepVerifier.create(result)
                .expectNext(accountData)
                .verifyComplete();
    }

    @Test
    public void shouldThrowRepeatedAccountException() {
        final var account = AccountFixture.createAccount();
        when(this.accountRepository.existsAccountByDocumentNumber(any())).thenReturn(Mono.just(true));

        final var result = this.interactor.execute(REQUEST_ID, account);
        StepVerifier.create(result)
                .expectError(RepeatedAccountException.class)
                .verify();
    }
}