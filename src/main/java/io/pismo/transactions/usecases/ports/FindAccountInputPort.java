package io.pismo.transactions.usecases.ports;

import io.pismo.transactions.interfaces.adapter.controller.model.account.findaccount.FindAccountResponse;
import reactor.core.publisher.Mono;

public interface FindAccountInputPort {

    Mono<FindAccountResponse> execute(final String requestId, final String accountId);

}
