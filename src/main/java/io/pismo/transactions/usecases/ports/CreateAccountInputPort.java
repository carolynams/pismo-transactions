package io.pismo.transactions.usecases.ports;

import io.pismo.transactions.entity.Account;
import io.pismo.transactions.interfaces.adapter.controller.model.account.createaccount.CreateAccountResponse;
import reactor.core.publisher.Mono;

public interface CreateAccountInputPort {

    Mono<CreateAccountResponse> execute(final String requestId, final Account account);

}
