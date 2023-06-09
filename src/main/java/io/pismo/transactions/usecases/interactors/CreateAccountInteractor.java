package io.pismo.transactions.usecases.interactors;

import io.pismo.transactions.entity.Account;
import io.pismo.transactions.interfaces.adapter.gateway.converters.AccountDataConverter;
import io.pismo.transactions.interfaces.adapter.gateway.database.AccountData;
import io.pismo.transactions.interfaces.adapter.gateway.database.repository.AccountRepository;
import io.pismo.transactions.usecases.exceptions.RepeatedAccountException;
import io.pismo.transactions.usecases.ports.CreateAccountInputPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@AllArgsConstructor
public class CreateAccountInteractor implements CreateAccountInputPort {

    private final AccountRepository repository;

    @Override
    public Mono<AccountData> execute(String requestId, Account account) {
        log.info("[{}] Creating account.", requestId);
        return this.repository.existsAccountByDocumentNumber(account.getDocumentNumber())
                .filter(exists -> !exists)
                .switchIfEmpty(Mono.error(new RepeatedAccountException()))
                .map(response -> AccountDataConverter.toDomain(account))
                .flatMap(this.repository::save);
    }
}
