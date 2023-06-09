package io.pismo.transactions.interfaces.adapter.controller;

import io.pismo.transactions.interfaces.adapter.controller.converter.CreateAccountConverter;
import io.pismo.transactions.interfaces.adapter.controller.model.account.createaccount.CreateAccountRequest;
import io.pismo.transactions.interfaces.adapter.controller.model.account.createaccount.CreateAccountResponse;
import io.pismo.transactions.interfaces.adapter.controller.model.account.findaccount.FindAccountResponse;
import io.pismo.transactions.usecases.ports.CreateAccountInputPort;
import io.pismo.transactions.usecases.ports.FindAccountInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountControllerImpl implements AccountController {

    private final CreateAccountInputPort createAccountInputPort;
    private final FindAccountInputPort findAccountInputPort;

    @Override
    public Mono<CreateAccountResponse> createAccount(final String requestId, final CreateAccountRequest createAccountRequest) {
        log.info("[{}] Request received.", requestId);
        final var account = CreateAccountConverter.toModel(createAccountRequest);
        return this.createAccountInputPort.execute(requestId, account)
                .map(response -> CreateAccountResponse.builder()
                        .accountId(response.getId().toString())
                        .build());
    }

    @Override
    public Mono<FindAccountResponse> getAccounts(final String requestId, final String accountId) {
        log.info("[{}] Request received.", requestId);
        return this.findAccountInputPort.execute(requestId, accountId)
                .map(response -> FindAccountResponse.builder()
                        .accountId(response.getId().toString())
                        .documentNumber(response.getDocumentNumber())
                        .availableCreditLimit(response.getAvailableCreditLimit())
                        .build());
    }
}
