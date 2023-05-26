package io.pismo.transactions.usecases.ports;

import io.pismo.transactions.entity.Account;
import io.pismo.transactions.interfaces.adapter.gateway.database.AccountData;
import reactor.core.publisher.Mono;

public interface CreateAccountInputPort {

    Mono<AccountData> execute(final String requestId, final Account account);

}
