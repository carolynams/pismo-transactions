package io.pismo.transactions.interfaces.adapter.gateway.database.repository;

import io.pismo.transactions.interfaces.adapter.gateway.database.AccountData;
import reactor.core.publisher.Mono;

public interface AccountRepository {

    <T extends AccountData> Mono<T> save(final AccountData accountData);


    Mono<Boolean> existsAccountByDocumentNumber(final String documentNumber);

    Mono<AccountData> findById(final String id);

}
