package io.pismo.transactions.interfaces.adapter.gateway.database.repository;

import io.pismo.transactions.interfaces.adapter.gateway.database.AccountData;
import reactor.core.publisher.Mono;

public interface AccountRepository {

    Mono<AccountData> insert(final AccountData accountData);


    Mono<Boolean> findByDocumentNumber(final Integer documentNumber);

}
