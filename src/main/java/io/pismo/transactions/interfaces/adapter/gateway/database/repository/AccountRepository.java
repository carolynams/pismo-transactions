package io.pismo.transactions.interfaces.adapter.gateway.database.repository;

import io.pismo.transactions.interfaces.adapter.gateway.database.AccountData;
import reactor.core.publisher.Mono;

public interface AccountRepository {

    <T extends AccountData> Mono<T> insert(final AccountData accountData);


    Mono<Boolean> existsAccountByDocumentNumber(final Integer documentNumber);

}
