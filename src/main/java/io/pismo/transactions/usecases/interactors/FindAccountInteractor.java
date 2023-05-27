package io.pismo.transactions.usecases.interactors;

import io.pismo.transactions.interfaces.adapter.gateway.database.AccountData;
import io.pismo.transactions.interfaces.adapter.gateway.database.repository.AccountRepository;
import io.pismo.transactions.usecases.exceptions.AccountNotFoundException;
import io.pismo.transactions.usecases.ports.FindAccountInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class FindAccountInteractor implements FindAccountInputPort {

    private final AccountRepository repository;

    @Override
    public Mono<AccountData> execute(String requestId, String accountId) {
        log.info("[{}] Finding account.", requestId);
        return this.repository.findById(accountId)
                .switchIfEmpty(Mono.error(new AccountNotFoundException()));
    }
}
