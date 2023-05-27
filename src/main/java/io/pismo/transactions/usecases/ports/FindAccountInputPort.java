package io.pismo.transactions.usecases.ports;

import io.pismo.transactions.interfaces.adapter.gateway.database.AccountData;
import reactor.core.publisher.Mono;

public interface FindAccountInputPort {

    Mono<AccountData> execute(final String requestId, final String accountId);

}
